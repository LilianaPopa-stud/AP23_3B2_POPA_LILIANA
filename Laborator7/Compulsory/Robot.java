import java.util.List;
import java.util.Random;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    int row, col;
    Exploration explore;


    /**
     * Creates a new robot.
     * @param name the name of the robot
     * @param explore the exploration object
     */
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        Random random = new Random();
        this.row = random.nextInt(10);
        this.col = random.nextInt(10);
        //print the initial position of the robot
        System.out.println(name + " is at (" + row + "," + col + ")");
    }

    /**
     * Starts the robot.
     */
    public void start() {
        this.running = true;
    }

    /**
     * Stops the robot.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * Returns the id of the robot.
     * @return the id of the robot
     */
    public int getId() {
        return name.hashCode();
    }

    /**
     * Extracts a token from the shared memory.
     * @return the extracted token
     */
    public Token extractToken() {
        return explore.getMemory().extractTokens(1).get(0);
    }

    /**
     * Runs the robot.
     */
    public void run() {
        start();
        while (running) {
            List<Cell> unexploredCells = explore.getMap().getUnexploredCells();
            if (unexploredCells.isEmpty()) {
                System.out.println("All cells explored, stopping robot " + name);
                stop();
                return;
            }
            Cell cell = unexploredCells.get(0);
            int row = cell.getRow();
            int col = cell.getCol();
            if (explore.getMap().visit(row, col, this)) {
                System.out.printf("Tokens left: %s%n", explore.getMemory().getTokens().size());
            } else {
                System.out.printf("Robot %d did not find any tokens left", getId(), row, col);
            }
            // make the robot sleep for some time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
