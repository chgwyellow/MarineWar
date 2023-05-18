package cn.tedu.submarine;


import javax.swing.*;
import java.awt.*;

/**
 * 父類別
 * 海洋對象類別
 * 放7個類別中共有的屬性和行為
 */
public abstract class SeaObject {   //抽象類別
    //用常數來表示一定會遇到得狀態
    public static final int LIVE = 0;   //活著的狀態
    public static final int DEAD = 1;   //死亡的狀態
    public int currentState = LIVE; //默認是活著的狀態

    protected int width;
    protected int height;
    protected int x;  //x軸
    protected int y;  //y軸
    protected int speed; //速度


    protected SeaObject(int width, int height) {   //給MineSubmarine, ObserverSubmarine, TorpedoSubmarine呼叫父類別的建構方法
        this.width = width;
        this.height = height;
        x = -width;
        y = (int) (Math.random() * (GameWorld.HEIGHT - height - 150) + 150);
        speed = (int) (Math.random() * (3 - 1) + 1);
    }

    protected SeaObject(int width, int height, int x, int y, int speed) {    //給戰艦、炸彈、水雷、魚雷類提供建構方法，具體數據由調用的類別輸入
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public boolean isLive() {
        return currentState == LIVE;  //判斷目前狀態是否活著，是就返回True
    }

    public boolean isDead() {
        return currentState == DEAD;  //判斷目前狀態是否死亡，是就返回True
    }

    protected abstract void step();    //抽象方法

    protected abstract ImageIcon getImage();    //獲取圖片的方法，由子類去實現

    /**
     * 為所有子類提供的繪製方法
     * 誰調用
     * this就是誰
     */
    public void paintImage(Graphics g) {
        ImageIcon icon = this.getImage(); //透過this調用當前調用方法物件的圖片
        if (icon != null) { //如果icon的圖片存在，才繪製圖片
            icon.paintIcon(null, g, this.x, this.y);   //null,g,x,y
        }
    }

    /**
     * 三種潛艇發射雷對象的方法
     * 由雷入場的方法調用
     * 水雷潛艇調用則返回水雷
     * 魚雷潛艇則返回魚雷
     * 偵查潛艇返回null
     * 雷發射的位置是在潛艇的頭
     * x : this.x + this.width
     * y : this.y - 5
     */
    public SeaObject shootThunder() {
        int x = this.x + this.width;
        int y = this.y - 5;
        //判斷類型語法: instanceof
        if (this instanceof MineSubmarine) {  //判斷當前物件是不是MineSubmarine
            return new Mine(x, y);  //創立新的水雷物件
        } else if (this instanceof TorpedoSubmarine) {
            return new Torpedo(x, y);   //創立新的魚雷物件
        }
        return null;    //偵查潛艇不需要返回值
    }

    /**
     * 判斷物件是否越界的方法
     */
    //潛艇的判斷條件相同，提出來做成普通方法
    public boolean isOutBounds() {
        return this.x >= GameWorld.WIDTH;  //潛艇超過視窗的寬
    }

    /**
     * 判斷是否有碰撞發生
     */
    public boolean isHit(SeaObject other) {
        //other表示傳遞進來的碰撞物件
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        int x = other.x;
        int y = other.y;
        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }

    /**
     * 誰調用誰死掉
     */
    public void goDead(){
        this.currentState = DEAD;
    }
}
