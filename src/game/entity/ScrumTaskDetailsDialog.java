package game.entity;

import game.GamePanel;
import game.data.ScrumTask;
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
        public void onScrumTaskDetailsDialogClosed();

        public void onTaskStatusDialogClosed();

        public void onAssignToDialogClosed();

        public void showTaskStatusDialog(ScrumTask task);

        public void showAssignedToDialog(ScrumTask task);

        public void showScrumBoard();

        public void closeScrumBoard();
    }

    private ScreenListener screenListener;

    public enum TASK_STATUS {
        NEW,
        IN_PROGRESS,
        TEST_READY,
        DONE,
        BLOCKER
    };

    private ScrumTask task;

    private ImageButton closeBtn;

    private ImageButton showTaskStatusBtn;

    private ImageButton showAssignedToBtn;

    public ScrumTaskDetailsDialog(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 300;
        this.height = 180;

        closeBtn = new ImageButton(gp,kh,x+270,y+10,20,20);
        closeBtn.setBackgroundImage("/assets/back.png");

        closeBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                screenListener.onScrumTaskDetailsDialogClosed();
            }
        });

        showTaskStatusBtn = new ImageButton(gp,kh,x+270,y+144,20,20);
        showTaskStatusBtn.setBackgroundImage("/assets/back.png");

        showTaskStatusBtn.setOnClickListener(new MouseClickInterface() {

            @Override
            public void onClicked() {
                System.out.println("Closeee");
                screenListener.showTaskStatusDialog(task);
            }
        });

        showAssignedToBtn = new ImageButton(gp,kh,x+270,y+104,20,20);
        showAssignedToBtn.setBackgroundImage("/assets/back.png");

        showAssignedToBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                System.out.println("Closeee");
                screenListener.showAssignedToDialog(task);
            }
        });
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#5F259F"));
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.fillRect(x+4, y+4,width-8, height-8);

        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.setColor(Color.decode("#5F259F"));
        g.drawString(task.getTitle(),x+20,y+24);

        g.drawString("Task ID = \t\t\t"+task.getTaskId(),x+20,y+64);

        g.drawString("Assigned to = \t\t\t"+task.getAssignedTo(),x+20,y+104);

        g.drawString("Task status = \t\t\t"+task.getTaskStatus(),x+20,y+144);

        closeBtn.draw(g);
        showTaskStatusBtn.draw(g);
        showAssignedToBtn.draw(g);
    }


    @Override
    public void update() {

    }

    public void setScreenListener(ScreenListener screenListener) {
        this.screenListener = screenListener;
    }

    public void setScrumTask(ScrumTask task) {
        this.task = task;
    }

    public void removeObservers(){
        closeBtn.pauseObserver();
        showTaskStatusBtn.pauseObserver();
        showAssignedToBtn.pauseObserver();
        pauseObserver();
    }

    public ScrumTask getTask() {
        return task;
    }
}