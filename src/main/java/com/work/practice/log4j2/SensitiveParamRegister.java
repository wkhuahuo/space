package com.work.practice.log4j2;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.util.LoaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangkai43
 * @create 2018-09-18-11:01
 * @email wangkai43@meituan.com
 */
public class SensitiveParamRegister<T extends SensitiveParam> {

    private static Logger log = LoggerFactory.getLogger(SensitiveParamRegister.class);

    private Map<String, T> sensitiveParamHashMap = new ConcurrentHashMap<>();
    private final String CONFIG_FILE_NAME = "sensitiveParam.properties";
    private final String KEY_CONFIG = "keysName";

    public SensitiveParamRegister(){
        init(CONFIG_FILE_NAME);
    }

    private void init(String fileName){
        loadSensitiveClassPath(loadPropertiesFile(fileName));
    }
    private void initSensitiveClass(String key, String value){
        try {
            Class aClass = Class.forName(value).asSubclass(SensitiveParam.class);
            T t = (T)aClass.newInstance();
            sensitiveParamHashMap.put(key, t);
        } catch (Exception e) {
            log.error("加载配置信息出错。", e);
        }
    }

    private void loadSensitiveClassPath(Properties properties){
        String str = properties.getProperty(KEY_CONFIG);
        if(str != null) {
            String[] keys = str.split(",");
            for (String key : keys) {
                String value = properties.getProperty(key);
                if (value == null) {
                    log.error("无法找到{}对应的配置信息。", key);
                } else {
                    initSensitiveClass(key, value);
                }
            }
        }
    }

    private static Properties loadPropertiesFile(final String fileName) {
        final Properties props = new Properties();
        for (final URL url : LoaderUtil.findResources(fileName)) {
            try (final InputStream in = url.openStream()) {
                props.load(in);
            } catch (IOException e) {
                log.error("Unable to read " + url, e);
            }
        }
        return props;
    }

    protected Set<String> getKeySet(){
        return sensitiveParamHashMap.keySet();
    }

    protected T getSensitiveParamByName(String name) {
        T t = sensitiveParamHashMap.get(name);
        if(t == null ){
            return null;
        }
        return t;
    }

    protected boolean register(String name, T param){
        try {
            T t = sensitiveParamHashMap.put(name, param);
            if(t != null) {
                log.info("替换原有key值对应的value。原值为：{}", JSON.toJSONString(t));
            }
        } catch (Exception e) {
            log.error("注册敏感信息失败。key or value 为空", e);
        }
        return true;
    }

    protected boolean unRegister(String name) {
        try {
            T t = sensitiveParamHashMap.remove(name);
            if(t == null){
                log.error("原敏感信息不存在，注销失败。");
            }
        } catch (Exception e) {
            log.error("注销失败，失败信息为如下", e);
        }
        return true;
    }


}
