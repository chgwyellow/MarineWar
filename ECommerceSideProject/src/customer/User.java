package customer;

public class User {
     private String account;
     private String password;
     private String gender;
     private String email;
     private String name;

     public User(String account, String password, String name, String gender, String email) {
         this.account = account;
         this.password = password;
         this.gender = gender;
         this.email = email;
         this.name = name;
     }

     public void setAccount(String account) {
         this.account = account;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public void setGender(String gender) {
         this.gender = gender;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getAccount() {
         return this.account;
     }

     public String getPassword() {
         return this.password;
     }

     public String getGender() {
         return this.gender;
     }

     public String getEmail() {
         return this.email;
     }

     public String getName() {
         return this.name;
     }

     public static String Pattern_Email() {
         return "[a-zA-Z0-9]{7,15}@[a-zA-Z]+(\\.[a-z]+)+";
     }

     public static String Pattern_Name() {
         return "[a-zA-Z]+";
     }

     public static String Pattern_Account() {
         return "[a-zA-Z0-9]{6,15}";
     }

     public static String Pattern_PassWord() {
         return "[a-zA-Z0-9]{6,12}";
     }
 }