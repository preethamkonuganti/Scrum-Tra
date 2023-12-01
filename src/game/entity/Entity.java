package game.entity;

import game.Lifecycle;
import game.Renderer;
import game.event.KeyHandler;
import game.GamePanel;
import game.event.MouseClickInterface;
import game.event.MouseObserver;

import java.awt.image.BufferedImage;

public abstract class Entity implements Renderer, MouseClickInterface, Lifecycle {

    private MouseClickInterface mouseClickListener;

    public int x;
    public int y;

    int width;
    int height;
    GamePanel gp;
    KeyHandler kh;

    BufferedImage[] atk;

    int spriteCounter = 0;
    int spriteIndex = 0;

    boolean isEnabled = true;


    public Entity(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;
    }


    public void setOnClickListener(MouseClickInterface listener){
        MouseObserver.getInstance().addObserver(this);
        this.mouseClickListener = listener;
    }


    @Override
    public void onClicked() {
        mouseClickListener.onClicked();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void pauseObserver() {
        MouseObserver.getInstance().removeObserver(this);
    }

    @Override
    public void resumeObserver() {
        MouseObserver.getInstance().addObserver(this);
    }

    public BufferedImage[] getSpriteImages() {
        return atk;
    }
}