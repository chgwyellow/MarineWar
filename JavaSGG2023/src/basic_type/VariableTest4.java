package basic_type;

/**
 * @author chgwyellow
 * @since 2023/5/6 19:00
 * 測試強制類型轉換
 * 強轉過程如果超過接收值的可存取範圍
 * 會造成精度損失
 */
public class VariableTest4 {
    public static void main(String[] args) {
        
        double d1 = 12; //automatically transfer type

        //int i1 = d1; //error

        int i2 =(int)d1; //force transfer type
        System.out.println(i2);

        long l1 = 123;

        //short s1 = l1; //error

        short s2 = (short)l1; //force transfer type
        System.out.println(s2);

        //練習
        int i3 = 12;
        float f1 = i3;//automatically transfer type
        System.out.println(f1);//12.0

        //精度損失
        double d2 = 12.3;
        int i4 = (int)d2;
        System.out.println(i4);//12


    }
}
