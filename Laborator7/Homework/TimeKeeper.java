import java.util.concurrent.TimeUnit;

public class TimeKeeper extends Thread implements Runnable {
    private final int maxTime;
    private volatile boolean isRunning;
    private volatile boolean hasExceededTimeLimit;
    private long startTime = System.currentTimeMillis();

    public TimeKeeper(int maxTime) {
        this.maxTime = maxTime;
        this.isRunning = true;
        this.hasExceededTimeLimit = false;
    }

    public boolean hasExceededTimeLimit() {
        return hasExceededTimeLimit;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start time: " + startTime);
        while (isRunning) {
             long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= maxTime * 1000) {
                hasExceededTimeLimit = true;
                isRunning = false;
            }
        }
    }

    public void stopTimer() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time in seconds: " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime));
        isRunning = false;
    }
}