package game.entity;

import game.Renderer;
import game.event.KeyHandler;
import game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements Renderer {

    public int x,y;
    GamePanel gp;
    KeyHandler kh;

    BufferedImage[] atk;

    int spriteCounter = 0;
    int spriteIndex = 0;


    public Entity(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;
    }

}