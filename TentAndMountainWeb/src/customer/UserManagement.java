package customer;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author chgwyellow
 * @create 2023-05-05 17:20
 * @用戶資料
 * @註冊、登入和查詢資料系統
 */
public class UserManagement {

    /**
     * 建立儲存用戶資料的陣列
     */
    private ArrayList<User> userList = new ArrayList<>();

    /**
     * 預設未註冊成功為false
     */
    public boolean isRegistered = false;

    /**
     * 註冊方法
     */
    public void register() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("請依序輸入資料\n");

        System.out.println("請輸入帳號: ");
        String account = sc.nextLine();
        if (!(account.matches(User.Pattern_Account()))) {
            System.out.println("Wrong account format.");
            return;
        }

        System.out.println("請輸入密碼: ");
        String pwd = sc.nextLine();
        if (!(pwd.matches(User.Pattern_PassWord()))) {
            System.out.println("Wrong password format.");
            return;
        }

        System.out.println("請輸入姓名: ");
        String name = sc.nextLine();
        if (!(name.matches(User.Pattern_Name()))) {
            System.out.println("Wrong name format.");
            return;
        }

        System.out.println("請輸入性別(male/female): ");
        String gender = sc.nextLine();
        if (!(gender.equals("Male") || gender.equals("male") || gender.equals("Female") || gender.equals("female"))) {
            System.out.println("Wrong gender.");
            return;
        }

        System.out.println("請輸入Email: ");
        String email = sc.nextLine();
        if (!(email.matches(User.Pattern_Email()))) {
            System.out.println("Wrong email format.");
            return;
        }

        User user1 = new User(account, pwd, name, gender, email);
        userList.add(user1);
        //將用戶資料寫入文件檔中
        PrintWriter bw = new PrintWriter(new FileWriter("./img&info/userInfo.txt"));
        for (User user : userList) {
            bw.println("Account: " + user.getAccount() + ", Password: " + user.getPassword() + ", Name: " + user.getName() + ", Gender: " + user.getGender() + ", Email: " + user.getEmail());
            bw.close();
            System.out.println(" Register is Finished. Welcome to be the part of us!");
        }
        isRegistered = true;

    }

    /**
     * 登入方法
     */
    public void login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入你的帳號: ");
        String account = sc.nextLine();

        System.out.println("請輸入你的密碼: ");
        String pwd = sc.nextLine();

        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(pwd)) {
                System.out.println("登入成功!");
                break;
            }
            System.out.println("帳號或密碼錯誤");
        }

    }

    /**
     * 查詢用戶資料
     */
    public void queryUserInfo(String account) {

        for (User user : userList) {
            if (user.getAccount().equals(account)) {
                System.out.println("Account: " + user.getAccount());
                System.out.println("Name: " + user.getName());
                System.out.println("Gender: " + user.getGender());
                System.out.println("Email: " + user.getEmail());
                break;
            }
            System.out.println("User is not found!");
        }

    }


}