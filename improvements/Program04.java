package improvements;

import java.util.ArrayList;
import java.util.Scanner;

public class Program04 {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        ArrayList<BookstoreBook> bookstoreBooks = new ArrayList<>();
        ArrayList<LibraryBook> libraryBooks = new ArrayList<>();

        System.out.println("Welcome to my Bookstore!");

        while (true) {
            System.out.println("\nWould you like to create a book object? (yes/no)");
            String choice = myScan.nextLine().trim().toLowerCase();

            if (choice.equals("no")) {
                break;
            }

            while (!choice.equals("yes")) {
                System.out.println("My apologies, \"" + choice + "\" is not an answer that I can accept.");
                System.out.println("Would you like to create a book object? (yes/no)");
                choice = myScan.nextLine().trim().toLowerCase();

                if (choice.equals("no")) {
                    return;
                }
            }

            System.out.println("Please enter the author, title, and ISBN of the book separated by / :");

            String booksInfo = myScan.nextLine();
            String[] bookInfoArray = booksInfo.split("/");

            if (bookInfoArray.length < 3) {
                System.out.println("Invalid input format. Please enter author/title/isbn separated by '/'.");
                continue;
            }

            String author = bookInfoArray[0].trim();
            String title = bookInfoArray[1].trim();
            String isbn = bookInfoArray[2].trim();

            System.out.println("Got it!");
            System.out.println("Is the book a bookstore book or a library book? (BB/LB)");

            String typeOfBook = myScan.nextLine().trim().toUpperCase();

            while (!typeOfBook.equals("BB") && !typeOfBook.equals("LB")) {
                System.out.println("Oops! That's not a valid entry. Please try again: ");
                typeOfBook = myScan.nextLine().trim().toUpperCase();
            }

            System.out.println("Got it!");
            if (typeOfBook.equals("BB")) {
                System.out.println("Please enter the list price of \"" + title + "\" by " + author + ":");

                while (!myScan.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number:");
                    myScan.next();
                }

                double listPrice = myScan.nextDouble();
                myScan.nextLine();

                System.out.println("Is it on sale? (y/n)");
                String sale = myScan.nextLine().trim().toLowerCase();
                boolean onSale = false;
                double discount = 0;

                if (sale.equals("y")) {
                    System.out.println("Deduction percentage: ");

                    while (!myScan.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid percentage:");
                        myScan.next();
                    }

                    discount = myScan.nextDouble();
                    myScan.nextLine();
                    onSale = true;
                }

                bookstoreBooks.add(new BookstoreBook(author, title, isbn, listPrice, onSale, discount));

                System.out.println("\nBookstore book information: ");
                System.out.println("- - - -");
                System.out.println(bookstoreBooks.get(bookstoreBooks.size() - 1));

            } else {
                libraryBooks.add(new LibraryBook(author, title, isbn));

                System.out.println("\nLibrary book information: ");
                System.out.println("- - - -");
                System.out.println(libraryBooks.get(libraryBooks.size() - 1));
            }
        }

        System.out.println("\nHere are all your books...");

        for (BookstoreBook book : bookstoreBooks) {
            System.out.println(book);
        }

        for (LibraryBook book : libraryBooks) {
            System.out.println(book);
        }

        System.out.println("\nGoodbye!");
        myScan.close();
    }
}

class BookstoreBook {
    private String author;
    private String title;
    private String isbn;
    private double price;
    private boolean onSale;
    private double discount;

    public BookstoreBook(String author, String title, String isbn, double price, boolean onSale, double discount) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.onSale = onSale;
        this.discount = discount;
    }

    public double getPriceAfterDiscount() {
        return onSale ? price - (price * discount / 100) : price;
    }

    @Override
    public String toString() {
        return "[" + isbn + " - " + title + " by " + author + ", $" + price + " listed for $" + getPriceAfterDiscount()
                + "]";
    }
}

class LibraryBook {
    private String isbn;
    private String author;
    private String title;
    private String callNumber;
    private static int numOfBooks;
    private int floorNumber;

    public LibraryBook(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.floorNumber = (int) (Math.random() * 99 + 1);
        this.callNumber = generateCallNumber();
        numOfBooks++;
    }

    private String generateCallNumber() {
        return (floorNumber < 10 ? "0" : "") + floorNumber + "-" + author.substring(0, 3) + "-"
                + isbn.charAt(isbn.length() - 1);
    }

    @Override
    public String toString() {
        return "[" + isbn + " - " + title + " by " + author + ", Call Number: " + callNumber + "]";
    }
}
