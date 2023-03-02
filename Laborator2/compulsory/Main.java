package compulsory;

public class Main {
    public static void main(String args[]){
        Location iasi = new Location("Iasi", 23.2, 26.1, LocationType.CITY);
        Road road = new Road(100, 30, RoadType.CITY);

        System.out.println(iasi.toString());
        System.out.println(road.toString());

        Location cluj = new Location("Cluj", 23.2, 26.1, LocationType.CITY);
        Road road2 = new Road(100, 50, RoadType.CITY);

        System.out.println(cluj.toString());
        System.out.println(road2.toString());

        Location henriCoanda = new Location("Henri Coanda", 23.2, 26.1, LocationType.AIRPORT);
        Road road3 = new Road(100, 120, RoadType.HIGHWAY);

        System.out.println(henriCoanda.toString());
        System.out.println(road3.toString());

        Location hotelTraian = new Location("Hotel Traian", 23.2, 26.1, LocationType.HOTEL);
        Road road4 = new Road(100, 30, RoadType.CITY);

        System.out.println(hotelTraian.toString());
        System.out.println(road4.toString());



    }
}
