package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: CollectionDemo01
 * Package: cn.tedu.collection
 * Descprition:
 * Java集合類
 * 用於儲存一組數據 但集合是將元素的操作都封裝成方法
 * 並提供各種實現類別使用
 *
 * @Author chgwyellow
 * @Create 2023-05-14 上午 11:08
 */
public class CollectionDemo01 {
    public static void main(String[] args) {

        //Collection是一個父介面 無法直接創立物件
        Collection c = new ArrayList();
        /*
        boolean add(E e);
        E是泛型
         */
        c.add("one");//添加元素
        c.add("two");
        c.add("three");
        System.out.println(c);
        System.out.println(c.size());//列印集合中的元素個數
        System.out.println("集合是否為空: "+c.isEmpty());//判斷集合是否為空
        System.out.println("開始清理集合");
        c.clear(); //清空集合
        System.out.println("集合是否為空: "+c.isEmpty());//判斷集合是否為空

    }
}
