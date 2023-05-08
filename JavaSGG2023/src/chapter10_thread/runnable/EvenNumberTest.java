package chapter10_thread.runnable;

/**
 * @author chgwyellow
 * @since 2023/05/08
 *        implements Runnable
 */
public class EvenNumberTest {

    public static void main(String[] args) {

        EvenNumber p = new EvenNumber(); // p可以共用 創建新thread時不需要再new EvenNumber()
        Thread t1 = new Thread(p);
        t1.start(); // getName() = Thread-0

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i); // main
            }
        }

        // 再創建一個Thread
        Thread t2 = new Thread(p);
        t2.start();// getName() = Thread-1

        // 匿名內部類實作Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "這是匿名內部類實作Runnable");
                }
            }
        }).start();

    }
}

class EvenNumber implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i); // Thread-0
            }
        }
    }
}
