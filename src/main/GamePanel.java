package main;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs=new MouseInputs(this);
    private int xDelta = 100;
    private int yDelta = 100;
    private BufferedImage subImg, img;

    public GamePanel() {
        importImg();
        setPanelSize();
        this.addKeyListener(new KeyboardInputs(this));
        this.addMouseListener(this.mouseInputs);
        this.addMouseMotionListener(this.mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMaximumSize(size);
        setMinimumSize(size);
        setPreferredSize(size);
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
        subImg = img.getSubimage(1 * 64, 8 * 40, 64, 40);
        g.drawImage(subImg, xDelta,yDelta,128,80,null);
    }
}