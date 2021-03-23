package programme.ms.assignment;

import java.util.Scanner;
import Adt.*;
import entity.*;
import static programme.ms.assignment.SortingDriver.sortmenu;
import static programme.ms.assignment.BinaryTreeDriver.binaryTreeMenu;

public class ProgrammeMSAssignment {

    public static SortedInterface<Faculty> faculty = new SortingList<Faculty>();
    public static BinaryTreeSearchInterface<Lecturer> lecturer = new BinaryTreeSearchAdt<Lecturer>();

    public static void main(String[] args) {
        //Initialize data
        //Generate Faculty
        faculty.add(new Faculty("FAFB", "Faculty of Accounting"));
        faculty.add(new Faculty("FOAS", "Faculty of Applied Science"));
        faculty.add(new Faculty("FOET", "Faculty of Engineering and Technology"));
        faculty.add(new Faculty("FSSH", "Faculty of Social Science and Humanities"));
        faculty.add(new Faculty("FOCS", "Faculty of Computing and Information Technology"));
        faculty.add(new Faculty("FCCI", "Faculty of Communication and Creative Industries"));

        //Generate Lecturer
        lecturer.add(new Lecturer("Keith", "012-255-5312", "keith_jt@gmail.com"), "Keith", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("Rylie", "012-364-8912", "rylie_o@gmail.com"), "Rylie", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("Jenson", "012-123-4845", "jenson_jnsn@gmail.com"), "Jenson", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("Kyle", "017-568-7481", "kl_chd@gmail.com"), "Kyle", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("James", "012-126-4895", "james_vi@gmail.com"), "James", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("Josaphine", "012-165-7821", "jsphn_tuit@gmail.com"), "Josaphine", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("Adam", "016-665-8942", "adm_jnsn@gmail.com"), "Adam", new Lecturer().idIndex++);
        lecturer.add(new Lecturer("Jason", "017-134-4953", "jason_v@gmail.com"), "Jason", new Lecturer().idIndex++);

        //Declaration
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String selection;

        //  Loop/Run System
        do {
            System.out.println("==========Programme Management System==========\n"
                    + "1. Faculty (Sorting List)\n"
                    + "2. Lecturers (Binary Tree)\n"
                    + "0. Exit\n");
            System.out.printf("> ");
            
            selection = scanner.nextLine();
            switch (selection) {
                case "0":
                    System.out.println("\nExiting System...");
                    exit = true;
                    break;
                case "1":
                    sortmenu();
                    break;
                case "2":
                    binaryTreeMenu();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        } while (!exit);
    }

    public static void entContinue() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nPress enter to continue...");
        try {
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
}
