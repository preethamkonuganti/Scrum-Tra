package game.screen;

import game.GamePanel;
import game.entity.Entity;
import game.entity.ImageButton;
import game.entity.Text;
import game.event.KeyHandler;

import java.awt.*;
import java.util.function.Consumer;

public class SimulationScreen extends Screen{
    public SimulationScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("Simulation : Scrum Planning",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");


        entities.add(title);
        entities.add(btn);

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
