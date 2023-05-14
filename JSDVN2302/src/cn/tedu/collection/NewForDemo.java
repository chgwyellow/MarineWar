package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: NewForDemo
 * Package: cn.tedu.collection
 * Descprition:
 * 增強for循環
 * 並不能取代舊的for循環
 * 只是為了使用相同格式遍歷集合和陣列
 * for(元素類型 e : 集合或陣列){
 * 主體
 * }
 *
 * @Author chgwyellow
 * @Create 2023-05-14 下午 04:43
 */
public class NewForDemo {
    public static void main(String[] args) {

        String[] arr = {"A", "B", "C", "D", "E"};
        System.out.println("----------------傳統for loop遍歷陣列----------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\n----------------新版for loop遍歷陣列----------------");
        for (String s : arr) {
            System.out.print(s + "\t");
        }

        Collection c = new ArrayList();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        System.out.println("\n----------------新版for loop遍歷集合----------------");
        for (Object e : c) {
            System.out.print(e + "\t");
        }

    }
}
