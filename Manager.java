/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author aston
 */
public class Manager{
    private String username;
    private String password;
    private final String role = "manager";
    public void login(){
        if (username.equals(password))
            System.out.println("Successful login");
        else
            System.out.println("Unsuccessful login. Please try again");
    }
    ArrayList<Customer> list = new ArrayList<Customer>();
    public void addCustomer(){
        list.add(new Customer());
    }
    public void deleteCustomer(Customer c){
        c = null;
    }
    public boolean compare(String n, String p) throws Exception{
        username = n;
        password = p;
        Path path = Paths.get(username + ".txt");   

        String line = Files.readAllLines(Paths.get(username + ".txt")).get(1);

        if (Files.exists(path) && line.equals(password)){

            return true;
        }
        else return false;
    }
    
    public boolean CustomerExists(String n) throws Exception{
        username  = n;
        Path path = Paths.get(username + ".txt");  
        if (Files.exists(path)){
            return true;
        }
        else return false;
    }
    
}
