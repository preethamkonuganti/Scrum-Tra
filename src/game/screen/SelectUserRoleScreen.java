package game.screen;

import game.GamePanel;
import game.entity.Entity;
import game.entity.Text;
import game.event.KeyHandler;

import java.awt.*;
import java.util.function.Consumer;

public class SelectUserRoleScreen extends Screen{

    public SelectUserRoleScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        Text title = new Text("Select User Role Level",gp ,kh);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        String text = title.getValue();
        int textWidth = (int)(text.length()*36*0.5);
        title.x = (screenWidth-textWidth) / 2;
        title.y = 100;
        entities.add(title);
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

    public void update() {
        entities.forEach(new Consumer<Entity>() {
            @Override
            public void accept(Entity entity) {
                entity.update();
            }
        });

    }
}
