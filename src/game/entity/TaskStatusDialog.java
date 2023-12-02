package game.entity;

import game.GamePanel;
import game.data.ScrumTask;
import game.event.KeyHandler;
import game.event.MouseClickInterface;

import java.awt.*;

/**
 * TaskStatusDialog , ui entity to select task status
 * enables user to change the task status
 */
public class TaskStatusDialog extends Entity{

    private ScrumTask task;
    private ImageButton closeBtn;

    private RadioGroup taskStatusGroup;

    private ScrumTaskDetailsDialog.ScreenListener screenListener;

    public TaskStatusDialog(GamePanel gp, KeyHandler kh, int x, int y) {
        super(gp, kh);
        this.x = x;
        this.y = y;
        this.width = 300;
        this.height = 380;


        closeBtn = new ImageButton(gp,kh,x+220,y+10,40,40);
        closeBtn.setBackgroundImage("/assets/back.png");

        taskStatusGroup = new RadioGroup(gp,kh,x+20,y+100);

        taskStatusGroup.addOption(ScrumTaskDetailsDialog.TASK_STATUS.NEW.toString());
        taskStatusGroup.addOption(ScrumTaskDetailsDialog.TASK_STATUS.IN_PROGRESS.toString());
        taskStatusGroup.addOption(ScrumTaskDetailsDialog.TASK_STATUS.TEST_READY.toString());
        taskStatusGroup.addOption(ScrumTaskDetailsDialog.TASK_STATUS.DONE.toString());

        closeBtn.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                screenListener.onTaskStatusDialogClosed();
            }
        });
    }

    public void setScrumTask(ScrumTask task){
        this.task = task;
        switch (task.getTaskStatus()){
            case NEW -> {
                taskStatusGroup.setSelected(0);
            }
            case IN_PROGRESS -> {taskStatusGroup.setSelected(1);
               }
            case TEST_READY -> {taskStatusGroup.setSelected(2);
               }
            case DONE -> {taskStatusGroup.setSelected(3);
                }
        }
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

        g.drawString("Task status ",x+20,y+64);


        closeBtn.draw(g);

        taskStatusGroup.draw(g);
    }


    @Override
    public void update() {

    }

    public ScrumTaskDetailsDialog.TASK_STATUS getTaskStatus(){
        switch (taskStatusGroup.getSelectedIndex()){
            case 0: return ScrumTaskDetailsDialog.TASK_STATUS.NEW;
            case 1: return ScrumTaskDetailsDialog.TASK_STATUS.IN_PROGRESS;
            case 2: return ScrumTaskDetailsDialog.TASK_STATUS.TEST_READY;
            case 3: return ScrumTaskDetailsDialog.TASK_STATUS.DONE;
            default:return ScrumTaskDetailsDialog.TASK_STATUS.BLOCKER;
        }

    }

    public void setScreenListener(ScrumTaskDetailsDialog.ScreenListener screenListener) {
        this.screenListener = screenListener;
    }

    public void removeObservers(){
        closeBtn.pauseObserver();
        taskStatusGroup.pauseObserver();
        pauseObserver();
    }

    public void setTaskStatus(ScrumTaskDetailsDialog.TASK_STATUS status) {
        task.setTaskStatus(status);
    }
}