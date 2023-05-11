package chapter10_thread.communication;

/**
 * @author chgwyellow
 * @create 2023-05-10
 *         Description: producer將產品交給clerk clerk賣產品給consumer
 *         clerk一次最多持有20個商品 如果持續生產 clerk會請producer暫停
 *         如果沒有產品了 clerk會請consumer晚點再買
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer pro1 = new Producer(clerk);
        Consumer con1 = new Consumer(clerk);

        pro1.setName("producer");
        con1.setName("consumer");

        pro1.start();
        con1.start();

    }

}

class Clerk {
    private int productNumber = 0;

    // 增加方法
    public synchronized void addProduct() {
        if (productNumber >= 20) {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productNumber++;
        System.out.println(Thread.currentThread().getName() + "生產第" + productNumber + "個產品");

        // 唤醒 有產品就可以消費
        notifyAll();

    }

    // 減少方法
    public synchronized void reduceProduct() {
        if (productNumber < 1) {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消費第" + productNumber + "個產品");
        productNumber--;

        // 喚醒 有消費就可以生產
        notifyAll();

    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("開始生產...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("開始消費...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.reduceProduct();
        }
    }
}