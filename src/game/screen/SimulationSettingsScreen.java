package game.screen;

import game.GamePanel;
import game.entity.ImageButton;
import game.entity.Text;
import game.event.KeyHandler;

import java.awt.*;

public class SimulationSettingsScreen extends Screen{
    public SimulationSettingsScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("Simulation Settings",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update() {

    }
}
