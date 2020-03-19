import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MuCollection<T> extends AbstractCollection<T> {
    private final int CAPACITY = 10;
    private T[] data;
    private int size;
    private MuCollectionIterator<T> it;

    public MuCollection() {
        this.size = 0;
        data = (T[]) new Object[0];
        it = new MuCollectionIterator<>(data);
    }

    public MuCollection(MuCollection <? extends T> array) {
        if(array.size > CAPACITY) {
            throw new IllegalArgumentException("error");
        } else {
            for ( T elem : array){
                data[size++] = elem;
            }

        }
    }
    public boolean add(T element) {
        int i = 0;
        if (size != CAPACITY) {
            while (it.hasNext()){
                if(element.equals(data[i])) return false;
                i++;
            }
            data[i] = element;
            return true;
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new MuCollectionIterator<>(data);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MuCollection)) return false;
        MuCollection<?> that = (MuCollection<?>) o;
        return CAPACITY == that.CAPACITY &&
                size == that.size &&
                Arrays.equals(data, that.data) &&
                Objects.equals(it, that.it);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(CAPACITY, size, it);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
