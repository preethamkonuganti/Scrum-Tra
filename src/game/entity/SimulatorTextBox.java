package game.entity;

import game.GamePanel;
import game.event.KeyHandler;
import game.util.SimulationStoryParser;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulatorTextBox extends Entity{

    ScrumTaskDetailsDialog.ScreenListener listener;

    public void setListener(ScrumTaskDetailsDialog.ScreenListener listener) {
        this.listener = listener;
    }

    private String cardTitle = "";

    private int start = 0;

    private int end = 1;

    private int ceremony = 0;

    private List<String> simulationDialogs;

    private List<List<String>> simMap;

    public SimulatorTextBox(GamePanel gp, KeyHandler kh, int x, int y, int width, int height) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        simulationDialogs = SimulationStoryParser.parseSim("/simulation_story/ds.txt");
        simMap = new ArrayList<>();
        simMap.add(SimulationStoryParser.parseSim("/simulation_story/sp.txt"));
        simMap.add(SimulationStoryParser.parseSim("/simulation_story/ds.txt"));
        simMap.add(SimulationStoryParser.parseSim("/simulation_story/srr.txt"));
        simMap.add(SimulationStoryParser.parseSim("/simulation_story/sr.text"));

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
        switch (ceremony){
            case 0: {
                cardTitle = "Sprint planning";
                break;
            }
            case 1: {
                cardTitle = "Daily Standup";
                break;
            }

            case 2: {
                cardTitle = "Sprint Retrospective";
                break;
            }
            case 3: {
                cardTitle = "Sprint Review";
            }
        }
        g.drawString(cardTitle,x+320,y+40);
        int ty = 80;

        g.setFont(new Font("Serif", Font.ITALIC, 18));


        for(int i=start; i<end;i++){
            if(simMap.get(ceremony).get(i).startsWith("<task")){
                listener.showScrumBoard();
            }
            g.drawString(simMap.get(ceremony).get(i),x+16,y+ty);
            ty += 20;
        }
        if(end == simulationDialogs.size()){
            g.drawString(cardTitle+" has ended. Press next to goto next ceremony",x+16,580);
        }

    }

    @Override
    public void update() {

    }

    public void renderNextDialog(){
        if(end < simulationDialogs.size()) {
            end += 1;
        }
        else if(ceremony <3){
            ceremony++;
            end = 0;
        }
    }

    public void renderBack() {
        if(end > 0){
            end -= 1;
        } else if (end ==1 && ceremony >0) {
            ceremony--;
        }
    }
}
