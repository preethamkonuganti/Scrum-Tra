package game.event;

import game.entity.Entity;

import java.util.ArrayList;

public class MouseObserver {

    private static MouseObserver instance = null;

    private ArrayList<Entity> observers;

    private MouseObserver(){
        observers = new ArrayList<>();
    }

    public static MouseObserver getInstance(){
        if(instance == null){
            instance = new MouseObserver();
        }
        return instance;
    }

    public void addObserver(Entity e){
        observers.add(e);
    }

    public void removeObserver(Entity e){
        observers.remove(e);
    }

    public void onScreenClicked(int x, int y){
        System.out.println("x : "+x+" y : "+y);
        for(Entity e : observers){
            if(isEntityClicked(e, x, y)){
                e.onClicked();
            }
        }
    }

    private boolean isEntityClicked(Entity e, int mouseX, int mouseY){
//        TODO("Check for mouse pointer click collision with the entity")
        return true;
    }
}
