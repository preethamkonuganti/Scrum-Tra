package game.util;

import game.entity.ScrumTaskDetailsDialog;
import game.entity.SimulatorTextBox;

public class AutoSimulatorEventThread extends Thread{

    boolean isSimulationRunning = true;

    float hitInOneSecond = 0.7f;

    boolean isPause = false;

    public void setSimulatorTextBox(SimulatorTextBox simulatorTextBox) {
        this.simulatorTextBox = simulatorTextBox;
    }

    SimulatorTextBox simulatorTextBox;

    @Override
    public void run() {
        simulate();
    }

    private void simulate() {
        double currentTime = System.nanoTime();
        double nextTimeInterval = currentTime + 1000000000/hitInOneSecond;

        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (isSimulationRunning){

            if(!isPause) {

                simulatorTextBox.renderNextDialog();

                try {
                    double rem = nextTimeInterval - System.nanoTime();
                    double remInMillis = rem / 1000000;

                    if (remInMillis < 0)
                        remInMillis = 0;
                    Thread.sleep((long) remInMillis);

                    nextTimeInterval += 1000000000 / hitInOneSecond;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void pause(){
        isPause = true;
    }

    public void resumeSim(){
        isPause = false;
    }
}
