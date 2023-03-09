package compulsory;

/**
 * a class that represents a company
 * it implements the interface Node and the interface Comparable from the package java.util
 * @author Popa Liliana
 */
public class Company implements Node, Comparable<Company> {
    private String name;

    public Company(String name) {
    this.name=name;
    }


    @Override
    public String getName() {
        return name;
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
                '}';
    }
}
