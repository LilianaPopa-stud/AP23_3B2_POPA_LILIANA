package homework;

import java.util.Arrays;

/**
 * This class represents a solution to the Best Route Problem
 * A solution is a route from a starting location to a destination location
 * The route is a sequence of locations
 */
public class Solution {
    private Location[] route;
    private int nrLocations;

    public void setRoute(Location[] route) {
        this.route = route;
        nrLocations = route.length;
    }

    /**
     * This method computes the length of the route
     * @param p This is the problem
     * @return the length of the route
     */
    public double computeLength(Problem p) {
        double length = 0;
        for (int i = 0; i < route.length - 1; i++) {
            // trebuie sa iterez drumurile si sa verific care drum are cele 2 locatii
            // care sunt in route[i] si route[i+1]
            for (int j = 0; j < p.getNrRoads(); j++) {
                if (p.getRoads()[j].getC1().equals(route[i]) && p.getRoads()[j].getC2().equals(route[i + 1])) {
                    length += p.getRoads()[j].getLength();
                }

            }
        }
        return length;

    }

    public Location[] getRoute() {
        return route;
    }


    @Override
    public String toString() {
        return "Solution{" +
                "route=" + Arrays.toString(route) +
                '}';
    }
}
