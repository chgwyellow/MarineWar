package cn.tedu.submarine;


import javax.swing.*;

/**
 * 存放項目中需要用到的圖片資源
 * 初始化圖片
 */
public class ImageResources {
    //ImageIcon類別，圖片類型，可以用來存圖片資源
    public static ImageIcon battleship;
    public static ImageIcon bomb;
    public static ImageIcon gameover;
    public static ImageIcon mine;
    public static ImageIcon minesubm;
    public static ImageIcon obsersubm;
    public static ImageIcon sea;
    public static ImageIcon start;
    public static ImageIcon torpedo;
    public static ImageIcon torpesubm;

    static {
        battleship = new ImageIcon("Tommc/img/battleship.png");   //創建圖片物件，參照圖片位置
        bomb = new ImageIcon("Tommc/img/bomb.png");
        gameover = new ImageIcon("Tommc/img/gameover.png");
        mine = new ImageIcon("Tommc/img/mine.png");
        minesubm = new ImageIcon("Tommc/img/minesubm.png");
        obsersubm = new ImageIcon("Tommc/img/obsersubm.png");
        sea = new ImageIcon("Tommc/img/sea.png");
        start = new ImageIcon("Tommc/img/start.png");
        torpedo = new ImageIcon("Tommc/img/torpedo.png");
        torpesubm = new ImageIcon("Tommc/img/torpesubm.png");
    }

//    public static void main(String[] args) {
//        getImageLoadStatus(); 獲取圖片狀態，8表示沒問題，4表示有問題
//        System.out.println(battleship.getImageLoadStatus());
//        System.out.println(bomb.getImageLoadStatus());
//        System.out.println(gameover.getImageLoadStatus());
//        System.out.println(mine.getImageLoadStatus());
//        System.out.println(minesubm.getImageLoadStatus());
//        System.out.println(obsersubm.getImageLoadStatus());
//        System.out.println(sea.getImageLoadStatus());
//        System.out.println(start.getImageLoadStatus());
//        System.out.println(torpedo.getImageLoadStatus());
//        System.out.println(torpesubm.getImageLoadStatus());
//    }
}
