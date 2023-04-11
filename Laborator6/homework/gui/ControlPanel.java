package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    /**
     * Initializes the control panel
     */
    private void init() {
        setLayout(new GridLayout(1, 4));
        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);
        add(exitBtn);
        add(saveBtn);
        add(loadBtn);
    }

    /**
     * Exits the game
     * @param e the event
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    /**
     * Saves the game
     * @param e the event
     */
    private void saveGame(ActionEvent e) {
        try {
            Robot r = new Robot();
            BufferedImage i = r.createScreenCapture( new Rectangle(0, 0, 800, 700 ));
            ImageIO.write(i, "png", new File("screenshot.png"));
        } catch (AWTException | IOException awtException) {
            awtException.printStackTrace();
        }
    }
    private void loadGame(ActionEvent e) {
        //TODO
    }
}
