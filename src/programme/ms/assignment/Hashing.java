/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programme.ms.assignment;

import Adt.HashInterface;
import Adt.HashImplement;
import entity.*;
import java.util.Scanner;
import static programme.ms.assignment.ProgrammeMSAssignment.*;

/**
 *
 * @author darks
 */
public class Hashing {

    public static HashInterface<Integer, Programme> programmeTable = new HashImplement<>(71);

    public static void hashIndexing() {
        programmeTable.clear();

        for (int i = 0; i < programmeList.size(); i++) {
            programmeTable.add(programmeList.get(i).hashCode(), programmeList.get(i));
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
            Programme progToSearch = new Programme(progNameToSearch);

            if (programmeTable.contains(progToSearch.hashCode())) {
                System.out.println(programmeTable.getValue(progToSearch.hashCode()));
            } else {
                System.err.println("Record not found!");
            }

            String yesNo;

            System.out.print("\nDo you want to search another programme? (Y/N): ");
            yesNo = sc.nextLine();
            switch (yesNo) {
                case "Y":
                    cls();
                    break;
                case "N":
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
        boolean exists = false;
        String query = "";
        String selection = "";
        boolean endSelection;
        boolean cancel = false;
        boolean again;

        do {
            String PCode, PName;
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Change To Programme!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            int lvlOfStudyOpt, programOpt, duration;
            Programme programme = null;
            Faculty faculty = new Faculty();
            String response;
            boolean invalid = false;

            /**
             * NEED TO CHANGE TO FACULTY CLASS
             */
            System.out.print("                Add A Programme\n");
            System.out.println("------------------------------------------------\n");

            do {
                again = false;
                System.out.print("\nProgram code: ");
                PCode = sc.nextLine();

                for (int i = 0; i < programmeList.size(); i++) {
                    if (PCode.equals(programmeList.get(i).getPCode())) {
                        System.out.println("Programe code already exists");
                        again = true;
                        break;
                    }
                }
            } while (again);

            System.out.print("\nProgram name: ");
            PName = sc.nextLine();

            exists = false;
            while (!exists) {
                System.out.println("Enter Faculty Code: ");
                query = sc.nextLine();

                for (int i = 0; i < facultyList.size(); i++) {
                    if (query.equals(String.valueOf(facultyList.get(i).getFCode()))) {
                        faculty = facultyList.get(i);
                        exists = true;
                    }
                }

                if (!exists) {
                    do {
                        System.out.println("\nInvalid Faculty Code, open Faculty Menu? (H)"
                                + "\nRetry? (Y/N)");
                        selection = sc.nextLine();
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
                                SortingDriver.sortmenu();
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
                Programme newProg = new Programme(PCode, PName, faculty);

                System.out.print("Enter (Y/N): ");
                cls();
                do {
                    System.out.println("Are you sure you want to add the following programme?");
                    System.out.println("Program Code: " + newProg.getPCode());
                    System.out.println("Program Name: " + newProg.getPName());
                    System.out.println("Faculty: " + newProg.getFaculty());

                    response = sc.nextLine().toUpperCase();
                    switch (response) {
                        case "Y":
                            invalid = false;
                            programmeTable.add(newProg.hashCode(), newProg);
                            programmeList.add(newProg);
                            System.out.println(newProg.getPCode() + " in " + newProg.getPName() + " has been added.");
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
            }

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
