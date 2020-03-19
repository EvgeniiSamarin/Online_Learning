import java.util.Iterator;
import java.util.NoSuchElementException;

public class CollectionIterator<T> implements Iterator<T> {
    private T[] data;
    private int cursor;
    public CollectionIterator(T[] data){
        cursor = 0;
        this.data = data;
    }
    @Override
    public boolean hasNext() {
       boolean flag = false;
       for (int i = cursor; i >= 0 && !flag; i--) {
           if(data[i] != null) flag = true;
       }
       return flag;
    }

    @Override
    public T next() {
        try {
            T r = data[cursor];
            cursor++;
            return r;
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException("Error");
        }
    }
}
