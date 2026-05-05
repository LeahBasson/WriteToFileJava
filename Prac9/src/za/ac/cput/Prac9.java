package za.ac.cput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prac9 {

    private String prodTypeStr, prodCatalogNumStr, prodDescription, prodPurchPriceStr, prodSellPriceStr, prodQuantitySoldStr;

    private FileReader fr;
    private BufferedReader br = null;

    double prodPurchPrice;
    double prodSellPrice;
    int prodQuantitySold;
    int prodType;
    String line = "";

    public void openFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            br = new BufferedReader(fr);
        } catch (IOException fnfe) { // FileNotFoundException
            System.out.println("File IO error...");
            System.out.println(fnfe);
            System.exit(1);
        }
    }

    public void processFile() { // don't need to pass the file through here again because we are already using the br which stores the file.
        try {
            while ((line = br.readLine()) != null) { 
                // Display all lines
                System.out.println(line);
                
                String [] splitLine = line.split("#");
                
                String prodTypeStr = splitLine[0];
                String prodCatalogNum = splitLine[1];
                String prodDescription = splitLine[2];
                int purchPrice = Integer.parseInt(splitLine[3]);
                int sellPrice = Integer.parseInt(splitLine[4]);
                int prodQuantity = Integer.parseInt(splitLine[5]);
                
                if(prodTypeStr.equals("1")){
                    double profit = (sellPrice - purchPrice) * prodQuantity;
                    System.out.println("Profit for prodType 1: " + profit); 
                }
                
            }

        } catch (IOException fnfe) {
            System.out.println("File IO error...");
            System.out.println(fnfe);
            System.exit(1);
        }
    }

    public void closeFile() {
        try {
            br.close();
        } catch (IOException fnfe) {
            System.out.println("File IO error...");
            System.out.println(fnfe);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        // public methods must be called by creating objects.
        Prac9 myObj = new Prac9();

        myObj.openFile("Sales1.txt");
        myObj.processFile();
        myObj.closeFile();

    }// end of main

}// end of class
