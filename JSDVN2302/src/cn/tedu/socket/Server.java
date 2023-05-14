package cn.tedu.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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
    private PrintWriter[] allOut = {}; //將各socket的輸出串流存入陣列

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
            PrintWriter pw = null; //全域變數
            /**
             Socket的getInputStream()方法
             接收用戶端輸出的數據
             */
            try {
                InputStream is = socket.getInputStream();
                //低級串流轉成高級串流
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

                //從socket獲取輸出串流給其他用戶發送消息
                OutputStream out = socket.getOutputStream();
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8)), true);

                //將該用戶端的輸出串流存入 等於用戶上線
                allOut = Arrays.copyOf(allOut, allOut.length + 1);//擴容
                allOut[allOut.length - 1] = pw; //最後一個index存入
                //廣播通知用戶上線
                sendMessage("一個用戶上線!\n當前在線人數: " + allOut.length);

                //br讀取到的數據儲存到line裡面
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    //將用戶端發送的訊息傳給所有用戶
                    sendMessage(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                //用戶端離線時將pw移出allOut陣列 縮容
                for (int i = 0; i < allOut.length; i++) {
                    //找到要刪除的元素 其實就是pw 因為不下線會一直在while迴圈裏面跑
                    if (allOut[i] == pw) {
                        allOut[i] = allOut[allOut.length - 1]; //將最後的元素覆蓋下線的用戶
                        allOut = Arrays.copyOf(allOut, allOut.length - 1); //縮容

                        break; //找到目標就結束 不用遍歷整個陣列
                    }
                }
                //廣播通知用戶下線
                sendMessage("一個用戶下線!\n當前在線人數: " + allOut.length);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 廣播通知所有用戶端
         *
         * @param message 訊息
         */
        private void sendMessage(String message) {
            for (int i = 0; i < allOut.length; i++) {
                allOut[i].println(message);
            }
        }
    }
}
