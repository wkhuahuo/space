package com.work.practice.log4j2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.StringBuilderFormattable;

import java.util.*;

/**
 * @author wangkai43
 * @create 2018-09-13-20:56
 * @email wangkai43@meituan.com
 */
public class DesensitizedUtil {

    private static final String SENSITIVE = "敏";

    private static final String RECURSION_PREFIX = "[...";
    private static final String RECURSION_SUFFIX = "...]";

    enum SensitiveParam {
        phone,
        name,
        idNo,
        personInfo
        ;
    }


    public static boolean needDesent(Object objKey){
        String key = "";
        if(objKey instanceof String) {
            String str = (String)objKey;
            if (str == null || "".equals(str)) {
                return false;
            }
            key = (String) objKey;
        } else {
            // 是否可以优化？
            key = JSON.toJSONString(objKey);
        }

        for (SensitiveParam param : SensitiveParam.values()) {
            if (key.contains(param.name())) {
                return true;
            }
        }
        return false;
    }



    public static Object desensitizeSpecialTypes(Object obj){

        if (obj == null || obj instanceof String) {
            return desensitizeString((String) obj);
        }else if (obj instanceof Integer) {
            return desensitizeIntValue(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            return desensitizeLongValue(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            return desensitizeDoubleValue(((Double) obj).doubleValue());
        } else if (obj instanceof Character) {
            return desensitizeCharValue(((Character) obj).charValue());
        } else if (obj instanceof Short) {
            return desensitizeShortValue(((Short) obj).shortValue());
        } else if (obj instanceof Float) {
            return desensitizeFloatValue(((Float) obj).floatValue());
        } else if (obj instanceof Byte) {
            return desensitizeByteValue(((Byte) obj).byteValue());
        }
        return obj;
    }

    public static Object desensitizeObject(Object obj) {
        Object deObj = desensitizeSpecialTypes(obj);
        // 如果是特定的几种类型那么一定会被转成String
        if (deObj instanceof String ){
            return deObj;
        } else if (isArray(deObj)) {
            return desensitizeArrayValue(deObj);
        } else if (isMap(deObj)) {
            return desensitizeMap(deObj);
        } else if (deObj instanceof Collection) {
            return SENSITIVE+" "+deObj.getClass().getName()+" size="+((Collection)deObj).size()+" "+identityToString(deObj);
        } else {
            deObj = SENSITIVE+identityToString(deObj);
        }
        return deObj;
    }

    /**
     * 脱敏数组
     * @param obj
     * @return
     */
    public static Object desensitizeArray(Object obj){
        if (isArray(obj)) {
            return desensitizeArrayValue(obj);
        }
        return obj;
    }

    private static boolean isMap(Object obj) {

        if (obj instanceof Map) {
            return true;
        }
        return false;
    }

    /**
     * Map的脱敏处理
     * @param o
     * @return
     */
    public static Object desensitizeMap(Object o) {
        return desensitizeMapValue(o);
    }


    /**
     * 校验final Map oMap = (Map<Object, Object>) o 与 final Map oMap = (Map < ?, ?>) o;的区别
     * 目前暂时用了Object
     * @param o
     * @return
     */
    private static Object desensitizeMapValue(Object o){
        final Map oMap = (Map<Object, Object>) o;
        for (final Object o1 : oMap.entrySet()) {
            final Map.Entry<?, ?> current = (Map.Entry<?, ?>) o1;
            final Object key = current.getKey();
            final Object value = current.getValue();
            if(DesensitizedUtil.needDesent(key)){
                Object desenobj = DesensitizedUtil.desensitizeObject(value);
                oMap.put(current.getKey(), desenobj);
            }

        }
        return o;
    }

    /**
     * Array的脱敏处理
     * @param o
     * @return
     */
    private static Object desensitizeArrayValue(Object o) {
        final Class<?> oClass = o.getClass();
        // 对于Array类型，直接返回其名称与长度即可。
        if (oClass == byte[].class) {
            return SENSITIVE+identityToString(o)+" "+((byte[]) o).length;
        } else if (oClass == short[].class) {
            return SENSITIVE+identityToString(o)+" "+((short[]) o).length;
        } else if (oClass == int[].class) {
            return SENSITIVE+identityToString(o)+" "+((int[]) o).length;
        } else if (oClass == long[].class) {
            return SENSITIVE+identityToString(o)+" "+((long[]) o).length;
        } else if (oClass == float[].class) {
            return SENSITIVE+identityToString(o)+" "+((float[]) o).length;
        } else if (oClass == double[].class) {
            return SENSITIVE+identityToString(o)+" "+((double[]) o).length;
        } else if (oClass == boolean[].class) {
            return SENSITIVE+identityToString(o)+" "+((boolean[]) o).length;
        } else if (oClass == char[].class) {
            return SENSITIVE+identityToString(o)+" "+((char[]) o).length;
        } else {
            final Object[] oArray = (Object[]) o;
            return SENSITIVE + oClass.getName() + " " + oArray.length;
        }
    }

    private static boolean isArray(Object obj) {
        final Class<?> oClass = obj.getClass();
        if (oClass.isArray()) {
            return true;
        }
        return false;
    }

    /**
     * byte的脱敏处理
     * @param b
     * @return
     */
    private static String desensitizeByteValue(byte b) {
        return desensitizeString(String.valueOf(b));
    }

    /**
     * float的脱敏处理
     * @param v
     * @return
     */
    private static String desensitizeFloatValue(float v) {
        return desensitizeString(String.valueOf(v));
    }

    /**
     * short的脱敏处理
     * @param i
     * @return
     */
    private static String desensitizeShortValue(short i) {
        return desensitizeString(String.valueOf(i));
    }

    /**
     * 对char的脱敏处理
     * @param c
     * @return
     */
    private static String desensitizeCharValue(char c) {
        return desensitizeString(String.valueOf(c));
    }

    /**
     * double的脱敏处理
     * @param v
     * @return
     */
    private static String desensitizeDoubleValue(double v) {
        return desensitizeString(String.valueOf(v));
    }

    /**
     * 对long值的脱敏处理
     * @param l
     * @return
     */
    private static String desensitizeLongValue(long l) {
        return desensitizeString(String.valueOf(l));
    }

    /**
     * 对int值的脱敏处理
     * @param i
     * @return
     */
    private static String desensitizeIntValue(int i) {
        return desensitizeString(String.valueOf(i));
    }

    /**
     * 对一个字符串的脱敏处理
     * @param str
     * @return
     */
    private static String desensitizeString(String str){
        if (str != null && str.length()>0) {
            if (str.length() == 1) {
                return "*";
            } else if (str.length() == 2) {
                return str.substring(0, 1) + "*";
            } else {
                return str.substring(0, 1) + "*" + str.substring(str.length() - 1, str.length());
            }
        }
        return "";
    }

    private static String identityToString(final Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
    }

}
