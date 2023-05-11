package chapter10_thread.threadsafe.runnablesafe;

/**
 * Description :
 * 有100張車票要從3個窗口售出
 * 以implements Runnable方式
 * 並用同步方法解決thread搶奪資源的問題
 * synchronize
 * 
 * @author chgwyellow
 * @create 2023-05-09
 */

class SaleTicket1 implements Runnable {

    int ticket = 100; // 所有thread共享此數據

    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            show();
        }
    }

    public synchronized void show() { // 同步方法 此時同步的物件是this

        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "售票，票號為: " + ticket);
            ticket--;
        } else
            flag = false;
    }

}

public class WindowTest1 {
    public static void main(String[] args) {

        SaleTicket1 s = new SaleTicket1();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}