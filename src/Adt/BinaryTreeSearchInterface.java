package Adt;

/**
 *
 * @author Ng Liang Ming
 */
public interface BinaryTreeSearchInterface<T extends Comparable<T>> {

    public boolean contains(T entry);
    //Description: Checks if an entry already exist
    //Post Condition: Returns boolean

    public T getEntry(T entry);
    //Description: Gets the existing entry
    //Post Condition: Returns T entry
    
    public T add(T newEntry, String key, int id);
    //Description: Add new entry into binary tree
    //Post Condition: Entry is added to binary tree

    public boolean isEmpty();
    //Description: Checks if the binary tree is empty
    //Post Condition: Returns boolean

    public void clear();
    //Description: Clears binary tree of all nodes
    //Post Condition: Root is set to null, nodes effectively cleared

    public BinaryTreeSearchAdt.Node getRoot();
    //Description: Gets root of binary tree
    //Post Condition: Root node is returned
    
    public void DisplayInOrderIterator(BinaryTreeSearchAdt<T>.Node node);
    //Description: Displays binary tree in in-order iterations
    //Post Condition: Binary tree is displayed in-order

}