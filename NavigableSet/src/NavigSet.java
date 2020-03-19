import java.util.*;

/**
 * Implementation of NavigableSet
 * version 1.0
 * @author Evgeny Samarin
 * @param <T>
 */
public class NavigSet<T> extends AbstractSet<T> implements NavigableSet<T> {
    private ArrayList<T> collection;
    private int size;
    private NavigSetIterator<T> it;
    private Comparator<T> cmp;

    /**
     *Constructor of NavigableSet that recieves a collections of type T at the input.
     * @param collection collections of type T at the input.
     * @param cmp the comparator passed for this collections
     */
    public NavigSet(ArrayList<T> collection, Comparator<T> cmp) {
        this.collection = collection;
        this.cmp = cmp;
        size = collection.size();
        it = new NavigSetIterator<>(collection);

    }

    /**
     * NavigableSet constructor that creates an empty class instance
     *
     * @param cmp the comparator passed for this collections
     */
    public NavigSet(Comparator<T> cmp){
        this.cmp = cmp;
        collection = new ArrayList<>();
        size = 0;
        it = new NavigSetIterator<>(collection);

    }

    /**
     * method that ads an item to the collection
     * throws ClassCastException if the transferred type not instance of T
     * @param element added element of type T
     * @return returns true if element is added or false if not.
     * @throws ClassCastException if the specified element cannot be compared with the elements currently in the set
     */
    @Override
    public boolean add(T element) {
        int i = 0;
        try {
            if (size != 0) {
                T in = null;
                while ((i < size) && (cmp.compare(element, in) <= 0)) {
                    in = collection.get(i);
                    if (cmp.compare(element, in) == 0) return false;
                    i++;
                }
            }

            collection.add(i, element);
            size++;
            return true;
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }
    }

    /**
     * deletes an element by index
     * @param index of element
     * @return element by index or null if the index is larger than the set size or less than 0
     */
    public T remove(int index) {
        if(index >= size || index < 0) return null;
        T obj = collection.get(index);
        collection.remove(index);
        return obj;
    }

    /**
     * Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
     * @param element - the value to match
     * @return returns the largest element smaller than element or null
     * @throws NullPointerException if the specified element is null and this set does not permit null elements
     * @throws ClassCastException  if the specified element cannot be compared with the elements currently in the set
     */
    @Override
    public T lower(T element) {
        if (element == null) throw new NullPointerException("error");
        int i = 0;
        try {
            while(cmp.compare(collection.get(i), element) < 0 ){
                i++;
            }
            i--;
            if(cmp.compare(collection.get(i), element) == 0) return collection.get(i - 1);
            return collection.get(i);

        } catch (IndexOutOfBoundsException ex) {
            if(i <  0) return null;
            i--;
            return collection.get(i);
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }
    }

    /**
     * Returns the greatest element in this set less than or equal to the given element
     * @param element - the value to match
     * @return the greatest element less than or equal to e, or null if there is no such element
     * @throws NullPointerException if the specified element is null and this set does not permit null elements
     * @throws  ClassCastException  if the specified element cannot be compared with the elements currently in the set
     */
    @Override
    public T floor(T element) {
        if (element == null) throw new NullPointerException("error");
        int i = 0;
        try {
            while(cmp.compare(collection.get(i), element) <= 0 ){
                i++;
            }
            i--;
            return collection.get(i);
        } catch (IndexOutOfBoundsException ex) {
            if (i < 0) return null;
            i--;
            return collection.get(i);
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }
    }

    /**
     * returns the smallest element larger than the given or equal, null if no such element
     * @param element - the value to match
     * @return the least element greater than or equal to element, or null if there is no such element
     * @throws NullPointerException if the specified element is null and this set does not permit null elements
     * @throws  ClassCastException  if the specified element cannot be compared with the elements currently in the set
     */
    @Override
    public T ceiling(T element) {
        if (element == null) throw new NullPointerException("error");
        int i = 0;
        try {
            while(cmp.compare(collection.get(i), element) < 0) {
                i++;
            }
            return collection.get(i);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }
    }

    /**
     * returns the smallest element larger than the given one or null if there is no such element
     * @param element - value to match
     * @return the least element greater than element, or null if there is no such element
     * @throws NullPointerException if the specified element is null and this set does not permit null elements
     * @throws  ClassCastException  if the specified element cannot be compared with the elements currently in the set
     */
    @Override
    public T higher(T element) {
        if (element == null) throw new NullPointerException("error");
        int i = 0;
        try {
            while(cmp.compare(collection.get(i), element) <= 0) {
                i++;
            }
            return collection.get(i);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }

    }

    /**
     * removes and returns the first element of the set or returns null if there is no such element
     * @return the first element, or null if this set is empty
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public T pollFirst() {
        try {
            T element = collection.get(0);
            collection.remove(0);
            size--;
            return element;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new NoSuchElementException("collection is empty");
        }
    }

    /**
     * removes and returns the first element of the set or returns null if there is no such element
     * @return the last element, or null if this set is empty
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public T pollLast() {
        try {
            T element = collection.get(size);
            collection.remove(0);
            size--;
            return element;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException("collection is empty");
        }

    }

    /**
     * Returns an iterator over the elements in this set, in ascending order
     * @return an iterator over the elements in this set, in ascending order
     */
    @Override
    public Iterator<T> iterator() {
        return it;
    }

    /**
     * Returns a reverse order view of the elements contained in this set
     * @return a reverse order view of this set
     */
    @Override
    public NavigableSet<T> descendingSet() {
        NavigableSet<T> ans = new NavigSet<>(cmp);
        for (int i = collection.size() - 1; i >= 0; i--  ) {
            T el = collection.get(i);
            ans.add(el);
        }
        return ans;
    }

    /**
     * Returns an iterator over the elements in this set, in descending order. Equivalent in effect to descendingSet().iterator().
     * @return an iterator over the elements in this set, in descending order
     */
    @Override
    public Iterator<T> descendingIterator() {
        return descendingSet().iterator();
    }

    /**
     * Returns a view of the portion of this set whose elements range from fromElement to toElement.
     * If fromElement and toElement are equal return Empty, if fromInclusive and toInclusive both are not equal true.
     * @param fromElement - low endpoint of the returned set
     * @param fromInclusive - true if the low endpoint is in the set
     * @param toElement - high endpoint of the returned set
     * @param toInclusive - true if the high endpoint is in the set
     * @return a view of the portion of this set whose elements range from fromElement, fromInclusive, toElement, toInclusive
     * @throws NullPointerException if fromElement or toElement is null
     * @throws IllegalArgumentException if fromElement is greater than toElement; or if this set itself has a restricted range, and fromElement or toElement lies outside the bounds of the range
     * @throws ClassCastException if fromElement and toElement cannot be compared to one another using this set's comparator
     */
    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
            if (fromElement == null || toElement == null) throw new NullPointerException("error");
            int i = 0;
            NavigableSet<T> ans = new NavigSet<>(cmp);
            try {
                while (cmp.compare(collection.get(i), fromElement) < 0) {
                    i++;
                }
                if(cmp.compare(collection.get(i), fromElement) == 0) {
                    if(fromElement.equals(toElement)) {
                        if(fromInclusive && toInclusive) {
                            ans.add(collection.get(i));
                            return ans;
                        }
                        else {
                            return ans;
                        }
                    }
                    if (fromInclusive) {
                        while (cmp.compare(collection.get(i), toElement) < 0) {
                            ans.add(collection.get(i));
                            i++;
                        }
                        if (cmp.compare(collection.get(i), toElement) == 0) {
                            if (toInclusive) {
                                ans.add(collection.get(i));
                                return ans;
                            } else {
                                return ans;
                            }
                        } else {
                            throw new IllegalArgumentException("error");
                        }
                    } else {
                        i++;
                        while (cmp.compare(collection.get(i), toElement) < 0) {
                            ans.add(collection.get(i));
                            i++;
                        }
                        if (cmp.compare(collection.get(i), toElement) == 0) {
                            if (toInclusive) {
                                ans.add(collection.get(i));
                                return ans;
                            } else {
                                return ans;
                            }
                        } else {
                            throw new IllegalArgumentException("error");
                        }

                    }
                } else {
                    throw new IllegalArgumentException("error");
                }

            } catch (IndexOutOfBoundsException ex) {
                throw new IllegalArgumentException("error");
            } catch (ClassCastException ex) {
                throw new ClassCastException("error");
            }
    }

    /**
     * returns a representation of this set of elements which are less than or equal(if inclusive is true) to toElement
     * @param toElement - high endpoint of the returned set
     * @param inclusive - true if the high endpoint is to be included in the returned view
     * @return a representation of this set of elements which are less than or equal(if inclusive is true) to toElement
     * @throws NullPointerException if toElement is null
     * @throws IllegalArgumentException if this set itself has a limited range, and toElement is out of range
     * @throws ClassCastException if toElement cannot be compared to one another using this set's comparator
     */
    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        if (toElement == null) throw new NullPointerException("error");
        int i = 0;
        NavigableSet<T> ans = new NavigSet<>(cmp);
        try{
            while(cmp.compare(collection.get(i), toElement) < 0) {
                ans.add(collection.get(i));
                i++;
            }
            if(cmp.compare(collection.get(i), toElement) == 0) {
                if(inclusive) {
                    ans.add(collection.get(i));
                    return ans;
                } else {
                    return ans;
                }
            } else {
                throw new IllegalArgumentException("error");
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("error");
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }
    }

    /**
     * returns a representation of this set of elements which are higher than or equal(if inclusive is true) fromElement
     * @param fromElement - low endpoint of the returned set
     * @param inclusive - true if the low endpoint is to be included in the returned view
     * @return a representation of this set of elements which are higher than or equal(if inclusive is true) fromElement
     * @throws NullPointerException if fromElement is null
     * @throws IllegalArgumentException if this set itself has a limited range, and fromElement is out of range
     * @throws ClassCastException if fromElement cannot be compared to one another using this set's comparator
     */
    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        if (fromElement == null) throw new NullPointerException("error");
        int i = 0;
        NavigableSet<T> ans = new NavigSet<>(cmp);
        try{
            while(cmp.compare(collection.get(i), fromElement) < 0) {
                i++;
            }
            if(cmp.compare(collection.get(i), fromElement) == 0) {
                if(inclusive) {
                    while(i < collection.size()) ans.add(collection.get(i));
                    return ans;
                } else {
                    i++;
                    while (i < collection.size()) ans.add(collection.get(i));
                    return ans;
                }
            } else {
                throw new IllegalArgumentException("error");
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("error");
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        }
    }

    /**
     * Returns the comparator used to order the elements in this set
     * @return the comparator used to order the elements in this set
     */
    @Override
    public Comparator<? super T> comparator() {
        return cmp;
    }

    /**
     * Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     * @param fromElement - low endpoint of the returned set
     * @param toElement - high endpoint of the returned set
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     * @throws NullPointerException if fromElement or toElement is null
     * @throws IllegalArgumentException if fromElement is greater than toElement; or if this set itself has a restricted range, and fromElement or toElement lies outside the bounds of the range
     * @throws ClassCastException if fromElement and toElement cannot be compared to one another using this set's comparator
     */
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return subSet(fromElement, true, toElement,false);
    }

    /**
     * Returns a view of the portion of this set whose elements are strictly less than toElement
     * @param toElement - high endpoint of the returned set
     * @return  a view of the portion of this set whose elements are strictly less than toElement
     * @throws NullPointerException if toElement is null
     * @throws IllegalArgumentException if this set itself has a limited range, and toElement is out of range
     * @throws ClassCastException if toElement cannot be compared to one another using this set's comparator
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        return headSet(toElement, false);
    }

    /**
     * Returns a view of the portion of this set whose elements are greater than or equal to fromElement
     * @param fromElement - low endpoint of the returned set
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     * @throws NullPointerException if fromElement is null
     * @throws IllegalArgumentException if this set itself has a limited range, and fromElement is out of range
     * @throws ClassCastException if fromElement cannot be compared to one another using this set's comparator
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return tailSet(fromElement, true);
    }

    /**
     * Returns the first (lowest) element currently in this set
     * @return the first (lowest) element currently in this set
     * @throws NoSuchElementException if set is empty
     */
    @Override
    public T first() {
        try {
            return collection.get(0);
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new NoSuchElementException("error");
        }
    }

    /**
     * Returns the last (highest) element currently in this set
     * @return the last (highest) element currently in this set
     * @throws NoSuchElementException is set is empty
     */
    @Override
    public T last() {
        try {
            return collection.get(size);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException("collection is empty");
        }
    }

    /**
     * returns the size of this set
     * @return the size of this set
     */
    @Override
    public int size() {
        return collection.size();
    }

}
