package chapter10_thread.threadsafe.notsafe;

/**
 * Description :
 * 有100張車票要從3個窗口售出
 * 以implements Runnable方式
 * 
 * @author chgwyellow
 * @create 2023-05-08
 */

class SaleTicket implements Runnable {

    int ticket = 100; // 所有thread共享此數據

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票，票號為: " + ticket);
                ticket--;
            } else
                break;
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
