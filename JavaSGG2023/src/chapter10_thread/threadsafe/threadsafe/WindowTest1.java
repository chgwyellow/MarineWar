package chapter10_thread.threadsafe.threadsafe;

/**
 * Description :
 * 有100張車票要從3個窗口售出
 * 以extends Thread方式
 * 並以同步方法解決重複賣票問題
 * 
 * @author chgwyellow
 * @create 2023-05-09
 */

class Window1 extends Thread {
    static int ticket = 100;// 設定為static屬性 才可以讓該類別創建得物件共用

    static boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            show();
        }
    }

    public static synchronized void show() { // 繼承Thread類創造的物件非唯一 Static方法不會有this 因為屬於類別 當前的物件是Window.class 所以是唯一

        if (ticket > 0) {
            try {
                Thread.sleep(5);
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

        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}