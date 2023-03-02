package homework;
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
        Airport otopeni = new Airport("Otopeni", 10.0, 90, 2);
        Airport chisinauAirport = new Airport("Chisinau Airport", 44, 40, 1);
        GasStation lukoil = new GasStation("Lukoil", 30, 40, 5.5);
        problem.addLocation(iasi);
        problem.addLocation(chisinau);
        problem.addLocation(otopeni);
        problem.addLocation(chisinauAirport);
        problem.addLocation(lukoil);
        problem.addRoad(new Highway(120,120,iasi,chisinau));
        problem.addRoad(new Highway(120,120,otopeni,iasi));
        problem.addRoad(new Highway(120,120,iasi,lukoil));
        problem.addRoad(new Country(120,120,lukoil,chisinau));
        problem.addRoad(new Highway(120,120,chisinau,chisinauAirport));
        problem.addRoad(new Express(120,120,iasi,chisinauAirport));
        Main app = new Main();
        app.checkInstance(problem);

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
}
