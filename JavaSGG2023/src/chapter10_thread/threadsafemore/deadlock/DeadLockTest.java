package chapter10_thread.threadsafemore.deadlock;

public class DeadLockTest {
    public static void main(String[] args) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread() {
            public void run() {
                synchronized (s1) {

                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);

                    }
                }
            }

        }.start();

        new Thread() {
            public void run() {
                synchronized (s2) {

                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);

                    }
                }
            }

        }.start();

        /*
         * 第一個執行緒運行取得s1
         * 之後睡眠
         * 第二個執行緒運行取得s2
         * 接著也睡眠
         * 執行緒1喚醒後要取得s2
         * 同時執行緒2醒後要s1
         * 兩邊同時把對方要的資源鎖住
         * 造成死結 deadlock
         */
    }
}
