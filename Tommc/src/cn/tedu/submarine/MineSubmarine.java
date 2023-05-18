package cn.tedu.submarine;


import javax.swing.*;

/**
 * 水雷潛艇類別
 */
public class MineSubmarine extends SeaObject implements EnemyLife {
    public MineSubmarine() {
        super(63, 19);
    }

    @Override
    public void step() {
        x += speed;
    }

    @Override
    protected ImageIcon getImage() {
        if (isLive()) {
            return ImageResources.minesubm;
        }
        return null;
    }

    @Override
    public int getLife() {
        return 1;
    }
}
