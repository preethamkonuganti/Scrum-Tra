package game.screen;

import game.GamePanel;
import game.entity.*;
import game.entity.Character;
import game.event.KeyHandler;
import game.event.MouseClickInterface;
import game.navigation.Navigation;

import java.awt.*;
import java.util.function.Consumer;

public class WelcomeScreen extends Screen{


    public WelcomeScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text title = new Text("SCRUM - TRA",gp ,kh);
        title.x = (gp.width - title.getStringWidth())/2;
        title.y = 100;

        Character genie = new Character(gp,kh,164, 400, 400, 200, "/Environment.txt");

        Character genie2 = new Character(gp,kh,850, 380, 400, 200, "/seller2.txt");

        Character genie3 = new Character(gp,kh,510, 140, 400, 200, "/seller3.txt");

        CustomTextInput input = new CustomTextInput(gp,kh);
        input.x = 600;
        input.y = 480;


        ImageButton g3 = new ImageButton(gp,kh,647,613,160,80);
        g3.setBackgroundImage("/next.png");

        Character arrowLtR = new Character(gp,kh,290,240,180,100,"/arrow.txt");

        Character arrowRtL = new Character(gp,kh,940,240,180,100,"/arrow_toR.txt");

        Character asset1 = new Character(gp, kh,1140,600, 140,120,"/asset.txt");



        Character arrow3 = new Character(gp, kh,380,620, 700,140,"/arrow3.txt");


        CustomTextInput textInput = new CustomTextInput(gp,kh);
        textInput.x = 100;
        textInput.y = 100;
        textInput.hint = "Type your name";

        entities.add(title);
        entities.add(genie);
        entities.add(genie2);
        entities.add(genie3);
        entities.add(input);
        entities.add(g3);
        entities.add(arrowLtR);
        entities.add(arrowRtL);
        entities.add(asset1);
        entities.add(arrow3);

        g3.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                Navigation.getInstance().navigateToNext();
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
