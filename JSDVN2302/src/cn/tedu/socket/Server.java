package cn.tedu.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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
                //有用戶訪問時 創建一個執行緒負責和用戶交互
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        Server server = new Server();
        server.start();

    }

    /**
     * 定義執行緒的任務類 負責和用戶交互
     */
    private class ClientHandler implements Runnable {

        private Socket socket; //設定成員變數 該類別都可以使用

        public ClientHandler(Socket socket) { //將start方法裡的socket當成參數傳入
            this.socket = socket;
        }

        @Override
        public void run() {

            /*
            Socket的getInputStream()方法
            接收用戶端輸出的數據
            */
            try {
                InputStream is = socket.getInputStream();
                //低級串流轉成高級串流
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                //br讀取到的數據儲存到line裡面
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}