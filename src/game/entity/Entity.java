package game.entity;

import game.Renderer;
import game.event.KeyHandler;
import game.GamePanel;
import game.event.MouseClickInterface;
import game.event.MouseObserver;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements Renderer, MouseClickInterface {

    private MouseClickInterface mouseClickListener;

    public int x,y;


    public int width;
    public int height;

    GamePanel gp;
    KeyHandler kh;

    BufferedImage[] atk;

    int spriteCounter = 0;
    int spriteIndex = 0;


    public Entity(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;
    }


    public void setOnClickListener(MouseClickInterface listener){
        MouseObserver.getInstance().addObserver(this);
        this.mouseClickListener = listener;
    }

    public void removeOnClickListener(){
        MouseObserver.getInstance().removeObserver(this);
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

}