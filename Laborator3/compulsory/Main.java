package compulsory;
import java.util.List;
/**
 * this class is the main class
 * @author Popa Liliana
 */
public class Main {
    public static void main(String[] args) {

        List<Node> nodes = List.of(
                new Person("Popescu"),
                new Person("Ionescu"),
                new Company("Google"),
                new Company("Apple")
        );
        System.out.println(nodes);


    }
}
