package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * a class that represents a person
 * it implements the interface Node and the interface Comparable from the package java.util
 * @author Popa Liliana
 */
public class Person implements Node, Comparable<Person> {
    private UUID id;
    private String name;
    private int age;
    private Map<Node, Relationship> relationships = new HashMap<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
    }
    public Person(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }
    public Person() {
        this.id = UUID.randomUUID();
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void addRelationship(Node node, Relationship relationship){
        relationships.put(node, relationship);
    }
    public int getNumberOfConnections(){
        return relationships.size();
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public Map<Node, Relationship> getRelationships() {
        return this.relationships;
    }

    public void setRelationships(Map<Node, Relationship> relationships) {
        this.relationships = relationships;
    }
}
