package cn.tedu.submarine;


import javax.swing.*;

/**
 * 魚雷潛艇類別
 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore {
    public TorpedoSubmarine() {
        super(64, 20);
    }

    @Override
    public void step() {
        x += speed;
    }

    @Override
    protected ImageIcon getImage() {
        if (isLive()) {
            return ImageResources.torpesubm;
        }
        return null;
    }

    @Override
    public int getScore() {
        return 40;
    }
}

