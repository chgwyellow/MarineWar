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
        System.out.println(c);

    }
}
