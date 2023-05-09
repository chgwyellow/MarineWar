package cn.tedu.thread;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 21:28
 * @description 守護執行緒
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {

        Thread rose = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Rose: Let me die!");
                    try {
                        Thread.sleep(1000
                        );
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Rose: Ah, ah, ah ,ah ah...");
                System.out.println("噗通! 咕嚕嚕嚕嚕....");
            }
        };

        Thread jack = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Jack: My darling, you jump, I jump!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        rose.start();
        jack.setDaemon(true); //設定jack為守護執行緒 rose執行完畢也跟著結束
        jack.start();

    }
}
