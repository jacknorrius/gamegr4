package main;

import javax.swing.*;
import java.awt.*;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs=new MouseInputs(this);
    private int xDelta = 100;
    private int yDelta = 100;

    public GamePanel() {
        this.addKeyListener(new KeyboardInputs(this));
        this.addMouseListener(this.mouseInputs);
        this.addMouseMotionListener(this.mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        this.repaint();
    }
    public void changeYDelta(int value) {
        this.yDelta += value;
        this.repaint();
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(xDelta,yDelta,200,200);
    }
}