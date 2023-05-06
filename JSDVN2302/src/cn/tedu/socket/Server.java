package cn.tedu.socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chgwyellow
 * @ date 2023-05-06
 * 聊天室伺服器端
 */

public class Server {

    /*
     * java.net.ServerSocket
     * 運行在伺服器端
     * 1.打開伺服器port(由客戶端來占用)
     * 2.監聽該port
     * 3.一旦客戶端訪問伺服器，就會生成socket，和客戶端
     */
    private ServerSocket server;

    public Server() {


        try {
            System.out.println("正在啟動伺服器...");
            /*
             * 建立ServerSocket時，要占用port，所以必須和用戶端的port一致
             */
            server = new ServerSocket(8088);
            System.out.println("伺服器連線成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void start() {

        while (true) {
            try {
                System.out.println("等待用戶端連接...");
            /*
            監聽當前占用的port，accept()方法為一個阻塞方法
            該port沒有被訪問，程序不會向下執行
            被用戶端訪問後會立即返回一個Socket物件，程序繼續執行
            該Socket會和用戶端交換數據
             */
                Socket socket = server.accept();
                System.out.println("用戶端已連接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        Server server = new Server();
        server.start();

    }
}
