public class Program03 {
   

    public static void main(String[] args) {

        String fullName = "Erika T. Jones";
        String employeeNumber = "ej789";
        double payRate = 100.0, hoursWorked = 1.0;
        // TA will change the payrate and the hours worked to test your code

        Employee e;
        e = new Employee(fullName, employeeNumber, payRate, hoursWorked);

        System.out.println(e); // To Test your toString method

        e.printCheck(); // This prints the check of Erika T. Jones

        System.out.println("Bye!");

    }
}

class Employee {

    private String fullName;
    private String employeeNumber;
    private double payRate;
    private double hoursWorked;
    private double grossPay;
    private double tax;
    private double netPay;

    public Employee(String fullName, String employeeNumber, double payRate, double hoursWorked) {
        this.fullName = fullName;
        this.employeeNumber = employeeNumber;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;

    }

    public double Gross() {
        grossPay = hoursWorked * payRate;
        return grossPay;
    }

    public double Tax() {
        tax = grossPay * 0.06;
        return tax;
    }

    public double Net() {
        netPay = grossPay - tax;
        return netPay;
    }

    public void printCheck() {
        System.out.println("\n" + "Thank you! \n");
        System.out.println("Here is your paycheck! \n\n\n");
        System.out.println("------------------------------------------ \n");

        System.out.println("Employee's name: " + fullName);
        System.out.println("Employee's number: " + employeeNumber);
        System.out.println("Hourly rate of pay: " + payRate);
        System.out.println("Hours worked: " + hoursWorked + "\n");
        System.out.println("Total Gross Pay: $" + Gross() + "\n");
        System.out.println("Deductions");
        System.out.println("Tax (6%): $" + Tax() + "\n");
        System.out.println("Net Pay: " + Net() + " Dollars \n");
        System.out.println("------------------------------------------ \n\n");
        System.out.println("Bye! \n");
        
    }

}
