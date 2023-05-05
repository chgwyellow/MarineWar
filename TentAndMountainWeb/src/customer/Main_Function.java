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


        label:
        while (true) {
            System.out.println("請選擇需要的操作: \n1. 註冊\n2. 登入\n3. 查詢資料\n輸入q離開");
            String result = sc.nextLine();
            switch (result) {
                case "1":
                    while (!user.isRegistered)
                        user.register();
                    break;
                case "2":
                    user.login();
                    break;
                case "3":
                    System.out.println("請輸入帳號: ");
                    String account = sc.nextLine();
                    user.queryUserInfo(account);
                    break;
                case "q":
                    System.out.println("程式結束執行");
                    break label;
            }
        }
    }
}
