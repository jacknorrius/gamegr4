package main;

import javax.swing.*;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setSize(600,600);
        jframe.setVisible(true);
        jframe.add(gamePanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}