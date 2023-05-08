package chapter10_thread.threadsafe.runnablesafe;

/**
 * Description :
 * 有100張車票要從3個窗口售出
 * 以implements Runnable方式
 * 並用同步方式解決thread搶奪資源的問題
 * synchronize
 * 
 * @author chgwyellow
 * @create 2023-05-08
 */

class SaleTicket implements Runnable {

    int ticket = 100; // 所有thread共享此數據

    @Override
    public void run() {
        while (true) { // 必須在synchronized外 否則thread結束同步的唯一條件變成ticket=0 也就是只有一個窗口在賣票
            synchronized (this) { // this為呼叫run()方法的物件 也就是SaleTicket創立的物件s 且s只有一個 所以這裡的this是唯一
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票，票號為: " + ticket);
                    ticket--;
                } else
                    break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {

        SaleTicket s = new SaleTicket();
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