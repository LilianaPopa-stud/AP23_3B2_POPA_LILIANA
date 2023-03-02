package homework;
/**
 * GasStation is a subclass of Location.
 * It represents a type of location.
 * Additional attributes: price.
 * @author Popa Liliana
 */

public class GasStation extends Location{
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GasStation(String name, double price) {
        super(name);
        this.price = price;
    }

    public GasStation(String name, double x, double y, double price) {
        super(name, x, y);
        this.price = price;
    }
}
