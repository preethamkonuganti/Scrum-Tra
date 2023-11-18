package game.data;

public class SimulationCeremonyConfig {

    private static SimulationCeremonyConfig instance = null;

    private boolean isSprintPlanningSelected = false;

    private boolean isDailyStandupSelected = false;

    private boolean isSprintReviewSelected = false;

    private boolean isSprintRetrospectiveSelected = false;

    private SimulationCeremonyConfig(){
    }

    public SimulationCeremonyConfig getInstance(){
        if(instance == null)
            instance = new SimulationCeremonyConfig();
        return instance;
    }

    public static void setInstance(SimulationCeremonyConfig instance) {
        SimulationCeremonyConfig.instance = instance;
    }

    public boolean isSprintPlanningSelected() {
        return isSprintPlanningSelected;
    }

    public void setSprintPlanningSelected(boolean sprintPlanningSelected) {
        isSprintPlanningSelected = sprintPlanningSelected;
    }

    public boolean isDailyStandupSelected() {
        return isDailyStandupSelected;
    }

    public void setDailyStandupSelected(boolean dailyStandupSelected) {
        isDailyStandupSelected = dailyStandupSelected;
    }

    public boolean isSprintReviewSelected() {
        return isSprintReviewSelected;
    }

    public void setSprintReviewSelected(boolean sprintReviewSelected) {
        isSprintReviewSelected = sprintReviewSelected;
    }

    public boolean isSprintRetrospectiveSelected() {
        return isSprintRetrospectiveSelected;
    }

    public void setSprintRetrospectiveSelected(boolean sprintRetrospectiveSelected) {
        isSprintRetrospectiveSelected = sprintRetrospectiveSelected;
    }
}