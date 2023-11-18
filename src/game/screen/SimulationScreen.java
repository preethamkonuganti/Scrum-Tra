package game.screen;

import game.GamePanel;
import game.entity.Entity;
import game.entity.ImageButton;
import game.entity.Player;
import game.entity.SimulatorTextBox;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;
import java.util.function.Consumer;

public class SimulationScreen extends Screen{
    public SimulationScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Player sm = new Player(gp,kh,40,160,80, 80,"Scrum master");
        sm.setBackgroundImage("/seller/seller_still.png");

        Player po = new Player(gp,kh,40,300,80, 80,"Product owner");
        po.setBackgroundImage("/seller/seller_still.png");

        Player user = new Player(gp,kh,300,gp.height-240,80, 80,"You");
        user.setBackgroundImage("/seller/seller_still.png");

        ImageButton back = new ImageButton(gp,kh,440,user.y,80,80);
        back.setBackgroundImage("/assets/back.png");

        ImageButton next = new ImageButton(gp,kh,640,user.y,80,80);
        next.setBackgroundImage("/next.png");

        SimulatorTextBox simulatorTextBox = new SimulatorTextBox(gp, kh, 180, 40, 1000,600);
        simulatorTextBox.setCardTitle("Sprint Planning");

//        entities.add(title);
        entities.add(sm);
        entities.add(po);
        entities.add(user);
        entities.add(back);
        entities.add(next);
        entities.add(simulatorTextBox);

        for(int i=0; i<3;i++){
            Player dev = new Player(gp,kh,gp.width - 120,160+140*(i),80, 80,"Dev "+(i+1));
            dev.setBackgroundImage("/seller/seller_still.png");
            entities.add(dev);
        }

        back.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                simulatorTextBox.renderBack();
            }
        });

        next.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                simulatorTextBox.renderNextDialog();
            }
        });

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
