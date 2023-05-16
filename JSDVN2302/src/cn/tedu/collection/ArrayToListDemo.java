package cn.tedu.collection;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ArryToListDemo
 * Package: cn.tedu.collection
 * Descprition:
 * 陣列轉為集合
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 09:26
 */
public class ArrayToListDemo {
    public static void main(String[] args) {

        String[] array = {"A", "B", "C", "D", "E"};
        System.out.println("陣列array: " + Arrays.toString(array));

        //陣列轉成對應集合
        List<String> list = Arrays.asList(array);
        System.out.println("集合list: " + list);

    }
}
