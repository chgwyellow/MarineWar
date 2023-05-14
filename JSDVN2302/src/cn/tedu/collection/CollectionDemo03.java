package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: CollectionDemo01
 * Package: cn.tedu.collection
 * Descprition:
 * 集合間的操作
 *
 * @Author chgwyellow
 * @Create 2023-05-14 上午 11:08
 */
public class CollectionDemo03 {
    public static void main(String[] args) {

        Collection c1 = new ArrayList();
        c1.add("大娃");
        c1.add("二娃");
        c1.add("三娃");
        System.out.println("c1= " + c1);
        Collection c2 = new ArrayList();
        c2.add("四娃");
        c2.add("五娃");
        //c2.add("大娃");
        System.out.println("c2= " + c2);

        //將給定集合中的所有元素添加到當前的集合中
        //操作後的集合發生改變則返回true
        c1.addAll(c2);
        System.out.println("c1= " + c1);
        System.out.println("c2= " + c2);

        Collection c3 = new ArrayList();
        c3.add("二娃");
        c3.add("大娃");
        System.out.println("c3= " + c3);
        //當前集合中是否包含給定集合的所有元素
        boolean b = c1.containsAll(c3);
        System.out.println("c1是否包含c3: " + b);

        //將當前集合中的元素和給定集合中元素相同的部分 取交集
        c1.retainAll(c3);
        System.out.println("c1= " + c1);
        System.out.println("c3= " + c3);
        c3.add("蛇精");

        //將當前集合和給定集合中相同的部分刪除
        c1.removeAll(c3);
        System.out.println("c1= " + c1);
        System.out.println("c3= " + c3);

    }
}
