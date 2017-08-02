package work.wk.mianshi.designmodel;

/**
 * Created by wkhuahuo on 2017/3/4.
 */
public enum Singleton_enm {
    INDTANCE,INDTANCE2;//此时实现的是双例模式
    //INDTANCE;//此时可以实现单例模式
    private MyResource instance = new MyResource();
    private MyResource2 instance2 = new MyResource2();
    /*Singleton_enm() {
        instance = new MyResource();
    }*/
    public MyResource getInstance() {
        return instance;
    }

    public MyResource2 getInstance2() {
        return instance2;
    }
}
class  MyResource{
    public static int num =-1;
    MyResource(){
        System.out.println("MyResource num: "+num++);

    }
}
class  MyResource2{
    public static int num =-2;
    MyResource2(){
        System.out.println("MyResource2 num: "+num++);
    }
}