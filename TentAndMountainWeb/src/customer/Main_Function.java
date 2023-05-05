package customer;


import java.io.IOException;
import java.util.Scanner;

/**
 * @author chgwyellow
 * @create 2023-05-05 17:28
 * @主要功能執行類別
 */

public class Main_Function {
    public static void main(String[] args) throws IOException {

        UserManagement user = new UserManagement();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("請選擇需要的操作: 註冊 登入 查詢資料 或輸入q離開");
            String result = sc.nextLine();
            if (result.equals("註冊")) {
                user.register();
            } else if (result.equals("登入")) {
                user.login();
            } else if (result.equals("查詢資料")) {
                System.out.println("請輸入帳號: ");
                String account = sc.nextLine();
                user.queryUserInfo(account);
            } else if (result.equals("q")) {
                System.out.println("程式結束執行");
                break;
            }
        }
    }
}
