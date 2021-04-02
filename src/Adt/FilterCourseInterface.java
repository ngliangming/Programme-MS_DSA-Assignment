package Adt;

/**
 *
 * @author wong-
 */
public interface FilterCourseInterface<T extends Comparable<T>> {
    public void add(T newEntry);
    public void display();
    public boolean isEmpty();
    public void clear();
    public int getSize();
    public T remove(int givenPosition);
    
    public void filter(T newEntrys);
}
