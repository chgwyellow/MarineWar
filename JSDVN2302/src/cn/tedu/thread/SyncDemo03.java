package cn.tedu.thread;

/**
 * ClassName: SyncDemo03
 * Package: cn.tedu.thread
 * Descprition:
 * 互斥鎖
 * 當使用多個synchronized鎖定多段程式碼片段
 * 並且指定的鎖都是相同
 *
 * @Author chgwyellow
 * @Create 2023-05-14 上午 08:12
 */
public class SyncDemo03 {
    public static void main(String[] args) {

        Person person = new Person();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                person.eat();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                person.breath();
            }
        };

        t1.start();
        t2.start();

    }
}

//兩個同步方法即可形成互斥鎖
class Person {
    public synchronized void eat() {

        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "正在吃飯");
            Thread.sleep(5000);
            System.out.println(t.getName() + "吃完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void breath() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "正在呼吸");
            Thread.sleep(5000);
            System.out.println(t.getName() + "呼吸完畢");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}