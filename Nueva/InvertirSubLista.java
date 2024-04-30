package linkedList2;

public class InvertirSubLista {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);

        System.out.println("Lista original:");
        list.print(); 

        list.reverseSublist(2, 5);

        System.out.println("Lista después de invertir la sublista:");
        list.print(); 
    }
}

