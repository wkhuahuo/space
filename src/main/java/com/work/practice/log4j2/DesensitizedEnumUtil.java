package com.work.practice.log4j2;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangkai43
 * @create 2018-09-13-20:56
 * @email wangkai43@meituan.com
 */
public class DesensitizedEnumUtil {

    private static final String SENSITIVE = "敏";
    private static final String STAR = "***";

    private static final String RECURSION_PREFIX = "[...";
    private static final String RECURSION_SUFFIX = "...]";

    enum SensitiveParamEnum {
        //手机参数脱敏
        phone("phone") {
            @Override
            public Object desensitizedRule(Object obj){
                String tmpStr = "";
                if(obj instanceof String){
                    String str = (String ) obj;
                    int length = str.length();
                    if (length>3) {
                        tmpStr = str.substring(0, 3) + STAR + str.substring(length - 3, length);
                    } else {
                        tmpStr = STAR;
                    }
                }
                return tmpStr;
            }
        },
        //姓名脱敏
        name("name") {
            @Override
            public Object desensitizedRule(Object obj){
                String tmpStr = "";
                if(obj instanceof String) {
                    String str = (String) obj;
                    int length = str.length();
                    if(length > 1){
                        tmpStr = str.substring(0,1);
                    }else {
                        tmpStr = str;
                    }
                }
                return tmpStr;
            }
        },

        //证件号脱敏
        idNo("idNo") {
            @Override
            public Object desensitizedRule(Object obj){
                return "";
            }
        },

        //类脱敏
        personInfo("personInfo") {
            @Override
            public Object desensitizedRule(Object obj){
                return "";
            }
        },

        //其他参数不脱敏
        unknow("unknow") {
            @Override
            public Object desensitizedRule(Object obj){
             return obj;
            }
        }
        ;

        private String code;
        private Object obj;
        SensitiveParamEnum(String code){
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        private static Map<String, SensitiveParamEnum> enumMap = new HashMap<>();

        public Object desensitizedRule(Object obj){
            return desensitizeObject(obj);
        }

        static {
            for (SensitiveParamEnum param : SensitiveParamEnum.values()) {
                enumMap.put(param.getCode(), param);
            }
        }
        public static SensitiveParamEnum getRuleByCode(String code) {
            SensitiveParamEnum sensitiveParamEnum = enumMap.get(code);
            if(sensitiveParamEnum == null ){
                sensitiveParamEnum = SensitiveParamEnum.unknow;
            }
            return sensitiveParamEnum;
        }

    }

    public static boolean isStrContainsSensitivePrarm(Object objKey) {
        String key = "";

        if(objKey instanceof String) {//如果为字符串
            String str = (String)objKey;
            if (str == null || "".equals(str)) {
                return false;
            }
            key = (String) objKey;
        } else {//当不为字符串时转变为字符串
            // 是否可以优化？
            key = JSON.toJSONString(objKey);
        }
        for (SensitiveParamEnum sen : SensitiveParamEnum.values()){
            if(key.contains(sen.getCode())){
                return true;
            }
        }
        return false;
    }

    public static boolean keyNeedDesent(Object objKey){
        if(objKey instanceof String) {//如果为字符串
            SensitiveParamEnum sensitiveParamEnum = SensitiveParamEnum.getRuleByCode((String) objKey);
            if(SensitiveParamEnum.unknow != sensitiveParamEnum){
                return true;
            }
        }
        return false;
    }


    /**
     * 特殊类型的脱敏处理。
     * @param obj
     * @return 字符串
     */
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

    /**
     * 脱敏Java类
     * @param obj
     * @return String
     */
    public static Object desensitizeObject(Object obj) {
        // 如果是特定的几种类型那么一定会被转成String
        Object deObj = desensitizeSpecialTypes(obj);
        if (deObj instanceof String ){
            return deObj;
        } else if (isArray(deObj)) {
            return desensitizeArrayValue(deObj);
        } else if (isMap(deObj)) {
            return desensitizeMap(deObj);
        } else if (deObj instanceof Collection) {
            return SENSITIVE+" "+deObj.getClass().getName()+" size="+((Collection)deObj).size()+" "+identityToString(deObj);
        } else {
            Object result = desensitizeClass(obj);
            if(result instanceof String){
                return result;
            }else {
                deObj = SENSITIVE + identityToString(deObj);
            }
        }
        return deObj;
    }

    /**
     * 如果需要对一个普通javaBean进行脱敏需要得到每一个属性
     * @param obj
     * @return
     */
    public static Object desensitizeClass(Object obj) {
        Class c = obj.getClass();
        Map<String, Object> result = new HashMap<>();
        Field[] fields= c.getFields();
        for(Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = "";
            try {
                if(keyNeedDesent(name)) {
                    Object fo = field.get(obj);
                    value = desensitizeObject(fo);
                    result.put(name, value);
                } else {
                    result.put(name,field.get(obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(result);
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
            if(DesensitizedEnumUtil.keyNeedDesent(key)){
                Object desenobj = DesensitizedEnumUtil.desensitizeObject(value);
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

    /**
     * 判断是否是数组
     * @param obj
     * @return
     */
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
     * 对一个普通字符串的脱敏处理
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
