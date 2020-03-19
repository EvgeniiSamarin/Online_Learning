import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavigSetIterator<T> implements Iterator<T> {
    private ArrayList collection;
    private int index;

    public NavigSetIterator(ArrayList<T> collection){
        this.collection = collection;
        index = 0;
    }

    @Override
    public boolean hasNext() {
       if(collection.get(++index) != null) return true;
       return false;
    }

    @Override
    public T next() {
        try {
            return (T) collection.get(index);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException("errorororor");
        }
    }
}
