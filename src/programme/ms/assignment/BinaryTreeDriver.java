package programme.ms.assignment;

import Adt.BinaryTreeSearchAdt.*;
import java.util.Scanner;
import static programme.ms.assignment.ProgrammeMSAssignment.*;
import entity.Lecturer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ng Liang Ming
 */
public class BinaryTreeDriver {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Node> list = new ArrayList();

    public static void binaryTreeMenu() {
        boolean exit = false;
        String selection;
        String key;

        do {
            System.out.println("==========Lecturer (Binary Search Tree)==========\n"
                    + "1. Show All (In-Order Iterations)\n"
                    + "2. Broad search by name\n"
                    + "3. Get lecturer by staff id\n"
                    + "4. Add new lecturer\n"
                    + "0. Exit\n");
            System.out.printf("> ");

            selection = scanner.nextLine();
            switch (selection) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    System.out.println("=====Entries Found=====");
                    lecturer.DisplayInOrderIterator(lecturer.getRoot());
                    System.out.println("=======================");
                    entContinue();
                    break;
                case "2":
                    list.clear();
                    System.out.printf("Enter search query(name) :\n> ");
                    key = scanner.nextLine();
                    search(lecturer.getRoot(), key);
                    if (!list.isEmpty()) {
                        System.out.printf("=====%2d Entries Found=====\n", list.size());
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i).data + "\n");
                        }
                        System.out.println("==========================");
                    } else {
                        System.out.println("No entries matching");
                    }
                    entContinue();
                    break;
                case "3":
                    findNodeId = null;
                    System.out.printf("Enter search query(staffId) :\n> ");
                    try {
                        int query = scanner.nextInt();
                        scanner.nextLine();

                        findById(lecturer.getRoot(), query);
                        if (findNodeId != null) {
                            System.out.println("=====Entry Found=====");
                            System.out.println(findNodeId.data);
                            System.out.println("=====================");
                        } else {
                            System.out.println("\nEntry Not Found");
                        }
                        entContinue();
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid Option");
                        break;
                    }
                case "4":
                    String name;
                    String phoneNum;
                    String email;
                    int staffId = new Lecturer().idIndex;
                    try {
                        do {
                            System.out.printf("Enter name (must be filled):\n> ");
                            name = scanner.nextLine();
                        } while (name.equals(""));
                        
                        do {
                        System.out.printf("Enter phone number (must be filled):\n> ");
                        phoneNum = scanner.nextLine();
                        } while (phoneNum.equals(""));
                        
                        do {
                        System.out.printf("Enter email (must be filled):\n> ");
                        email = scanner.nextLine();
                        } while (email.equals(""));

                        lecturer.add(new Lecturer(name, phoneNum, email), name, new Lecturer().idIndex++);

                        findById(lecturer.getRoot(), staffId);
                        if (findNodeId != null) {
                            System.out.println("\n\nNew Entry Found\n");
                            System.out.println(findNodeId.data);
                        } else {
                            System.out.println("\n\nNew Entry Not Found\n");
                        }
                        entContinue();
                    } catch (Exception e) {
                        System.out.println("An error has occured! Please try again!");
                        entContinue();
                    }
                    break;
                default:
                    System.out.println("\nInvalid Option");
                    break;
            }
        } while (!exit);
    }

    public static void search(Node node, String key) {
        if (node != null) {
            if (node.matches(key)) {
                list.add(node);
            }

            if (node.left != null) {
                search(node.left, key);
            }
            if (node.right != null) {
                search(node.right, key);
            }

        }
    }

    public static Node findNodeId;

    public static void findById(Node node, int id) {
        if (node != null) {
            if (node.matches(id)) {
                findNodeId = node;
            }

            if (node.left != null) {
                findById(node.left, id);
            }
            if (node.right != null) {
                findById(node.right, id);
            }

        }
    }
}
