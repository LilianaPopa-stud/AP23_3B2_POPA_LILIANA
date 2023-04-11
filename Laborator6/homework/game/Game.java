package game;

import gui.MainFrame;
import players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    private final Board board;
    private final List<Player> players = new ArrayList<>();
    private Player currentPlayer;
    private Player winner;


    public Game(int n, double m) {
        this.board = new Board(n, m);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public Board getBoard() {
        return board;
    }

    /**
     * Initializes the players
     */
    private void initPlayers() {
        for (Player player : players) {
            Thread thread = new Thread(player);
            player.setThread(thread);
            thread.start();
        }
    }

    /**
     * Starts the game
     */
    public void start() {

        initPlayers();
        setCurrentPlayer(players.get(0));

        MainFrame frame = new MainFrame(this);
        System.out.println(currentPlayer.getName() + "'s turn!");

        frame.setBoard(board);
        frame.setVisible(true);
        frame.init();
        board.n = (int) frame.getConfigPanel().dotsSpinner.getValue();
        board.m = (double) frame.getConfigPanel().linesCombo.getSelectedItem();
        board.setN(board.n);
        board.setM(board.m);
        board.init();


    }

    /**
     * Updates the game
     */
    public void update() throws InterruptedException {

        if (isEnded()) {
            TimeUnit.SECONDS.sleep(1);
            end();
        }


        currentPlayer = players.get(1 - currentPlayer.getIndex());
        System.out.println(currentPlayer.getName() + "'s turn!");


    }

    /**
     * Ends the game
     */
    public void end() {
        System.out.println("Winner is " + winner.getName());
        System.out.println("Game has ended!");
        System.exit(-1);
    }


    /**
     * Checks if the game has ended
     * @return true if the game has ended, false otherwise
     */
    public boolean isEnded() {
        if (board.isTriangleFilled(currentPlayer)) {
            winner = currentPlayer;
            return true;
        }

        return false;
    }

}
