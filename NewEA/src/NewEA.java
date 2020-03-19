import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static java.lang.System.arraycopy;

public class NewEA<T> implements Iterable<T> {
    private EaIterator<T> iter;
    private static final int SIZE_ARRAY = 5;
    /**
     *Field implements size
     */
    private int size;
    /**
     *Field impelements array
     */
    private Object[] array;

    /**
     * Empty constructor
     */
    public NewEA() {
        this(SIZE_ARRAY);
    }

    /**
     * Constructor with users size
     * @param sizeArray start size
     */
    public NewEA(int sizeArray){
        this.array = new Object[sizeArray];
    }

    /**
     * Constructor with array of first elements
     * @param firstElements array of first elements
     */
    public NewEA( Object[] firstElements) {
        arraycopy(firstElements,0, array, 0, firstElements.length);
    }

    /**
     * Add new element
     * @param a
     * @throws
     */
    public void put(T a) throws IndexOutOfSizeException {
        if (size == array.length - 1){
            this.extendArray(array.length*(2-1));
        }
        this.setElement(size, a);
        size++;
    }

    /**
     * extend field old array
     * @param l
     */
    public void extendArray(int l){
        array = Arrays.copyOf(array, l+array.length);
    }

    /**
     * set new element
     * @param index
     * @param a
     * @throws IndexOutOfSizeException
     */
    public void setElement(int index, T a) throws IndexOutOfSizeException{
        if(index <= size) {
            this.array[index] = a;
        } else {
            throw new IndexOutOfSizeException("number is larger than the size of the array");
        }
    }

    /**
     * remove element from array
     * @param index
     */
    public void removeElement(int index){
        for (int i = index; i < size-1; i++){
            this.array[i] = this.array[i + 1];
        }
        size--;
        array[size++] = null;
    }

    /**
     * get element witn this index
     * @param index
     * @return
     */
    public Object getElement(int index){
        return this.array[index];
    }

    /**
     * Search element
     * @param a
     * @return
     */
    public int indexOf(T a){
        return this.indexOf(a,0);
    }

    /**
     *search for an item from a given position
     * @param a
     * @param firstIndex
     * @return
     */
    public int indexOf(T a, int firstIndex){
        for (int i = firstIndex; i < size; i++){
            if (a.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new EaIterator<T>((T[]) array);
    }

    /**
     * Exception that trown if you adress to element that doesnt exist
     */
    private class IndexOutOfSizeException extends Exception {
        public IndexOutOfSizeException(String message) {
            super(message);
        }
    }

    /**
     * get size of array
     * @return
     */
    public int getSize(){
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewEA)) return false;
        NewEA<?> newEA = (NewEA<?>) o;
        return size == newEA.size &&
                Arrays.equals(array, newEA.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    /**
     * Create Array as to string
     * @return
     */
    @Override
    public String toString() {
        return "{" +
                "This array = " + Arrays.toString(array) +
                '}';
    }
}
