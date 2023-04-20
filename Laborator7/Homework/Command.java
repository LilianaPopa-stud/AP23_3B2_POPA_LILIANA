import java.util.Scanner;

public class Command extends Thread implements Runnable {

    private final Exploration exploration;


    public Command(Exploration exploration) {
        this.exploration = exploration;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+");
            System.out.println(tokens[0]);
            String action = tokens[0];
            if (action.equals("1")) { // start all robots
                for (Robot robot : exploration.robots) {
                    robot.isStopped = false;
                }

                System.out.println("All robots started");
            } else if (action.equals("2")) { // pause all robots
                for (Robot robot : exploration.robots) {
                    robot.isStopped = true;
                }
                System.out.println("All robots paused");
            } else if (action.equals("3")) { // start a specific robot
                if (tokens.length >= 2) {
                    String robotName = tokens[1];
                    for (Robot robot : exploration.robots) {
                        if (robot.getName().equals(robotName)) {
                            robot.isStopped = false;
                            robot.isPaused = false;
                        }
                    }
                    System.out.println("Robot started");
                }
                System.out.println("Robot started");
            } else if (action.equals("4")) { // pause a specific robot
                String robotName = tokens[1];
                for (Robot robot : exploration.robots) {
                    if (robot.getName().equals(robotName)) {
                        if (tokens.length >= 3) {
                            long time = Long.parseLong(tokens[2]);
                            robot.isPaused = true;
                            robot.isStopped = false;
                            robot.pausedTime = time;
                        } else {
                            robot.isPaused = false;
                            robot.isStopped = true;
                        }
                        break;
                    }
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
