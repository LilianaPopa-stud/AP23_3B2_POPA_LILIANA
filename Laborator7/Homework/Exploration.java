import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(10);
    private final ExplorationMap map = new ExplorationMap(10);
    final List<Robot> robots = new ArrayList<>();

    /**
     * Adds a robot to the exploration.
     * @param robot the robot to add
     */
    public void addRobot(Robot robot) {
        robots.add(robot);

    }

    /**
     * Starts the exploration.
     */
    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
       Thread command = new Thread(new Command(explore));
        command.start();
        explore.start();

    }
    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMemory() {
        return mem;
    }

}
