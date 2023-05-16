package cn.tedu.collection;

import java.util.Objects;

/**
 * ClassName: Point
 * Package: cn.tedu.collection
 * Descprition:
 *
 * @Author chgwyellow
 * @Create 2023-05-14 上午 11:33
 */
public class Point implements Comparable<Point> {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //同類就true
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o; //將傳入參數強制轉型
        return x == point.x && y == point.y; //比較呼叫的變數與參數內容
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point o) { //自訂義排序方法
        //定義比較兩個點的x座標
        int x1 = this.getX();
        int x2 = o.getX();
//        if (x1 > x2)
//            return 1;
//        else if (x1 < x2) {
//            return -1;
//        } else
//            return 0;
        return x1 - x2;
    }
}

