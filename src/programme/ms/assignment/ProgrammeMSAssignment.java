/*
    TODO
    ====
    
    
    Course.java, line 222, add in support for opening programme menu. Also implement correctly getting programme codes
 */
package programme.ms.assignment;

import java.util.Scanner;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import static programme.ms.assignment.SortingDriver.sortmenu;
import static programme.ms.assignment.BinaryTreeDriver.binaryTreeMenu;
import static programme.ms.assignment.FilterCourseDriver.displayCourse;
import static programme.ms.assignment.Hashing.hashIndexing;

public class ProgrammeMSAssignment {

    //Glogal array lists for global access to all data
    public static List<Faculty> facultyList = new ArrayList();
    public static List<Lecturer> lecturerList = new ArrayList();
    public static List<Programme> programmeList = new ArrayList();
    public static List<Course> courseList = new ArrayList();

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
                    + "4. Course (Filter List)\n"
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
                case "4":
                    displayCourse();
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
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Keith", "012-255-5312", "keith_jt@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Rylie", "012-364-8912", "rylie_o@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Jenson", "012-123-4845", "jenson_jnsn@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Kyle", "017-568-7481", "kl_chd@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "James", "012-126-4895", "james_vi@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Josaphine", "012-165-7821", "jsphn_tuit@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Adam", "016-665-8942", "adm_jnsn@gmail.com"));
        lecturerList.add(new Lecturer(Lecturer.idIndex++, "Jason", "017-134-4953", "jason_v@gmail.com"));

        //Generate Programme array list
        programmeList.add(new Programme("REI2", "DIPLOMA IN IT",facultyList.get(4)));
        programmeList.add(new Programme("REI1", "DIPLOMA IN PC",facultyList.get(2)));
        programmeList.add(new Programme("REI5", "DIPLOMA IN ASD",facultyList.get(1)));
        programmeList.add(new Programme("REI4", "DIPLOMA IN QWE",facultyList.get(3)));
        programmeList.add(new Programme("REI7", "DIPLOMA IN ERT",facultyList.get(0)));
        programmeList.add(new Programme("REI2", "DIPLOMA IN IXCV",facultyList.get(5)));
        programmeList.add(new Programme("REI9", "DIPLOMA IN LKJH",facultyList.get(3)));
        programmeList.add(new Programme("REI0", "DIPLOMA IN ZXC",facultyList.get(2)));
        
        //Generate Course array list
        courseList.add(new Course("BBFA1043 " + Course.sessionIndex++, "PRINCIPLES OF ACCOUNTING", "BBFA1043", 3, lecturerList.get(2), programmeList.get(4)));
        courseList.add(new Course("BACS2063 " + Course.sessionIndex++, "DATA STRUCTURES AND ALGORITHMS", "BACS2063", 3, lecturerList.get(4), programmeList.get(4)));
        courseList.add(new Course("BHEL1013 " + Course.sessionIndex++, "ENGLISH LANGUAGE", "BHEL1013", 3, lecturerList.get(1), programmeList.get(4)));
        courseList.add(new Course("BACS1053 " + Course.sessionIndex++, "DATABASE MANAGEMENT", "BACS1053", 3, lecturerList.get(3), programmeList.get(4)));
        courseList.add(new Course("BACS1014 " + Course.sessionIndex++, "PROBLEM SOLVING AND PROGRAMMING", "BACS1014", 4, lecturerList.get(5), programmeList.get(4)));
        courseList.add(new Course("BAIT1133 " + Course.sessionIndex++, "ENTERPRISE SYSTEMS", "BAIT1133", 3, lecturerList.get(6), programmeList.get(4)));
        courseList.add(new Course("BAIT3003 " + Course.sessionIndex++, "DATA WAREHOUSE TECHNOLOGY", "BAIT3003", 3, lecturerList.get(2), programmeList.get(4)));
        courseList.add(new Course("BAIT3023 " + Course.sessionIndex++, "INFORMATION SYSTEMS IMPLEMENTATION", "BAIT3023", 3, lecturerList.get(4), programmeList.get(4)));
        courseList.add(new Course("FPMA1024 " + Course.sessionIndex++, "QUANTITATIVE METHODS", "FPMA1024", 4, lecturerList.get(0), programmeList.get(4)));
        courseList.add(new Course("BBDH2083 " + Course.sessionIndex++, "ORGANISATION DEVELOPMENT & CHANGE", "BBDH2083", 3, lecturerList.get(7), programmeList.get(4)));
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
