package bonus;

import java.util.Calendar;
import java.util.List;

/**
 * An interface that represents a node,
 * it has an abstract method that needs to be implemented in the classes that implement it,
 * it extends the interface Identifiable,
 * @author Popa Liliana
 */
public interface Node extends Identifiable {
    String getName();
}
