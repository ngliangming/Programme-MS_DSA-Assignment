/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programme.ms.assignment;

import Adt.HashInterface;
import Adt.HashImplement;
import entity.Faculty;
import entity.Programme;
import java.util.Scanner;
import static programme.ms.assignment.ProgrammeMSAssignment.*;

/**
 *
 * @author darks
 */
public class Hashing {
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Change To Programme!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static HashInterface<Integer, Faculty> programmeTable = new HashImplement<>(71);

    public static void hashIndexing() {
        programmeTable.clear();
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Change To Programme!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < facultyList.size(); i++) {
            programmeTable.add(facultyList.get(i).hashCode(), facultyList.get(i));
        }

        hashMenu();
    }

    public static void hashMenu() {
        Scanner sc = new Scanner(System.in);
        cls();
        int sel = 0;
        boolean exit = false;

        do {
            System.out.print("                Hashed Indexing\n");
            System.out.print("------------------------------------------------\n");
            System.out.print("1. Display Programmes\n");
            System.out.print("2. Search Programme\n");
            System.out.print("3. Add Programme\n");
            System.out.print("0. Exit\n");

            switch (sc.nextLine()) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    displayHashTable();
                    entContinue();
                    exit = true;
                    break;
                case "2":
                    cls();
                    hashSearch();
                    break;
                case "3":
                    cls();
                    hashAdd();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!exit);
    }

    public static void hashSearch() {
        Scanner sc = new Scanner(System.in);
        boolean repeatSearch = true;

        do {
            System.out.print("                Search Programme\n");
            System.out.println("------------------------------------------------\n");
            System.out.print("Enter programme to be search: ");

            String progNameToSearch = sc.nextLine();
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Change To Programme!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Faculty progToSearch = new Faculty(progNameToSearch);

            if (programmeTable.contains(progToSearch.hashCode())) {
                System.out.println(programmeTable.getValue(progToSearch.hashCode()));
            } else {
                System.err.println("Record not found!");
            }

            char yesNo;

            System.out.print("\nDo you want to search another programme? (Y/N): ");
            yesNo = Character.toUpperCase(sc.nextLine().charAt(0));
            switch (yesNo) {
                case 'Y':
                    cls();
                    break;
                case 'N':
                    repeatSearch = false;
                    cls();
                    return;
                default:
                    System.err.println("Please enter a valid selection!");
            }
        } while (repeatSearch);
    }

    public static void hashAdd() {
        Scanner sc = new Scanner(System.in);
        boolean repeatAdd = true;

        do {
            String FCode, FName;
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Change To Programme!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            int lvlOfStudyOpt, facultyOpt, duration;
            Faculty faculty = null;
            /**
             * NEED TO CHANGE TO FACULTY CLASS
             */

            System.out.print("                Add A Programme\n");
            System.out.println("------------------------------------------------\n");
            System.out.print("\nProgram name: ");
            FCode = sc.nextLine();

            System.out.print("\nLevel Of Study: ");
            FName = sc.nextLine();
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Change To Programme!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Faculty newProg = new Faculty(FCode, FName);

            String response;
            System.out.print("Enter (Y/N): ");
            boolean invalid = false;
            cls();
            do {
                System.out.println("Are you sure you want to add the following programme?");
                System.out.println("Program Name: " + newProg.getFCode());
                System.out.println("Level of Study: " + newProg.getFName());

                response = sc.nextLine().toUpperCase();
                switch (response) {
                    case "Y":
                        invalid = false;
                        programmeTable.add(newProg.hashCode(), newProg);
//E!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ADD TO LIST HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        System.out.println(newProg.getFCode() + " in " + newProg.getFName() + " has been added.");
                        cls();
                        break;
                    case "N":
                        invalid = false;
                        repeatAdd = false;
                        cls();
                        return;
                    default:
                        invalid = true;
                        System.err.println("Please enter a valid selection!");
                }
            } while (invalid);

            do {
                System.out.print("\nDo you want to add another programme? (Y/N): ");
                response = sc.nextLine().toUpperCase();
                switch (response) {
                    case "Y":
                        invalid = false;
                        cls();
                        break;
                    case "N":
                        invalid = false;
                        cls();
                        return;
                    default:
                        invalid = true;
                        System.err.println("Please enter a valid selection!");
                }
            } while (invalid);
        } while (repeatAdd);
    }

    public static void displayHashTable() {
        System.out.println(programmeTable);
        System.out.println(programmeTable.getSize());
    }

    public static void cls() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
}
