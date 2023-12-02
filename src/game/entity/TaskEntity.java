package game.entity;

import game.GamePanel;
import game.data.ScrumTask;
import game.event.KeyHandler;

import java.awt.*;

public class TaskEntity extends Entity{

    public  interface TaskEntityActionListener{
        public void onTaskClicked(ScrumTask task);
    }

    ScrumTask task;

    ScrumTaskDetailsDialog.TASK_STATUS status;

    public TaskEntity(GamePanel gp, KeyHandler kh, ScrumTask task) {
        super(gp, kh);
        this.width = 32;
        this.height = 32;
        this.task = task;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.setColor(Color.white);
        g.drawString(""+task.getTaskId(),x+8,y+20);
    }

    @Override
    public void update() {

    }

    public ScrumTask getTask(){
        return task;
    }
}
