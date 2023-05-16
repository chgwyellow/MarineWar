package cn.tedu.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ListDemo
 * Package: cn.tedu.collection
 * Descprition:
 * 給指定index添加元素
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 08:51
 */
public class ListDemo02 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        System.out.println("List: " + list);

        //添加元素至集合最後面
        list.add("G");
        //添加元素至指定位置 並將原index後的元素全部後移
        list.add(3, "star");
        System.out.println("list = " + list);

        //刪除指定index的元素並返回
        String str = list.remove(3);
        System.out.println("刪除了: " + str);
        System.out.println("list: " + list);

    }
}
