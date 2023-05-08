package chapter10_thread.thread;

/**
 * @author chgwyellow
 * @date 2023-05-07
 *       Set two threads, one is print even number from 1-100
 *       another is print odd number from 1-100.
 */
public class EvenNumberTest_Practice {

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }

        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }

        }.start();

    }
}