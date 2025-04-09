// 1) No redundant code (Use inheritance), and try not to write too much code; use the Java built-in classes whenever that is applicable. Up to 30-point deduction
// 2) When your project is graded, the lectures and labs provided in lec.txt may change but the file structure stays the same.
// 3) UCF ids must be 7 digits, and are unique. 20-point deduction if that is not checked
// 4) No IdException (throwable) class in your code: 10-point deduction
// 5) The use of interfaces is not required but permissible.
// 6) You may use other data structures to work on the lectures/labs. One idea is to load the offered lectures/labs from lec.txt into Arraylist(s). But don’t forget to update lec.txt when a lecture is deleted! 10-point deduction if lec.txt isn’t updated
// 7) Program crashes (for whatever reason). 20-point deduction
// 8) All the faculty, TA and student objects are to be stored in ONE data structure (one array, one ArrayList,...etc). Up to 30-point deduction
// 9) The provided sample run should give you a clear idea on how your code should run. Note well that the spacing and the order in which things are tested in the provided sample run doesn’t matter. That is: all your menu options should all run properly. 10-point deduction if any menu option that is not done properly

import java.io.*;
import java.util.*;

public class Program05 {
    private File file;
    private List<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Program05 main = new Program05();
        main.askFilePath();
    }

    private void askFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the absolute path of the file: ");

        while (true) {
            String input = scanner.nextLine();
            file = new File(input);
            if (file.exists())
                break;
            System.out.println("File does not exist. Please enter a valid path.");
        }
        System.out.println("File Found! Let's proceed...\n");
        new Menu(people).displayMenu();
    }
}

abstract class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        if (!id.matches("\\d{7}"))
            throw new IllegalArgumentException("Invalid UCF ID");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Faculty extends Person {
    private String rank;
    private String office;
    private List<String> lectures = new ArrayList<>();

    public Faculty(String id, String name, String rank, String office) {
        super(id, name);
        this.rank = rank;
        this.office = office;
    }

    public void addLecture(String crn) {
        lectures.add(crn);
    }
}

class Student extends Person {
    private List<Integer> lectures = new ArrayList<>();

    public Student(String id, String name) {
        super(id, name);
    }

    public void enroll(int crn) {
        lectures.add(crn);
    }
}

class Menu {
    private final List<Person> people;

    public Menu(List<Person> people) {
        this.people = people;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1- Add Faculty");
            System.out.println("2- Enroll Student");
            System.out.println("3- Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addFaculty(scanner);
                case 2 -> enrollStudent(scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addFaculty(Scanner scanner) {
        System.out.print("Enter UCF ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Rank: ");
        String rank = scanner.nextLine();
        System.out.print("Enter Office: ");
        String office = scanner.nextLine();

        people.add(new Faculty(id, name, rank, office));
        System.out.println("Faculty added.");
    }

    private void enrollStudent(Scanner scanner) {
        System.out.print("Enter UCF ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        Student student = new Student(id, name);

        System.out.print("Enter CRN of lecture (or 0 to stop): ");
        while (true) {
            int crn = scanner.nextInt();
            if (crn == 0)
                break;
            student.enroll(crn);
        }
        people.add(student);
        System.out.println("Student enrolled.");
    }
}
