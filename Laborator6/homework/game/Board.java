package game;

import players.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public Point currentPoint;
    private List<Point> points = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    public boolean pressed = false;
    public Line currentLine;
    int n;
    double m;
    final static int W = 800, H = 600;
    public Object mutex = new Object();

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public Board(int n, double m) {
        this.n = n;
        this.m = m;
    }


    public void addPoint(Point point) {
        this.points.add(point);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Line> getLines() {
        return lines;
    }

    /**
     * Draws the board
     */
    public void draw(int n, double m) {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / n; // the angle
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));

        }
        //draw the dots
        for (int i = 0; i < n; i++) {
            Point point = new Point(x[i], y[i]);
            addPoint(point);
        }
        //draw the lines
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.random() < m) {
                    Line line = new Line(new Point(x[i], y[i]), new Point(x[j], y[j]));
                    addLine(line);
                }
            }
        }
    }


    /**
     * Checks if a triangle was formed
     * @param line   - the line that was clicked
     * @param player - the player that clicked the line
     * @return true if a triangle was formed, false otherwise
     */
    public boolean checkTriangle(Line line, Player player) {
        Point start = line.getP1();
        Point end = line.getP2();

        for (Line l : lines) {
            if (l != line && l.isColoredBy(player)) {
                Point lStart = l.getP1();
                Point lEnd = l.getP2();
                if (start.equals(lStart) || start.equals(lEnd)) {
                    for (Line l2 : lines) {
                        if (l2 != line && l2 != l && l2.isColoredBy(player)) {
                            Point l2Start = l2.getP1();
                            Point l2End = l2.getP2();
                            if (end.equals(l2Start) || end.equals(l2End)) {
                                if (lStart.equals(l2Start) || lStart.equals(l2End) || lEnd.equals(l2Start) || lEnd.equals(l2End)) {
                                    return true;
                                }
                            }
                        }
                    }
                } else if (end.equals(lStart) || end.equals(lEnd))
                    for (Line l2 : lines) {
                        if (l2 != line && l2 != l && l2.isColoredBy(player)) {
                            Point l2Start = l2.getP1();
                            Point l2End = l2.getP2();
                            if (start.equals(l2Start) || start.equals(l2End)) {
                                if (lStart.equals(l2Start) || lStart.equals(l2End) || lEnd.equals(l2Start) || lEnd.equals(l2End)) {
                                    return true;
                                }
                            }
                        }
                    }

            }
        }
        return false;
    }

    /**
     * Checks if a player has formed a triangle
     * @param currentPlayer - the player that clicked the line
     * @return true if a triangle was formed, false otherwise
     */
    public boolean isTriangleFilled(Player currentPlayer) {
        for (Line line : lines) {
            if (line.isColoredBy(currentPlayer)) {
                if (checkTriangle(line, currentPlayer)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeLine(Line line) {
        lines.remove(line);
    }


    /**
     * Clears the board
     */
    public void clear() {
        lines.clear();
        points.clear();
    }

    public void init() {
        draw(n, m);
    }
}
