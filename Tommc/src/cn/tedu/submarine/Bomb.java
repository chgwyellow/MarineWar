package cn.tedu.submarine;


import javax.swing.*;

/**
 * 炸彈類別
 */
public class Bomb extends SeaObject {
    public Bomb(int x, int y) {    //x和y不確定位置，由創造的物件指定
        super(9, 12, x, y, 3);
    }

    @Override
    public void step() {
        y += speed;
    }

    @Override
    protected ImageIcon getImage() {
        if (isLive()) {  //判斷當前物件是否存活，返回同樣是布林值，可以不用加this
            return ImageResources.bomb;
        }
        return null;    //物件死亡就不傳回圖片
    }

    @Override
    public boolean isOutBounds() {
        return this.y >= GameWorld.HEIGHT;  //炸彈越界標準
    }
}
