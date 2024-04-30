package linkedList2;


public class ListArray<T> implements TDAList<T> {
    private T[] data;
    private int size;

    public ListArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmptyList() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public void destroyList() {
        data = (T[]) new Object[data.length];
        size = 0;
        System.out.println ("Lista Destruida");
    }

    public int search(T x) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void insertFirst(T x) {
        if (size == data.length) {
            System.out.println ("Lista vacía");
        }
        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = x;
        size++;
    }

    public void insertLast(T x) {
        if (size == data.length) {
            System.out.println ("Lista vacía");
        }
        data[size] = x;
        size++;
    }

    public void removeNode(T x) {
        int index = search(x);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
    }
}


