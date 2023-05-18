package cn.tedu.submarine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.TimerTask; //任務模板類別
import java.util.Timer; //定時器類別
import java.awt.event.KeyEvent; //鍵盤事件
import java.awt.event.KeyAdapter;   //鍵盤監聽器

/**
 * 遊戲窗口
 * 用來運行程式
 * 本類別的所有變數和方法都只在自己類使用
 * 所以全部修飾符都用private
 */

public class GameWorld extends JPanel {
    //宣告常數
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;
    public static final int GAME_START = 0; //遊戲開始狀態
    public static final int GAME_RUNNING = 1; //遊戲運行狀態
    public static final int GAME_OVER = 2; //遊戲結束狀態

    public int currentGameStates = GAME_START;  //默認遊戲開始狀態

    // 宣告類別的實例變數，整個class都可以使用
    private BattleShip ship = new BattleShip(); //戰艦只有一個，可以直接創造物件
    //為陣列賦值{}，表示創建對象，但長度為0
    private Bomb[] bomb = {};    //多的同類型物件，用[]存儲
    private SeaObject[] submarine = {}; //代表三種不同潛艇
    private SeaObject[] thunder = {};    //代表兩種不同的雷


    /**
     * 創建潛艇物件的方法，該方法由潛艇入場方法調用
     * 方法返回值可能是隨機的潛艇對象
     * 返回值類型寫父類別
     */
    private SeaObject createSubmarine() {   //有回傳值的方法，可以不必另外創造物件去接收
        /*
        1.產生0~20區間(不含20)的隨機整數
        2.該值小於10 生成偵查潛艇
        小於15則生成魚雷潛艇
        否則返回水雷潛艇
         */
        int type = (int) (Math.random() * 20);
        if (type < 10)
            return new ObserverSubmarine();
        else if (type < 15)
            return new TorpedoSubmarine();
        else
            return new MineSubmarine();
    }

    private int submarineEnterIndex = 0;    //控制潛艇生成的時間

    /**
     * 潛艇入場的方法 --- 在run中調用
     */
    private void submarineEnterAction() {   //遊戲設定10毫秒執行一次
        submarineEnterIndex++;  //方法執行一次就自增一次
        if (submarineEnterIndex % 40 == 0) {    //設定每400毫秒生成一次
            submarine = Arrays.copyOf(submarine, submarine.length + 1); //陣列擴充
            submarine[submarine.length - 1] = createSubmarine();    //調用生成潛艇方法並直接賦值
        }
    }

    private int thunderEnterIndex = 0; //控制雷生成的時間

    /**
     * 雷入場方法 --- 在run中調用
     */
    private void thunderEnterAction() {     //每10毫秒調用一次
        thunderEnterIndex++;
        if (thunderEnterIndex % 100 == 0) { //每隔1000毫秒在潛艇陣列生成可以發射雷的指令
            for (int i = 0; i < submarine.length; i++) {    //for循環遍歷submarine陣列
                if ((submarine[i].shootThunder()) != null) {     //不為null的情況
                    thunder = Arrays.copyOf(thunder, thunder.length + 1);   //陣列擴充
                    thunder[thunder.length - 1] = submarine[i].shootThunder();
                }
            }
        }
    }

    private void stepAction() {
        for (int i = 0; i < submarine.length; i++) {
            submarine[i].step();
        }
        for (int i = 0; i < thunder.length; i++) {
            thunder[i].step();
        }
        for (int i = 0; i < bomb.length; i++) {
            bomb[i].step();
        }
    }

    private void bombEnterAction() {    //投放炸彈方法
        bomb = Arrays.copyOf(bomb, bomb.length + 1);
        bomb[bomb.length - 1] = ship.shootBomb();   //用戰艦去調用方法
    }

    /**
     * 超過範圍的物件自動刪除減少內存占用
     */
    private void deleteOfOutBounds() {
        submarine = deleteObjectByArray(submarine);
        thunder = deleteObjectByArray(thunder);
        bomb = (Bomb[]) deleteObjectByArray(bomb);   //downcasting，因為方法內是傳入父類別物件
    }

    /**
     * 將陣列物件刪除的方法優化
     */
    public SeaObject[] deleteObjectByArray(SeaObject[] seaObjects) {
        for (int i = 0; i < seaObjects.length; i++) {
            if (seaObjects[i].isOutBounds() || seaObjects[i].isDead()) {
                seaObjects[i] = seaObjects[seaObjects.length - 1];
                seaObjects = Arrays.copyOf(seaObjects, seaObjects.length - 1);
            }
        }
        return seaObjects;  //縮容後的新陣列
    }

    /**
     * 炸彈與潛艇碰撞測試
     */
    private void bombBangAction() {
        for (int i = 0; i < bomb.length; i++) { //輪數循環
            Bomb b = bomb[i];   //儲存當前炸彈物件
            for (int j = 0; j < submarine.length; j++) {    //次數循環
                if (b.isHit(submarine[j])) {  //用當前炸彈對像一次與潛艇數組做碰撞檢測
                    b.goDead();
                    submarine[j].goDead();
                    if (submarine[j] instanceof EnemyScore) { //如果當前潛艇物件實作了加分介面
                        EnemyScore obj = (EnemyScore) submarine[j]; //向下轉型成介面類型
                        score += obj.getScore();    //編譯調介面的方法，執行回到原類別方法
                    } else if (submarine[j] instanceof EnemyLife) {
                        EnemyLife obj = (EnemyLife) submarine[j];
                        ship.setLife(obj.getLife());
                    }
                }
            }
        }
    }

    /**
     * 雷與戰艦的碰撞方法
     */
    private void thunderBangAction() {
        for (int i = 0; i < thunder.length; i++) {
            if (thunder[i].isHit(ship)) {
                thunder[i].goDead();    //碰撞的雷標記為死亡狀態
                ship.subtractLife();    //戰艦減命
                checkGameOver();    //檢測是否符合遊戲結束
            }
        }
    }

    /**
     * 確認命數是否歸零
     */
    private void checkGameOver() {
        if (ship.getLife() <= 0) {
            currentGameStates = GAME_OVER;
        }
    }

    private void action() {
        //創建各類別物件，方便創造多個物件
        //監聽使用者是否按下鍵盤!
        //1.創建監聽器對象  2.監聽按下鍵盤的方法
        KeyAdapter adapter = new KeyAdapter() { //KeyAdapter是抽象類別，建立匿名類部類
            @Override
            public void keyPressed(KeyEvent e) {    //當按下鍵盤的監聽方法
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {  //判斷是否按下鍵盤空白鍵
                    if (currentGameStates == GAME_START) {  //如果當前狀態是遊戲開始
                        currentGameStates = GAME_RUNNING;    //切換成運行狀態
                    } else {
                        bombEnterAction();  //發射炸彈
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {    //判斷是否按下右方向鍵
                    ship.moveRight();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {     //判斷是否按下左方向鍵
                    ship.moveLeft();
                }
            }
        };
        addKeyListener(adapter);    //將監聽器對象添加在鍵盤檢測中


        //創建定時器物件
        Timer timer = new Timer();

        //重寫TimerTask類中的抽象方法run，但只會給schedule方法使用，所以創建匿名類別
        TimerTask task = new TimerTask() {
            @Override
            public void run() { //需要自動執行的任務程式碼編寫區
                if (currentGameStates == GAME_RUNNING) {    //運行才執行方法
                    submarineEnterAction(); //調用潛艇入場的方法
                    thunderEnterAction();   //調用雷入場方法
                    stepAction();   //調用移動方法
                    deleteOfOutBounds();    //調用越界刪除方法
                    bombBangAction();   //調用碰撞檢測方法
                    thunderBangAction();    //調用雷和戰艦碰撞方法
                    repaint();  //重新刷新繪製
                }
            }
        };

        timer.schedule(task, 3000, 10);   //1.給任務 2.給延遲時間(毫秒) 3.給間隔時間(0.01-0.02秒是遊戲建議)
    }

    //繪製視窗方法---在main中使用
    private void paintWorld() {
        JFrame j = new JFrame();    //創建一個視窗物件
        this.setFocusable(true);      //視窗可聚焦，滑鼠游標移出視窗依然可以執行程式
        j.add(this);                             //視窗添加底板
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //視窗關閉並停止程式
        j.setSize(WIDTH + 16, HEIGHT + 39);   //視窗大小，+16是預留兩側空位，+39是標題列的高，641,479是內部視窗的大小
        j.setLocationRelativeTo(null);      //默認視窗居中
        j.setVisible(true);     //設定視窗可見
    }

    private int score = 0;  //分數

    /**
     * 繪製遊戲視窗與內容
     */
    @Override
    public void paint(Graphics g) {
        switch (currentGameStates) {    //遊戲開始時
            case GAME_START:
                ImageResources.start.paintIcon(null, g, 0, 0);  //開始畫面
                break;
            case GAME_RUNNING:  //遊戲運行時
                ImageResources.sea.paintIcon(null, g, 0, 0);    //繪製背景圖
                ship.paintImage(g);
                for (int i = 0; i < bomb.length; i++) {
                    bomb[i].paintImage(g);
                }
                for (int i = 0; i < submarine.length; i++) {
                    submarine[i].paintImage(g);
                }
                for (int i = 0; i < thunder.length; i++) {
                    thunder[i].paintImage(g);
                }
                g.setFont(new Font("", Font.BOLD, 20));
                g.drawString("SCORE:" + score, 200, 50);    //繪製分數
                g.drawString("LIFE:" + ship.getLife(), 400, 50);
                break;
            case GAME_OVER: //遊戲結束時
                ImageResources.gameover.paintIcon(null, g, 0, 0);
                break;
        }
    }

    public static void main(String[] args) {
        GameWorld gw = new GameWorld();
        gw.paintWorld();    //調用繪製視窗方法
        gw.action();             //調用方法創造物件
    }
}





