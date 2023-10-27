package game;

import game.event.KeyHandler;
import game.screen.Screen;
import game.screen.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class GamePanel extends JPanel implements Runnable{


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int width = screenSize.width;
    int height = screenSize.height;

    int FPS = 60;

    boolean isGameRunning = false;

    KeyHandler kh = new KeyHandler();

    ArrayList<Screen> screens;


    public GamePanel() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.decode("#150725"));
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);

        screens = new ArrayList<>();
        screens.add(new WelcomeScreen(this,kh));

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

        screens.forEach(new Consumer<Screen>() {
            @Override
            public void accept(Screen screen) {
                screen.draw(g2);
            }
        });


    }

    private void update() {
        screens.forEach(new Consumer<Screen>() {
            @Override
            public void accept(Screen screen) {
                screen.update();
            }
        });
    }
}
