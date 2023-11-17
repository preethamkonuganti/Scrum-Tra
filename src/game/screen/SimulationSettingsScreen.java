package game.screen;

import game.GamePanel;
import game.data.SimulationCeremonyConfig;
import game.data.SimulationSettings;
import game.entity.*;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;
import java.util.function.Consumer;

public class SimulationSettingsScreen extends Screen{

    private SimulationSettings simulationSettings;

    public SimulationSettingsScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);


        Text title = new Text("Simulation Settings",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");

        ImageButton backBtn = new ImageButton(gp,kh,40,40,80, 80);
        backBtn.setBackgroundImage("/assets/back.png");

        ImageButton nextBtn = new ImageButton(gp,kh, title.x+800, 50,80, 80);
        nextBtn.setBackgroundImage("/next.png");

        Text numberOfSprints = new Text("Number of sprints",gp ,kh);
        numberOfSprints.x = (gp.width-numberOfSprints.getStringWidth())/2;
        numberOfSprints.y = 240;
        numberOfSprints.setTextColor(Color.BLACK);

        CustomNumberInput numberOfSprintsInput = new CustomNumberInput(gp,kh);
        numberOfSprintsInput.x = numberOfSprints.x+ numberOfSprints.getStringWidth()+48;
        numberOfSprintsInput.y = 240;
        numberOfSprintsInput.hint = "2";

        Text numberOfDailyStandups = new Text("Number of daily standups",gp ,kh);
        numberOfDailyStandups.x = (gp.width-numberOfDailyStandups.getStringWidth())/2;
        numberOfDailyStandups.y = 380;
        numberOfDailyStandups.setTextColor(Color.BLACK);

        CustomNumberInput numberOfDailyStandupsInput = new CustomNumberInput(gp,kh);
        numberOfDailyStandupsInput.x = numberOfDailyStandups.x+ numberOfDailyStandups.getStringWidth()+48;
        numberOfDailyStandupsInput.y = 380;
        numberOfDailyStandupsInput.hint = "2";


        Text sizeOfTeam = new Text("size of team",gp ,kh);
        sizeOfTeam.x = (gp.width-sizeOfTeam.getStringWidth())/2;
        sizeOfTeam.y = 520;
        sizeOfTeam.setTextColor(Color.BLACK);

        CustomNumberInput sizeOfTeamInput = new CustomNumberInput(gp,kh);
        sizeOfTeamInput.x = sizeOfTeam.x+ sizeOfTeam.getStringWidth()+48;
        sizeOfTeamInput.y = 520;
        sizeOfTeamInput.hint = "2";

        Text numberOfUserStories = new Text("Number of user stories",gp ,kh);
        numberOfUserStories.x = (gp.width-numberOfUserStories.getStringWidth())/2;
        numberOfUserStories.y = 660;
        numberOfUserStories.setTextColor(Color.BLACK);

        CustomNumberInput numberOfUserStoriesInput = new CustomNumberInput(gp,kh);
        numberOfUserStoriesInput.x = numberOfUserStories.x+ numberOfUserStories.getStringWidth()+48;
        numberOfUserStoriesInput.y = 660;
        numberOfUserStoriesInput.hint = "2";

        entities.add(title);
        entities.add(btn);
        entities.add(backBtn);
        entities.add(numberOfSprints);
        entities.add(numberOfSprintsInput);
        entities.add(numberOfDailyStandups);
        entities.add(numberOfDailyStandupsInput);
        entities.add(sizeOfTeam);
        entities.add(sizeOfTeamInput);
        entities.add(numberOfUserStories);
        entities.add(numberOfUserStoriesInput);
        entities.add(nextBtn);



        backBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });

        nextBtn.setOnClickListener(new MouseClickInterface() {
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