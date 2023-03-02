package compulsory;
/**
 * This class represents a location
 * @author Popa Liliana
 */
public class Location {
    /**
     * This is the name of the location
     */
    private String name;
    /**
     * This is the x coordinate of the location
     */
    private double x;
    /**
     * This is the y coordinate of the location
     */
    private double y;
    /**
     * This is the type of the location
     */
    private LocationType type;

    /**
     * This is the default constructor of the class
     */
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
     * @param type This is the type of the location
     */
    public Location(String name, double x, double y, LocationType type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * This method returns the name of the location
     * @return the name of the location
     */
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

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
