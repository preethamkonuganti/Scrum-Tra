package game.util;

public class AutoSimulatorEventThread extends Thread{

    boolean isSimulationRunning = true;

    float hitInOneSecond = 0.5f;

    @Override
    public void run() {
        simulate();
    }

    private void simulate() {
        double currentTime = System.nanoTime();
        double nextTimeInterval = currentTime + 1000000000/hitInOneSecond;

        while (isSimulationRunning){
            System.out.println("Thread hit");

            try {
                double rem = nextTimeInterval - System.nanoTime();
                double remInMillis = rem/1000000;

                if(remInMillis < 0)
                    remInMillis = 0;
                Thread.sleep((long) remInMillis);

                nextTimeInterval += 1000000000/hitInOneSecond;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
