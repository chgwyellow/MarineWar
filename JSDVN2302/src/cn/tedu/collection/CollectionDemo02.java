package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: CollectionDemo01
 * Package: cn.tedu.collection
 * Descprition:
 * 引用Point類別的建構方法
 *
 * @Author chgwyellow
 * @Create 2023-05-14 上午 11:08
 */
public class CollectionDemo02 {
    public static void main(String[] args) {

        Collection c = new ArrayList();
        c.add(new Point(1, 2));
        c.add(new Point(3, 4));
        c.add(new Point(5, 6));
        c.add(new Point(7, 8));
        c.add(new Point(9, 10));

        /*
        集合重寫toString方法
        格式:
        [元素1.toString, 元素2.toString,...]
         */
        System.out.println(c);
        Point p = new Point(3, 4);

        //contain() 是否包含 比較的是地址
        System.out.println("集合中是否包含(3,4)這個點: " + c.contains(p));

        //Object類別的equals()是比較地址
        //重寫equals方法比較內容
        System.out.println("集合中是否包含(3,4)這個點: " + c.equals(p));

    }
}
