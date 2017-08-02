package work.wk.Spring;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wkhuahuo on 2017/3/7.
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = null;
        try {
            clazz = loader.loadClass("work.practice.Spring.AppleDemo");
            AppleDemo apple = (AppleDemo) clazz.newInstance();
            apple.speak();
            Field nameFid = clazz.getDeclaredField("name");
            Field priceFid = clazz.getDeclaredField("price");

            nameFid.setAccessible(true);
            nameFid.set(apple,"henan");
            priceFid.setAccessible(true);
            priceFid.set(apple,"100");

            Method meth = clazz.getDeclaredMethod("eat",String.class);
            meth.setAccessible(true);
            meth.invoke(apple,"practice");
//
//            System.out.println("current loader:"+loader);
//            System.out.println("parent loader:"+loader.getParent());
//            System.out.println("grandparent loader:"+loader.getParent().getParent());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
/**
 * Comments
 * Java类加载机制为：全盘负责委托机制。
 * 全盘负责：ClassLoader在加载一个类的时候除非显示地使用另一个ClassLoader，该类所依赖及引用的类也由这个ClassLoader载入
 * 委托机制：先委托父类加载器寻找目标类，只有在找不到的情况下才从自己的类路径中查找并装在目标类。
 */


