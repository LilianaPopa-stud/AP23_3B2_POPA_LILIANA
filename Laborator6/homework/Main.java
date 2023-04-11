import game.Game;
import players.HumanPlayer;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(6,1);

        HumanPlayer player1 = new HumanPlayer("Andreea",0, Color.RED, game);
        HumanPlayer player2 = new HumanPlayer("Liliana",1, Color.BLUE, game);


        game.addPlayer(player1);
        game.addPlayer(player2);

        game.start();

    }
}
