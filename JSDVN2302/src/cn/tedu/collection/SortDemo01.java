package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ClassName: SortDemo01
 * Package: cn.tedu.collection
 * Descprition:
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 09:30
 */
public class SortDemo01 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100)); //生成100以內的隨機整數
        }
        System.out.println("亂序list = " + list);

        Collections.sort(list); //對list進行小到大排序
        System.out.println("排序後list = " + list);

    }
}
