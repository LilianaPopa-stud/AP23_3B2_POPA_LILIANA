package homework;

/**
 * DijkstraAlgorithm is a class that implements the Dijkstra algorithm.
 * @author Popa Liliana
 */
public class DijkstraAlgorithm extends Algorithm {
    Problem p;

    public DijkstraAlgorithm(Problem p) {
        this.p = p;
    }

    /**
     * This method implements the Dijkstra algorithm
     *
     * @param p This is the problem
     * @return the solution of the problem
     */
    public Solution solve(Problem p) {
        Solution s = new Solution();
        p.setIds();
        double[] distance = new double[p.getNrLocations()];
        Location[] previous = new Location[p.getNrLocations()];
        boolean[] visited = new boolean[p.getNrLocations()];
        for (int i = 0; i < p.getNrLocations(); i++) {
            distance[i] = Double.MAX_VALUE;
            previous[i] = null;
            visited[i] = false;
        }
        distance[p.getStart().getId()] = 0;
        while (!allVisited(visited)) {
            int minIndex = getMinIndex(distance, visited);
            if (minIndex == -1) {
                break;
            }
            visited[minIndex] = true;
            for (int i = 0; i < p.getNrLocations(); i++) {
                if (!visited[i] && p.getAdjacencyMatrix()[minIndex][i] != 0) {
                    double distanceToI = distance[minIndex] + p.getAdjacencyMatrix()[minIndex][i];
                    if (distanceToI < distance[i]) {
                        distance[i] = distanceToI;
                        previous[i] = p.getLocations()[minIndex];
                    }
                }
            }
        }
        // build the solution
        Location current = p.getEnd();
        buildSolution(s, current, previous);
        return s;
    }

    /**
     * This method returns the index of the unvisited location with the smallest distance
     *
     * @param distance the distance of each location
     * @param visited  the visited locations
     * @return the index of the unvisited location with the smallest distance
     */
    private int getMinIndex(double[] distance, boolean[] visited) {
        int minIndex = -1;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * This method checks if all locations are visited
     *
     * @param visited the visited locations
     * @return true if all locations are visited, false otherwise
     */
    private boolean allVisited(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method builds the solution
     * @param s the solution
     * @param current the current location
     * @param previous the previous location
     */
    public void buildSolution(Solution s, Location current, Location[] previous) {
        Location[] route = new Location[p.getNrLocations()];
        int i = 0;
        while (current != null) {
            route[i] = current;
            current = previous[current.getId()];
            i++;
        }
        Location[] route2 = new Location[i];
        int k = 0;
        for (int j = i - 1; j >= 0; j--) {
            route2[k++] = route[j];
            s.setRoute(route2);

        }
    }
}
