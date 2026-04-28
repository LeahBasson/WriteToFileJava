package za.ac.cput;

import javax.swing.JOptionPane;

public class Prac8 {

    public static void main(String[] args) {

        // when you runs it create a text file.
        FileWriteHandler.openFile("prac8File.txt");

        String empName = JOptionPane.showInputDialog("Enter Employee Name (or EXIT to stop):");
        String empSurname = null, department = null, empType = null;

        while (!empName.equals("EXIT")) {
            empSurname = JOptionPane.showInputDialog("Enter Employee Surname:");
            department = JOptionPane.showInputDialog("Enter Department:");
            empType = JOptionPane.showInputDialog("Enter Employment Type (permanent/temporary):");

            FileWriteHandler.processFile(empName + "#" + empSurname + "#" + department + "#" + empType);

            empName = JOptionPane.showInputDialog("Enter Employee Name (or EXIT to stop):");
        }

        // you have to close the file after you write to it otherwise data won't be saved.
        FileWriteHandler.closeFile();
    }// end of main

}// end of class
