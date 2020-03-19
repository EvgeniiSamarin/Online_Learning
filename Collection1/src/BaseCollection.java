import java.util.*;

public class BaseCollection<T> extends AbstractCollection<T> {
    private final int CAPACITY = 10;
    private T[] data ;
    private int size;
    private CollectionIterator<T> it;
    public BaseCollection() {
        this.size = 0;
        data = (T[]) new Object[0];
        it = new CollectionIterator<>(data);
    }
    public BaseCollection(BaseCollection<? extends T> array) {
        if(array.size > CAPACITY) {
            throw new IllegalArgumentException("too much");
        } else{
            for ( T elem : array){
                data[size++] = elem;
            }

        }
    }



    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator<>(data);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseCollection)) return false;
        BaseCollection<?> that = (BaseCollection<?>) o;
        return CAPACITY == that.CAPACITY &&
                size == that.size &&
                Arrays.equals(data, that.data) &&
                Objects.equals(it, that.it);
    }


}
