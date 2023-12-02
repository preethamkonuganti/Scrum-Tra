package game.data;

import game.entity.ScrumTaskDetailsDialog;

public class ScrumTask {
    private int taskId;
    private String title;

    private int assignedTo; //takes user id

    private ScrumTaskDetailsDialog.TASK_STATUS taskStatus;

    public ScrumTask(int taskId, String title, int assignedTo, ScrumTaskDetailsDialog.TASK_STATUS taskStatus) {
        this.taskId = taskId;
        this.title = title;
        this.assignedTo = assignedTo;
        this.taskStatus = taskStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public ScrumTaskDetailsDialog.TASK_STATUS getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(ScrumTaskDetailsDialog.TASK_STATUS taskStatus) {
        this.taskStatus = taskStatus;
    }
}
