package chapter10_thread.threadsafemore.singleton;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 23:31
 * @description 懶漢式
 */

public class BankTest {
    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                b1 = Bank.getInstance(); // getInstance會返回instance 也就是Bank生成的物件
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join(); // 讓t1先執行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join(); // 接著是t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);

    }
}

class Bank {
    private Bank() { // 私有化建構方法
    }

    private static volatile Bank instance = null; // volatile關鍵字 : 同一時間只有一個執行緒可以讀取或修改該變量

    // 實現執行緒的安全方法1 - 同步方法
    // 因為建構方法被私有化 所以創一個靜態方法 讓外部可以調用並創立物件
    // public static synchronized Bank getInstance() { // 默認同步物件是Bank.class 是類別的物件
    // 唯一
    // if (instance == null) {
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // instance = new Bank();
    // }
    // return instance;
    // }

    // // 實現執行緒的安全方法2 - 同步程式碼區
    // public static Bank getInstance() { // 默認同步物件是Bank.class 是類別的物件 唯一
    // synchronized (Bank.class) {
    // if (instance == null) {
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // instance = new Bank();
    // }
    // return instance;
    // }
    // }

    // 實現執行緒的安全方法3 - 避免執行緒同步後創立了instance 其他執行緒每次呼叫程式碼都還需要一一進入同步程式碼塊 減少效率
    public static Bank getInstance() { // 默認同步物件是Bank.class 是類別的物件 唯一
        if (instance == null) { // 當instance創建好後 其他執行緒就不用進入synchronized block去排隊 減少資源消耗也增加效率
            synchronized (Bank.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Bank();
                }

            }
        }
        return instance;
    }
}