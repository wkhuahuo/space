package com.work.practice.Java.reflect;

import java.lang.reflect.Field;
import java.util.*;

import com.alibaba.fastjson.JSON;
/**
 * Created by wangkai43 on 2017/6/21.
 */
public class Reflect {

    private <T,K,V>T createClassFormMap(T t, Map<K,V> map) throws Exception {
        if(t == null){
            return null;
        }
        Class ct = t.getClass();
        Field fields[] = ct.getDeclaredFields();
        Field.setAccessible(fields,true);
        Set<K> keys = map.keySet();
        for(Field field : fields){

            try {
                V v = map.get(field.getName());
                field.setAccessible(true);
                field.set(t,v);
            } catch (Exception e) {
                throw new Exception("Set "+field.getName()+" error.",e);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Reflect reflect = new Reflect();
        String jsonStr = "{\"downEnd\":\"\",\"downStart\":\"\",\"bankCode\":\"BOS\",\"healthCondition\":1,\"userList\":[29281403,32446939,30914765,1910009024],\"appList\":[\"group\"],\"weight\":1,\"cityList\":[1,10],\"status\":1}";

        Map<String,Object> map = new HashMap<>();
        map = JSON.parseObject(jsonStr, map.getClass());
        BeanModel beanModel = null;
        try {
            beanModel = reflect.createClassFormMap(new BeanModel(), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(beanModel);

        ArrayList<String> list =new  ArrayList<>();
        list.toArray();

    }
    
}
