package game.data;

public class SimulationSettings {

    private static SimulationSettings instance = null;

    public int numOfSprints = 3; //default value for number of sprints
    public int numOfStandupInOneSprint = 6; //default value for 2 weeks sprint

    public int sizeOfTeam = 5; // default value for size of team

    public int numOfUserStories = numOfSprints*4; //default value = 4 user stories per print

    private SimulationSettings(){
    }

    public SimulationSettings getInstance(){
        if(instance == null ){
            instance = new SimulationSettings();
        }
        return instance;
    }

}
