
package za.ac.cput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    
    public static void main(String[] args) {
        BufferedWriter bw =null;
        try{
            //FileWriter fw = new FileWriter("testout.txt");  
            bw = new BufferedWriter(new FileWriter("testout.txt")); 
            bw.write("Radford###Burger###12334456");  
            bw.write("\nJon###Smith###44565632");  
        }
        catch (IOException ioe){
            System.out.println("ioexception occurred");
        }
        finally{
            try{
            bw.close();              
            }
        catch (IOException ioe){
            System.out.println("ioexception occurred");
        }
        }
        
    System.out.println("Great success"); 
    }// end of main
    
}// end of class
