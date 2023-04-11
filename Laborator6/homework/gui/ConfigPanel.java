package gui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    public JSpinner dotsSpinner;
    public JComboBox linesCombo;

    private final DrawingPanel canvas;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        this.canvas = frame.getCanvas();
        init();
    }

    /**
     * Initializes the config panel
     */
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        dotsSpinner.setValue(6); //default number of dots
        //create the label and the combo box
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox(new Double[]{0.5, 0.6, 0.7, 0.8, 0.9, 1.0});
        linesCombo.setSelectedIndex(5); //default number of line probability

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton());
    }

    /**
     * Creates the button
     * @return the button
     */
    private JButton createButton() {
        JButton createButton = new JButton("Create new game");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dots = (Integer) dotsSpinner.getValue();
                double lines = (Double) linesCombo.getSelectedItem();
                frame.getBoard().clear(); // adauga aceasta linie pentru a sterge continutul vechiului board
                frame.getBoard().draw(dots, lines);
                canvas.repaint();
            }
        });
        return createButton;
    }

}

