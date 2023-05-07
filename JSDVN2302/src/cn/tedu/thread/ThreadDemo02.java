package cn.tedu.thread;


/**
 * @author chgwyellow
 * @date 2023/5/7 15:47
 * @description 多執行緒
 * 實作Runnable介面
 */
public class ThreadDemo02 {

    public static void main(String[] args) {

        //將要執行的執行緒任務實體化
        MyRunnable01 r1 = new MyRunnable01();
        MyRunnable02 r2 = new MyRunnable02();

        //將執行緒的任務分配給執行緒實例
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }

}

/**
 * Runnable是執行緒的任務類介面
 * 不是執行緒本身
 */
// 1. 實作Runnable 創建執行緒任務子類
class MyRunnable01 implements Runnable {

    //重寫run方法
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("我是Java大師!");
        }

    }
}

class MyRunnable02 implements Runnable {

    //重寫run方法
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("同時也是Python大師");
        }

    }
}