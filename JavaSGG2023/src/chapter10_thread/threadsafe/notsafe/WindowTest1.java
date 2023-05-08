package chapter10_thread.threadsafe.notsafe;

/**
 * Description :
 * 有100張車票要從3個窗口售出
 * 以extends Thread方式
 * 
 * @author chgwyellow
 * @create 2023-05-08
 */

class Window extends Thread {
    int ticket = 100;// 每個物件都有100張票 所以每個窗口都賣了100張

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

public class WindowTest1 {
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
