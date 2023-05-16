package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * ClassName: CollectionToArrayDemo
 * Package: cn.tedu.collection
 * Descprition:
 * 集合轉成陣列
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 09:16
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {

        Collection<String> c = new ArrayList<>();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");
        System.out.println("集合c: " + c);

        /*
        Object[] toArray();
        將當前集合轉換為Object類型的陣列
        此方法很少用
         */
        Object[] array = c.toArray();

        /*
        較常用方法  <T> T[] toArray(T[] a);
        陣列的類型最好和集合的泛型一致
        陣列長度最好和集合儲存的長度一致
         */
        String[] array1 = c.toArray(new String[c.size()]);
        System.out.println("陣列的長度: " + array1.length);
        System.out.println("陣列array1: " + Arrays.toString(array1));

    }
}
