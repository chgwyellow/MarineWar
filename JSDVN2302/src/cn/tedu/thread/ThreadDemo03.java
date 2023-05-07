package cn.tedu.thread;


/**
 * @author chgwyellow
 * @date 2023/5/7 15:54
 * @description 使用匿名內部類簡化
 */
public class ThreadDemo03 {

    public static void main(String[] args) {

        Thread t1 = new Thread() { //匿名內部類
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("哩洗項?");
                }
            }
        };
        t1.start();

    }

}