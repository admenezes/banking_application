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
public class Silver extends CState{
    Customer c;
    public Silver(Customer c){
        this.c = c;
    }
    
    @Override
    public void checkState() {
        if(c.getBalance() >= 10000 && c.getBalance() < 20000){
            c.setState(c.getGold());
        }
        else if(c.getBalance() >= 20000){
            c.setState(c.getPlatinum());
        }
    }
    
    @Override
    public void purchase(int x){
        if(x<50){
            System.out.println("A purchase cannot be less than 50.");
        }
        else{
            c.withdraw(20+x);
        }   
    }  
}
