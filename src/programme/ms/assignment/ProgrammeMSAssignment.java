package programme.ms.assignment;

import java.util.Scanner;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import static programme.ms.assignment.SortingDriver.sortmenu;
import static programme.ms.assignment.BinaryTreeDriver.binaryTreeMenu;
import static programme.ms.assignment.Hashing.hashIndexing;

public class ProgrammeMSAssignment {
    //Glogal array lists for global access to all data
    public static List<Faculty> facultyList = new ArrayList();
    public static List<Lecturer> lecturerList = new ArrayList();
    public static List<Programme> programmeList = new ArrayList();

    public static void main(String[] args) {
        //Initialize all data
        initializeData();

        //Declaration
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String selection;

        //  Loop/Run System
        do {
            System.out.println("==========Programme Management System==========\n"
                    + "1. Faculty (Sorting List)\n"
                    + "2. Lecturers (Binary Tree)\n"
                    + "3. Programmes (Hash Indexing)\n"
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
                case "3":
                    hashIndexing();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        } while (!exit);
    }

    private static void initializeData() {
        //Initialize data
        
        //Generate Faculty array list
        facultyList.add(new Faculty("FAFB", "Faculty of Accounting"));
        facultyList.add(new Faculty("FOAS", "Faculty of Applied Science"));
        facultyList.add(new Faculty("FOET", "Faculty of Engineering and Technology"));
        facultyList.add(new Faculty("FSSH", "Faculty of Social Science and Humanities"));
        facultyList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology"));
        facultyList.add(new Faculty("FCCI", "Faculty of Communication and Creative Industries"));
        
        //Generate Lecturer array list
        lecturerList.add(new Lecturer(Lecturer.idIndex++ ,"Keith", "012-255-5312", "keith_jt@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Rylie", "012-364-8912", "rylie_o@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Jenson", "012-123-4845", "jenson_jnsn@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Kyle", "017-568-7481", "kl_chd@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "James", "012-126-4895", "james_vi@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Josaphine", "012-165-7821", "jsphn_tuit@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Adam", "016-665-8942", "adm_jnsn@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Jason", "017-134-4953", "jason_v@gmail.com"));
        
        //Generate Programme array list
        
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!TO BE IMPLEMENTED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        programmeList.add(new Programme());
    }

    //Function for "Press enter to continue..." for users to read displays before proceeding
    public static void entContinue() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nPress enter to continue...");
        try {
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
}
