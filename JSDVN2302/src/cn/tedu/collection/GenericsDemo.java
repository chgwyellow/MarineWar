package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: GenericsDemo
 * Package: cn.tedu.collection
 * Descprition:
 * 泛型介紹
 *
 * @Author chgwyellow
 * @Create 2023-05-16 下午 07:35
 */
public class GenericsDemo {
    public static void main(String[] args) {

        Collection c = new ArrayList();
        //集合在沒有泛型的約束下 可以裝任型的類型
        c.add("任意類型的元素");

        Collection<String> c1 = new ArrayList<>();
        c1.add("現在只能寫入字串");

        Collection<Integer> c2 = new ArrayList<>();
        c2.add(43); //只能是整數類型

        //宣告泛型時，Test類別裡的所有T都會被改變
        Test<String> test = new Test<>();
        test.setObj("字串");
        test.getObj();

    }
}

//類別名稱後面用泛型約束 T-> type E->Element K->Key V->Value
class Test<T>{
    //類別中需要參數控制的地方都改成泛型
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}