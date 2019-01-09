/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author aston
 */
public class Customer{
    
    private String userID;
    private String pwd;
    private final String role = "customer";
    private int accBal;
    
    private CState customerState;
    private CState silver;
    private CState gold;
    private CState platinum;
    
    public Customer(){
    silver = new Silver(this);
    gold = new Gold(this);
    platinum = new Platinum(this);
    customerState = silver;
    accBal =100;
    }
    public void login(){
        if (userID.equals(pwd))
            System.out.println("Successful login");
        else
            System.out.println("Unsuccessful login. Please try again");
    }
    public void setState(CState cust){
        customerState = cust;
    }
    public int getBalance(){
        return accBal;
    }
    public void deposit(int x){
        if(x>= 0){
        accBal += x;
        }
        else{
            System.out.println("Invalid entry. Please deposit a value greater than 0");
        }    
    }
    public boolean canWithdraw(int check){
        return check <= accBal;
    }
    public void withdraw(int x){
        if(canWithdraw(x)){
            accBal -= x;
        }
        else{
            System.out.println("Insufficient funds. Withdraw not processed.");
        }
    }
    public void purchase(int x){
        withdraw(x);
    }
    public CState getSilver(){
        return silver;
    }
    public CState getGold(){
        return gold;
    }
    public CState getPlatinum(){
        return platinum;
    }
    
}
