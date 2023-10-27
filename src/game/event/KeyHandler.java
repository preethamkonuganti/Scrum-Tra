package game.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean isUpKeyPressed = false;
    public boolean isDownKeyPressed = false;

    public boolean isLeftKeyPressed = false;

    public boolean isRightKeyPressed = false;

    public boolean isSpacePressed = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP){
            isUpKeyPressed = true;
        }
        if(key == KeyEvent.VK_DOWN){
            isDownKeyPressed = true;
        }
        if(key == KeyEvent.VK_LEFT){
            isLeftKeyPressed = true;
        }
        if(key == KeyEvent.VK_RIGHT){
            isRightKeyPressed = true;
        }
        if(key == KeyEvent.VK_SPACE){
            isSpacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP){
            isUpKeyPressed = false;
        }
        if(key == KeyEvent.VK_DOWN){
            isDownKeyPressed = false;
        }
        if(key == KeyEvent.VK_LEFT){
            isLeftKeyPressed = false;
        }
        if(key == KeyEvent.VK_RIGHT){
            isRightKeyPressed = false;
        }
        if(key == KeyEvent.VK_SPACE){
            isSpacePressed = false;
        }
    }
}
