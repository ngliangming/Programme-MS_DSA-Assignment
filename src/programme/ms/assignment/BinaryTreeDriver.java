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
            System.out.println("==========Programme Management System==========\n"
                    + "1. Show All (In-Order Iterations)\n"
                    + "2. Search\n"
                    + "0. Exit\n");
            System.out.printf("> ");

            selection = scanner.nextLine();
            switch (selection) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    lecturer.DisplayInOrderIterator(lecturer.getRoot());
                    break;
                case "2":
                    list.clear();
                    key = scanner.nextLine();
                    search(lecturer.getRoot(), key);
                    if (!list.isEmpty()) {
                        System.out.println(list.size());
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i).data);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while (!exit);
    }

    public static void search(Node node, String key) {
        Node result = null;

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
}
