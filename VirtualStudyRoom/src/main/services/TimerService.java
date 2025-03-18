package main.services;

import main.models.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerService {
    private ScheduledExecutorService scheduler;
    private boolean isRunning = false;

    public void startTimer(Timer timer) {
        if (isRunning) {
            System.out.println("❌ A timer is already running.");
            return;
        }

        isRunning = true;
        scheduler = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < timer.getDuration(); i++) {
            int timeLeft = timer.getDuration() - i;
            scheduler.schedule(() -> {
                if (isRunning) {
                    System.out.println("⏳ Time left: " + timeLeft + " minutes");
                }
            }, i, TimeUnit.MINUTES);
        }

        scheduler.schedule(() -> {
            if (isRunning) {
                System.out.println("🎉 Time's up!");
                isRunning = false;
            }
        }, timer.getDuration(), TimeUnit.MINUTES);
    }

    public void stopTimer() {
        if (scheduler != null) {
            scheduler.shutdownNow();
            isRunning = false;
            System.out.println("⏸ Timer Stopped.");
        }
    }
}
