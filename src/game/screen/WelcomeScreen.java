package game.screen;

import game.entity.Entity;
import game.entity.Character;
import game.entity.Text;
import game.entity.TextInputBox;
import game.event.KeyHandler;
import game.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;

public class WelcomeScreen extends Screen {
    private JTextField usernameInputField;

    public WelcomeScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("Welcome Screen", gp, kh);
        int screenWidth = gp.getWidth();
        int screenHeight = gp.getHeight();
        title.x = (screenWidth) / 2;
        title.y = 100;

        Character genie = new Character(gp, kh);
        genie.x = (screenWidth - 525) / 2;
        genie.y = (screenHeight - 275) / 2;

        TextInputBox textInputBox = new TextInputBox(gp,kh);

        entities.add(title);
        entities.add(genie);
        entities.add(textInputBox);
    }


    @Override
    public void draw(Graphics2D g) {
        entities.forEach(new Consumer<Entity>() {
            @Override
            public void accept(Entity entity) {
                entity.draw(g);
            }
        });
    }
    @Override
    public void update() {
        entities.forEach(new Consumer<Entity>() {
            @Override
            public void accept(Entity entity) {
                entity.update();
            }
        });
    }
}
