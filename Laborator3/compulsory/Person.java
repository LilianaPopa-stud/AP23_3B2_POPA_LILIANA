package compulsory;

import java.util.Comparator;

/**
 * a class that represents a person
 * it implements the interface Node and the interface Comparable from the package java.util
 * @author Popa Liliana
 */
public class Person implements Node, Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Person o) {
        if (o.name == null) throw new NullPointerException();
        return this.name.compareTo(o.name);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
