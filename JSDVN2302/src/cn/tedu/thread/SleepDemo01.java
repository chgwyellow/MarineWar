package cn.tedu.thread;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 20:47
 * @description Thread中的靜態sleep方法
 * 執行緒呼叫sleep()後會進入阻塞狀態 參數設定為毫秒
 * 時間到後會自動進入就緒狀態並繼續執行
 */
public class SleepDemo01 {
    public static void main(String[] args) {

        System.out.println("Start!");
        try {
            Thread.sleep(5000); //單位毫秒
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End!");

    }
}
