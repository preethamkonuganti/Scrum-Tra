package game.navigation;

import game.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    private static Navigation instance = null;

    private List<Screen> screens;

    private int lastNavigatedOn = -1;

    private NavigationListener listener ;


    private Navigation() {
        screens = new ArrayList<>();
    }

    public static Navigation getInstance() {
        if(instance == null)
            instance = new Navigation();
        return instance;
    }

    public Screen getCurrentScreen(){
        return screens.get(screens.size()-1);
    }

    public void addScreen(Screen screen){
        screens.add(screen);
    }

    public void registerNavigationListener(NavigationListener listener){
        this.listener = listener;
    }

    public void navigateToNext(){
        listener.onNext();
    }

    public void navigateBack(){
        listener.onBack();
    }


    public void pop() {
        screens.remove(screens.size()-1);
    }
}
