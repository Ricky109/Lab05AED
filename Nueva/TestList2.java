package linkedList2;

public class TestList2 {
    public static void main(String[] args) {
    	// Prueba con enteros
    	LinkedList<Integer> intList = new LinkedList<>();
        intList.insert(5);
        intList.insert(10);
        intList.insert(1);
        intList.print();
        intList.remove(5);
        intList.print();
        
        // Prueba con cadenas
        LinkedList<String> stringList = new LinkedList<>();
        stringList.insert("Hello");
        stringList.insert("World");
        stringList.insert("Java");
        stringList.print();
        stringList.remove("World");
        stringList.print();

        // Prueba con el tipo Person
        LinkedList<Person> personList = new LinkedList<Person>();
        personList.insert(new Person("Alice", "Andrade", 25));
        personList.insert(new Person("John", "Doe", 30));
        personList.insert(new Person("Bob", "Johnson", 40));
        personList.print();
        personList.remove(new Person("Bob", "Johnson", 40));
        personList.print();
    }
}

