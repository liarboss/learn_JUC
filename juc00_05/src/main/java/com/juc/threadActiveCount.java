package com.juc;

import java.util.concurrent.TimeUnit;

public class threadActiveCount {
    public static void main(String[] args) {
        //打印当前线程组的线程
        Thread.currentThread().getThreadGroup().list();
        System.out.println("=========");
        //idea用的是反射,还有一个monitor监控线程。
        System.out.println(Thread.activeCount());
        /*
        输出结果:
        java.lang.ThreadGroup[name=main,maxpri=10]
            Thread[main,5,main]
            Thread[Monitor Ctrl-Break,5,main]
        =========
        2
        * */


        //停顿3s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //停顿3分钟
        try {
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //停顿3h
        try {
            TimeUnit.HOURS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //停顿三天
        try {
            TimeUnit.DAYS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
