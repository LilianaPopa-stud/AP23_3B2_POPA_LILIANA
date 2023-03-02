package compulsory;

public class Location {
    private String name;
    private double x;
    private double y;
    private LocationType type;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, double x, double y, LocationType type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
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

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
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
