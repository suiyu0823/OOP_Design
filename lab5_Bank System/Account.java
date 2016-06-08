/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suiyu
 */
public class Account  {
     private double balance;
 public Account (double balance){
     this.balance = balance;
 }
public void setbalance(double balance){
  this.balance = balance;
}
public double getbalance(){
        return balance;
}
 public boolean deposit(double amount)
    {     if(amount <= 0)
        {
            return false;
        }
        else
        {
        this.setbalance(balance+amount);
        return true;
        }   
    }
 public boolean withdraw(double amount)
    {
        if((amount>0)&(this.balance-amount>=0))
        {
            this.setbalance(balance-amount);
            return true;
        }
        else
        {
            return false;
        }
        }
 @Override
    public String toString() {
        return " " +  " " +
                String.format("$%.2f", getbalance()) ;
    }
}