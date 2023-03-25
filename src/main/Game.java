package main;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel = new GamePanel();
    private final int FPS_SET = 120;
    private Thread gameThread;

    public Game() {
        this.gameWindow = new GameWindow(this.gamePanel);
        this.gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        while (true) {
            now = System.nanoTime();

            if (now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}