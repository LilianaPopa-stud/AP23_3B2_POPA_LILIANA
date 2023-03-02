package compulsory;
/**
 * This class represents a road
 * @author Popa Liliana
 */
public class Road {
    private double length;
    private int speedLimit;
    private  RoadType type;
    
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
