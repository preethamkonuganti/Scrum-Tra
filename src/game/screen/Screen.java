package game.screen;

import game.Lifecycle;
import game.Renderer;
import game.entity.Entity;
import game.event.KeyHandler;
import game.GamePanel;

import java.util.ArrayList;

public abstract class Screen implements Renderer, Lifecycle {

    GamePanel gp;
    KeyHandler kh;

    protected ArrayList<Entity> entities;

    public Screen(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;

        entities = new ArrayList<>();
    }

    @Override
    public void pauseObserver() {
        for(Entity e : entities){
            e.pauseObserver();
        }
    }

    @Override
    public void resumeObserver() {
        for(Entity e : entities){
            e.resumeObserver();
        }
    }

}
