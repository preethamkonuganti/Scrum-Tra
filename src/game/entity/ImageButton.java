package game.entity;

import game.GamePanel;
import game.event.KeyHandler;

import java.awt.*;

public class ImageButton extends Character implements ButtonInterface{

    public ImageButton(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh, x, y);
    }

    public ImageButton(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh, x, y, width, height);
    }

    public void setBackgroundImage(String file){

    }

    @Override
    public void setStrokeColor(Color color) {

    }

    @Override
    public void onMouseCursorOnButton() {

    }

    @Override
    public void setEnable(boolean isEnabled) {

    }
}