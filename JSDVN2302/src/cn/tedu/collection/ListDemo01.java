package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: ListDemo
 * Package: cn.tedu.collection
 * Descprition:
 * List學習
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 08:51
 */
public class ListDemo01 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        System.out.println("List: " + list);

        //E get(int index)
        String str = list.get(2);//用index取出元素
        System.out.println("Str: " + str);

        //用index遍歷集合
        for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
            System.out.println("集合中的第" + (i + 1) + "個元素: " + str);
        }

        /**
         *E set(int index, E element);
         * 給定的element設置在index上 並將被替換的元素返回
         */
        str = list.set(2, "star");
        System.out.println("被替換的元素= " + str); //C
        System.out.println("list= " + list);

        //翻轉集合 Collections是集合的工具類別套件 直接針對整個集合動作
        Collections.reverse(list);
        System.out.println("翻轉後的集合: " + list);

        //添加元素進入集合
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "1", "2", "3");
        System.out.println(list1);

    }
}
