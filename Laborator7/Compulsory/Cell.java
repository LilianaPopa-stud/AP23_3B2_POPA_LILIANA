import java.util.ArrayList;
import java.util.List;
public class Cell {
    private List<Token> tokens;
    private int row;
    private int col;

    /**
     * Creates a new cell.
     * @param row the row of the cell
     * @param col the column of the cell
     */
    public Cell(int row, int col) {
        this.tokens = new ArrayList<>();
        this.row = row;
        this.col = col;
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
