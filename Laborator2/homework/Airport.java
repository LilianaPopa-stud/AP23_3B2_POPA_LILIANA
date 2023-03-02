package homework;

/**
 * Airport is a subclass of Location
 * Adds the number of terminals
 * @author Popa Liliana
 */
public class Airport extends Location{
    private int numberOfTerminals;

    public Airport(String name, int numberOfTerminals) {
        super(name);
        this.numberOfTerminals = numberOfTerminals;
    }

    public Airport(String name, double x, double y, int numberOfTerminals) {
        super(name, x, y);
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
}
