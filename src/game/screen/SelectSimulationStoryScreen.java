package game.screen;

import game.GamePanel;
import game.data.GameSettings;
import game.entity.Entity;
import game.entity.ImageButton;
import game.entity.SimulationStoryListView;
import game.entity.Text;
import game.event.KeyHandler;
import game.event.MouseClickInterface;
import game.navigation.Navigation;

import java.awt.*;

public class SelectSimulationStoryScreen extends Screen{

    int storyCardIndex;
    public SelectSimulationStoryScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);
        Text title = new Text("Hey "+ GameSettings.getInstance().getUserName(),gp ,kh);
        title.x = (gp.width-title.getStringWidth())/2;
        title.y = 100;
        storyCardIndex = 0;
        ImageButton btn = new ImageButton(gp,kh,title.x-150,40,140, 140);
        btn.setBackgroundImage("/seller/seller_still.png");

        SimulationStoryListView simulationStoryListView = new SimulationStoryListView(gp,kh,40,220,gp.width-80,480);

        entities.add(simulationStoryListView);
        entities.add(title);
        entities.add(btn);

        for( storyCardIndex = 0; storyCardIndex<simulationStoryListView.getStoryCards().size();storyCardIndex++){
            simulationStoryListView.getStoryCards().get(storyCardIndex).setOnClickListener(new MouseClickInterface() {
                @Override
                public void onClicked() {
                    int i = storyCardIndex;
                    System.out.println("Story card clicked "+i);
                    Navigation.getInstance().navigateToNext();
                }
            });
        }
    }

    @Override
    public void draw(Graphics2D g) {
        for(Entity e : entities){
            e.draw(g);
        }
    }

    @Override
    public void update() {
        for(Entity e : entities){
            e.update();
        }
    }
}
