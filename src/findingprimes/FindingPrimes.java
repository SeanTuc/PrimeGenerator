/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findingprimes;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        createTextFile();
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                System.out.println("The next 1000 Primes!");
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
    
    
    // create file if doesnt exist
    public static void createTextFile(){
        try {
            File primeFile = new File("PrimeNumbers.txt");
            if (primeFile.createNewFile()) {
                System.out.println("File created: " + primeFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    // print array to file
    public static void savePrimesToFile(){
        
        try{
            FileWriter primesWriter = new FileWriter("PrimeNumbers.txt");
            for(int i=0; i<primes.size();i++){
                primesWriter.write(primes.get(i));
            }
            primesWriter.close();
            
        }catch(IOException e){
            System.out.println("An error Occured");
            e.printStackTrace();
        }
            
        
        
        
    }
    
    
    //read file into array and set number to laregest prime
    
}
