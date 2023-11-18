package game.screen;

import game.GamePanel;
import game.data.SimulationCeremonyConfig;
import game.entity.CustomCheckBox;
import game.entity.Entity;
import game.entity.ImageButton;
import game.entity.Text;
import game.event.KeyHandler;
import game.event.MouseClickInterface;
import game.navigation.Navigation;

import java.awt.*;
import java.util.function.Consumer;

public class SelectSimulationCeremonyScreen extends Screen{
    public SelectSimulationCeremonyScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("Select Simulation Ceremonies",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");

        CustomCheckBox sprintPlanning = new CustomCheckBox(gp ,kh,
                340, 240,"Sprint Planning");
        sprintPlanning.setChecked(false);

        CustomCheckBox sprintRetrospective = new CustomCheckBox(gp ,kh,
                340, 340,"Sprint Retrospective");

        CustomCheckBox sprintReview = new CustomCheckBox(gp ,kh,
                340, 440,"Sprint Review");

        CustomCheckBox dailyStandup = new CustomCheckBox(gp ,kh,
                340, 540,"Daily Standups");


        ImageButton g3 = new ImageButton(gp,kh, gp.getWidth()-240, 60,160,80);
        g3.setBackgroundImage("/next.png");

        entities.add(title);
        entities.add(btn);
        entities.add(sprintPlanning);
        entities.add(sprintRetrospective);
        entities.add(sprintReview);
        entities.add(dailyStandup);
        entities.add(g3);


        g3.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

                SimulationCeremonyConfig.getInstance().setSprintPlanningSelected(sprintPlanning.isChecked());
                SimulationCeremonyConfig.getInstance().setSprintReviewSelected(sprintReview.isChecked());
                SimulationCeremonyConfig.getInstance().setSprintRetrospectiveSelected(sprintRetrospective.isChecked());
                SimulationCeremonyConfig.getInstance().setDailyStandupSelected(dailyStandup.isChecked());

                System.out.println("SP : "+SimulationCeremonyConfig.getInstance().isSprintPlanningSelected());
                System.out.println("SR : "+SimulationCeremonyConfig.getInstance().isSprintReviewSelected());
                System.out.println("SRP : "+SimulationCeremonyConfig.getInstance().isSprintRetrospectiveSelected());
                System.out.println("DS : "+SimulationCeremonyConfig.getInstance().isDailyStandupSelected());


                Navigation.getInstance().navigateToNext();
            }
        });

        sprintPlanning.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });

        sprintRetrospective.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });

        sprintReview.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

            }
        });

        dailyStandup.setOnClickListener(new MouseClickInterface() {
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
