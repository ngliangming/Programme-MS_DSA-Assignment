package programme.ms.assignment;

/**
 *
 * @author wong-
 */
import java.util.Scanner;
import Adt.FilterCourse;
import Adt.FilterCourseInterface;
import entity.*;
import java.util.List;
import java.util.stream.Stream;
import static programme.ms.assignment.Hashing.hashIndexing;
import static programme.ms.assignment.ProgrammeMSAssignment.*;

public class FilterCourseDriver {

    public static FilterCourseInterface<Course> course = new FilterCourse<Course>();
    public static Stream<Course> FilterList;
    public static List<Course> forFilter = courseList;

    public static void displayCourse() {
        course.clear();
        Scanner scanner = new Scanner(System.in); //selection in course menu
        Scanner scanCH = new Scanner(System.in); //for fitler credit hours menu
        boolean exit = false;
        String selection;
        String selection1;

        for (int i = 0; i < courseList.size(); i++) {
            course.add(new Course(courseList.get(i).getSessionId(), courseList.get(i).getCourseName(), courseList.get(i).getCourseCode(), courseList.get(i).getCreditHours(), courseList.get(i).getLecturer(), courseList.get(i).getProgramme()));
        }

        do {
            System.out.println("\nPlease select the action you want to perform");
            System.out.println("1. View course list");
            System.out.println("2. Add new course");
            System.out.println("3. Filter course");
            System.out.println("4. Delete a course");
            System.out.println("0. Exit course module");
            System.out.print("> ");
            selection = scanner.nextLine();

            switch (selection) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    course.display();
                    entContinue();
                    break;
                case "2":
                    newCourseMenu();
                    break;
                case "3": {
                    boolean exit1 = false;

                    do {
                        filterCourseMenu(); //display menu
                        selection1 = scanCH.nextLine();//get input for selection

                        switch (selection1) {
                            case "0":
                                System.out.println("\nExiting Module...");
                                exit1 = true;
                                break;
                            case "1":
                                creditHours3(); //filter credit hours 3
                                entContinue();
                                break;
                            case "2":
                                creditHours4(); //filter credit hours 4
                                entContinue();
                                break;
                            default:
                                System.out.println("Please enter a valid selection.");
                                break;
                        }
                    } while (!exit1);
                    break;
                }
                case "4":
                    deleteMenu();
                    entContinue();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!exit);

    }

    public static void filterCourseMenu() {
        System.out.println("\n");
        System.out.println("================");
        System.out.println("   Filter by               ");
        System.out.println("================");
        System.out.println("1. Filter by Credit Hours 3");
        System.out.println("2. Filter by Credit Hours 4");
        System.out.println("0. Exit filter");
        System.out.print("\nWhat you want to filter? ");
        System.out.print("> ");
    }

    public static void creditHours3() { //ch 3 filter 
        System.out.println("\n\n");
        Course c2 = new Course(3);
        course.filter(c2);
    }

    public static void creditHours4() { //ch 4 filter 
        System.out.println("\n\n");
        Course c2 = new Course(4);
        course.filter(c2);
    }

    public static void newCourseMenu() {
        String newCourseName;
        String newCourseCode;
        int newCreditHours = 3;
        Lecturer newLecturer = new Lecturer();
        Programme newProgramme = new Programme();
        String query;
        String selection;
        boolean cancel = false;

        boolean invalid;
        boolean endSelection;

        Scanner newScanner = new Scanner(System.in);
        boolean again = true;

        do {
            System.out.print("Enter course name: ");
            newCourseName = newScanner.nextLine();
            boolean againC;

            do {
                againC = false;
                System.out.print("Enter course code: ");
                newCourseCode = newScanner.nextLine().toUpperCase();

                for (int i = 0; i < courseList.size(); i++) {
                    if (newCourseCode.equals(courseList.get(i).getCourseCode())) {
                        System.out.println("Course code already exists");
                        againC = true;
                        break;
                    }
                }
            } while (againC);

            do {
                try {
                    System.out.print("Enter credit hours: ");
                    newCreditHours = newScanner.nextInt();
                    if (newCreditHours < 3 || newCreditHours > 4) {
                        System.out.println("Invalid input!!!");
                        invalid = true;
                    } else {
                        invalid = false;
                    }
                } catch (Exception e) {
                    invalid = true;
                    System.out.println("Invalid input!!!");
                    newScanner.nextLine();
                }

            } while (invalid);
            boolean exists = false;

            newScanner.nextLine();
            while (!exists) {
                System.out.print("Enter Lecturer Id: ");
                query = newScanner.nextLine();

                for (int i = 0; i < lecturerList.size(); i++) {
                    if (query.equals(String.valueOf(lecturerList.get(i).getStaffId()))) {
                        newLecturer = lecturerList.get(i);
                        exists = true;
                    }
                }

                if (!exists) {
                    do {
                        System.out.println("Invalid Staff Id, open Lecturer Menu? (H)"
                                + "\nRetry? (Y/N)");
                        selection = newScanner.nextLine();
                        switch (selection.toUpperCase()) {
                            case "Y":
                                endSelection = true;
                                break;
                            case "N":
                                exists = true;
                                cancel = true;
                                endSelection = true;
                                break;
                            case "H":
                                BinaryTreeDriver.binaryTreeMenu();
                                endSelection = true;
                                break;
                            default:
                                System.out.println("Invalid option");
                                endSelection = false;
                                break;
                        }
                    } while (!endSelection);
                }

            }

            exists = false;
            while (!exists && !cancel) {
                System.out.print("Enter Programme Code: ");
                query = newScanner.nextLine();

                for (int i = 0; i < programmeList.size(); i++) {
                    if (query.equals(programmeList.get(i).getPCode())) {
                        newProgramme = programmeList.get(i);
                        exists = true;
                    }
                }

                if (!exists) {
                    do {
                        System.out.println("Invalid Staff Id, open Programme Menu? (H)"
                                + "\nRetry? (Y/N)");
                        selection = newScanner.nextLine();
                        switch (selection.toUpperCase()) {
                            case "Y":
                                endSelection = true;
                                break;
                            case "N":
                                exists = true;
                                cancel = true;
                                endSelection = true;
                                break;
                            case "H":
                                hashIndexing();
                                endSelection = true;
                                break;
                            default:
                                System.out.println("Invalid option");
                                endSelection = false;
                                break;
                        }
                    } while (!endSelection);
                }

            }

            if (!cancel) {
                course.add(new Course(newCourseCode + Course.sessionIndex++, newCourseName, newCourseCode, newCreditHours, newLecturer, newProgramme));
                courseList.add(new Course(newCourseCode + Course.sessionIndex++, newCourseName, newCourseCode, newCreditHours, newLecturer, newProgramme));
            }
            boolean validOption;
            Scanner addMore = new Scanner(System.in);

            do {
                System.out.println("\nDo you wish to add more? (Y/N)");
                System.out.printf("> ");
                selection = addMore.nextLine();

                switch (selection.toUpperCase()) {
                    case "Y":
                        validOption = true;
                        break;
                    case "N":
                        again = false;
                        validOption = true;
                        break;
                    case "":
                        validOption = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                        validOption = false;
                        break;
                }

            } while (!validOption);
        } while (again);

    }

    private static void deleteMenu() {
        int cidRemove = 0;

        Scanner scanDel = new Scanner(System.in);

        for (int i = 0; i < courseList.size(); i++) {
            int id = i + 1;
            System.out.println("Course id : " + id
                    + "\nCourse Name  : " + courseList.get(i).getCourseName()
                    + "\nCourse code  : " + courseList.get(i).getCourseCode()
                    + "\nCredit Hours : " + courseList.get(i).getCreditHours() + "\n");
        }

        boolean exit = false;
        do {

            try {
                System.out.print("\nEnter the course number you want to remove : ");
                cidRemove = scanDel.nextInt();
                
                if (cidRemove <= courseList.size()) {
                    exit = true;
                } else {
                    System.out.println("Error course number detected. Please re-enter a valid number.");
                    exit = false;
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanDel.nextLine();
                exit=false;
            }
        } while (!exit);

        for (int i = 0; i < courseList.size(); i++) {
            int id = i + 1;
            if (cidRemove == id) {
                System.out.println("Course id : " + id
                        + "\nCourse Name  : " + courseList.get(i).getCourseName()
                        + "\nCourse code  : " + courseList.get(i).getCourseCode()
                        + "\nCredit Hours : " + courseList.get(i).getCreditHours() + "\n");
            }
        }

        boolean validOption = false;
        boolean exit2 = false;
        Scanner confirmDel = new Scanner(System.in);

        do {
            String delYN;
            System.out.print("\nAre you sure you want to delete? (Y/N): ");

            do {

                try {
                    delYN = confirmDel.nextLine();
                    exit2 = true;

                    switch (delYN.toUpperCase()) {
                        case "Y":
                            course.remove(cidRemove - 1);
                            courseList.remove(cidRemove - 1);
                            System.out.println("Course successfully deleted.");
                            validOption = true;
                            break;
                        case "N":
                            System.out.println("No couse was deleted.");
                            validOption = true;
                            break;
                        case "":
                            validOption = false;
                            break;
                        default:
                            System.out.println("Invalid Option");
                            validOption = false;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    scanDel.nextLine();
                }
            } while (!exit2);

        } while (!validOption);
    }
}
