package homework;

import java.util.UUID;

/**
 * a class that represents a company
 * it implements the interface Node and the interface Comparable from the package java.util
 * @author Popa Liliana
 */
public class Company implements Node, Comparable<Company> {
    private UUID id;
    private String name;
    int numberOfEmployees;

    public Company(String name) {
    this.name=name;
    this.id = UUID.randomUUID();
    }
    public Company(String name, int numberOfEmployees) {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
        this.id = UUID.randomUUID();
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public int compareTo(Company o) {
        if (o.name == null) throw new NullPointerException();
        return this.name.compareTo(o.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}'+'\n';
    }


}
