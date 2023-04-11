package players;
import game.Game;
import game.Line;
import game.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Runnable {
    private String name;
    private int index;
    private final Color color;
    protected final Game game;
    protected Thread thread;
    private List<Line> lines = new ArrayList<>();
    private List<Point> points = new ArrayList<>();

    public Player(String name, int index, Color color, Game game) {
        this.name = name;
        this.index = index;
        this.color = color;
        this.game = game;
    }


    public int getIndex(){
        return index;
    }

    public String getName(){
        return name;
    }

    public List<Line> getLines(){
        return lines;
    }


    public Color getColor(){
        return color;
    }


    public void setThread(Thread thread) {
        this.thread = thread;
    }


    private void waitTurn() throws InterruptedException {
        synchronized (game) {

            while (game.getCurrentPlayer().getIndex() != this.index && !game.isEnded()) {
                this.game.wait(3*1000);
            }

        }

    }

    @Override
    public void run() {
        while (!game.isEnded()) {
            try {
                waitTurn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!game.isEnded()) {
                Line line = chooseLine();
                lines.add(line);
                game.getBoard().pressed = false;
                try {
                    game.update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public abstract Line chooseLine();

}

