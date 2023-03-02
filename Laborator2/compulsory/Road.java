package compulsory;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * This class represents a road
 * @author Popa Liliana
 */
public class Road {
    private double length;
    private int speedLimit;
    private  RoadType type;
    Location c1;
    Location c2;
    public Road() {
    }

    public Road(double length, int speedLimit, RoadType type, Location c1, Location c2) {
        if (length < sqrt(pow(c1.getX() - c2.getX(), 2) + pow(c1.getY() - c2.getY(), 2))) {
            throw new IllegalArgumentException("The length of the road is smaller than the distance between the two locations");
        }
        else {
            this.length = length;
            this.speedLimit = speedLimit;
            this.type = type;
            this.c1 = c1;
            this.c2 = c2;
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

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", speedLimit=" + speedLimit +
                ", type=" + type +
                ", C1=" + c1 +
                ", C2=" + c2 +
                '}';
    }
}
