package cn.tedu.thread;


/**
 * @author chgwyellow
 * @date 2023/5/7
 * @description 多執行緒
 * 繼承Thread類別 重寫run方法
 */
public class ThreadDemo01 {

    public static void main(String[] args) {

        //創建執行緒實例
        MyThread01 t1 = new MyThread01();
        MyThread02 t2 = new MyThread02();

        /*
        Thread有start方法
        將執行緒加入調度器中被統一管理
        直到執行緒被加入時間片後
        就會啟動執行緒
        並執行run方法
         */
        t1.start();
        t2.start();

    }

}

/**
 * Thread是執行緒的父類別
 * 繼承後可以創建執行緒實例
 */
class MyThread01 extends Thread {
    //重寫run方法，執行緒啟動後自動執行
    @Override
    public void run() {
        //執行緒要執行的方法
        for (int i = 0; i < 1000; i++) { //1000.fori
            System.out.println("我是金剛");
        }
    }
}

class MyThread02 extends Thread {
    //重寫run方法
    @Override
    public void run() {
        //執行緒要執行的方法
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是查水表的");
        }
    }
}