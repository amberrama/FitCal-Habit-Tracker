import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FitCalMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                JFrame frame = new JFrame("FitCal - Habit Tracker");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(600, 400);

                CalendarView calendarPanel = new CalendarView();
                frame.add(calendarPanel);

                frame.setVisible(true);
            }
        });

        // Start reminder thread (can close with app exit)
        ReminderThread reminder = new ReminderThread();
        reminder.start();
    }
}