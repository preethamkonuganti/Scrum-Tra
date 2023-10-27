package game.screen;

import game.Renderer;
import game.entity.Entity;
import game.event.KeyHandler;
import game.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public abstract class Screen implements Renderer {

    GamePanel gp;
    KeyHandler kh;

    protected ArrayList<Entity> entities;

    public Screen(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;

        entities = new ArrayList<>();
    }

}
