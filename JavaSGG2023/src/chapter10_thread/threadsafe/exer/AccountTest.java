package chapter10_thread.threadsafe.exer;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 22:40
 * @description
 */

public class AccountTest {

    public static void main(String[] args) {

        Account account = new Account(); // 讓Customer類別可以共享數據
        Customer customer1 = new Customer(account, "A");
        Customer customer2 = new Customer(account, "B");

        customer1.start();
        customer2.start();

    }

}

class Account { // 帳戶
    private double balance; // 餘額

    public synchronized void deposit(double money) { // this = account is the only object in Account class
        if (money > 0) {
            balance += money;
        }
        System.out.println(Thread.currentThread().getName() + "存款1000元,餘額: " + balance);

    }

}

class Customer extends Thread {
    Account account;

    public Customer(Account account, String name) {
        this.account = account;
        this.setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(1000);
        }
    }
}
