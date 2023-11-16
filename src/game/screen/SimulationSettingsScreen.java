package game.screen;

import game.GamePanel;
import game.data.SimulationCeremonyConfig;
import game.data.SimulationSettings;
import game.entity.Entity;
import game.entity.ImageButton;
import game.entity.Text;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;
import java.util.function.Consumer;

public class SimulationSettingsScreen extends Screen{

    private SimulationSettings simulationSettings;

    public SimulationSettingsScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        simulationSettings = SimulationSettings.getInstance();

        Text title = new Text("Simulation Settings",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");

        ImageButton backBtn = new ImageButton(gp,kh,40,40,80, 80);
        backBtn.setBackgroundImage("/assets/back.png");

        Text numberOfSprints = new Text("Number of sprints",gp ,kh);
        numberOfSprints.x = (gp.width-numberOfSprints.getStringWidth())/2;
        numberOfSprints.y = 240;
        numberOfSprints.setTextColor(Color.BLACK);


        Text numberOfDailyStandups = new Text("Number of daily standups",gp ,kh);
        numberOfDailyStandups.x = (gp.width-numberOfDailyStandups.getStringWidth())/2;
        numberOfDailyStandups.y = 380;
        numberOfDailyStandups.setTextColor(Color.BLACK);

        Text sizeOfTeam = new Text("size of team",gp ,kh);
        sizeOfTeam.x = (gp.width-sizeOfTeam.getStringWidth())/2;
        sizeOfTeam.y = 520;
        sizeOfTeam.setTextColor(Color.BLACK);

        Text numberOfUserStories = new Text("Number of user stories",gp ,kh);
        numberOfUserStories.x = (gp.width-numberOfUserStories.getStringWidth())/2;
        numberOfUserStories.y = 520;
        numberOfUserStories.setTextColor(Color.BLACK);

        entities.add(title);
        entities.add(btn);
        entities.add(backBtn);
        entities.add(numberOfSprints);
        entities.add(numberOfDailyStandups);
        entities.add(sizeOfTeam);
        entities.add(numberOfUserStories);

        backBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

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