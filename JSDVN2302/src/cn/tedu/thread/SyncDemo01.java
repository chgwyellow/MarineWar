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
                    System.out.println(getName() + "出手搶了一顆豆子，此時豆子數量為:" + (bean - 1));
                }
            }
        };

        Thread t2 = new Thread("青雀") {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    System.out.println(getName() + "出手搶了一顆豆子，此時豆子數量為:" + (bean - 1));
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
    public int getBeans() {
        if (beans == 0) {
            throw new RuntimeException("桌上沒有豆子了!");
        }
        return beans--;
    }
}