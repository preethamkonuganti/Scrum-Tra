import game.GamePanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        initGameWindow();
    }

    private static void initGameWindow(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Scrum-Tra");

        GamePanel panel = new GamePanel();
        window.add(panel);
        window.pack();

        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
