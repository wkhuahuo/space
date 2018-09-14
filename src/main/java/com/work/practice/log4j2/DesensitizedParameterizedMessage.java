package com.work.practice.log4j2;

import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.util.Constants;
import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.StringBuilders;

import java.util.*;

/**
 * @author wangkai43
 * @create 2018-09-13-14:26
 * @email wangkai43@meituan.com
 */
public class DesensitizedParameterizedMessage implements Message, StringBuilderFormattable {

    // Should this be configurable?
    private static final int DEFAULT_STRING_BUILDER_SIZE = 255;

    /**
     * Prefix for recursion.
     */
    public static final String RECURSION_PREFIX = DesensitizedParameterizedFormatter.RECURSION_PREFIX;
    /**
     * Suffix for recursion.
     */
    public static final String RECURSION_SUFFIX = DesensitizedParameterizedFormatter.RECURSION_SUFFIX;

    /**
     * Prefix for errors.
     */
    public static final String ERROR_PREFIX = DesensitizedParameterizedFormatter.ERROR_PREFIX;

    /**
     * Separator for errors.
     */
    public static final String ERROR_SEPARATOR = DesensitizedParameterizedFormatter.ERROR_SEPARATOR;

    /**
     * Separator for error messages.
     */
    public static final String ERROR_MSG_SEPARATOR = DesensitizedParameterizedFormatter.ERROR_MSG_SEPARATOR;

    /**
     * Suffix for errors.
     */
    public static final String ERROR_SUFFIX = DesensitizedParameterizedFormatter.ERROR_SUFFIX;
    private static final long serialVersionUID = -665975803997290697L;
    private static final int HASHVAL = 31;

    // storing JDK classes in ThreadLocals does not cause memory leaks in web apps, so this is okay
    private static ThreadLocal<StringBuilder> threadLocalStringBuilder = new ThreadLocal<>();

    //姓名:{}, 手机号:{}, 银行卡号:{}
    private String messagePattern;
    // wk, 01987654321, 12345678910
    private transient Object[] argArray;
    // 格式化之后的信息
    private String formattedMessage;
    // 异常类
    private transient Throwable throwable;
    // 标识位{}在messagePattern的位置
    private int[] indices;
    // 记录当前使用到第几个位置了
    private int usedCount;
    public DesensitizedParameterizedMessage(final String messagePattern, final Object[] arguments, final Throwable throwable){
        this.argArray = arguments;
        this.throwable = throwable;
        init(messagePattern);
    }



    public DesensitizedParameterizedMessage(final String messagePattern, final Object... arguments) {
        this.argArray = arguments;
        init(messagePattern);
    }

    public DesensitizedParameterizedMessage(final String messagePattern, final Object arg) {
        this(messagePattern, new Object[]{arg});
    }

    public DesensitizedParameterizedMessage(final String messagePattern, final Object arg0, final Object arg1) {
        this(messagePattern, new Object[]{arg0, arg1});
    }

    private void init(final String messagePattern) {
        this.messagePattern = messagePattern;
        final int len = Math.max(1, messagePattern == null ? 0 : messagePattern.length() >> 1); // divide by 2
        this.indices = new int[len]; // LOG4J2-1542 ensure non-zero array length
        final int placeholders = DesensitizedParameterizedFormatter.countArgumentPlaceholders2(messagePattern, indices);
        initThrowable(argArray, placeholders);
        this.usedCount = Math.min(placeholders, argArray == null ? 0 : argArray.length);
    }

    private void initThrowable(final Object[] params, final int usedParams) {
        if (params != null) {
            final int argCount = params.length;
            if (usedParams < argCount && this.throwable == null && params[argCount - 1] instanceof Throwable) {
                this.throwable = (Throwable) params[argCount - 1];
            }
        }
    }




    @Override
    public String getFormat() {
        return messagePattern;
    }

    @Override
    public Object[] getParameters() {
        return argArray;
    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public String getFormattedMessage() {
        if (formattedMessage == null) {
            final StringBuilder buffer = getThreadLocalStringBuilder();
            formatTo(buffer);
            formattedMessage = buffer.toString();
            StringBuilders.trimToMaxSize(buffer, Constants.MAX_REUSABLE_MESSAGE_SIZE);
        }
        return formattedMessage;
    }

    private static StringBuilder getThreadLocalStringBuilder() {
        StringBuilder buffer = threadLocalStringBuilder.get();
        if (buffer == null) {
            buffer = new StringBuilder(DEFAULT_STRING_BUILDER_SIZE);
            threadLocalStringBuilder.set(buffer);
        }
        buffer.setLength(0);
        return buffer;
    }

    @Override
    public void formatTo(final StringBuilder buffer) {
        if (formattedMessage != null) {
            buffer.append(formattedMessage);
        } else {
            if (indices[0] < 0) {
                DesensitizedParameterizedFormatter.formatMessage(buffer, messagePattern, argArray, usedCount);
            } else {
                DesensitizedParameterizedFormatter.formatMessage2(buffer, messagePattern, argArray, usedCount, indices);
            }
        }
    }

    /**
     * Replace placeholders in the given messagePattern with arguments.
     *
     * @param messagePattern the message pattern containing placeholders.
     * @param arguments      the arguments to be used to replace placeholders.
     * @return the formatted message.
     */
    public static String format(final String messagePattern, final Object[] arguments) {
        return DesensitizedParameterizedFormatter.format(messagePattern, arguments);
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final DesensitizedParameterizedMessage that = (DesensitizedParameterizedMessage) o;

        if (messagePattern != null ? !messagePattern.equals(that.messagePattern) : that.messagePattern != null) {
            return false;
        }
        if (!Arrays.equals(this.argArray, that.argArray)) {
            return false;
        }
        //if (throwable != null ? !throwable.equals(that.throwable) : that.throwable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messagePattern != null ? messagePattern.hashCode() : 0;
        result = HASHVAL * result + (argArray != null ? Arrays.hashCode(argArray) : 0);
        return result;
    }


    /**
     * Counts the number of unescaped placeholders in the given messagePattern.
     *
     * @param messagePattern the message pattern to be analyzed.
     * @return the number of unescaped placeholders.
     */
    public static int countArgumentPlaceholders(final String messagePattern) {
        return DesensitizedParameterizedFormatter.countArgumentPlaceholders(messagePattern);
    }

    public static String deepToString(final Object o) {
        return DesensitizedParameterizedFormatter.deepToString(o);
    }

    public static String identityToString(final Object obj) {
        return DesensitizedParameterizedFormatter.identityToString(obj);
    }

    @Override
    public String toString() {
        return "DesensitizedParameterizedMessage[messagePattern=" + messagePattern + ", stringArgs=" +
                Arrays.toString(argArray) + ", throwable=" + throwable + ']';
    }




}
