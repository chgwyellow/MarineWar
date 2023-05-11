package customer;

import java.io.IOException;
import java.util.Scanner;

public class Main_Function {

    public static void main(String[] args) throws IOException {
        Main_Function mf = new Main_Function();
        mf.getMenu();
    }

    public void getMenu() throws IOException {
        UserManagement user = new UserManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("請選擇需要的操作: \n1. 註冊\n2. 登入\n3. 查詢資料\n輸入q離開");
            switch (sc.nextLine()) {
                case "1":
                    if (user.isRegistered) {
                        continue;
                    } else {
                        user.register();
                    }
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
                    return;
            }
        }
    }
}