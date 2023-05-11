package customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagement {
    ArrayList<User> userList = new ArrayList<>();
    public boolean isRegistered = false;

    /**
     * 註冊
     */
    public void register() throws IOException {

        while (!isRegistered) {
            Scanner sc = new Scanner(System.in);
            System.out.println("歡迎來到註冊頁面");
            System.out.println("請依序輸入資料\n");

            String account;
            do {
                System.out.println("請輸入帳號: ");
                account = sc.nextLine();
                if (!account.matches(User.Pattern_Account())) {
                    System.out.println("Wrong account format.");
                }
            } while (!account.matches(User.Pattern_Account()));

            String pwd;
            do {
                System.out.println("請輸入密碼: ");
                pwd = sc.nextLine();
                if (!pwd.matches(User.Pattern_PassWord())) {
                    System.out.println("Wrong password format.");
                }
            } while (!pwd.matches(User.Pattern_PassWord()));


            String name;
            do {
                System.out.println("請輸入姓名: ");
                name = sc.nextLine();
                if (!name.matches(User.Pattern_Name())) {
                    System.out.println("Wrong name format.");
                }
            } while (!name.matches(User.Pattern_Name()));


            String gender;
            do {
                System.out.println("請輸入性別(male/female): ");
                gender = sc.nextLine();
                if (!gender.equals("male") && !gender.equals("female")) {
                    System.out.println("Wrong gender.");
                }
            } while (!gender.equals("male") && !gender.equals("female"));


            String email;
            do {
                System.out.println("請輸入Email: ");
                email = sc.nextLine();
                if (!email.matches(User.Pattern_Email())) {
                    System.out.println("Wrong email format.");
                }
            } while (!email.matches(User.Pattern_Email()));


            User user1 = new User(account, pwd, name, gender, email);
            this.userList.add(user1);
            PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter("./img&info/userInfo.txt", true)));
            Iterator list = this.userList.iterator();

            while (list.hasNext()) {
                User user = (User) list.next();
                bw.println("Account: " + user.getAccount() + ", Password: " + user.getPassword() + ", Name: " + user.getName() + ", Gender: " + user.getGender() + ", Email: " + user.getEmail());
                System.out.println(" Register is Finished. Welcome to be the part of us!");
            }

            bw.close();
            this.isRegistered = true;
        }

    }


    /**
     * 登入
     */
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎來到登入頁面");
        System.out.println("請輸入你的帳號: ");
        String account = sc.nextLine();
        System.out.println("請輸入你的密碼: ");
        String pwd = sc.nextLine();
        Iterator list = userList.iterator();

        while (list.hasNext()) {
            User user = (User) list.next();
            if (user.getAccount().equals(account) && user.getPassword().equals(pwd)) {
                System.out.println("登入成功!");
                break;
            }

            System.out.println("帳號或密碼錯誤");
        }

    }

    /**
     * 查詢資料
     */
    public void queryUserInfo(String account) throws IOException {
        System.out.println("--您的會員資料--");
        BufferedReader br = new BufferedReader(new FileReader("./img&info/userInfo.txt"));
        String line = null;

        String[] userInfo;
        do {
            if ((line = br.readLine()) == null) {
                System.out.println("User is not found!");
                br.close();
                return;
            }

            userInfo = line.split(",");
        } while (!userInfo[0].trim().equals("Account: " + account));

        System.out.println("Account: " + userInfo[0].trim().substring(9));
        System.out.println("Password: " + userInfo[1].trim().substring(10));
        System.out.println("Name: " + userInfo[2].trim().substring(6));
        System.out.println("Gender: " + userInfo[3].trim().substring(8));
        System.out.println("Email: " + userInfo[4].trim().substring(7));
        br.close();
    }
}