package customer;


/**
 * @author chgwyellow
 * @create 2023-05-05 00:14
 * 註冊與登入系統
 */
public class Login_SignUp {
    public static void main(String[] args) {

        User user = new User("dinnis1107", "123456", "Male", "dinnis1107@gmail.com", "Arthur");
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
        if (!(user.getGender().equals("Male") || user.getGender().equals("Female"))) {
            System.out.println("Wrong gender.");
            return false;
        } else if (!(user.getEmail().matches(user.Pattern_Email()))) {
            System.out.println("Wrong email format.");
            return false;
        } else if (!(user.getName().matches(user.Pattern_Name()))) {
            System.out.println("Wrong name format.");
            return false;
        } else if (!(user.getAccount().matches(user.Pattern_Account()))) {
            System.out.println("Wrong account format.");
            return false;
        } else if (!(user.getPassword().matches(user.Pattern_PassWord()))) {
            System.out.println("Wrong password format.");
            return false;
        } else {
            System.out.println("Sign up is Finished. Welcome to be the part of us!");
            return true;
        }
    }
}