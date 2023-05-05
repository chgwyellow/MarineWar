package customer;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author chgwyellow
 * @create 2023-05-05 17:20
 * @客戶資料管理
 * @註冊與登入系統
 */
public class UserManagement {

    /**
     * 建立儲存用戶資料的陣列
     */
    private ArrayList<User> userList = new ArrayList<>();

    /**
     * TODO 登入方法
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
        }

    }

    /**
     * TODO 註冊方法
     */
    public void register() {

        Scanner sc = new Scanner(System.in);
        System.out.println("請依序輸入您的資料: ");

        System.out.println("請輸入帳號: ");
        String account = sc.nextLine();

        System.out.println("請輸入密碼: ");
        String pwd = sc.nextLine();

        System.out.println("請輸入姓名: ");
        String name = sc.nextLine();

        System.out.println("請輸入性別: ");
        String gender = sc.nextLine();

        System.out.println("請輸入Email: ");
        String email = sc.nextLine();

        if (!(gender.equals("Male") || gender.equals("Female"))) {
            System.out.println("Wrong gender.");
        } else if (!(email.matches(User.Pattern_Email()))) {
            System.out.println("Wrong email format.");
        } else if (!(name.matches(User.Pattern_Name()))) {
            System.out.println("Wrong name format.");
        } else if (!(account.matches(User.Pattern_Account()))) {
            System.out.println("Wrong account format.");
        } else if (!(pwd.matches(User.Pattern_PassWord()))) {
            System.out.println("Wrong password format.");
        } else {
            User user1 = new User(account, pwd, name, gender, email);
            userList.add(user1);
            System.out.println(" Register is Finished. Welcome to be the part of us!");
        }
    }
}