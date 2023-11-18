package game.data;

public class GameSettings {
    private static GameSettings instance = null;
    private String userName;

    private String simulationStory;

    private int level; // 1 - beginner, 2-Intermediate, 3-Advanced

    private GameSettings(){

    }

    public static GameSettings getInstance(){
        if(instance == null ){
            instance = new GameSettings();
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSimulationStory() {
        return simulationStory;
    }

    public void setSimulationStory(String simulationStory) {
        this.simulationStory = simulationStory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
