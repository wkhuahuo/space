package com.work.practice.mianshi.designmodel;

/**
 * Created by wkhuahuo on 2017/3/5.
 */
public class Singleton_test {

    public static void main(String[] args) throws Exception {
        for(int i=0;i<5;i++){//普通创建类实例
            //Singleton_static2 s2 = new Singleton_static2();
            Singleton_static2 s2 = Singleton_static2.getInstance();
            System.out.println("普通方法创建类对象"+i+"的HashCode: "+s2.hashCode());
        }
       /* for(int i=0;i<5;i++) {//通过反射创建实例
            Class<Singleton_static2> clazz = (Class<Singleton_static2>) Class.forName("work.practice.mianshi.designmodel.Singleton_static2");
            Constructor<Singleton_static2> singleStatic2 = clazz.getDeclaredConstructor(null);//获得无参构造器
            singleStatic2.setAccessible(true);//跳过权限检查，访问私有的构造器
            Singleton_static2 s3 = singleStatic2.newInstance();
        //    System.out.println("无readResolve方法时,反射方法创建对象"+i+"的HashCode: "+s3.hashCode());
            System.out.println("有readResolve方法时,反射方法创建对象"+i+"的HashCode: "+s3.hashCode());
        }


        // 通过反序列化的方式构造多个对象（类需要实现Serializable接口）
        try{
            Singleton_static2 sc1 = Singleton_static2.getInstance();
            // 1. 把对象sc1写入硬盘文件
            FileOutputStream fos = new FileOutputStream("object.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sc1);
            oos.close();
            fos.close();
            // 2. 把硬盘文件上的对象读出来
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.out"));
            // 如果对象定义了readResolve()方法，readObject()会调用readResolve()方法。从而解决反序列化的漏洞
            Singleton_static2 sc5 = (Singleton_static2) ois.readObject();
            // 反序列化出来的对象，和原对象，不是同一个对象。如果对象定义了readResolve()方法，可以解决此问题。
            ois.close();
            System.out.println("对象定义了readResolve()方法，通过反序列化得到的对象：" + (sc5 == sc1));
            System.out.println("sc5.hashCode: " + sc5.hashCode());
            System.out.println("sc5.hashCode: " + sc1.hashCode());
        }catch(Exception e){
            e.printStackTrace();
        }
*/

    }

}
