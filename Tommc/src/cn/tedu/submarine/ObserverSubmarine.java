package cn.tedu.submarine;


import javax.swing.*;

/**
 * 偵查潛艇類別
 */
public class ObserverSubmarine extends SeaObject implements EnemyScore {
    public ObserverSubmarine() {
        super(63, 19);
    }

    @Override
    public void step() {
        x += speed;
    }

    @Override
    protected ImageIcon getImage() {
        if (isLive()) {
            return ImageResources.obsersubm;
        }
        return null;
    }

    @Override
    public int getScore() {
        return 10;
    }
}
