package cn.tedu.thread;


/**
 * @author chgwyellow
 * @date 2023-05-07
 * @description Thread提供一個靜態currentThread()方法
 * 可以取得該方法的執行緒實例
 * java中的所有代碼都靠執行緒運行 main方法也是
 * JVM啟動後會自動建立執行緒
 * 執行main方法的稱為主執行緒
 * 同時名字也叫main
 */
public class CurrentThreadDemo {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();

        //Thread的getName方法可以取得名稱
        System.out.println("當前執行緒名稱: " + t.getName());

        Thread t2 = new Thread("跑阿跑阿跑"); //可以設定名稱
        System.out.println("t2執行緒名稱: " + t2.getName());

        Thread t3 = new Thread(() -> { //實作Runnable
            Thread tt = Thread.currentThread(); //Thread.currentThread() 的Thread不可省略
            System.out.println("t3執行緒名稱: " + tt.getName());
        });
        t3.setName("跑不動了鴨");
        t3.start();

        Thread t4 = new Thread("跑到肚子餓") {
            @Override
            public void run() {
                Thread tt = currentThread(); //繼承Thread Thread.currentThread()的Thread可省略
                System.out.println("t4執行緒名稱: " + tt.getName());
            }
        };
        t4.start();

    }

}
