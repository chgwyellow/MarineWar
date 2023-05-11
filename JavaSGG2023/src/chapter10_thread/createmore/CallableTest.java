package chapter10_thread.createmore;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author chgwyellow
 * @create 2023-05-10
 *         descriptino : Callable介面使用
 */
public class CallableTest {
    public static void main(String[] args) {

        NumThread numThread = new NumThread();

        // 將callable介面實現的物件傳入FutureTask建構方法中
        FutureTask<Object> futureTask = new FutureTask<>(numThread);

        // 將FutureTask物件放入Thread中
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            Object sum = futureTask.get(); // 取得call方法的返回值
            System.out.println("偶數總和為:" + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class NumThread implements Callable<Object> { // 需要重寫call()方法 且可以使用泛型
    @Override
    public Object call() throws Exception { // 可以拋異常 也可以有任何型態的返回值
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
            Thread.sleep(10);
        }
        return sum;
    }
}