package com.work.practice.Java.scheduled;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangkai43 on 2017/7/5.
 */
public class SchduleMain {
    public static void main(String[] args) {

        SchduleThreadPoolEx stpe = new SchduleThreadPoolEx();

        ScheduledThreadPoolExecutor sepe  = new ScheduledThreadPoolExecutor(10);

     //  sepe.scheduleAtFixedRate(new TimerWorker(stpe),0,2, TimeUnit.SECONDS);

        sepe.scheduleWithFixedDelay(new TimerWorker(stpe),0,5, TimeUnit.SECONDS);



        sepe.getActiveCount();
        System.out.println("taskCount "+sepe.getTaskCount());
      //  stpe.notifyothers();

    }
}
