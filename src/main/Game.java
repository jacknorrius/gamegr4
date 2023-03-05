package main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel = new GamePanel();

    public Game() {
        this.gameWindow=new GameWindow(this.gamePanel);
        this.gamePanel.requestFocus();
    }
}