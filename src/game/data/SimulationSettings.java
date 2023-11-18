package game.data;

public class SimulationSettings {

    private static SimulationSettings instance = null;

    private int numOfSprints = 3; //default value for number of sprints
    private int numOfStandupInOneSprint = 6; //default value for 2 weeks sprint

    private int sizeOfTeam = 5; // default value for size of team

    private int numOfUserStories = numOfSprints*4; //default value = 4 user stories per print

    private SimulationSettings(){
    }

    public static SimulationSettings getInstance(){
        if(instance == null ){
            instance = new SimulationSettings();
        }
        return instance;
    }


    public int getNumOfSprints() {
        return numOfSprints;
    }

    public void setNumOfSprints(int numOfSprints) {
        this.numOfSprints = numOfSprints;
    }

    public int getNumOfStandupInOneSprint() {
        return numOfStandupInOneSprint;
    }

    public void setNumOfStandupInOneSprint(int numOfStandupInOneSprint) {
        this.numOfStandupInOneSprint = numOfStandupInOneSprint;
    }

    public int getSizeOfTeam() {
        return sizeOfTeam;
    }

    public void setSizeOfTeam(int sizeOfTeam) {
        this.sizeOfTeam = sizeOfTeam;
    }

    public int getNumOfUserStories() {
        return numOfUserStories;
    }

    public void setNumOfUserStories(int numOfUserStories) {
        this.numOfUserStories = numOfUserStories;
    }
}
