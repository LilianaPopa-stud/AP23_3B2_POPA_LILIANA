package compulsory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigPanel extends JPanel { final MainFrame frame;
    public ConcurrentHashMap<Object, Object> dotsField=new ConcurrentHashMap<>();

    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init(); }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        dotsSpinner.setValue(6);
        linesLabel = new JLabel("Line probability: ");
        linesCombo = new JComboBox(new Double[]{0.5, 0.6, 0.7, 0.8, 0.9, 1.0});
        linesCombo.setSelectedIndex(5);

        //create the rest of the components
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton());
    }
    private JButton createButton() {
        JButton createButton = new JButton("Create new game");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getCanvas().repaint();
            }
        });
        return createButton;
    }}