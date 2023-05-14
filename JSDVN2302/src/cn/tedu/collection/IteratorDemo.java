package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ClassName: IteratorDemo
 * Package: cn.tedu.collection
 * Descprition:
 * 集合支持隨機存取 Collection除外
 * 用迭代器訪問
 *
 * @Author chgwyellow
 * @Create 2023-05-14 下午 04:20
 */
public class IteratorDemo {
    public static void main(String[] args) {

        Collection c = new ArrayList();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");
        c.add("F");
        System.out.println("c = " + c);

        //獲取迭代器
        Iterator it = c.iterator();
        while (it.hasNext()) { //如果迭代器後方還有元素
            Object e = it.next(); //用next()取出元素並移動迭代器
            System.out.println(e);
        }
    }
}
