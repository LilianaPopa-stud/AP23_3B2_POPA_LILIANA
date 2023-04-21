import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final int size;
    private int numCellsExplored;

    /**
     * Creates a new exploration map.
     * @param size the size of the map
     */

    public ExplorationMap(int size) {
        this.size = size;  //size is the number of rows and columns
        this.matrix = new Cell[size][size]; //matrix is a 2D array of Cell objects
        this.numCellsExplored = 0; //number of cells explored
        for (int row = 0; row < size; row++) { //for each row
            for (int col = 0; col < size; col++) { //for each column
                matrix[row][col] = new Cell(row, col); //create a new Cell object
            }
        }
    }


    /**
     * @param row the row of the cell
     * @param col the column of the cell
     * @param robot the robot that is visiting the cell
     * @return true if the cell was explored, false otherwise
     */
    public boolean visit(int row, int col, Robot robot) {
        Cell cell = matrix[row][col];
        synchronized (cell) {
            if (cell.getTokens().isEmpty()) {
                for (int i = 0; i < size; i++) {
                    Token token = robot.extractToken();
                    robot.countTokens();
                    if (token == null) {
                        break;
                    }
                    cell.addToken(token);

                }
                System.out.println("Robot " + robot.getId() + " stored " + cell.getTokens().size() + " tokens in cell (" + row + "," + col + ")");
                if (!cell.getTokens().isEmpty()) {
                    numCellsExplored++;
                    System.out.printf("Robot %d explored cell (%d,%d)%n",
                            robot.getId(), row, col);
                    return true;
                }
            }
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public int getNumCellsExplored() {
        return numCellsExplored;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(Arrays.toString(matrix[i])).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns the unexplored cells.
     * @return the unexplored cells
     */
    public synchronized List<Cell> getUnexploredCells() {
        List<Cell> unexploredCells = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Cell cell = matrix[row][col];
                synchronized (cell) {
                    if (cell.getTokens().isEmpty()) {
                        unexploredCells.add(cell);
                    }
                }
            }
        }
        Collections.shuffle(unexploredCells);
        return unexploredCells;
    }

}
