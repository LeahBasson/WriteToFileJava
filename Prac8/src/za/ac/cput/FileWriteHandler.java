package za.ac.cput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteHandler {

    static BufferedWriter bw = null;

    public static void openFile(String fileName) {
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException ioe) {
            System.out.println("ioexception occurred");
        }
    }

    public static void processFile(String rec) {
        try {
            bw = new BufferedWriter(new FileWriter("testout.txt"));
            bw.write(rec);
        } catch (IOException ioe) {
            System.out.println("ioexception occurred");
        }
    }

    public static void closeFile() {
        try {
            bw.close();
        } catch (IOException ioe) {
            System.out.println("ioexception occurred");
        } 
    }

}// end of class
