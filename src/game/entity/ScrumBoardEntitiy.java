package game.entity;

import game.GamePanel;
import game.data.ScrumTask;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;
import java.util.ArrayList;

public class ScrumBoardEntitiy extends Entity{

    ArrayList<TaskEntity> tasks;
    ImageButton closeBtn;

    private ScrumTaskDetailsDialog.ScreenListener screenListener;

    public void setScreenListener(ScrumTaskDetailsDialog.ScreenListener screenListener) {
        this.screenListener = screenListener;
    }

    private TaskEntity.TaskEntityActionListener taskEntityActionListener;
    public ScrumBoardEntitiy(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);

        width = 600;
        height = 640;

        this.x = (gp.width - width)/2;
        this.y = (gp.height - height)/2;

        tasks = new ArrayList<>();

        closeBtn = new ImageButton(gp,kh,this.x+560,this.y-10,20,20);
        closeBtn.setBackgroundImage("/assets/back.png");

        closeBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {

                System.out.println("Close clicked on sim board");
                screenListener.closeScrumBoard();
            }
        });

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y-40, width, height);

        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.setColor(Color.black);
        g.drawString("New",x+20,y-10);
        g.drawString("In Progress",x+20+1*width/4,y-10);
        g.drawString("Test Ready",x+20+2*width/4,y-10);
        g.drawString("Done",x+20+3*width/4,y-10);

        int restHt = height-40;
        g.setColor(Color.white);
        g.fillRect(x+6, y+6, width-12, restHt-12);

        g.setColor(Color.decode("#5F259F"));
        g.drawLine(x+1*width/4, y, x+1*width/4, y+restHt);
        g.drawLine(x+2*width/4, y, x+2*width/4, y+restHt);
        g.drawLine(x+3*width/4, y, x+3*width/4, y+restHt);

        for(TaskEntity t : tasks){
            t.draw(g);
        }

        closeBtn.draw(g);


    }

    @Override
    public void update() {

    }

    public void setTaskEntityActionListener(TaskEntity.TaskEntityActionListener listener) {
        taskEntityActionListener = listener;
    }

    public void addTask(ScrumTask task){

        TaskEntity taskEntity = new TaskEntity(gp,kh,task);

        switch (taskEntity.getTask().getTaskStatus()){
            case NEW -> {
                taskEntity.setPosition(this.x+20,this.y+60*(tasks.size()+1));
            }
            case IN_PROGRESS -> {
                taskEntity.setPosition(this.x+20+1*width/4,this.y+60*(tasks.size()+1));
            }
            case TEST_READY -> {
                taskEntity.setPosition(this.x+20+2*width/4,this.y+60*(tasks.size()+1));
            }
            case DONE -> {
                taskEntity.setPosition(this.x+20+3*width/4,this.y+60*(tasks.size()+1));
            }
        }

        tasks.add(taskEntity);

        taskEntity.setOnClickListener(new MouseClickInterface() {

            final ScrumTask task = taskEntity.getTask();

            @Override
            public void onClicked() {
                System.out.println("TE Clicked");
                taskEntityActionListener.onTaskClicked(task);
            }
        });
    }

    public void updateTaskPositions(){
        int i = 1;
        for(TaskEntity taskEntity : tasks){
            switch (taskEntity.getTask().getTaskStatus()){
                case NEW -> {
                    taskEntity.setPosition(this.x+20,this.y+60*i);
                }
                case IN_PROGRESS -> {
                    taskEntity.setPosition(this.x+20+1*width/4,this.y+60*i);
                }
                case TEST_READY -> {
                    taskEntity.setPosition(this.x+20+2*width/4,this.y+60*i);
                }
                case DONE -> {
                    taskEntity.setPosition(this.x+20+3*width/4,this.y+60*i);
                }
            }

            i++;
        }
    }

    public void removeObserver(){
        for(TaskEntity t : tasks){
            t.resumeObserver();
        }
        closeBtn.resumeObserver();
    }

}
