
package za.ac.cput;


public class Employee extends FileWriteHandler{
    String department;
    String firstName;
    String lastName;
    String empType;

    public Employee(String department, String firstName, String lastName, String empType) {
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empType = empType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    @Override
    public String toString() {
        return "Employee: " + "department=" + department + ", firstName=" + firstName + ", lastName=" + lastName + ", empType=" + empType + '}';
    }

   public void writeToFile(){
      openFile("Employees.txt");
      processFile(department + "#" + firstName + "#" + lastName + "#" + empType);
   }
      
}// end of class
