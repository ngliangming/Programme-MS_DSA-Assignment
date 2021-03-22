package Adt;

import java.util.List;

/**
 *
 * @author Ng Liang Ming
 */
public interface BinaryTreeSearchInterface<T extends Comparable<T>> {

    public boolean contains(T entry);
    //Checks if exist

    public T getEntry(T entry);
    //Gets entry
    
    public T add(T newEntry, String key);
    //Add new entry

    public T remove(T entry);
    //Remove existing entry

    public boolean isEmpty();
    //Is node empty?

    public void clear();
    //Clear node

    public BinaryTreeSearchAdt.Node getRoot();
    
    public void DisplayInOrderIterator(BinaryTreeSearchAdt<T>.Node node);
    //Displays in in-order iterations

}