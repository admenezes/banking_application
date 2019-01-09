/**
 *
 * @author aghiasi
 */
package coe528.project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.VPos;
import javafx.scene.text.Text;



public class Bank extends Application {
    
    @Override 
    public void start(Stage primaryStage) {

        
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(10.5, 11.5, 12.5, 13.5));
    pane.setHgap(6.5);
    pane.setVgap(6.5);
    

    
    TextField Line1 = new TextField();
    TextField Line2 = new TextField();
    TextField Line3 = new TextField();
    pane.add(new Label("Accout Name: "), 0, 0);
    pane.add(new TextField(), 1, 0);
    pane.add(Line1, 1, 0);
    pane.add(new Label("Password:"), 0, 1); 
    pane.add(new TextField(), 1, 1);
    pane.add(Line2, 1, 1);
    pane.add(new Label("Position:"), 0, 2);
    pane.add(new TextField(), 1, 2);
    pane.add(Line3, 1, 2);
    Button buttonAdd = new Button("Log In");
    pane.add(buttonAdd, 1, 3);
    GridPane.setHalignment(buttonAdd, HPos.CENTER);    

    
    
    Scene scene = new Scene(pane);
    primaryStage.setTitle("Log In Information"); 
    primaryStage.setScene(scene); 
    primaryStage.show();
    

    buttonAdd.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle (ActionEvent e){        
            

            if("Manager".equals(Line3.getText())){

                
                if(!"Admin".equals(Line1.getText()) || !"Admin".equals(Line2.getText())){
                    Line1.clear();
                    Line2.clear();
                    Line3.clear();
                    System.out.println("Log In Information Does Not Satisfy Current Data. Please Attempt Again!");
                }

                
                else{
                        primaryStage.close();     
                
                        
                        GridPane pane2 = new GridPane();
                        Scene scene2 = new Scene(pane2,400, 150);               
            
                        
                        Button Add = new Button("Add a Customer");
                        Button Delete = new Button("Delete a Customer");
                        Button Logout = new Button("Log Out");
                        pane2.add(Add, 12, 3);
                        pane2.add(Delete, 12, 4);
                        pane2.add(Logout, 12, 5);
                        pane2.setHgap(7.5);
                        pane2.setVgap(7.5);
               
                        
                        
                        Stage secondaryStage = primaryStage;
                        secondaryStage.setTitle("Please Choose One Of The Following Options Below"); 
                        secondaryStage.setScene(scene2); 
                        secondaryStage.show();
                


            Add.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e2){
                    TextField username = new TextField();
                    TextField password = new TextField();  

                    
                    secondaryStage.close();
   
                    
                    GridPane pane = new GridPane();
                    Scene scene = new Scene(pane,350, 200);  
        
                    
                    pane.setAlignment(Pos.CENTER);
                    pane.setPadding(new Insets(13.5, 14.5, 15.5, 16.5));
                    pane.setHgap(6.5);
                    pane.setVgap(6.5);

                    
                    pane.add(new Label("Surname: "), 0, 0);
                    pane.add(new TextField(), 1, 0);
                    pane.add(username, 1, 0);
                    pane.add(new Label("Password:"), 0, 1); 
                    pane.add(new TextField(), 1, 1);
                    pane.add(password, 1, 1);
                    Button done = new Button("Add");
                    Button done2 = new Button ("Back");
                    pane.add(done, 1, 2);
                    pane.add(done2, 2, 2);
                    GridPane.setHalignment(done, HPos.RIGHT);    

                    
                    Stage stage = new Stage();           
                    stage.setTitle("Please Add Your Customer");
                    stage.setScene(scene);
                    stage.show();                   
                    

                    
                    done.setOnAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent e){
                            Manager manager = new Manager();
                            try { 
                                
                                if (manager.CustomerExists(username.getText())){
                                    username.clear();
                                    password.clear();
                                    System.out.println("This Name Already Exists, Please Choose Another Name.");
                                    
                                }
                                else {
                                    System.out.println("A New Customer Was Added Successfully.");
                                    stage.close();
                                    secondaryStage.show();
                                    try {
                                        
                                        manager.addCustomer();
                                        
                                    } catch (Exception ex){
                                        
                                    }
                                    
                            } 
                                
                            }catch (Exception ex) {
                                
                            }
                            
                        }
                    
                    });
                    

                    done2.setOnAction (new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent e){
                            stage.close();
                            secondaryStage.show();
                        }
                        
                    });  
                    
                }
                
            });
            

            
            Delete.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e2){               
                    secondaryStage.close();
                
                    
                    GridPane pane = new GridPane();
                    Scene scene = new Scene(pane, 450, 250);  
        
                    
                    pane.setAlignment(Pos.CENTER);
                    pane.setPadding(new Insets(12.5, 13.5, 14.5, 15.5));
                    pane.setHgap(10.5);
                    pane.setVgap(10.5);
        
                    
                    TextField surname = new TextField();
                    TextField password = new TextField();
                   
                    
                    pane.add(new Label("Surname:"), 0, 0);
                 
                    pane.add(new TextField(), 1, 0);
                  
                    pane.add(surname, 1, 0);
                    pane.add(new Label("Password:"),0,1);
                    pane.add(new TextField(),1,1);
                    pane.add(password,1,1);
                    Button btt =  new Button("Delete");
                    Button done2 = new Button("Back");
                    pane.add( btt, 1, 2);
                    pane.add(done2, 2, 2);
                    GridPane.setHalignment(btt,HPos.RIGHT);
        
                    
                    Stage stage = new Stage();           
                    stage.setTitle("Please Choose Which Customer You Would Like To Delete "); 
                    stage.setScene(scene); 
                    stage.show();
                    
/*
                    btt.setOnAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent e){                            
                            Manager manager = new Manager();
                            try{
                                
                                if (!(manager.CustomerExists(surname.getText()))){
                                    surname.clear();
                                    password.clear();
                                    System.out.println("Customer Does Not Exist in Current Data, Please Enter Another Surname.");
                                }
                                else{
                                    
                                    manager.deleteCustomer(surname.getText());
                                    System.out.println("A Customer Was Deleted Successfully.");
                                    stage.close();
                                    secondaryStage.show();
                                }
                            } catch (Exception ex2)
                            {    
                              
                                
                            }
                        }
                        
                    });*/
                    

                    done2.setOnAction (new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent e2){
                            stage.close();
                            secondaryStage.show();
                        }
                        
                    });  
                    
                }
                
            });
            
            
            

            
            


            Logout.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e2){
                    System.out.println("You Are Logged Out Successfully.");
                    secondaryStage.close();
                }
                
            });
            
                }
                
            }


            else if("Customer".equals(Line3.getText())){
                try {
                    
                    Manager manager = new Manager();
                    
                    if (!(manager.CustomerExists(Line1.getText())) ||!(manager.compare(Line1.getText(), Line2.getText()))){
                        Line1.clear();
                        Line2.clear();
                        Line3.clear();
                        System.out.println("Log In Information Does Not Match. Please Attempt Again!");
                    }                  
                    
                    else{
                        
                        primaryStage.close();
                        GridPane pane2 = new GridPane();
                        Scene scene2 = new Scene(pane2,350, 200);
                        Stage secondaryStage = primaryStage;
                        secondaryStage.setTitle("Please Choose One Of The Options Below");
                        secondaryStage.setScene(scene2);
                        secondaryStage.show();
                        
                        Button purchase = new Button("Online Purchase");
                        Button withdraw = new Button("Withdraw Cash$$");
                        Button show = new Button("Show Balance");
                        Button deposit = new Button("Deposit $$");
                        Button logout = new Button("Log Out");
                        
                        pane2.add(withdraw, 12, 3);
                        pane2.add(purchase, 12, 4);                    
                        pane2.add(show, 12, 5);
                        pane2.add(deposit, 12, 6);                                       
                        pane2.add(logout, 12, 7);
                        pane2.setHgap(6.5);
                        pane2.setVgap(6.5);
                        
                        


                        deposit.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            public void handle (ActionEvent e){
                                secondaryStage.close();
                                GridPane pane = new GridPane();
                                Scene scene = new Scene(pane, 600, 350);
                                Stage stage = new Stage();
                                pane.setAlignment(Pos.CENTER);
                                TextField Amount = new TextField();
                                pane.add(new Label("Please Enter the Amount of Cash You Would Like to Deposit:$"), 0, 0);
                                pane.add(new TextField(), 1, 0);
                                pane.add(Amount, 1, 0);
                                Button button = new Button("Deposit");
                                pane.add(button, 1, 1);
                                GridPane.setHalignment(button, HPos.CENTER);
                                stage.setScene(scene);
                                stage.show();
                                pane.setVgap(10.5);

                                button.setOnAction(new EventHandler<ActionEvent>(){
                                    @Override
                                    public void handle(ActionEvent e){
                                        Customer customer = new Customer();
                                        int i = Integer.parseInt(Amount.getText());
                                        try {
                                            
                                            customer.deposit(i);
                                            customer.getBalance();
                                        } catch (Exception ex1) {
                                            
                                        }
                                        System.out.println("Cash Deposited: $" + i + "\n" +"With a Current Balance of: $" + customer.getBalance());
                                        stage.close();
                                        secondaryStage.show();
                                    }
                                    
                                    
                                });
                                
                            }
                            
                        });
                        

                        withdraw.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent e){
                                secondaryStage.close();
                                GridPane pane = new GridPane();
                                Scene scene = new Scene(pane, 700, 250);
                                Stage stage = new Stage();
                                pane.setAlignment(Pos.CENTER);
                                TextField Amount = new TextField();
                                pane.add(new Label("Please Enter The Amount Of Cash You Would Like To Withdraw: $"), 0, 0);
                                pane.add(new TextField(), 1, 0);
                                pane.add(Amount, 1, 0);
                                Button button = new Button("Withdraw");
                                pane.add(button, 1, 1);
                                GridPane.setHalignment(button, HPos.CENTER);
                                stage.setScene(scene);
                                stage.show();
                                pane.setVgap(10.5);
                                
                                
                                button.setOnAction(new EventHandler<ActionEvent>(){
                                    @Override
                                    public void handle(ActionEvent e1){
                                        Customer customer = new Customer();
                                        int i2 = Integer.parseInt(Amount.getText());
                                        try {
                                            
                                            customer.withdraw(i2);
                                            customer.getBalance();
                                        } catch (Exception ex1) {
                                            
                                        }
                                        System.out.println("Cash Withdrawn: $" + i2 + "\n" +"With a Current Balance of: $" + customer.getBalance());
                                        stage.close();
                                        secondaryStage.show();
                                        
                                    }
                                    
                                });
                            }
                            
                        });
                        
                        

                        show.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent e){
                                secondaryStage.close();
                                GridPane pane = new GridPane();
                                Scene scene = new Scene(pane, 350, 150);
                                Stage stage = new Stage();
                                GridPane.setHalignment(pane, HPos.CENTER);
                                Customer customer = new Customer();
                                try {                                   
                                    
                                    customer.getBalance();
                                } 
                                catch (Exception ex) 
                                {
                                    
                                }
                                pane.add(new Label("Your Current Balance is: $$" + customer.getBalance()), 0, 0);
                                stage.setScene(scene);
                                pane.setVgap(5.5);
                                stage.show();
                                Button done = new Button("Back");
                                pane.add(done, 1, 1);
                                
                                pane.setAlignment(Pos.CENTER);
                                done.setOnAction(new EventHandler<ActionEvent>(){
                                    @Override
                                    public void handle(ActionEvent e){
                                        stage.close();
                                        secondaryStage.show();
                                    }
                                    
                                    
                                });    
                                
                            }
                            
                            
                        });
                        

                        purchase.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            
                            public void handle(ActionEvent e1){
                                secondaryStage.close();
                                
                                GridPane pane = new GridPane();
                                
                                Scene scene = new Scene(pane, 600, 100);
                                
                                Stage stage = new Stage();
                                
                                pane.setAlignment(Pos.CENTER);
                                
                                TextField Amount = new TextField();
                                pane.add(new Label("Please Enter The Amount You Would Like To Purchase: $"), 0, 0);
                                pane.add(new TextField(), 1, 0);
                                pane.add(Amount, 1, 0);
                                stage.setScene(scene);
                                
                                stage.show();
                                Button button = new Button("Purchase");
                                pane.add(button, 1, 1);
                                pane.setVgap(5.5);
                                pane.setHgap(10.5);
                                        
                                
                                button.setOnAction(new EventHandler<ActionEvent>(){
                                    @Override
                                    public void handle(ActionEvent e1){
                                        Customer customer= new Customer();
                                        int i3 = Integer.parseInt(Amount.getText());
                                            if 
                                                    
                                                    (i3 < 50){
                                                Amount.clear();
                                                System.out.println("Online purhcase Must Be Minimum $50, Please Try Your Purchase Again.");
                                            } else
                                              
                                                
                                            {
                                                
                                            try{
                                            //c.setState(new Silver());
                                            customer.purchase(i3);
                                            customer.getBalance();
                                            customer.setState();
                                        
                                            
                                            System.out.println("Amount Of Cash Spent On Purchase: $" + dble + "\n" + "Additional Charge: $" + customer.state.getAmount() + "\n" + "Your Current balance Is: $" + customer.line);
                                        stage.close();
                                        secondaryStage.show();
                                    
                                            } catch (Exception ex1) 
                                    {
                                        
                                    }
                                            
                                    }
                                            
                                    }
                                    
                                });
                                
                            }
                            
                        });
                        
                        

                        logout.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent e1){
                                System.out.println("You Are Logged Out Successfully.");
                                secondaryStage.close();
                            }
                        });
                        
                    } 
                } catch (Exception ex1) 
                {
                    
                }
        }
            
        }
        
    });
    
  }
  
  public static void main(String[] args) {
    launch(args);
  }
  
}