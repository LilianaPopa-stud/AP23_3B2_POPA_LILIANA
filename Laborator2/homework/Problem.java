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
    private Location start;
    private Location end;

    public Problem() {
        locations = new Location[100];
        roads = new Road[100];
        nrLocations = 0;
        nrRoads = 0;
    }

    /**
     * Constructor with parameters
     *
     * @param locations   the locations of the problem
     * @param roads       the roads of the problem
     * @param nrLocations the number of locations
     * @param nrRoads     the number of roads
     */
    public Problem(Location[] locations, Road[] roads, int nrLocations, int nrRoads, Location start, Location end) {
        this.locations = locations;
        this.roads = roads;
        this.nrLocations = nrLocations;
        this.nrRoads = nrRoads;
        this.start = start;
        this.end = end;
    }

    public void addLocation(Location l) {
        locations[nrLocations] = l;
        nrLocations++;
    }

    public void addRoad(Road r) {
        roads[nrRoads] = r;
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

    public int getNrRoads() {
        return nrRoads;
    }

    public void setNrRoads(int nrRoads) {
        this.nrRoads = nrRoads;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    /**
     * This method sets the id of each location
     */
    public void setIds() {
        for (int i = 0; i < nrLocations; i++) {
            locations[i].setId(i);
        }
    }

    /**
     * This method returns the adjacency matrix of the problem
     * The adjacency matrix is a matrix of size nrLocations x nrLocations
     * The element at position (i,j) is the length of the road between the locations i and j
     * @return the adjacency matrix
     */
    public double[][] getAdjacencyMatrix() {
        double[][] adjacencyMatrix = new double[nrLocations][nrLocations];
        for (int i = 0; i < nrLocations; i++) {
            for (int j = 0; j < nrLocations; j++) {
                adjacencyMatrix[i][j] = Double.MAX_VALUE;
            }
        }
        for (int i = 0; i < nrRoads; i++) {
            adjacencyMatrix[roads[i].getC1().getId()][roads[i].getC2().getId()] = roads[i].getLength();
        }

        return adjacencyMatrix;
    }

    public void setNrLocations(int i) {
        nrLocations = i;
    }

}


