package cn.tedu.thread;


/**
 * @author chgwyellw
 * @create 2023-05-13
 * description :
 * 同步程式碼區
 * 有效縮小同步範圍 並可以保證併發安全的情況下 提高效率
 */
public class SyncDemo02 {
    public static void main(String[] args) {

        Shop shop = new Shop();
        Thread t1 = new Thread("Kimi") {
            @Override
            public void run() {
                shop.buy();
            }
        };

        Thread t2 = new Thread("成瑋") {
            @Override
            public void run() {
                shop.buy();
            }
        };

        t1.start();
        t2.start();

    }
}

class Shop {
    public void buy() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "正在挑衣服");
            Thread.sleep(5000);
            synchronized (this) { //當前調用的物件必須是唯一 此處是shop
                System.out.println(t.getName() + "正在試衣服");
                Thread.sleep(5000);
            }
            System.out.println(t.getName() + "結帳離開");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }


    }
}
