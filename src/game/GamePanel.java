package game;

import game.event.KeyHandler;
import game.event.MouseObserver;
import game.navigation.Navigation;
import game.navigation.NavigationListener;
import game.screen.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable, MouseListener , NavigationListener {


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public int width = screenSize.width;
    public int height = screenSize.height;

    int FPS = 60;

    boolean isGameRunning = false;

    KeyHandler kh = new KeyHandler();

    ArrayList<Screen> screens;
    MouseObserver mouseObserver;




    public GamePanel() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.decode("#150725"));
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.addMouseListener(this);
        mouseObserver = MouseObserver.getInstance();
        this.setFocusable(true);

        Navigation.getInstance().registerNavigationListener(this);
        Navigation.getInstance().addScreen(new WelcomeScreen(this, kh));

        screens = new ArrayList<>();
        startGameThread();
    }

    private void startGameThread() {
        Thread t = new Thread(this);
        isGameRunning = true;
        t.start();
    }

    @Override
    public void run() {
        gameLoop();
    }

    private void gameLoop(){
        double currentTime = System.nanoTime();
        double nextTimeInterval = currentTime + 1000000000/FPS;

        while (isGameRunning){

            update();
            repaint();

            try {
                double rem = nextTimeInterval - System.nanoTime();
                double remInMillis = rem/1000000;

                if(remInMillis < 0)
                    remInMillis = 0;
                Thread.sleep((long) remInMillis);

                nextTimeInterval += 1000000000/FPS;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Navigation.getInstance().getCurrentScreen().draw(g2);

    }

    private void update() {
        Navigation.getInstance().getCurrentScreen().update();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        mouseObserver.onScreenClicked(e.getX(),e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void onNext() {
        Navigation.getInstance().getCurrentScreen().pauseObserver();
        if(Navigation.getInstance().getCurrentScreen() instanceof WelcomeScreen){
            Navigation.getInstance().addScreen(new SelectSimulationStoryScreen(this,kh));
        }
        else if(Navigation.getInstance().getCurrentScreen() instanceof SelectSimulationStoryScreen){
            Navigation.getInstance().addScreen(new SelectRoleScreen(this,kh));
        }
        else if(Navigation.getInstance().getCurrentScreen() instanceof SelectRoleScreen){
            Navigation.getInstance().addScreen(new SelectProficiencyScreen(this,kh));
        }
        else if(Navigation.getInstance().getCurrentScreen() instanceof SelectProficiencyScreen){
            Navigation.getInstance().addScreen(new SimulationSettingsScreen(this,kh));
        }
        else if(Navigation.getInstance().getCurrentScreen() instanceof SimulationSettingsScreen){
            Navigation.getInstance().addScreen(new SelectSimulationCeremonyScreen(this,kh));
        }
        else if(Navigation.getInstance().getCurrentScreen() instanceof SelectSimulationCeremonyScreen){
            Navigation.getInstance().addScreen(new SimulationScreen(this,kh));
        }
    }

    @Override
    public void onBack() {

        Navigation.getInstance().pop();
        Navigation.getInstance().getCurrentScreen().resumeObserver();

    }
}
