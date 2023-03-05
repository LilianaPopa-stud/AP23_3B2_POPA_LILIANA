package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the Main class of the application.
 * @author Popa Liliana
 */
public class Main{
    /**
     * This is the main method of the application and the starting point of the application
     * It creates an instance of the problem and checks if it is valid
     *
     * @param args This is the array of arguments
     */
    public static void main(String[] args) {
        Problem problem = new Problem();
        City iasi = new City("Iasi", 20.5, 28.1, 1000000);
        City chisinau = new City("Chisinau", 40, 33.2, 500000);
        Airport otopeni = new Airport("Otopeni", 10.0, 90,2);
        Airport chisinauAirport = new Airport("Chisinau Airport", 44, 40, 1);
        GasStation lukoil = new GasStation("Lukoil", 30, 40, 5.5);
        problem.addLocation(iasi);
        problem.addLocation(chisinau);
        problem.addLocation(otopeni);
        problem.addLocation(chisinauAirport);
        problem.addLocation(lukoil);
        problem.addRoad(new Highway(120,120,iasi,chisinau));
        problem.addRoad(new Highway(360,120,otopeni,iasi));
        problem.addRoad(new Highway(110,120,iasi,lukoil));
        problem.addRoad(new Country(40,120,lukoil,chisinau));
        problem.addRoad(new Highway(35,120,chisinau,chisinauAirport));
        problem.addRoad(new Express(30,120,iasi,chisinauAirport));
        problem.setStart(otopeni);
        problem.setEnd(chisinauAirport);
        Main app = new Main();
        app.checkInstance(problem);
        app.canReach(chisinau, lukoil, problem);
        app.canReach(lukoil, chisinauAirport, problem);
        app.canReach(otopeni, chisinau, problem);
        Solution solution = new Solution();
        solution.setRoute(new Location[]{iasi, chisinau, chisinauAirport});
        System.out.println(solution.computeLength(problem)+" km "+"between "+solution.getRoute()[0].getName()+" and "+solution.getRoute()[solution.getRoute().length-1].getName());

        Algorithm algorithm = new DijkstraAlgorithm(problem);
        Solution sol = new Solution();
        sol=algorithm.solve(problem);
        System.out.println("The shortest path between "+problem.getStart().getName()+" and "+problem.getEnd().getName()+" is: "+sol.toString());


    }

    /**
     * This method checks if a instance of the problem is valid
     * A valid instance of the problem does not have two locations with the same name and coordinates
     * A valid instance of the problem does not have two roads with the same name and length
     * A valid instance of the problem does not a source and a destination that are the same
     * @param pb This is the instance of the problem
     */
    public void checkInstance(Problem pb){

        String message = "The instance is not valid";
        for (int i = 0; i < pb.getNrLocations(); i++) {
            for (int j = i+1; j < pb.getNrLocations(); j++) {
                if(pb.getLocations()[i].equals(pb.getLocations()[j])){
                    System.out.println(message);
                    return;
                }
            }
        }
        for (int i = 0; i < pb.getNrRoads(); i++) {
            for (int j = i+1; j < pb.getNrRoads(); j++) {
                if(pb.getRoads()[i].equals(pb.getRoads()[j])){
                    System.out.println(message);
                    return;
                }
            }
        }
        for (int i = 0; i < pb.getNrRoads(); i++) {
            if(pb.getRoads()[i].getC1().equals(pb.getRoads()[i].getC2())){
                System.out.println(message);
                return;
            }
        }
        System.out.println("The instance is valid");

    }
    /**
     * This method checks if there is a path from a source location to a destination location
     * @param c1 This is the source location
     * @param c2 This is the destination location
     * @param pb This is the instance of the problem
     */
    public void canReach(Location c1, Location c2, Problem pb){
        int [][] adjacencyMatrix = new int[pb.getNrLocations()][pb.getNrLocations()];
        Road [] roads = pb.getRoads();
        pb.setIds();
        for (int i = 0; i < pb.getNrRoads(); i++)
        {
            adjacencyMatrix[roads[i].getC1().getId()][roads[i].getC2().getId()] = 1;
        }
        // bfs algorithm
        boolean[] visited = new boolean[pb.getNrLocations()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(c1.getId());
        visited[c1.getId()] = true;
        while (!queue.isEmpty())
        {
            int s = queue.remove();
            for (int i = 0; i < pb.getNrLocations(); i++)
            {
                if (adjacencyMatrix[s][i] == 1 && !visited[i])
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        if(visited[c2.getId()]){
            System.out.println("There is a path between the two locations: "+c1.getName()+" and "+c2.getName());
            return;
        }
        System.out.println("There is no path between the two locations: "+c1.getName()+" and "+c2.getName());
    }
}
