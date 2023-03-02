package homework;

public class Main{
    public static void main(String[] args) {
        Problem problem = new Problem();
        City iasi = new City("Iasi", 200, 200, 1000000);
        City chisinau = new City("Chisinau", 300, 300, 500000);
        Airport otopeni = new Airport("Otopeni", 100, 100, 2);
        Airport chisinauAirport = new Airport("Chisinau Airport", 300, 300, 1);
        GasStation lukoil = new GasStation("Lukoil", 100, 100, 5.5);
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


    }
}
