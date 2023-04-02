package compulsory;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel; ControlPanel controlPanel; DrawingPanel canvas;
    public MainFrame() {
        super("My Drawing Application");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        add(canvas,BorderLayout.CENTER);

        //invoke the layout manager
        pack(); }

    public DrawingPanel getCanvas() {
        return canvas;
    }
    public ConfigPanel getConfigPanel() {
        return configPanel;
    }
}