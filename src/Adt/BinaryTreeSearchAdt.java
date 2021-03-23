package Adt;

/**
 *
 * @author Ng Liang Ming
 */
public class BinaryTreeSearchAdt<T extends Comparable<T>> implements BinaryTreeSearchInterface<T> {

    public Node root;

    @Override
    public boolean contains(T entry) {
        return getEntry(entry) != null;
    }

    @Override
    public T getEntry(T entry) {
        return findEntry(root, entry);
    }

    private T findEntry(Node rootNode, T entry) {
        T result = null;

        if (rootNode != null) {
            T rootEntry = rootNode.data;

            if (entry.equals(rootEntry)) {
                result = rootEntry;
            } else if (entry.compareTo(rootEntry) < 0) {
                result = findEntry(rootNode.left, entry);
            } else {
                result = findEntry(rootNode.right, entry);
            }
        }
        return result;
    }

    @Override
    public T add(T newEntry, String name, int id) {
        T result = null;

        if (isEmpty()) {
            root = new Node(newEntry, name, id);
        } else {
            result = addEntry(root, newEntry, name, id);
        }

        return result;
    }

    private T addEntry(Node rootNode, T newEntry, String name, int id) {
        T result = null;
        int comparison = newEntry.compareTo(rootNode.data);

        if (comparison == 0) {
            result = rootNode.data;
            rootNode.data = newEntry;
        } else if (comparison < 0) {
            if (rootNode.left != null) {
                result = addEntry(rootNode.left, newEntry, name, id);
            } else {
                rootNode.left = new Node(newEntry, name, id);
            }
        } else {
            if (rootNode.right != null) {
                result = addEntry(rootNode.right, newEntry, name, id);
            } else {
                rootNode.right = new Node(newEntry, name, id);
            }
        }
        return result;
    }

    @Override
    public void DisplayInOrderIterator(Node node) {
        if (node.left != null) {
            System.out.println("");
            this.DisplayInOrderIterator(node.left);
        }
        System.out.println(node.data);
        if (node.right != null) {
            System.out.println("");
            this.DisplayInOrderIterator(node.right);
        }
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    public class Node {

        public T data;
        public Node left;
        public Node right;
        public String key;
        public int id;

        public boolean matches(String key) {
            return this.key.toUpperCase().matches("(.*)" + key.toUpperCase() + "(.*)");
        }

        public boolean matches(int id) {
            return this.id == id;
        }

        public Node() {
        }

        private Node(T dataPortion, String key, int id) {
            this(dataPortion, key, id, null, null);
        }

        private Node(T data, String key, int id, Node left, Node right) {
            this.data = data;
            this.key = key;
            this.id = id;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            return (left == null) && (right == null);
        }

    }

}
