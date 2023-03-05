package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel=gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65:
                this.gamePanel.changeXDelta(-5);
                break;
            case 68:
                this.gamePanel.changeXDelta(5);
                break;
            case 83:
                this.gamePanel.changeYDelta(5);
                break;
            case 87:
                this.gamePanel.changeYDelta(-5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
