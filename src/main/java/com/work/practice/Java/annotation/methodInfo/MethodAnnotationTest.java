package com.work.practice.Java.annotation.methodInfo;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by wangkai43 on 2017/6/21.
 */
public class MethodAnnotationTest {
    public static void main(String[] args) {
        Method[] methods =null;
        try {
             methods = MethodAnnotationTest.class.getClassLoader().loadClass("work.practice.Java.annotation.methodInfo.MethodAnnotationExample").getMethods();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(methods == null){
            return;
        }


        for (Method method : methods) {
            // checks if MethodInfo annotation is present for the method
            if (method.isAnnotationPresent(MethodInfo.class)) {
                try {
                    // iterates all the annotations available in the method
                    for (Annotation anno : method.getDeclaredAnnotations()) {
                        System.out.println("Annotation in Method "+ method + " : "+ anno);
                    }
                    MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);

                    System.out.println(methodAnno.author());
                    System.out.println(methodAnno.version());
                    System.out.println(methodAnno.date());
                    System.out.println(methodAnno.comments());

                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println();
        }

    }
}
