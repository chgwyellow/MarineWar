package cn.tedu.thread;

import java.util.Scanner;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 20:47
 * @description sleep方法的中斷異常
 * 當sleep方法被中斷時，interrupt()方法會被呼叫
 * 中斷阻塞並拋出異常
 */
public class SleepDemo03 {
    public static void main(String[] args) {

        Thread lin = new Thread() {
            @Override
            public void run() {
                System.out.println("林: 剛打掃完衛生 休一會~");
                try {
                    Thread.sleep(10000);
                    System.out.println("林: 睡的真舒服~");
                } catch (InterruptedException e) {
                    System.out.println("林: 幹嘛呢 吵吵吵!!!");
                }
            }
        };

        Thread huang = new Thread() {
            @Override
            public void run() {
                System.out.println("黃: 大槌80!小垂40!開始砸牆");
                for (int i = 0; i < 5; i++) {
                    System.out.println("黃: 80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("黃: 大哥!搞定!");
                //強制喚醒lin執行緒
                lin.interrupt();
            }
        };

        lin.start();
        huang.start();

    }
}
