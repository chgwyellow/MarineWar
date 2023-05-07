package cn.tedu.thread;


/**
 * @author chgwyellow
 * @date 2023/5/7 15:54
 * @description 簡化Thread
 */
public class ThreadDemo03 {

    public static void main(String[] args) {

        //匿名內部類
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("哩洗項?");
                }
            }
        };

        //實作Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("項洗哩?");
                }
            }
        };
        Thread t2 = new Thread(r1);

        //透過Lambda表達式簡化
        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("龍賣岔?");
            }
        };
        Thread t3 = new Thread(r2);

        t1.start();
        t2.start();
        t3.start();
    }

}