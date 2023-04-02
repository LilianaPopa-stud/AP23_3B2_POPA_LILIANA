package compulsory;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int numVertices = (int) frame.configPanel.dotsSpinner.getValue();
        double edgeProbability = (double) frame.configPanel.linesCombo.getSelectedItem();
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        int[] x = new int[numVertices];
        int[] y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));

        }
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    g.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }

}

}

//get the number of dots (numVertices)
//get the probability that two dots form a line (edgeProbability)
//draw the board, that is:
//compute the coordinates of the dots
//draw the dots
//draw the lines