package cn.tedu.submarine;


import javax.swing.*;

/**
 * 魚雷類別
 */
public class Torpedo extends SeaObject {
    public Torpedo(int x, int y) {
        super(5, 18, x, y, 2);
    }

    @Override
    public void step() {
        y -= speed;
    }

    @Override
    protected ImageIcon getImage() {
        if (isLive()) {
            return ImageResources.torpedo;
        }
        return null;
    }

    @Override
    public boolean isOutBounds() {
        return this.y <= -this.height;  //魚雷越界標準
    }
}
