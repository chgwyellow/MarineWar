package cn.tedu.thread;

import java.util.Scanner;

/**
 * @author chgwyellow
 * @create 2023-05-09
 * @time 20:47
 * @description 用sleep寫倒數計時
 */
public class SleepDemo02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入倒數計時時間: ");
        int time = sc.nextInt();
        for (int i = time; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time's up!");

    }
}
