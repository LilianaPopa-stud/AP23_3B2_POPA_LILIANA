package homework;

import java.util.Objects;
/**
 * This class represents a location in the Best Route Problem
 * @author Popa Liliana
 */
public class Location {
    private String name;
    private double x;
    private double y;
    private int id;

    public Location() {
    }
    /**
     * This is the constructor of the class
     * @param name This is the name of the location
     */
    public Location(String name) {
        this.name = name;
    }

    /**
     * This is the constructor of the class
     * @param name This is the name of the location
     * @param x This is the x coordinate of the location
     * @param y This is the y coordinate of the location
     */
    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * This method overrides the equals method
     * @param o This is the object to be compared
     * @return true if the objects are equal, false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && id == location.id && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, id);
    }
}
