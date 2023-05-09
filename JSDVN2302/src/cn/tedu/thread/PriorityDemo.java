package cn.tedu.thread;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 19:50
 * @description 執行緒的優先級別
 * 1-10 默認為5
 */

public class PriorityDemo {
    public static void main(String[] args) {

        Thread min = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("我是min");
                }
            }
        };

        Thread norm = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("我是norm");
                }
            }
        };

        Thread max = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("我是max");
                }
            }
        };

        min.setPriority(1); //優先級別最低
        norm.setPriority(5); //優先級別設定為5
        max.setPriority(10); //修先級別最高

        min.start();
        norm.start();
        max.start();

    }
}
