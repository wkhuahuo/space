package com.work.practice.log4j2;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.StringBuilders;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangkai43
 * @create 2018-09-13-20:43
 * @email wangkai43@meituan.com
 */
class DesensitizedParameterizedFormatter {
    /**
     * Prefix for recursion.
     */
    static final String RECURSION_PREFIX = "[...";
    /**
     * Suffix for recursion.
     */
    static final String RECURSION_SUFFIX = "...]";

    /**
     * Prefix for errors.
     */
    static final String ERROR_PREFIX = "[!!!";
    /**
     * Separator for errors.
     */
    static final String ERROR_SEPARATOR = "=>";
    /**
     * Separator for error messages.
     */
    static final String ERROR_MSG_SEPARATOR = ":";
    /**
     * Suffix for errors.
     */
    static final String ERROR_SUFFIX = "!!!]";

    private static final char DELIM_START = '{';
    private static final char DELIM_STOP = '}';
    private static final char ESCAPE_CHAR = '\\';

    private static ThreadLocal<SimpleDateFormat> threadLocalSimpleDateFormat = new ThreadLocal<>();

    private DesensitizedParameterizedFormatter() {
    }

    /**
     * Counts the number of unescaped placeholders in the given messagePattern.
     *
     * @param messagePattern the message pattern to be analyzed.
     * @return the number of unescaped placeholders.
     */
    static int countArgumentPlaceholders(final String messagePattern) {
        if (messagePattern == null) {
            return 0;
        }
        final int length = messagePattern.length();
        int result = 0;
        boolean isEscaped = false;
        for (int i = 0; i < length - 1; i++) {
            final char curChar = messagePattern.charAt(i);
            if (curChar == ESCAPE_CHAR) {
                isEscaped = !isEscaped;
            } else if (curChar == DELIM_START) {
                if (!isEscaped && messagePattern.charAt(i + 1) == DELIM_STOP) {
                    result++;
                    i++;
                }
                isEscaped = false;
            } else {
                isEscaped = false;
            }
        }
        return result;
    }

    /**
     * Counts the number of unescaped placeholders in the given messagePattern.
     *
     * @param messagePattern the message pattern to be analyzed.
     * @return the number of unescaped placeholders.
     */
    static int countArgumentPlaceholders2(final String messagePattern, final int[] indices) {
        if (messagePattern == null) {
            return 0;
        }
        final int length = messagePattern.length();
        int result = 0;
        boolean isEscaped = false;
        for (int i = 0; i < length - 1; i++) {
            final char curChar = messagePattern.charAt(i);
            if (curChar == ESCAPE_CHAR) {
                isEscaped = !isEscaped;
                indices[0] = -1; // escaping means fast path is not available...
                result++;
            } else if (curChar == DELIM_START) {
                if (!isEscaped && messagePattern.charAt(i + 1) == DELIM_STOP) {
                    indices[result] = i;
                    result++;
                    i++;
                }
                isEscaped = false;
            } else {
                isEscaped = false;
            }
        }
        return result;
    }

    /**
     * Counts the number of unescaped placeholders in the given messagePattern.
     *
     * @param messagePattern the message pattern to be analyzed.
     * @return the number of unescaped placeholders.
     */
    static int countArgumentPlaceholders3(final char[] messagePattern, final int length, final int[] indices) {
        int result = 0;
        boolean isEscaped = false;
        for (int i = 0; i < length - 1; i++) {
            final char curChar = messagePattern[i];
            if (curChar == ESCAPE_CHAR) {
                isEscaped = !isEscaped;
            } else if (curChar == DELIM_START) {
                if (!isEscaped && messagePattern[i + 1] == DELIM_STOP) {
                    indices[result] = i;
                    result++;
                    i++;
                }
                isEscaped = false;
            } else {
                isEscaped = false;
            }
        }
        return result;
    }

    /**
     * Replace placeholders in the given messagePattern with arguments.
     *
     * @param messagePattern the message pattern containing placeholders.
     * @param arguments      the arguments to be used to replace placeholders.
     * @return the formatted message.
     */
    static String format(final String messagePattern, final Object[] arguments) {
        final StringBuilder result = new StringBuilder();
        final int argCount = arguments == null ? 0 : arguments.length;
        formatMessage(result, messagePattern, arguments, argCount);
        return result.toString();
    }

    /**
     * Replace placeholders in the given messagePattern with arguments.
     *
     * @param buffer the buffer to write the formatted message into
     * @param messagePattern the message pattern containing placeholders.
     * @param arguments      the arguments to be used to replace placeholders.
     */
    static void formatMessage2(final StringBuilder buffer, final String messagePattern,
                               final Object[] arguments, final int argCount, final int[] indices) {
        if (messagePattern == null || arguments == null || argCount == 0) {
            buffer.append(messagePattern);
            return;
        }
        int previous = 0;
        String nextPart ="";
        //1. 从这里获取下一个将被append的字符串有没有包含关键词，如果有，增加标志位。
        // 2. 如果参数是数字，要根据标志位进行脱敏
        // 3. 如果参数是个字符串，要判断是否包含关键词。
        //    如果包含，使用json进行转换，获取关键词对应的value值
        // 4. 如果是一个Object，对其进行JSON化转成Map，获取关键词对应的value值。
        for (int i = 0; i < argCount; i++) {
            nextPart = messagePattern.substring(previous, indices[i]);
            buffer.append(nextPart);
            previous = indices[i] + 2;
            Object result =desenifNextPartLikeSensitiveParam(nextPart,arguments[i]);
            myRecursiveDeepToString(result, buffer, null);
        }
        buffer.append(messagePattern, previous, messagePattern.length());
    }

    private static Object desenifNextPartLikeSensitiveParam(String nextPart, Object obj) {
        return DesensitizedUtil.desenifKeyLikeSensitivePrarm(nextPart, obj);
    }


    /**
     * Replace placeholders in the given messagePattern with arguments.
     *
     * @param buffer the buffer to write the formatted message into
     * @param messagePattern the message pattern containing placeholders.
     * @param arguments      the arguments to be used to replace placeholders.
     */
    static void formatMessage3(final StringBuilder buffer, final char[] messagePattern, final int patternLength,
                               final Object[] arguments, final int argCount, final int[] indices) {
        if (messagePattern == null) {
            return;
        }
        if (arguments == null || argCount == 0) {
            buffer.append(messagePattern);
            return;
        }
        int previous = 0;
        for (int i = 0; i < argCount; i++) {
            buffer.append(messagePattern, previous, indices[i]);
            previous = indices[i] + 2;
            recursiveDeepToString(arguments[i], buffer, null);
        }
        buffer.append(messagePattern, previous, patternLength);
    }

    /**
     * Replace placeholders in the given messagePattern with arguments.
     *
     * @param buffer the buffer to write the formatted message into
     * @param messagePattern the message pattern containing placeholders.
     * @param arguments      the arguments to be used to replace placeholders.
     */
    static void formatMessage(final StringBuilder buffer, final String messagePattern,
                              final Object[] arguments, final int argCount) {
        if (messagePattern == null || arguments == null || argCount == 0) {
            buffer.append(messagePattern);
            return;
        }
        int escapeCounter = 0;
        int currentArgument = 0;
        int i = 0;
        final int len = messagePattern.length();
        for (; i < len - 1; i++) { // last char is excluded from the loop
            final char curChar = messagePattern.charAt(i);
            if (curChar == ESCAPE_CHAR) {
                escapeCounter++;
            } else {
                if (isDelimPair(curChar, messagePattern, i)) { // looks ahead one char
                    i++;

                    // write escaped escape chars
                    writeEscapedEscapeChars(escapeCounter, buffer);

                    if (isOdd(escapeCounter)) {
                        // i.e. escaped: write escaped escape chars
                        writeDelimPair(buffer);
                    } else {
                        // unescaped
                        writeArgOrDelimPair(arguments, argCount, currentArgument, buffer);
                        currentArgument++;
                    }
                } else {
                    handleLiteralChar(buffer, escapeCounter, curChar);
                }
                escapeCounter = 0;
            }
        }
        handleRemainingCharIfAny(messagePattern, len, buffer, escapeCounter, i);
    }

    /**
     * Returns {@code true} if the specified char and the char at {@code curCharIndex + 1} in the specified message
     * pattern together form a "{}" delimiter pair, returns {@code false} otherwise.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 22 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static boolean isDelimPair(final char curChar, final String messagePattern, final int curCharIndex) {
        return curChar == DELIM_START && messagePattern.charAt(curCharIndex + 1) == DELIM_STOP;
    }

    /**
     * Detects whether the message pattern has been fully processed or if an unprocessed character remains and processes
     * it if necessary, returning the resulting position in the result char array.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 28 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void handleRemainingCharIfAny(final String messagePattern, final int len,
                                                 final StringBuilder buffer, final int escapeCounter, final int i) {
        if (i == len - 1) {
            final char curChar = messagePattern.charAt(i);
            handleLastChar(buffer, escapeCounter, curChar);
        }
    }

    /**
     * Processes the last unprocessed character and returns the resulting position in the result char array.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 28 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void handleLastChar(final StringBuilder buffer, final int escapeCounter, final char curChar) {
        if (curChar == ESCAPE_CHAR) {
            writeUnescapedEscapeChars(escapeCounter + 1, buffer);
        } else {
            handleLiteralChar(buffer, escapeCounter, curChar);
        }
    }

    /**
     * Processes a literal char (neither an '\' escape char nor a "{}" delimiter pair) and returns the resulting
     * position.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 16 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void handleLiteralChar(final StringBuilder buffer, final int escapeCounter, final char curChar) {
        // any other char beside ESCAPE or DELIM_START/STOP-combo
        // write unescaped escape chars
        writeUnescapedEscapeChars(escapeCounter, buffer);
        buffer.append(curChar);
    }

    /**
     * Writes "{}" to the specified result array at the specified position and returns the resulting position.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 18 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void writeDelimPair(final StringBuilder buffer) {
        buffer.append(DELIM_START);
        buffer.append(DELIM_STOP);
    }

    /**
     * Returns {@code true} if the specified parameter is odd.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 11 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static boolean isOdd(final int number) {
        return (number & 1) == 1;
    }

    /**
     * Writes a '\' char to the specified result array (starting at the specified position) for each <em>pair</em> of
     * '\' escape chars encountered in the message format and returns the resulting position.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 11 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void writeEscapedEscapeChars(final int escapeCounter, final StringBuilder buffer) {
        final int escapedEscapes = escapeCounter >> 1; // divide by two
        writeUnescapedEscapeChars(escapedEscapes, buffer);
    }

    /**
     * Writes the specified number of '\' chars to the specified result array (starting at the specified position) and
     * returns the resulting position.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 20 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void writeUnescapedEscapeChars(int escapeCounter, final StringBuilder buffer) {
        while (escapeCounter > 0) {
            buffer.append(ESCAPE_CHAR);
            escapeCounter--;
        }
    }

    /**
     * Appends the argument at the specified argument index (or, if no such argument exists, the "{}" delimiter pair) to
     * the specified result char array at the specified position and returns the resulting position.
     */
    // Profiling showed this method is important to log4j performance. Modify with care!
    // 25 bytes (allows immediate JVM inlining: < 35 bytes) LOG4J2-1096
    private static void writeArgOrDelimPair(final Object[] arguments, final int argCount, final int currentArgument,
                                            final StringBuilder buffer) {
        if (currentArgument < argCount) {
            recursiveDeepToString(arguments[currentArgument], buffer, null);
        } else {
            writeDelimPair(buffer);
        }
    }

    /**
     * This method performs a deep toString of the given Object.
     * Primitive arrays are converted using their respective Arrays.toString methods while
     * special handling is implemented for "container types", i.e. Object[], Map and Collection because those could
     * contain themselves.
     * <p>
     * It should be noted that neither AbstractMap.toString() nor AbstractCollection.toString() implement such a
     * behavior. They only check if the container is directly contained in itself, but not if a contained container
     * contains the original one. Because of that, Arrays.toString(Object[]) isn't safe either.
     * Confusing? Just read the last paragraph again and check the respective toString() implementation.
     * </p>
     * <p>
     * This means, in effect, that logging would produce a usable output even if an ordinary System.out.println(o)
     * would produce a relatively hard-to-debug StackOverflowError.
     * </p>
     * @param o The object.
     * @return The String representation.
     */
    static String deepToString(final Object o) {
        if (o == null) {
            return null;
        }
        // Check special types to avoid unnecessary StringBuilder usage
        if (o instanceof String) {
            return (String) o;
        }
        if (o instanceof Integer) {
            return Integer.toString((Integer) o);
        }
        if (o instanceof Long) {
            return Long.toString((Long) o);
        }
        if (o instanceof Double) {
            return Double.toString((Double) o);
        }
        if (o instanceof Boolean) {
            return Boolean.toString((Boolean) o);
        }
        if (o instanceof Character) {
            return Character.toString((Character) o);
        }
        if (o instanceof Short) {
            return Short.toString((Short) o);
        }
        if (o instanceof Float) {
            return Float.toString((Float) o);
        }
        if (o instanceof Byte) {
            return Byte.toString((Byte) o);
        }
        final StringBuilder str = new StringBuilder();
        recursiveDeepToString(o, str, null);
        return str.toString();
    }

    /**
     * This method performs a deep toString of the given Object.
     * Primitive arrays are converted using their respective Arrays.toString methods while
     * special handling is implemented for "container types", i.e. Object[], Map and Collection because those could
     * contain themselves.
     * <p>
     * dejaVu is used in case of those container types to prevent an endless recursion.
     * </p>
     * <p>
     * It should be noted that neither AbstractMap.toString() nor AbstractCollection.toString() implement such a
     * behavior.
     * They only check if the container is directly contained in itself, but not if a contained container contains the
     * original one. Because of that, Arrays.toString(Object[]) isn't safe either.
     * Confusing? Just read the last paragraph again and check the respective toString() implementation.
     * </p>
     * <p>
     * This means, in effect, that logging would produce a usable output even if an ordinary System.out.println(o)
     * would produce a relatively hard-to-debug StackOverflowError.
     * </p>
     *
     * @param o      the Object to convert into a String
     * @param str    the StringBuilder that o will be appended to
     * @param dejaVu a list of container identities that were already used.
     */
    static void recursiveDeepToString(final Object o, final StringBuilder str, final Set<String> dejaVu) {
        if (appendSpecialTypes(o, str)) {
            return;
        }
        if (isMaybeRecursive(o)) {
            appendPotentiallyRecursiveValue(o, str, dejaVu);
        } else {
            tryObjectToString(o, str);
        }
    }
    static void myRecursiveDeepToString(final Object o, final StringBuilder str, final Set<String> dejaVu) {
        if (myAppendSpecialTypes(o, str)) {
            return;
        }
        if (isMaybeRecursive(o)) {
            myAppendPotentiallyRecursiveValue(o, str, dejaVu);
        } else {
            myTryObjectToString(o, str);
        }
    }

    private static boolean appendSpecialTypes(final Object o, final StringBuilder str) {
        return StringBuilders.appendSpecificTypes(str, o) || appendDate(o, str);
    }

    private static boolean myAppendSpecialTypes(final Object o, final StringBuilder str) {
        return myAppendSpecificTypes(str, o) || appendDate(o, str);
    }

    private static boolean isJSONObject(final Object obj){
        if(obj == null || obj instanceof String ) {
            return false;
        }
        try {
            JSONObject.parseObject((String) obj);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean myAppendSpecificTypes(final StringBuilder stringBuilder, final Object obj) {
        if (obj == null || obj instanceof String) {

            try {
                JSONObject jsonStr = JSONObject.parseObject((String) obj);
                stringBuilder.append(DesensitizedUtil.desensitizeObject(jsonStr));
            } catch (Exception e){

                stringBuilder.append((String) obj);
            }
        } else if (obj instanceof StringBuilderFormattable) {
            ((StringBuilderFormattable) obj).formatTo(stringBuilder);
        } else if (obj instanceof CharSequence) {
            stringBuilder.append((CharSequence) obj);
        } else if (obj instanceof Integer) { // LOG4J2-1437 unbox auto-boxed primitives to avoid calling toString()
            stringBuilder.append(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            stringBuilder.append(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            stringBuilder.append(((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            stringBuilder.append(((Boolean) obj).booleanValue());
        } else if (obj instanceof Character) {
            stringBuilder.append(((Character) obj).charValue());
        } else if (obj instanceof Short) {
            stringBuilder.append(((Short) obj).shortValue());
        } else if (obj instanceof Float) {
            stringBuilder.append(((Float) obj).floatValue());
        } else if (obj instanceof Byte) {
            stringBuilder.append(((Byte) obj).byteValue());
        } else {
            return false;
        }
        return true;
    }

    private static boolean appendDate(final Object o, final StringBuilder str) {
        if (!(o instanceof Date)) {
            return false;
        }
        final Date date = (Date) o;
        final SimpleDateFormat format = getSimpleDateFormat();
        str.append(format.format(date));
        return true;
    }

    private static SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat result = threadLocalSimpleDateFormat.get();
        if (result == null) {
            result = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            threadLocalSimpleDateFormat.set(result);
        }
        return result;
    }

    /**
     * Returns {@code true} if the specified object is an array, a Map or a Collection.
     */
    private static boolean isMaybeRecursive(final Object o) {
        return o.getClass().isArray() || o instanceof Map || o instanceof Collection;
    }

    private static void appendPotentiallyRecursiveValue(final Object o, final StringBuilder str,
                                                        final Set<String> dejaVu) {
        final Class<?> oClass = o.getClass();
        if (oClass.isArray()) {
            appendArray(o, str, dejaVu, oClass);
        } else if (o instanceof Map) {
            appendMap(o, str, dejaVu);
        } else if (o instanceof Collection) {
            appendCollection(o, str, dejaVu);
        }
    }

    private static void myAppendPotentiallyRecursiveValue(final Object o, final StringBuilder str,
                                                        final Set<String> dejaVu) {
        final Class<?> oClass = o.getClass();
        if (oClass.isArray()) {
            Object deo =DesensitizedUtil.desensitizeArray(o);
            appendSpecialTypes(deo, str);
        } else if (o instanceof Map) {
            Object deo =DesensitizedUtil.desensitizeMap(o);
            appendMap(deo, str, dejaVu);
        } else if (o instanceof Collection) {
            appendCollection(o, str, dejaVu);
        }
    }

    private static void appendArray(final Object o, final StringBuilder str, Set<String> dejaVu,
                                    final Class<?> oClass) {
        if (oClass == byte[].class) {
            str.append(Arrays.toString((byte[]) o));
        } else if (oClass == short[].class) {
            str.append(Arrays.toString((short[]) o));
        } else if (oClass == int[].class) {
            str.append(Arrays.toString((int[]) o));
        } else if (oClass == long[].class) {
            str.append(Arrays.toString((long[]) o));
        } else if (oClass == float[].class) {
            str.append(Arrays.toString((float[]) o));
        } else if (oClass == double[].class) {
            str.append(Arrays.toString((double[]) o));
        } else if (oClass == boolean[].class) {
            str.append(Arrays.toString((boolean[]) o));
        } else if (oClass == char[].class) {
            str.append(Arrays.toString((char[]) o));
        } else {
            if (dejaVu == null) {
                dejaVu = new HashSet<>();
            }
            // special handling of container Object[]
            final String id = identityToString(o);
            if (dejaVu.contains(id)) {
                str.append(RECURSION_PREFIX).append(id).append(RECURSION_SUFFIX);
            } else {
                dejaVu.add(id);
                final Object[] oArray = (Object[]) o;
                str.append('[');
                boolean first = true;
                for (final Object current : oArray) {
                    if (first) {
                        first = false;
                    } else {
                        str.append(", ");
                    }
                    recursiveDeepToString(current, str, new HashSet<>(dejaVu));
                }
                str.append(']');
            }
            str.append(Arrays.deepToString((Object[]) o));
        }
    }

    private static void appendMap(final Object o, final StringBuilder str, Set<String> dejaVu) {
        // special handling of container Map
        if (dejaVu == null) {
            dejaVu = new HashSet<>();
        }
        final String id = identityToString(o);
        if (dejaVu.contains(id)) {
            str.append(RECURSION_PREFIX).append(id).append(RECURSION_SUFFIX);
        } else {
            dejaVu.add(id);
            final Map<?, ?> oMap = (Map<?, ?>) o;
            str.append('{');
            boolean isFirst = true;
            for (final Object o1 : oMap.entrySet()) {
                final Map.Entry<?, ?> current = (Map.Entry<?, ?>) o1;
                if (isFirst) {
                    isFirst = false;
                } else {
                    str.append(", ");
                }
                final Object key = current.getKey();
                final Object value = current.getValue();
                recursiveDeepToString(key, str, new HashSet<>(dejaVu));
                str.append('=');
                recursiveDeepToString(value, str, new HashSet<>(dejaVu));
            }
            str.append('}');
        }
    }

    private static void appendCollection(final Object o, final StringBuilder str, Set<String> dejaVu) {
        // special handling of container Collection
        if (dejaVu == null) {
            dejaVu = new HashSet<>();
        }
        final String id = identityToString(o);
        if (dejaVu.contains(id)) {
            str.append(RECURSION_PREFIX).append(id).append(RECURSION_SUFFIX);
        } else {
            dejaVu.add(id);
            final Collection<?> oCol = (Collection<?>) o;
            str.append('[');
            boolean isFirst = true;
            for (final Object anOCol : oCol) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    str.append(", ");
                }
                recursiveDeepToString(anOCol, str, new HashSet<>(dejaVu));
            }
            str.append(']');
        }
    }

    private static void tryObjectToString(final Object o, final StringBuilder str) {
        // it's just some other Object, we can only use toString().
        try {
            str.append(o.toString());
        } catch (final Throwable t) {
            handleErrorInObjectToString(o, str, t);
        }
    }

    private static void myTryObjectToString(final Object o, final StringBuilder str) {
        // it's just some other Object, we can only use toString().
        try {
            str.append(DesensitizedUtil.desensitizeClass(o));
        } catch (final Throwable t) {
            handleErrorInObjectToString(o, str, t);
        }
    }

    private static void handleErrorInObjectToString(final Object o, final StringBuilder str, final Throwable t) {
        str.append(ERROR_PREFIX);
        str.append(identityToString(o));
        str.append(ERROR_SEPARATOR);
        final String msg = t.getMessage();
        final String className = t.getClass().getName();
        str.append(className);
        if (!className.equals(msg)) {
            str.append(ERROR_MSG_SEPARATOR);
            str.append(msg);
        }
        str.append(ERROR_SUFFIX);
    }

    /**
     * This method returns the same as if Object.toString() would not have been
     * overridden in obj.
     * <p>
     * Note that this isn't 100% secure as collisions can always happen with hash codes.
     * </p>
     * <p>
     * Copied from Object.hashCode():
     * </p>
     * <blockquote>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the Java&#8482; programming language.)
     * </blockquote>
     *
     * @param obj the Object that is to be converted into an identity string.
     * @return the identity string as also defined in Object.toString()
     */
    static String identityToString(final Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
    }

}
