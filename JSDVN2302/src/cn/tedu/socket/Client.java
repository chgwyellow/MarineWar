package cn.tedu.socket;


import java.io.IOException;
import java.net.Socket;

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

    //客戶端開始工作的方法 執行工作邏輯
    public void start() {


    }

    //主程式開始 只用來調用方法 不會寫太多程式碼
    public static void main(String[] args) {

        Client client = new Client();
        client.start();

    }

}
