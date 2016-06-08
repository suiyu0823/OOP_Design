/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suiyu
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Manager  {
    private static Manager instance;
    private ArrayList<User>Users = new ArrayList<User>();
    private String name;
    private String password;
private Manager (String name, String password){
   this.name = name;
   this.password = password;
}
public static Manager getinstance(){
   if (instance == null){
    instance = new Manager("admin", "admin");   
   }
   return instance;
}

public void add(User n){
  Users.add(n);
 //   System.out.println(Users.size());
  
}

public boolean delete_user(User n){ 
    for (int i = 0 ; i < Users.size(); i++){
       if (n.getname().matches(Users.get(i).getname()) && n.getpassword().matches(Users.get(i).getpassword())) {
         Users.remove(i);
         return true;
       }
   }
     return false;
  // if (Users.isEmpty()) {
//}
  // else {
    //   return true;
     //  }
}

public boolean check_user(User n){
  for (int i = 0 ; i < Users.size(); i++){
       if (n.getname().matches(Users.get(i).getname()) && n.getpassword().matches(Users.get(i).getpassword())) {
         return true;
       }
   }
  
     return false;
}
public int find_index (User n){
  for (int i =0 ; i < Users.size() ; i++){
   if (n.getname().matches(Users.get(i).getname()) && n.getpassword().matches(Users.get(i).getpassword())){  
   return i;
   }
 // return -1;
  }
return -1;
}

public void create_account(int i, int amount){
  Users.get(i).addsaving(new Account(amount));
}

public String user_out (int i){
 return Users.get(i).toString();
}
public void user_deposit_checking(int i, int j){
  Users.get(i).checking_deposit(j);
}
public void user_withdraw_checking (int i, int j){
 Users.get(i).checking_withdraw(j);
}
public void user_deposit_saving(int i, int j){
 Users.get(i).saving_depoit(j);
}
public void user_withdraw_saving(int i, int j){
Users.get(i).saving_withdraw(j);
}
public void user_transfer_saving(int i, int j){
 Users.get(i).transfer_to_saving(j);
}
public void user_transfer_checking(int i, int j){
 Users.get(i).transfer_to_checking(j);
}
public String Users_Profile(){
   String s = "";
     for (int i = Users.size(); i > 0; i--){
        s = Users.get(i).UserProfiles()+s;       
     }
      return "" + s;
}
    @Override
 public String toString() {  
         String s = "";
     for (int i = 0; i < Users.size(); i++){
        s = Users.get(i).toString()+s;       
     }
      return "" + s;
 }  
public void execute(){   //executiong 
    String mname = "admin";
    String mpassword = "admin";
     File f = new File ("UserProfiles.txt");
      Manager m = new Manager("admin", "admin");
    Logout exits = new Logout();
    Scanner m1 = new Scanner(System.in);
    //
   // System.out.println(pro.next());
  /*  while (pro.hasNext()) {
    String str_name = pro.next();
    String str_pass = pro.next();
    User make = new User(str_name, str_pass);
    int str_checking = pro.nextInt();
     make.checking_deposit(str_checking);
     if (pro.hasNext()){
    int str_saving = pro.nextInt();
    make.saving_depoit(str_checking);
    m.add(make);
    }
    }*/
    while (true) {
    System.out.println("        Welcome To ABC BankSystem          ");  
    System.out.println("\nPlease select your type:");
    System.out.println("   1. Manager");
    System.out.println("   2. Users");
    System.out.println("   3. Logout");
    int input = m1.nextInt();
         if (input == 1) {
         System.out.println("Please input your name");
          String name = m1.next();
           if (mname.equals(name)){
                 System.out.println("\nPlease input password");
                 String mpss = m1.next();
                 if(mpassword.equals(mpss)){
                     System.out.println("Weclome you");
                      while(true){
    System.out.println("  1. add user");
    System.out.println("  2. delete user");
    System.out.println("  3. create saving account");
    System.out.println("  4. deposit in checking");
    System.out.println("  5. logout"); 
    int i = m1.nextInt();
    if(i == 1){
        System.out.println("please input user's name");
        String k1 = m1.next();
        System.out.println("please input user's password");
        String k2 = m1.next();
        m.add( (new User(k1,k2)));
        System.out.println("add successfully");
        System.out.println("\n");
        System.out.println(m.toString()); 
    }
    if(i == 2){
       System.out.println("please input delete user's name");
       String k1 = m1.next();
       System.out.println("please input delete user's password");
       String k2 = m1.next();  
       User m3 = new User(k1,k2);
       if (m.delete_user(m3) == true){
         System.out.println("delete successfully");  
           System.out.println("\n");
         System.out.println(m.toString());
            }
           else { System.out.println("no such user");
             
          }  
     }
     if (i == 3){
      System.out.println("please input user's name");
      String f1 = m1.next();
      System.out.println("please input user's password");
      String f2 = m1.next();
       User m3 = new User(f1 , f2);
               // System.out.println("fuck");
       if (m.check_user(m3)== true) {
           int k = m.find_index(m3);
          // System.out.println(k);
         //  System.out.println(Users.size());
        System.out.println("please deposit amount for your saving account");
         int amount = m1.nextInt();
          m.create_account(k, amount);
         System.out.println(m.toString());           
       }
       
     }        
     if (i == 4) {
       System.out.println("please input user's name");
       String k1 = m1.next();
       System.out.println("please input delete user's password");
       String k2 = m1.next();  
       User m3 = new User(k1,k2);
       if (m.check_user(m3)== true) {
      int k = m.find_index(m3);
        System.out.println("please deposit amount for your checking account");
         int amount = m1.nextInt();
          m.user_deposit_checking(k, amount);
         System.out.println(m.toString());           
       }
        
     
     }
     if (i == 5) {
         try {
           FileWriter fw = new FileWriter(f);
           fw.write(m.Users_Profile());
           fw.close();
         }
         catch(Exception ex){}
           exits.exit(5);
           break;
           
          }  
       }
                 }
                 else {
                     System.out.println("Incorrect password");
                     
                 }
             }
}
       if (input == 2){    
      System.out.println("please input user's name");
      String k3 = m1.next();
      System.out.println("please input user's password");
      String k4 = m1.next();
       User m3 = new User(k3,k4);
       if (m.check_user(m3) == true){
           int k = m.find_index(m3);
         System.out.println("login successfully"); 
         System.out.println("\n");
         while(true){
         System.out.println(m.user_out(k));
         System.out.println("  1. checking_deposit");
         System.out.println("  2. checking_withdraw");
         System.out.println("  3. saving_deposit");
         System.out.println("  4. saving_withdraw");
         System.out.println("  5. trasfer to saving account");
         System.out.println("  6, trasfer to checking account");
         System.out.println("  7. logout");
         int i = m1.nextInt();
           if (i == 1){
               System.out.println("plese deposit");
               int i1 = m1.nextInt();
                m.user_deposit_checking(k, i1);
                System.out.println(m.user_out(k));
           }
           if (i == 2){
               System.out.println("plese withdraw");
               int i2 = m1.nextInt();
               m.user_withdraw_checking(k, i2);
               System.out.println(m.user_out(k));
           }
           if (i == 3){
               System.out.println("please deposit");
               int i3 = m1.nextInt();
               m.user_deposit_saving(k, i3);
               System.out.println(m.user_out(k));
              
           }
           if (i == 4){
               System.out.println("please withdraw");
               int i4 = m1.nextInt();
               m.user_withdraw_saving(k, i4);
               System.out.println(m.user_out(k));
           }
           if (i == 5){
               System.out.println("please transfer");
               int i5 = m1.nextInt();
               m.user_transfer_saving(k, i5);
               System.out.println(m.user_out(k));
           }
           if (i == 6){
               System.out.println("please transfer");
               int i6 = m1.nextInt();
               m.user_transfer_checking(k, i6);
               System.out.println(m.user_out(k));
           }
           if (i == 7) {
           try {
           FileWriter fw = new FileWriter(f);
           fw.write(m.Users_Profile());
           fw.close();
         }
         catch(Exception ex){}
           exits.exit(7);
           break;      
          }  
            }
       }
           else { System.out.println("no such user");
             
          }  
     
         }
     
          if (input == 3){
           break; 
       }
    }
}
}

