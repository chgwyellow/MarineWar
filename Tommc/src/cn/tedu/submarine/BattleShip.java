package cn.tedu.submarine;


import javax.swing.*;
import java.awt.*;

/**
 * 戰艦類別
 */
public class BattleShip extends SeaObject {
    private int life;   //戰艦特有

    public int getLife() {   //對外提供可以獲取life的方法
        return life;
    }

    public void setLife(int life) {  //對外提供可以累加生命的方法
        if (life > 0) {
            this.life += life;
        }
    }

    public void subtractLife(){ //減命
        life--;
    }

    public BattleShip() {   //戰艦只有一個，且各初始值皆固定，用無參數即可
        super(66, 26, 270, 124, 20);
        life = 5;
    }

    @Override
    public void step() {
        System.out.println("戰艦透過鍵盤左右鍵移動...");
    }

    @Override
    protected ImageIcon getImage() {    //戰艦獲取圖片的重寫
        return ImageResources.battleship;
    }

    //發射炸彈方法
    public Bomb shootBomb() {
        return new Bomb(x, y);   //在戰艦圖片的x,y發射炸彈
    }

    public void moveLeft() {    //左移
        if (x >= 0) //限制戰艦最左邊界
            x -= speed;
    }

    public void moveRight() {   //右移
        if (x <= GameWorld.WIDTH - width)   ////限制戰艦最右邊界
            x += speed;
    }
}
