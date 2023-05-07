package cn.tedu.socket;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author chgwyellow
 * @ date 2023-05-06
 * 聊天室客戶端
 */

public class Client {

    /*
    網路插座
    封裝了TCP協議，可以與遠端建立TCP連線
    並應用IO串流來完成與其他伺服器完成數據交換
     */
    private Socket socket;

    //初始化客戶端內容 類似事前準備
    public Client() {
        try {
            System.out.println("正在連接伺服器...");
        /*
        創建socket時傳入兩個參數
        1. 要連接的伺服器IP
        要連接的IP位置分兩種:
        1) 如果是非本機 需要查詢對方IP
        2) 如果是本機 可以選取下列的值:
                i. 真實IP(ipconfig)
                ii. 127.0.0.1(自動映射本機的真實IP)
                iii. localhost(是127.0.0.1的域名)
        2. 要連接的伺服器port
         */
            socket = new Socket("localhost", 8088);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //用戶端開始工作的方法 執行工作邏輯
    public void start() throws IOException {

        try {
            /*
            呼叫Socket的getOutputStream()方法
            獲取位元輸出流
            輸出的位元會透過網路發送到遠端伺服器
             */
            OutputStream out = socket.getOutputStream();
            //將低級串流轉換成高級串流
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8)), true);
            Scanner sc = new Scanner(System.in);
            while (true) {
                String line = sc.nextLine();
                if ("exit".equals(line)) { //TCP協議下 和伺服器中斷連線必須通知 否則會報錯
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /*
            Socket提供的close方法
            1. 中斷連線並告知
            2. 將socket所連接的串流關閉
             */
            socket.close();
        }

    }

    //主程式開始 只用來調用方法 不會寫太多程式碼
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

    }

}
