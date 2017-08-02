package work.wk.mianshi.classloading;

/**
 * 非主动使用类字段演示
 * Created by wkhuahuo on 2017/3/5.
 */
public class NotInitialization {
    public static void main(String[] args){
        //被动引用情况一：
        //System.out.println(SubClass.value);//对于只有直接定义这个字段的类才会被初始化。
                                            // 通过子类引用只在父类中定义的静态字段不会出发子类的初始化。
        //被动引用情况二：
        //SuperClass[] sca = new SuperClass[10];//通过数组定义来引用类，不会触发该类的初始化。

        //被动引用情况三：
        //System.out.println(ConstClass.HELLOWORLD);//在编译阶段通过常量传播优化，已经将该常量的值存储到了NotInitialization类的常量池中
                                                    //以后NotInitialization对常量的引用实际都被转化为它对自身常量池的引用。

        
    }
}
