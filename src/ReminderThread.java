public class ReminderThread extends Thread {
    private boolean running = true;

    @Override
	public void run() {
        while (running) {
            try {
                // Placeholder: Print reminder every 10 seconds
                System.out.println("Don't forget to log your habits!");
                Thread.sleep(10000); // 10 seconds for testing
            } catch (InterruptedException e) {
                System.out.println("Reminder thread interrupted.");
                running = false;
            }
        }
    }

    public void stopReminders() {
        running = false;
    }
}
