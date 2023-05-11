package cn.tedu.thread;


/**
 * @author chgwyellw
 * @create 2023-05-11
 * @description :
 * 多執行緒的併發安全問題
 */
public class SyncDemo01 {
    public static void main(String[] args) {

        Table table = new Table();

        Thread t1 = new Thread("白鷺") {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    System.out.println(getName() + "搶了一顆豆子，豆子剩下:" + (bean - 1));
                }
            }
        };

        Thread t2 = new Thread("青雀") {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    System.out.println(getName() + "搶了一顆豆子，豆子剩下:" + (bean - 1));
                }
            }
        };

        t1.start();
        t2.start();

    }
}

class Table {

    private int beans = 20; //桌上有20顆豆子

    /**
     * 取得豆子數量
     */
    public synchronized int getBeans() { //設定為同步方法 呼叫者為table 為Table唯一物件
        if (beans == 0) {
            throw new RuntimeException("桌上沒有豆子了!");
        }
       //禮讓執行緒 主動讓出CPU
        Thread.yield();
        return beans--;
    }
}