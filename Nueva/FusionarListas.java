package linkedList2;

public class FusionarListas {
    public static void main(String[] args) {
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();

    list1.insertLast(1);
    list1.insertLast(3);
    list1.insertLast(5);
    list1.insertLast(7);

    list2.insertLast(2);
    list2.insertLast(4);
    list2.insertLast(6);
    list2.insertLast(8);

    LinkedList<Integer> mergedList = merge(list1, list2);

    Node<Integer> current = mergedList.first;
    while (current != null) {
        System.out.print(current.getData() + " -> ");
        current = current.getNext();
    }
    System.out.println("null");
}

public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    LinkedList<Integer> result = new LinkedList<>();
    Node<Integer> node1 = list1.first;
    Node<Integer> node2 = list2.first;

    while (node1 != null && node2 != null) {
        if (node1.getData().compareTo(node2.getData()) < 0) {
            result.insertLast(node1.getData());
            node1 = node1.getNext();
        } else {
            result.insertLast(node2.getData());
            node2 = node2.getNext();
        }
    }

    while (node1 != null) {
        result.insertLast(node1.getData());
        node1 = node1.getNext();
    }

    while (node2 != null) {
        result.insertLast(node2.getData());
        node2 = node2.getNext();
    }

    return result;
}
}

