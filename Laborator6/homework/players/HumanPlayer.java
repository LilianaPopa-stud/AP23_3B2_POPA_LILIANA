package players;

import game.Game;
import game.Line;
import game.Point;

import java.awt.*;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, int index, Color color, Game game) {
        super(name, index, color, game);
    }


    @Override
    public Line chooseLine() {
        Line line;
        synchronized (game.getBoard().mutex) {
            while (!game.getBoard().pressed) {
                try {
                    game.getBoard().mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        line = game.getBoard().currentLine;
        return line;
    }


}
