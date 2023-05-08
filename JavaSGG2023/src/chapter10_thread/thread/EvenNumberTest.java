package chapter10_thread.thread;

public class EvenNumberTest {
    public static void main(String[] args) {

        PrintNumber t1 = new PrintNumber();
        t1.start();

        // main thread
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }

    }
}

// Set a new thread and print the even number from 1 to 100
class PrintNumber extends Thread {
    public void run() {

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }

    }
}