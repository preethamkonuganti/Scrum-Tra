package game.screen;

import game.GamePanel;
import game.entity.Button;
import game.entity.Entity;
import game.entity.ImageButton;
import game.entity.Text;
import game.event.KeyHandler;
import game.event.MouseClickInterface;
import game.navigation.Navigation;

import java.awt.*;
import java.util.function.Consumer;

public class SelectProficiencyScreen extends Screen{

    String selectedProficiency = "beginner";
    public SelectProficiencyScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("Select Proficiency",gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;

        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");

        Button beginner = new Button("Beginner",gp ,kh);
        beginner.x = (gp.width-beginner.getStringWidth())/2;
        beginner.y = 240;
        beginner.setTextColor(Color.WHITE);
        beginner.setStrokeColor(Color.BLACK);
        beginner.setBackgroundColor(Color.decode("#55ACEE"));


        Button advanced = new Button("Advanced",gp ,kh);
        advanced.x = (gp.width-advanced.getStringWidth())/2;
        advanced.y = 380;
        advanced.setTextColor(Color.WHITE);
        advanced.setStrokeColor(Color.BLACK);
        advanced.setBackgroundColor(Color.decode("#55ACEE"));

        Button expert = new Button("Expert",gp ,kh);
        expert.x = (gp.width-expert.getStringWidth())/2;
        expert.y = 520;
        expert.setTextColor(Color.WHITE);
        expert.setStrokeColor(Color.BLACK);
        expert.setBackgroundColor(Color.decode("#55ACEE"));


        ImageButton g3 = new ImageButton(gp,kh, expert.x, 620,160,80);
        g3.setBackgroundImage("/next.png");

        entities.add(title);
        entities.add(btn);
        entities.add(beginner);
        entities.add(advanced);
        entities.add(expert);
        entities.add(g3);


        g3.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                Navigation.getInstance().navigateToNext();
            }
        });


        beginner.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                selectedProficiency = "beginner";
            }
        });

        advanced.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                selectedProficiency = "advanced";
            }
        });

        expert.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                selectedProficiency = "expert";
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

        g.setFont(new Font("Serif", Font.ITALIC, 28));
        g.setColor(Color.white);
        g.drawString("Selected Role : ",1000, 600);
        g.drawString(selectedProficiency,1020,660);
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
