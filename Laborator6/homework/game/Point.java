package game;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Objects;

public class Point {
    private final int x;
    private final int y;
    private Ellipse2D circle;
    private Color color;
    private boolean marked = false;
    private final int radius = 25;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", circle=" + circle +
                ", color=" + color +
                ", marked=" + marked +
                ", radius=" + radius +
                '}';
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Draws a point
     * @return the point as an Ellipse2D
     */
    public Ellipse2D draw() {
        Ellipse2D circle = new Ellipse2D.Double(x - radius / 2, y - radius / 2, radius, radius);
        this.circle = circle;
        return circle;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
