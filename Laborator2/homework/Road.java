package homework;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * This class represents a road
 * @author Popa Liliana
 */
public class Road {
    private double length;
    private int speedLimit;
    Location c1;
    Location c2;
    private int nrRoads;
    /**
    * This is the default constructor of the class
     */
    public Road() {
    }

    /**
     * This is the constructor of the class
     * @param length This is the length of the road
     * @param speedLimit This is the speed limit of the road
     * @param c1 This is the first location
     * @param c2 This is the second location
     */

    public Road(double length, int speedLimit, Location c1, Location c2) {
        if (length < sqrt(pow(c1.getX() - c2.getX(), 2) + pow(c1.getY() - c2.getY(), 2))) {
            throw new IllegalArgumentException("The length of the road is smaller than the distance between the two locations");
        }
        else {
            this.length = length;
            this.speedLimit = speedLimit;
            this.c1 = c1;
            this.c2 = c2;
            this.nrRoads++;
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getC1() {
        return c1;
    }

    public void setC1(Location c1) {
        this.c1 = c1;
    }

    public Location getC2() {
        return c2;
    }

    public void setC2(Location c2) {
        this.c2 = c2;
    }

    /**
     * This method returns the string representation of the object
     * @return String This returns the string representation of the object
     */
    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", speedLimit=" + speedLimit +
                ", c1=" + c1 +
                ", c2=" + c2 +
                '}';
    }

    /**
     * This method checks if two objects (roads) are equal
     * @param o This is the object to be compared
     * @return boolean This returns true if the objects are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0 && speedLimit == road.speedLimit && c1.equals(road.c1) && c2.equals(road.c2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, speedLimit, c1, c2);
    }
}
