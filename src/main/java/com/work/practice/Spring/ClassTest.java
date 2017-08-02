package work.wk.Spring;

import java.lang.reflect.Constructor;

/**
 * Created by wkhuahuo on 2017/3/7.
 */
public class ClassTest {
    public static void main(String[] args){
        ClassTest classTest = new ClassTest();
        classTest.class_forname();
        classTest.class_getconstructors();
    }
    public void class_getconstructors(){
        try{
            Constructor constructor = Class.forName("work.practice.Spring.AppleDemo").getConstructor(String.class,String.class);
            String str =constructor.getName();
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void class_forname(){
        try {
            Class c = Class.forName("work.practice.Spring.AppleDemo");
            AppleDemo apple = (AppleDemo) c.newInstance();
            //  AppleDemo apple2 = (AppleDemo) c.n
            apple.speak();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 *Comments
 * newInstance关键之只能使用无参构造器构造实例。
 * 被构造的类必须有无参构造方法。
 */
