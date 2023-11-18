package game.entity;

import game.GamePanel;
import game.event.KeyHandler;
import game.util.SimulationStoryParser;

import java.awt.*;
import java.util.List;

public class SimulatorTextBox extends Entity{

    private String cardTitle = "";

    private int start = 0;

    private int end = 1;

    private List<String> simulationDialogs;

    public SimulatorTextBox(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        simulationDialogs = SimulationStoryParser.parseSim("/simulation_story/ds.txt");

    }

    public void setCardTitle(String cardTitle){
        this.cardTitle = cardTitle;
    }



    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x,y,width,height);

        g.setColor(Color.white);
        g.fillRect(x+8, y+8,width-16, height-16);

        g.setColor(Color.decode("#5F259F"));
        g.drawString(cardTitle,x+320,y+40);
        int ty = 100;

        g.setFont(new Font("Serif", Font.ITALIC, 18));
        for(int i=start; i<end;i++){
            g.drawString(simulationDialogs.get(i),x+16,y+ty);
            ty += 20;
        }
        if(end == simulationDialogs.size()){
            g.drawString(cardTitle+" has ended. Press next to goto next ceremony",x+16,480);
        }

    }

    @Override
    public void update() {

    }

    public void renderNextDialog(){
        if(end < simulationDialogs.size()) {
            end += 1;
        }
    }

    public void renderBack() {
        if(end > 0){
            end -= 1;
        }
    }
}
