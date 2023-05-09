package chapter10_thread.threadsafemore.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description :
 * 用Lock介面來鎖住執行緒
 * 
 * @author chgwyellow
 * @create 2023-05-10
 */

class Window extends Thread {
    static int ticket = 100;// 每個物件都有100張票 所以每個窗口都賣了100張

    // 創建Lock的物件，確保多個執行緒共用一個Lock物件!
    // 聲明為static final
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock(); // 鎖定對共享資源的呼叫

                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票號為: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock(); // 確保解鎖 釋放對共享數據的鎖定
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {

        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}
