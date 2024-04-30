package linkedList2;

import java.util.Objects;

class Person implements Comparable<Person>{
    private String name;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastName, person.lastName);
    }
    
    @Override
    public int compareTo(Person otherPerson) {
        // Comparar por apellido
        int lastNameComparison = this.lastName.compareTo(otherPerson.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        
        // Si los apellidos son iguales, comparar por nombre
        return this.name.compareTo(otherPerson.name);
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
