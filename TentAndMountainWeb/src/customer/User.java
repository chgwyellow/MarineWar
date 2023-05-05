package customer;


/**
 * @author chgwyellow
 * @create 2023-05-05-17:17
 */
public class User {
    private String account;
    private String password;
    private String gender;
    private String email;
    private String name;

    public User(String account, String password, String gender, String email, String name) {
        this.account = account;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.name = name;
    }
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

    public static String Pattern_Email() {
        //email格式的正規表達式
        return "[a-zA-Z0-9]{7,15}@[a-zA-Z]+(\\.[a-z]+)+";
    }

    public static String Pattern_Name() {
        //姓名格式的正規表達式
        return "[a-zA-Z]+";
    }

    public static String Pattern_Account() {
        //帳號格式的正規表達式
        return "[a-zA-Z0-9]{6,15}";
    }

    public static String Pattern_PassWord() {
        //密碼格式的正規表達式
        return "[a-zA-Z0-9]{6,12}";
    }

}
