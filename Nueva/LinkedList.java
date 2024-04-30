package linkedList2;

public class LinkedList<T extends Comparable> implements TDAList<T> {
    public Node<T> first;
    public int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    @Override
    public boolean isEmptyList() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void destroyList() {
        first = null;
        size = 0;
        System.out.println ("Lista Destruida");
    }

    

    @Override
    public void insertFirst(T x) {
        first = new Node<>(x, first);
        size++;
    }

    @Override
    public void insertLast(T x) {
        if (isEmptyList()) {
            insertFirst(x);
        } else {
            Node<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(x));
            size++;
        }
    }

    @Override
    public void removeNode(T x) {
        if (isEmptyList()) {
            System.out.println("Lista vacía");
        }
        if (first.getData().equals(x)) {
            first = first.getNext();
        } else {
            Node<T> current = first;
            while (current.getNext() != null && !current.getNext().getData().equals(x)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
        size--;
    }

    public void deleteDuplicates() {
        Node<T> current = first;
        while (current != null) {
            Node<T> runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData().equals(current.getData())) {
                    runner.setNext(runner.getNext().getNext());
                    size--;
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    public void insertNth(T data, int pos) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (pos == 0) {
            insertFirst(data);
        } else {
            Node<T> current = first;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<>(data, current.getNext()));
            size++;
        }
    }
    
    public void deleteNth(int pos) {
        if(pos < size) {
            if(pos == 0) {
                first = first.getNext();
            } else {
                Node<T> current = first;
                for(int i = 0; i < pos - 1 && current.getNext() != null; i++) {
                    current = current.getNext();
                }
                if(current.getNext() != null) {
                    current.setNext(current.getNext().getNext());
                }
            }
            size--;
        } else {
            System.out.println("La posición excede el tamaño de la lista");
        }
    }

    public void reverseSublist(int left, int right) {
        if (left < 0 || right >= size || left >= right) {
            System.out.println("Indices de sublista invalidos");
        }
    
        Node<T> prev = null;
        Node<T> current = first;
        Node<T> next = null;
        Node<T> beforeLeft = null;
        Node<T> afterRight = null;
        int currentIndex = 0;
    
        while (current != null && currentIndex < left) {
            beforeLeft = current;
            current = current.getNext();
            currentIndex++;
        }
    
        Node<T> leftNode = current; 
    
        while (current != null && currentIndex <= right) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            currentIndex++;
        }
    
        if (beforeLeft != null) {
            beforeLeft.setNext(prev);
        } else {
            first = prev; 
        }
    
        leftNode.setNext(current); 
    }
    

    public void print() {
        Node<T> current = first;

        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    
    @Override
    public int search(T x) {
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(x)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1; // Elemento no encontrado
    }

    public void insert(T x) {
        Node<T> newNode = new Node<>(x);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            Node<T> previous = null;
            while (current != null && x.compareTo(current.getData()) > 0) {
                previous = current;
                current = current.getNext();
            }

            // Insertar el nuevo nodo en la posición adecuada
            newNode.setNext(current); // El nuevo nodo apunta al siguiente nodo
            if (previous == null) {
                first = newNode;
            } else {
                previous.setNext(newNode);
            }
        }
        size++;
    }

    public void remove(T x) {
        if (first == null) {
            return;
        }
        if (first.getData().equals(x)) {
            first = first.getNext();
            size--;
            return;
        }

        Node<T> current = first;
        Node<T> previous = null;
        while (current != null && !current.getData().equals(x)) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
            size--;
        }
    }



}
    
