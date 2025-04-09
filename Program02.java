import java.util.Scanner;

public class Program02 {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int hundred = 100;
        int fifty = 50;
        int twenty = 20;
        int ten = 10;
        int five = 5;
        int one = 1;
        double quarter = 0.25;
        double dime = 0.10;
        double nickel = 0.05;
        double cent = 0.01;

        System.out.print("\n" + "Enter your dollar amount:");
        double input = myScanner.nextDouble();
        System.out.println("\n" + "You have: \n");

        // if the input is diviable by 100 excute code in brackets
        if ((input / hundred) >= 1) {
            int count = (int) (input / hundred); // calculate the number of 100's in the number that was inputed
            double remainder = input % hundred; // calculate the amount the remains
            System.out.println(" -  " + count + " hundred(s)"); // print the number of 100's
            input = remainder; // assign the remainder to the input and excute the remaining code

        } else {
            System.out.println(" -  0 hundred(s)"); // if it isn't divisable by 100 print "0 hundred(s)"
        }
        if ((input / fifty) >= 1) {
            int count = (int) (input / fifty);
            double remainder = input % fifty;
            System.out.println(" -  " + count + " fifty(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 fifty(s)");
        }
        if ((input / twenty) >= 1) {
            int count = (int) (input / twenty);
            double remainder = input % twenty;
            System.out.println(" -  " + count + " twenty(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 twenty(s)");
        }
        if ((input / ten) >= 1) {
            int count = (int) (input / ten);
            double remainder = input % ten;
            System.out.println(" -  " + count + " ten(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 ten(s)");
        }
        if ((input / five) >= 1) {
            int count = (int) (input / five);
            double remainder = input % five;
            System.out.println(" -  " + count + " five(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 five(s)");
        }
        if ((input / one) >= 1) {
            int count = (int) (input / one);
            ;
            double remainder = input % one;
            System.out.println(" -  " + count + " one(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 one(s)");
        }
        if ((input / quarter) >= 1) {
            int count = (int) (input / quarter);
            double remainder = input % quarter;
            System.out.println(" -  " + count + " quarter(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 quarter(s)");
        }
        if ((input / dime) >= 1) {
            int count = (int) (input / dime);
            double remainder = input % dime;
            System.out.println(" -  " + count + " dime(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 dime(s)");
        }
        if ((input / nickel) >= 1) {
            int count = (int) (input / nickel);
            double remainder = input % nickel;
            System.out.println(" -  " + count + " nickel(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 nickel(s)");
        }
        if ((input / cent) >= 1) {
            int count = (int) (input / cent);
            ;
            double remainder = input % cent;
            System.out.println(" -  " + count + " cent(s)");
            input = remainder;

        } else {
            System.out.println(" -  0 cent(s)");
        }
        System.out.println("\n" + "Goodbye! \n");
        myScanner.close(); // stop scanning

    }
}