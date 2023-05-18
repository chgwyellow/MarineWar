package cn.tedu.submarine;


import javax.swing.*;

/**
 * 水雷類別
 */
public class Mine extends SeaObject {
    public Mine(int x, int y) {
        super(11, 11, x, y, 2);
    }

    @Override
    public void step() {
        y -= speed;
    }

    @Override
    protected ImageIcon getImage() {
        if (isLive()) {
            return ImageResources.mine;
        }
        return null;
    }

    @Override
    public boolean isOutBounds() {
        return this.y <= 150 - this.height;  //水雷越界標準
    }
}
