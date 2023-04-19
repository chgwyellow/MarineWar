package customer;

import javax.jws.soap.SOAPBinding;

public class Login_SignUp {
    public static void main(String[] args) {

        User user = new User();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setGender("男");
        user.setEmail("dinnis1107@gmail.com");
        user.setName("Arthur");
        if (SignUp(user)) {
            System.out.println(Login(user));
        }


    }

    /**
     * TODO 登入方法
     */
    public static String Login(User user) {
        if (user.getAccount().equals("admin") && user.getPassword().equals("123456"))
            return "登入成功";
        else if (!(user.getAccount().equals("admin"))) //帳號不匹配
            return "查無此帳號!";
        else    //密碼不匹配
            return "密碼錯誤!";
    }

    /**
     * TODO 註冊方法
     */
    public static boolean SignUp(User user) {
        if (!(user.getGender().equals("男") || user.getGender().equals("女"))) {
            System.out.println("性別未填寫");
            return false;
        } else if (!(user.getEmail().matches(user.getPattern_Email()))) {
            System.out.println("Wrong email format.");
            return false;
        } else if (!(user.getName().matches(user.getPattern_Name()))) {
            System.out.println("Wrong name format.");
            return false;
        } else {
            System.out.println("註冊完畢，請開始使用");
            return true;
        }
    }
}

/**
 * TODO 登入方法
 */
class User { //使用者的屬性
    private String account;
    private String password;
    private String gender;
    private String email;
    private String name;
    private final String pattern_Email = "[a-zA-Z0-9]{7,15}@[a-zA-Z]+(\\.[a-z]+)+"; //email格式的正規表達式
    private final String pattern_Name = "[a-zA-Z]+"; //姓名格式的正規表達式

    public void setAccount(String account) { //輸入帳號
        this.account = account;
    }

    public void setPassword(String password) { //輸入密碼
        this.password = password;
    }

    public void setGender(String gender) { //輸入性別
        this.gender = gender;
    }

    public void setEmail(String email) { //輸入email
        this.email = email;
    }

    public void setName(String name) { //輸入姓名
        this.name = name;
    }

    public String getAccount() { //取得帳號
        return account;
    }

    public String getPassword() { //取得密碼
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPattern_Email(){
        return pattern_Email;
    }

    public String getPattern_Name(){
        return pattern_Name;
    }

}

