/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findingprimes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class FindingPrimes extends Application {
    
     public static ArrayList<Integer> primes = new ArrayList<>();
     
     static int counter =5, number = 2;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Next 1000 Primes");
        this.primes.add(2);
        
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                System.out.println("The next Primes!");
                for(int i = 0; i<1000; i++){
                    do{
                        number++;
                    }
                    while(!isPrime(number));
                    
                    System.out.println(number);
                }
                
                
                
                
                
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Prime Finder!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    /**
     * 
     * @param number
     * @return if number given is a prime based on list of primes
     */
    public static boolean isPrime(int number){
        boolean isPrime = false, flag = true;
        int primesFound = primes.size(),i=0, max;
        
        max = (int) Math.sqrt(number);
        
        do{
            
            ///////   5   < 13/ 5 = 2
            //if((primes.get(i)<=(number/primes.get(i)))){
            
            
            //testing
            if((primes.get(i)<=(max))){
                if(number%primes.get(i) == 0){
                    flag = false;
                }
            }else{
                isPrime=true;
                flag = false;
                addPrime(number);
                //System.out.println(counter);
            }
            
            i++;
            
                
        }while(flag);
        
        
        
        return isPrime;
    }
    
    
    
    /**
     * adds number given to list of prime numbers
     * @param newPrime 
     */
    public static void addPrime(int newPrime){
        primes.add(newPrime);
        counter ++;
    }
    
    
    
    // print array to file
    
    //read file into array
    
}
