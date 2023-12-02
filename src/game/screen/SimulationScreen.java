package game.screen;

import game.GamePanel;
import game.data.ScrumTask;
import game.entity.*;
import game.event.KeyHandler;
import game.event.MouseClickInterface;
import game.util.AutoSimulatorEventThread;

import java.awt.*;
import java.util.function.Consumer;

public class SimulationScreen extends Screen implements ScrumTaskDetailsDialog.ScreenListener, TaskEntity.TaskEntityActionListener{

    ScrumTaskDetailsDialog scrumTaskDetailsDialog;

    UserSelectionDialog userSelectionDialog;

    TaskStatusDialog taskStatusDialog;
    ScrumBoardEntitiy entitiy;

    AutoSimulatorEventThread thread;


    public SimulationScreen(GamePanel gp, KeyHandler kh) {
        super(gp, kh);

        Player sm = new Player(gp,kh,40,160,80, 80,"Scrum master");
        sm.setBackgroundImage("/seller/seller_still.png");

        Player po = new Player(gp,kh,40,300,80, 80,"Product owner");
        po.setBackgroundImage("/seller/seller_still.png");

        Player user = new Player(gp,kh,300,gp.height-240,80, 80,"You");
        user.setBackgroundImage("/seller/seller_still.png");

        ImageButton back = new ImageButton(gp,kh,440,user.y,80,80);
        back.setBackgroundImage("/assets/simulate.png");

        ImageButton next = new ImageButton(gp,kh,640,user.y,80,80);
        next.setBackgroundImage("/next.png");

        ImageButton simulation = new ImageButton(gp,kh,840,user.y,80,80);
        simulation.setBackgroundImage("/assets/pause.png");

        SimulatorTextBox simulatorTextBox = new SimulatorTextBox(gp, kh, 180, 40, 1000,600);
        simulatorTextBox.setCardTitle("Sprint Planning");
        simulatorTextBox.setListener(this);

//        entities.add(title);
        entities.add(sm);
        entities.add(po);
        entities.add(user);
        entities.add(back);
        entities.add(next);
        entities.add(simulation);
        entities.add(simulatorTextBox);

        for(int i=0; i<3;i++){
            Player dev = new Player(gp,kh,gp.width - 120,160+140*(i),80, 80,"Dev "+(i+1));
            dev.setBackgroundImage("/seller/seller_still.png");
            entities.add(dev);
        }

        back.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
//                simulatorTextBox.renderBack();
                showScrumBoard();
            }
        });

        next.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                simulatorTextBox.renderNextDialog();
            }
        });

        simulation.setOnClickListener(new MouseClickInterface() {
            @Override
            public void onClicked() {
                thread = new AutoSimulatorEventThread();
                thread.setSimulatorTextBox(simulatorTextBox);
                thread.start();
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

        if(entitiy!=null) {
            entitiy.draw(g);
        }

        if(scrumTaskDetailsDialog != null ){
            scrumTaskDetailsDialog.draw(g);
        }

        if(userSelectionDialog != null){
            userSelectionDialog.draw(g);
        }

        if(taskStatusDialog != null){
            taskStatusDialog.draw(g);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void onScrumTaskDetailsDialogClosed() {
        scrumTaskDetailsDialog.removeObservers();
        scrumTaskDetailsDialog = null;
    }

    @Override
    public void onTaskStatusDialogClosed() {
        taskStatusDialog.setTaskStatus(taskStatusDialog.getTaskStatus());
        entitiy.updateTaskPositions();
        taskStatusDialog.removeObservers();
        taskStatusDialog = null;
    }

    @Override
    public void onAssignToDialogClosed() {
        scrumTaskDetailsDialog.getTask().setAssignedTo(userSelectionDialog.getSelectedUserIndex());
        userSelectionDialog.removeObservers();
        userSelectionDialog = null;
    }

    @Override
    public void showTaskStatusDialog(ScrumTask task) {
        taskStatusDialog = new TaskStatusDialog(gp, kh, 100, 100);
        taskStatusDialog.setScrumTask(task);
        taskStatusDialog.setScreenListener(this);
    }

    @Override
    public void showAssignedToDialog(ScrumTask task) {
        userSelectionDialog = new UserSelectionDialog(gp,kh, 180, 20);
        userSelectionDialog.addUser("Sudhir");
        userSelectionDialog.addUser("Preetham");
        userSelectionDialog.addUser("Pradyumn");
        userSelectionDialog.setAssignedTo(scrumTaskDetailsDialog.getTask().getAssignedTo());
        userSelectionDialog.setScreenListener(this);
    }

    @Override
    public void showScrumBoard() {
//        thread.pause();
        entitiy = new ScrumBoardEntitiy(gp,kh,200,200);
        entitiy.setTaskEntityActionListener(SimulationScreen.this);
        entitiy.setScreenListener(SimulationScreen.this);

        entitiy.addTask(new ScrumTask(1,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.NEW));
        entitiy.addTask(new ScrumTask(2,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.TEST_READY));

        entitiy.addTask(new ScrumTask(3,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.IN_PROGRESS));
        entitiy.addTask(new ScrumTask(4,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.NEW));
        entitiy.addTask(new ScrumTask(5,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.NEW));

        entitiy.addTask(new ScrumTask(6,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.DONE));
        entitiy.addTask(new ScrumTask(4,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.NEW));
        entitiy.addTask(new ScrumTask(5,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.NEW));

        entitiy.addTask(new ScrumTask(6,"xyz",2, ScrumTaskDetailsDialog.TASK_STATUS.NEW));

    }

    @Override
    public void closeScrumBoard() {
        try{
            entitiy.removeObserver();
        }
        catch (Exception e){

        }
        entitiy = null;
//        thread.resumeSim();
    }

    @Override
    public void onTaskClicked(ScrumTask task) {
        scrumTaskDetailsDialog = new ScrumTaskDetailsDialog(gp, kh, 100, 100);
        scrumTaskDetailsDialog.setScrumTask(task);
        scrumTaskDetailsDialog.setScreenListener(this);
    }
}
