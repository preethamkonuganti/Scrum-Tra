package game.data;

public class SimulationCeremonyConfig {

    private static SimulationCeremonyConfig instance = null;

    public boolean isSprintPlanningSelected = false;

    public boolean isDailyStandupSelected = false;

    public boolean isSprintReviewSelected = false;

    public boolean isSprintRetrospectiveSelected = false;

    private SimulationCeremonyConfig(){
    }

    public SimulationCeremonyConfig getInstance(){
        if(instance == null)
            instance = new SimulationCeremonyConfig();
        return instance;
    }
}
