package game;

import players.Player;

import java.awt.Color;
import java.awt.geom.Line2D;


public class Line {
    private final Point p1;
    private final Point p2;
    private Player player;
    private Color color;
    private boolean marked = false;
    private Line2D line;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = null;
    }

    public Line(Point p1, Point p2, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws a line
     * @return the line as a Line2D
     */
    public Line2D draw() {
        Line2D line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.line = line;
        return line;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean getMarked() {
        return this.marked;
    }

    public Line2D getLine() {
        return line;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Checks if the line is colored by the player
     * @param player the player
     * @return true if the line is colored by the player, false otherwise
     */
    public boolean isColoredBy(Player player) {
        return this.color == player.getColor();
    }


    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", player=" + player +
                ", color=" + color +
                ", marked=" + marked +
                ", line=" + line +
                '}';
    }
}
