package work.wk.Java.interfaceAndAbstract;

/**
 * Created by wangkai43 on 2017/6/20.
 */
public abstract class BeansTalkIEventProcess implements IEventProcess {
    public void say(String name){
        System.out.println("Hello "+name);
    }
    public abstract void bye(String name);

}
