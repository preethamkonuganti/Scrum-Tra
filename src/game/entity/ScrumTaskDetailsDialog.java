package game.entity;

import game.GamePanel;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;

/**
 * ScrumTaskDetailsDialog , ui entity to show details of a scrum task on task board
 * enables user to assign task to a team member
 * enables user to change the task status
 */
public class ScrumTaskDetailsDialog extends Entity{

    public interface ScreenListener{
        public void onDialogClosed();
    }

    private ScreenListener screenListener;

    public enum TASK_STATUS {
        NEW,
        IN_PROGRESS,
        READY_For_TEST,
        DONE,
        BLOCKER
    };

    private String title;
    private int taskId;
    private int assignedTo;

    private TASK_STATUS status;

    private ImageButton closeBtn;

    public ScrumTaskDetailsDialog(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 300;
        this.height = 180;


        closeBtn = new ImageButton(gp,kh,x+220,y+10,40,40);
        closeBtn.setBackgroundImage("/assets/back.png");

        closeBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                screenListener.onDialogClosed();
            }
        });
    }

    public void setScrumTaskDetails(String title, int taskId, int assignedTo, TASK_STATUS status){
        this.title = title;
        this.taskId = taskId;
        this.assignedTo = assignedTo;
        this.status =status;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.fillRect(x+4, y+4,width-8, height-8);

        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.setColor(Color.decode("#5F259F"));
        g.drawString(title,x+20,y+24);

        g.drawString("Task ID = \t\t\t"+taskId,x+20,y+64);

        g.drawString("Assigned to = \t\t\t"+assignedTo,x+20,y+104);

        g.drawString("Task status = \t\t\t"+status,x+20,y+144);

        closeBtn.draw(g);
    }


    @Override
    public void update() {

    }

    public void setScreenListener(ScreenListener screenListener) {
        this.screenListener = screenListener;
    }
}