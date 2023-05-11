package cn.tedu.thread;


/**
 * @author chgwyellow
 * @create 2023-05-11
 * @description :
 * join方法的使用
 * 將資源集中在某個執行緒
 */
public class JoinDemo {

    static boolean isFinish = false; //表示圖片未下載

    public static void main(String[] args) {

        Thread download = new Thread() { //下載
            @Override
            public void run() {
                System.out.println("開始下載圖片");
                for (int i = 1; i <= 100; i++) {
                    System.out.println("downloaded:" + i + "%");
                    try {
                        Thread.sleep(50
                        );
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("圖片下載完畢");
                isFinish = true; //表示圖片下載完畢
            }
        };

        Thread show = new Thread() { //顯示
            @Override
            public void run() {
                System.out.println("開始顯示文字");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("開始顯示圖片...");
                if (!isFinish) {
                    throw new RuntimeException("圖片加載失敗");
                }
                System.out.println("圖片下載完畢!");
            }
        };
        download.start();
        show.start();

    }
}
