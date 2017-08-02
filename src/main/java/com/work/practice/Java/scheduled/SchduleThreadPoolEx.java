package work.wk.Java.scheduled;

import java.util.Date;


/**
 * Created by wangkai43 on 2017/7/5.
 */
public class SchduleThreadPoolEx {

    public synchronized void notifyothers(){
        Worker.name.notifyAll();
    }

    public synchronized void waitmoment(boolean flag){
        if(flag) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
        }
    }
}

class Worker{
    public static String name = "worker";
}

class TimerWorker implements Runnable{
    SchduleThreadPoolEx stpe;
    public TimerWorker(SchduleThreadPoolEx stpe){
        this.stpe = stpe;
    }
    boolean flag = true;
    @Override
    public void run() {
        System.out.println("hello "+new Date().toString());
        stpe.waitmoment(flag);
        flag = false;
    }
}