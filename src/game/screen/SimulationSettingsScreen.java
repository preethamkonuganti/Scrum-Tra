package game.screen;

import game.GamePanel;
import game.entity.ImageButton;
import game.entity.Text;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;

public class SimulationSettingsScreen extends Screen{
    public SimulationSettingsScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("Simulation Settings",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");

        ImageButton backBtn = new ImageButton(gp,kh,100,40,80, 80);
        btn.setBackgroundImage("/asset/back.png");

        Text numberOfSprints = new Text("Number of sprints",gp ,kh);
        numberOfSprints.x = (gp.width-numberOfSprints.getStringWidth())/2;
        numberOfSprints.y = 240;
        numberOfSprints.setTextColor(Color.WHITE);


        Text numberOfDailyStandups = new Text("Number of daily standups",gp ,kh);
        numberOfDailyStandups.x = (gp.width-numberOfDailyStandups.getStringWidth())/2;
        numberOfDailyStandups.y = 380;
        numberOfDailyStandups.setTextColor(Color.WHITE);

        Text sizeOfTeam = new Text("size of team",gp ,kh);
        sizeOfTeam.x = (gp.width-sizeOfTeam.getStringWidth())/2;
        sizeOfTeam.y = 520;
        sizeOfTeam.setTextColor(Color.WHITE);

        Text numberOfUserStories = new Text("Number of user stories",gp ,kh);
        numberOfUserStories.x = (gp.width-numberOfUserStories.getStringWidth())/2;
        numberOfUserStories.y = 520;
        numberOfUserStories.setTextColor(Color.WHITE);


        backBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update() {

    }
}