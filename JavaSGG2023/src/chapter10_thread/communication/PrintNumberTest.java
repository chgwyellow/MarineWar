package chapter10_thread.communication;

/**
 * @author chgwyellow
 * @create 2023-05-10
 *         Description: 利用兩個thread交互列印1-100
 */
public class PrintNumberTest {
    public static void main(String[] args) {

        PrintNumber p = new PrintNumber();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();

    }
}

class PrintNumber implements Runnable {

    private int number = 1; // 從1開始列印

    @Override
    public void run() {

        while (true) {
            synchronized (this) { // this = p 是唯一物件
                notifyAll(); // 喚醒所有等待執行緒
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait(); // thread一但進入此方法就會阻塞 且釋放同步資源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else
                    break;
            }

        }
    }
}