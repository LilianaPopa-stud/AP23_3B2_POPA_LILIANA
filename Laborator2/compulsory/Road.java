package compulsory;
/**
 * This class represents a road
 * @author Popa Liliana
 */
public class Road {
    /**
     * This is the length of the road
     */
    private double length;
    /**
     * This is the speed limit of the road
     */
    private int speedLimit;
    /**
     * This is the type of the road
     */
    private  RoadType type;

    /**
     * This is the constructor of the class
     */
    public Road() {
    }

    /**
     * This is the constructor of the class
     * @param length This is the length of the road
     * @param speedLimit This is the speed limit of the road
     * @param type This is the type of the road
     */
    public Road(float length, int speedLimit, RoadType type) {
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
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

    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", speedLimit=" + speedLimit +
                ", type=" + type +
                '}';
    }
}
