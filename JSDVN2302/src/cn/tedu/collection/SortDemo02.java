package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: SortDemo01
 * Package: cn.tedu.collection
 * Descprition:
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 09:30
 */
public class SortDemo02 {
    public static void main(String[] args) {

        List<Point> list = new ArrayList<>();
        list.add(new Point(1, 4));
        list.add(new Point(3, 12));
        list.add(new Point(2, 5));
        list.add(new Point(0, 8));
        list.add(new Point(3, 3));
        list.add(new Point(9, 2));
        System.out.println("亂序list: " + list);

        /*
        Collections的sort方法要對集合進行排序，必須實做Comparable介面
        該介面中的compareTo方法自定義排序規則
        sort方法會將集合中的兩個元素比較
        比較時會通過compareTo方法比較
        A.compareTo(B)
        A>B 返回正數
        A=B 返回0
        A<B 返回負數
         */
        Collections.sort(list);
        System.out.println("正序: " + list);

    }
}
