package game.screen;

import game.GamePanel;
import game.entity.*;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;

/**
 * CreateSimulationScreen - It will enable user to create their own simulation story.
 */
public class CreateSimulationStoryScreen extends Screen{
    public CreateSimulationStoryScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Text text = new Text("Title of story", gp, kh);
        text.x = 80;
        text.y = 120;

        CustomTextInput titleIn = new CustomTextInput(gp,kh);
        titleIn.hint = "Title";
        titleIn.x = text.x+text.getStringWidth()+20;
        titleIn.y = 120;

        Text spTv = new Text("Sprint Planning(s)", gp, kh);
        spTv.x = 80;
        spTv.y = 240;


        Text dsTv = new Text("Daily Standup(s)", gp, kh);
        dsTv.x = 80;
        dsTv.y = 340;

        Text srTv = new Text("Sprint Review(s)", gp, kh);
        srTv.x = 80;
        srTv.y = 440;

        Text sRetroTv = new Text("Sprint Retrospective(s)", gp, kh);
        sRetroTv.x = 80;
        sRetroTv.y = 540;


        entities.add(text);
        entities.add(titleIn);
        entities.add(spTv);
        entities.add(dsTv);
        entities.add(srTv);
        entities.add(sRetroTv);
    }

    @Override
    public void draw(Graphics2D g) {



        g.setColor(Color.decode("#5F259F"));
        g.fillRect(10,10,gp.width-20,gp.height-120);

        g.setColor(Color.white);
        g.fillRect(18, 18,gp.width-36, gp.height-156);

        for (Entity e : entities){
            e.draw(g);
        }

    }

    @Override
    public void update() {

    }
}