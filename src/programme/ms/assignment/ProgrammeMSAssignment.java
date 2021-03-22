package programme.ms.assignment;

import java.util.Scanner;
import Adt.*;
import entity.*;
import static programme.ms.assignment.SortingDriver.*;  

public class ProgrammeMSAssignment {
    public static SortedInterface<Faculty> faculty = new SortingList<Faculty>();

    public static void main(String[] args) {
        //Initialize data
        //Faculty
        faculty.add(new Faculty("FAFB", "Faculty of Accounting"));
        faculty.add(new Faculty("FOAS", "Faculty of Applied Science"));
        faculty.add(new Faculty("FOET", "Faculty of Engineering and Technology"));
        faculty.add(new Faculty("FSSH", "Faculty of Social Science and Humanities"));
        faculty.add(new Faculty("FOCS", "Faculty of Computing and Information Technology"));
        faculty.add(new Faculty("FCCI", "Faculty of Communication and Creative Industries"));

        //Declaration
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String selection;

        //  Loop/Run System
        do {
            System.out.println("==========Programme Management System==========\n"
                    + "1. Faculty (Sorting List)\n"
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
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        } while (!exit);
    }

    public static void entContinue() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Press enter to continue...");
        try
        {
            scanner.nextLine();
        }  
        catch(Exception e)
        {}  
    }
}
