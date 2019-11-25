package pl.coderstrust.myarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {

    private final static int DEFAULT_SIZE = 10;
    private Object[] a;
    private int size;

    MyArrayList(T[] array) {
        a = array;
        size = array.length;
    }

    MyArrayList() {
        a = new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(a, size());
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) a;
    }

    @Override
    public boolean add(T e) {
        Object[] newArray = new Object[size + 1];
        System.arraycopy(a, 0, newArray, 0, size);
        a = newArray;
        a[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        int index = indexOf(o);
        System.arraycopy(a, index + 1, a, index, size() - index - 1);
        a[--size] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] newArray = new Object[size + c.size()];
        System.arraycopy(a, 0, newArray, 0, size);
        System.arraycopy(c.toArray(), 0, newArray, size, c.size());
        size += c.size();
        a = newArray;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Object[] newArray = new Object[size + c.size()];
        if (index == 0) {
            System.arraycopy(c.toArray(), 0, newArray, 0, c.size());
            System.arraycopy(a, 0, newArray, c.size(), size);
        }
        else {
            System.arraycopy(a, 0, newArray, 0, index);
            System.arraycopy(c.toArray(), 0, newArray, index, c.size());
            System.arraycopy(a, index, newArray, index + c.size(), size - index);
        }
        size = size + c.size();
        a = newArray;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object el : c) {
            remove(el);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        MyArrayList<Object> array = new MyArrayList<>();
        for (Object el : a) {
            if (!c.contains(el))
            {
                array.add(el);
            }
        }
        removeAll(array);
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            a[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element at given index.");
        }
        @SuppressWarnings("unchecked")
        T result = (T) a[index];
        return result;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element at given index.");
        }
        @SuppressWarnings("unchecked")
        T oldValue = (T) a[index];
        a[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        Object[] newArray = new Object[++size];
        if(index == 0) {
            newArray[0] = element;
            System.arraycopy(a, 0, newArray, 1, size - 1);
        }
        else {
            System.arraycopy(a, 0, newArray, 0, index);
            newArray[index] = element;
            System.arraycopy(a, index, newArray, index + 1, size - 1 - index);
        }
        a = newArray;
    }

    @Override
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element at given index.");
        }
        T el = get(index);
       System.arraycopy(a, index + 1, a, index, size - index - 1);
       a[--size] = null;
        return el;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < a.length; i++) {
            if (o.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size()-1; i > -1; i--) {
            if (o.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListItr(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        @SuppressWarnings("unchecked")
        List<T> result = Arrays.asList(Arrays.copyOfRange((T[])a, fromIndex, toIndex));
        return result;
    }

    private class Itr implements Iterator<T> {

        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return lastIndex + 1 < size();
        }

        @Override
        public T next() {
            if (lastIndex == size()) {
                throw new IndexOutOfBoundsException();
            }
            @SuppressWarnings("unchecked")
            T result = (T) a[++lastIndex];
            return result;
        }
    }

    private class ListItr extends Itr implements ListIterator<T> {

        ListItr() {
            super();
        }

        ListItr(int index) {
            super();
            lastIndex = index - 1;
        }

        @Override
        public boolean hasPrevious() {
            return lastIndex - 1 >= 0;
        }

        @Override
        public T previous() {
            @SuppressWarnings("unchecked")
            T result = (T) a[lastIndex--];
            return result;
        }

        @Override
        public int nextIndex() {
            return lastIndex + 1;
        }

        @Override
        public int previousIndex() {
            return lastIndex;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(lastIndex + 1);
            lastIndex--;
        }

        @Override
        public void set(Object o) {
            @SuppressWarnings("unchecked")
            T toSet = (T) o;
            MyArrayList.this.set(lastIndex + 1, toSet);
        }

        @Override
        public void add(T o) {
            MyArrayList.this.add(lastIndex + 1, o);
            lastIndex++;
        }
    }
}
