package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import game.*;
import game.Point;


public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    final static int W = 800, H = 600;
    private Board board;
    private List<Point> points;
    private List<Line> lines;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Initializes the drawing panel
     */
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        //mouse listener for drawing lines
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Line line = lineClicked(e.getX(), e.getY());
                if (line != null && !line.getMarked()) {
                    synchronized (frame.getBoard().mutex) {
                        frame.getBoard().pressed = true;
                        frame.getBoard().mutex.notify();

                    }
                    line.setMarked(true);
                     Line coloredLine = new Line(line.getP1(), line.getP2(), frame.getGame().getCurrentPlayer().getColor());
                     coloredLine.setColor(frame.getGame().getCurrentPlayer().getColor());
                    board.removeLine(line);
                    board.addLine(coloredLine);
                    frame.getBoard().currentLine = coloredLine;
                    repaint();

                }
            }
        });
    }

    /**
     * Checks if a line was clicked
     * @param x - coordinate of the mouse click
     * @param y - coordinate of the mouse click
     * @return the line that was clicked
     */
    private Line lineClicked(int x, int y) {
        for (Line line : lines) {
            if (line.getLine().ptSegDist(x, y) < 10) {
                return line;
            }
        }
        return null;
    }

    /**
     * Paints the points and lines
     * @param g - the graphics object
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        lines = board.getLines();
        points = board.getPoints();

        for (Point point : points) {
            g2d.setPaint(point.getColor());
            g2d.fill(point.draw());
        }
        for (Line line : lines) {
            g2d.setPaint(line.getColor());
            g2d.draw(line.draw());
        }

        g2d.dispose();

    }
}


