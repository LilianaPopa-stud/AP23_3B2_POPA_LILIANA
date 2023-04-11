package gui;

import game.Board;
import game.Game;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    private Board board;
    private Game game;


    public MainFrame(Game game) {
        super("My Drawing Application");
        this.game = game;

    }


    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Initializes the main frame
     */
    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        canvas.setBoard(board);
        configPanel = new ConfigPanel(this);


        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        pack();
    }

    public Board getBoard() {
        return board;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }


    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public Game getGame() {
        return game;
    }

}