package homework;

/**
 * Problem is a class that contains the locations and roads of a problem.
 * It also contains the number of locations and roads.
 * @author Popa Liliana
 */

public class Problem {
    private Location[] locations;
    private Road[] roads;
    private int nrLocations;
    private int nrRoads;

    public Problem() {
        locations = new Location[100];
        roads = new Road[100];
        nrLocations = 0;
        nrRoads = 0;
    }
    /**
     * Constructor with parameters
     * @param locations the locations of the problem
     * @param roads the roads of the problem
     * @param nrLocations the number of locations
     * @param nrRoads  the number of roads
     */
    public Problem(Location[] locations, Road[] roads, int nrLocations, int nrRoads) {
        this.locations = locations;
        this.roads = roads;
        this.nrLocations = nrLocations;
        this.nrRoads = nrRoads;
    }
    public void addLocation(Location l){
        locations[nrLocations]=l;
        nrLocations++;
    }
    public void addRoad(Road r){
        roads[nrRoads]=r;
        nrRoads++;
    }
    public Location[] getLocations() {
        return locations;
    }
    public void setLocations(Location[] locations) {
        this.locations = locations;
    }
    public Road[] getRoads() {
        return roads;
    }
    public void setRoads(Road[] roads) {
        this.roads = roads;
    }
    public int getNrLocations() {
        return nrLocations;
    }
    public void setNrLocations(int nrLocations) {
        this.nrLocations = nrLocations;
    }
    public int getNrRoads() {
        return nrRoads;
    }
    public void setNrRoads(int nrRoads) {
        this.nrRoads = nrRoads;
    }

}
