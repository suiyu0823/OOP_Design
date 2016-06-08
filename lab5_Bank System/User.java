
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suiyu
 */
public class User {
    private String name;
    private String password;
    private Account[]accounts = new Account[2];
 public User (String name, String password){
     this.name = name;
     this.password = password;
     accounts[0] = new Account(20);    
  //  Manager k = Manager.getinstance();
   // k.add(this);
 }
 public String getname(){
  return name;
 }
 public String getpassword(){
 return password;
 }
 public void addsaving(Account saving){
       this.accounts[1] = saving;
 }
 public void checking_deposit(double amount){
     accounts[0].deposit(amount);
 }
 public void checking_withdraw (double amount){
     accounts[0].withdraw(amount);
   }
 public void saving_depoit(double amount){
     if (this.check_saving() == true){
        accounts[1].deposit(amount);
     }
 }
 public void saving_withdraw(double amount){
  if (this.check_saving() == true){
        accounts[1].withdraw(amount);
     }
 }
 public void transfer_to_saving(double amount){
  if  (accounts[0].getbalance() > 20){
          accounts[1].deposit(amount);  
          accounts[0].withdraw(amount);
  }
 }
 public void transfer_to_checking(double amount){
    accounts[0].deposit(amount); 
    accounts[1].withdraw(amount);
 } 
 
public boolean check_saving(){
  if(this.accounts[1]== null) {
  return false;
  }
  return true;
}
public String UserProfiles(){
   if (this.check_saving() == false){
     return ""+this.getname() +" "+ this.getpassword()+'\n' +"checking"+this.accounts[0].toString()+'\n'+'\n';//+" " +"saving"+ this.accounts[1].toString();
             
 }
        else {
            
            return ""+this.getname() +" "+this.getpassword()+'\n' +"checking"+this.accounts[0].toString()+" " +"saving"+ this.accounts[1].toString() +'\n'; 
        }  
}
    @Override
 public String toString() {
        if (this.check_saving() == false){
     return ""+this.getname() +" "+'\n' +"checking"+this.accounts[0].toString()+'\n'+'\n';//+" " +"saving"+ this.accounts[1].toString();
             
 }
        else {
            
            return ""+this.getname() +" "+'\n' +"checking"+this.accounts[0].toString()+" " +"saving"+ this.accounts[1].toString() +'\n'; 
        }  
 }
}