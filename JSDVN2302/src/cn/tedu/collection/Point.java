package cn.tedu.collection;

/**
 * ClassName: Point
 * Package: cn.tedu.collection
 * Descprition:
 *
 * @Author chgwyellow
 * @Create 2023-05-14 上午 11:33
 */
public class Point {

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
        return "(" + x +","+ y + ')';
    }

}
