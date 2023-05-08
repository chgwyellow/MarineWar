package chapter10_thread.lifecycle;

public class EvenNumberTest {
    public static void main(String[] args) {

        PrintNumber t1 = new PrintNumber("thread1");
        t1.start();

        Thread.currentThread().setName("main_thread"); // 設定main thread名稱

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); // 變更主執行緒優先級別為最大

        for (int i = 0; i < 100; i++) {
            // try {
            // Thread.sleep(500);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i); // main
            }

            if (i == 20) {
                try {
                    t1.join(); // 呼叫join方法的thread優先執行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.getName() + ":" + t1.getPriority()); // 取得t1的優先級別
        System.out.println(Thread.currentThread().getName() + ":" +
                Thread.currentThread().getPriority()); // 取得main thread的優先級別

    }
}

class PrintNumber extends Thread {

    public PrintNumber(String name) { // 設定thread名稱
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i); // main
            }
            if (i % 20 == 0) {
                Thread.yield(); // 該執行緒釋放資源讓其他執行緒先執行 但也可能又讓自己繼續執行
            }

        }

    }
}