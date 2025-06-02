/**
 * ReminderThread prints a reminder message at regular intervals
 * to help the user remember to log their habits.
 * 
 * This runs in the background while the app is open.
 * 
 * @author Amber Rama
 *
 * References:
 * https://www.w3schools.com/java/java_threads.asp
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
 */
public class ReminderThread extends Thread {
    private boolean running = true;

    /**
     * This method runs when the thread is started.
     * It prints a message every 10 seconds (for testing).
     */
    @Override
    public void run() {
        while (running) {
            try {
                System.out.println("⏰ Don't forget to log your habits!");
                Thread.sleep(10000); // 10 seconds
            } catch (InterruptedException e) {
                System.out.println("Reminder thread interrupted.");
                running = false;
            }
        }
    }

    /**
     * Stops the reminder thread.
     */
    public void stopReminders() {
        running = false;
    }
}
