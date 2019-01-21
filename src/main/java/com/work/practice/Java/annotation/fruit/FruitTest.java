package com.work.practice.Java.annotation.fruit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by wangkai43 on 2017/6/21.
 */
public class FruitTest {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Field[] fields =Fruit.class.getDeclaredFields();
        for(Field field:fields){
            System.out.println("field "+field);
            System.out.println("filed.getName= "+field.getName());
            Annotation[] annos = field.getAnnotations();
            for(Annotation anno : annos){
                System.out.println(anno);
                if(anno.annotationType() == FruitColor.class){
                    String fruitColor=((FruitColor) anno).color();
                    System.out.println("fruitcolor "+fruitColor);
                    fruit.setColor(fruitColor);
                }
                if(anno.annotationType() == FruitName.class){
                    String fruitName =((FruitName) anno).name();
                    System.out.println("fruitname "+fruitName);
                    fruit.setName(fruitName);
                }
            }

        }
        System.out.println(fruit.toString());
    }
}
