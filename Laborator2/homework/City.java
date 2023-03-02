package homework;

/**
 * City is a subclass of Location
 * Additonal attributes: population
 * @author Popa Liliana
 */
public class City extends Location{
    private int population;

    public City(String name, int population) {
        super(name);
        this.population = population;
    }

    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
