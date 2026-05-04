package za.ac.cput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteHandler {

    static BufferedWriter bw = null;

    public static void openFile(String fileName) {
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException ioe) {
            System.out.println("ioexception occurred");
        }
    }

    public static void processFile(String rec) {
        try {
            bw.write(rec);
            bw.newLine();
        } catch (IOException ioe) {
            System.out.println("ioexception occurred");
        }
        finally{
            closeFile();
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
