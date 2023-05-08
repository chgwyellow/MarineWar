package chapter10_thread.threadsafe.threadsafe;

/**
 * Description :
 * 有100張車票要從3個窗口售出
 * 以extends Thread方式
 * 並以同步方式解決重複賣票問題
 * 
 * @author chgwyellow
 * @create 2023-05-08
 */

class Window extends Thread {
    static int ticket = 100;// 設定為static屬性 才可以讓該類別創建得物件共用

    @Override
    public void run() {
        while (true) {
            synchronized (Window.class) { // Class clz = Window.class 是Window類別加載時創立的物件 因為類別只會加載一次 所以是唯一物件
                if (ticket > 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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