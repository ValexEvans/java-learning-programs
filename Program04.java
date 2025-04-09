import java.util.Scanner;

public class Program04 {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        BookstoreBook[] bookstoreBooks = new BookstoreBook[100];
        LibraryBook[] libraryBooks = new LibraryBook[200];

        int bookstoreBooksCount = 0;
        int libraryBooksCount = 0;

        System.out.println("Welcome to my Bookstore!");

        String choice = "1";
        do {
            System.out.println("\nWould you like to create a book object? (yes/no)");
            choice = myScan.nextLine();
            if (choice.equals("no")) {
                break;
            }

            while (!choice.equalsIgnoreCase("yes")) {
                System.out.println("My apologies, " + choice + "is not an answer that I can accept.");
                System.out.println("\nWould you like to create a book object? (yes/no)");
                choice = myScan.nextLine();

                if (choice.equals("no")) {
                    break;
                }

            }

            System.out.println("Please enter the author, title and the isbn of the book separated by / :");

            String booksInfo = myScan.nextLine();
            String[] bookInfoArray = booksInfo.split("/");
            String author = bookInfoArray[0];
            String title = bookInfoArray[1];
            String isbn = bookInfoArray[2];

            System.out.println("Got it!");
            System.out.println(
                    "Now, tell me if the book is a bookstore book or a library book (BB/LB) (enter BB for bookstore book and LB for library book)");
            String typeOfBook = myScan.nextLine();

            while (!typeOfBook.equalsIgnoreCase("BB") && !typeOfBook.equalsIgnoreCase("LB")) {
                System.out.println("Oops! That's not a valid entry. Please try again: ");
                typeOfBook = myScan.nextLine();
            }

            System.out.println("Got it!");
            if (typeOfBook.equalsIgnoreCase("BB")) {
                System.out.println("Please enter the list price of " + title + " by " + author + ":");
                double listPrice = myScan.nextDouble();
                myScan.nextLine();
                System.out.println("Is it on sale? (y/n)");
                String sale = myScan.nextLine();
                boolean onSale = false;
                double discount = 0;
                if (sale.equals("y")) {
                    System.out.println("Deduction percentage: ");
                    discount = myScan.nextDouble();
                    myScan.nextLine();
                    onSale = true;
                }

                System.out.println("Got It!");
                System.out.println("\nHere are all your books... ");
                bookstoreBooks[bookstoreBooksCount] = new BookstoreBook(author, title, isbn, listPrice, onSale,
                        discount);

                System.out.println("\nbookstore book information: ");
                System.out.println("- - - -");
                System.out.println(bookstoreBooks[bookstoreBooksCount].toString());

                bookstoreBooksCount++;

            } else {
                libraryBooks[libraryBooksCount] = new LibraryBook(author, title, isbn);

                System.out.println("\nlibrary book information: ");
                System.out.println("- - - -");
                System.out.println(libraryBooks[libraryBooksCount].toString());

                libraryBooksCount++;
            }

        } while (choice.equals("yes"));

        for (int i = 0; i < bookstoreBooksCount; i++) {
            System.out.println(bookstoreBooks[i].toString());
        }

        for (int i = 0; i < libraryBooksCount; i++) {
            System.out.println(libraryBooks[i].toString());
        }

        System.out.println("\nGoodbye");
        myScan.close();
        System.exit(0);
    }

}

class BookstoreBook {

    private String author;
    private String title;
    private String isbn;
    private double price;
    private boolean onSale;
    private double discount;
    private static int numOfBooks = 0;

    public BookstoreBook(String author, String title, String isbn, double price, boolean onSale, double discount) {
        // set all the data members
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.onSale = onSale;
        this.discount = discount;

    }

    public BookstoreBook(String author, String title, String isbn, double price) {
        this(author, title, isbn, price, false, 0);
    }

    public BookstoreBook(String author, String title, String isbn) {
        this(author, title, isbn, 0);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPriceAfterDiscount() {
        return price - (price * discount / 100);
    }

    public String toString() {
        return "[" + isbn + "-" + title + " by " + author + ", $" + price + " listed for $" + getPriceAfterDiscount()
                + "]";
    }

}

class LibraryBook {
    private String isbn;
    private String author;
    private String title;
    private String callNumber;
    private static int amntOfBooks;
    private int floorNumber;

    public LibraryBook(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        floorNumber = (int) (Math.random() * 99 + 1);
        this.callNumber = generateCallNumber();
        amntOfBooks++;
    }

    public LibraryBook(String author, String title) {
        this(author, title, "notavailable");
    }

    public LibraryBook() {
        this("notavailable", "notavailable", "notavailable");
    }

    private String generateCallNumber() {
        if (floorNumber < 10) {
            return "0" + floorNumber + "-" + author.substring(0, 3) + "-" + isbn.charAt(isbn.length() - 1);
        } else {
            return floorNumber + "-" + author.substring(0, 3) + "-" + isbn.charAt(isbn.length() - 1);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public static int getNumOfBooks() {
        return amntOfBooks;
    }

    public static void setNumOfBooks(int amntOfBooks) {
        LibraryBook.amntOfBooks = amntOfBooks;
    }

    public String toString() {
        return "[" + isbn + "-" + title + " by " + author + ", Call Number: " + callNumber + "]";
    }
}