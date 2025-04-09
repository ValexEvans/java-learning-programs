import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.Scanner;

public class Program01 {
  private static final DecimalFormat df = new DecimalFormat("0.00");

  public static void main(String[] args) {

    // Assign scanner to myScanner
    Scanner myScanner = new Scanner(System.in);
    // When decimals are involved, round up
    df.setRoundingMode(RoundingMode.UP);

    // Enter the data and assign to the strings
    System.out.print("\n" + "Enter the Employees full name: ");
    String name = myScanner.nextLine();
    System.out.print("Enter the Employees number: ");
    String id = myScanner.nextLine();
    System.out.print("Enter the pay rate per hour: ");
    double hourlyPay = myScanner.nextDouble();
    System.out.print("Enter the regular hours worked: ");
    double hours = myScanner.nextDouble();
    System.out.println("\n" + "Thank you! \n");
    System.out.println("Here is your paycheck! \n\n\n");
    System.out.println("------------------------------------------ \n");

    // Calculate the gross pay, tax, and hourly pay
    double grossPay = hours * hourlyPay;
    double tax = grossPay * 0.06;
    double netPay = grossPay - tax;

    // Print the collected data and the calculations
    System.out.println("Employee's name: " + name);
    System.out.println("Employee's number: " + id);
    System.out.println("Hourly rate of pay: " + df.format(hourlyPay));
    System.out.println("Hours worked: " + df.format(hours) + "\n");
    System.out.println("Total Gross Pay: $" + df.format(grossPay) + "\n");
    System.out.println("Deductions");
    System.out.println("Tax (6%): $" + df.format(tax) + "\n");
    System.out.println("Net Pay: " + df.format(netPay) + " Dollars \n");
    System.out.println("------------------------------------------ \n\n");
    System.out.println("Bye! \n");
    myScanner.close(); // stop scanning
  }
}