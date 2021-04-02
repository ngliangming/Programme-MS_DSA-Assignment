package Adt;

/**
 *
 * @author wong-
 */
public class FilterCourse<T extends Comparable<T>> implements FilterCourseInterface<T> {

    private T[] array;
    private int length;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public FilterCourse() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public FilterCourse(int initial) {
        length = 0;
        array = (T[]) new Comparable[initial];
    }

    private void doubleArray() {
        T[] oldArray = array;
        array = (T[]) new Object[2 * oldArray.length];
        for (int i = 0; i < length; i++) {
            array[i] = oldArray[i];
        }
    }

    @Override
    public void add(T newEntry) {
        if (length == array.length) {
            doubleArray();
        }
        array[length] = newEntry;
        length++;
    }

    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSize() {
        return length;
    }

    @Override
    public void display() {
        System.out.printf("------------Course List------------\n");
        for (int index = 0; index < length; ++index) {
            System.out.printf("Course #%d\n%-50s\n", index + 1, array[index]);
        }
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < length; ++index) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public void filter(T entry) {
        for (int index = 0; index < length; ++index) {
            if (entry.compareTo(array[index]) == 0) {
                System.out.println(array[index]);
            }
        }
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            result = array[givenPosition - 1];

            if (givenPosition < length) {
                removeGap(givenPosition);
            }
            length--;
        }
        return result;
    }

    private void removeGap(int givenPosition) {
        // move each entry to next lower position starting at entry after the
        // one removed and continuing until end of array
        int removedIndex = givenPosition - 1;
        int lastIndex = length - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

}
