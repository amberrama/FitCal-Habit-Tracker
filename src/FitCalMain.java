import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * The main entry point for the FitCal habit tracker application.
 * 
 * This class sets up the main window and adds the calendar panel
 * where users can log their habits. It also starts the reminder thread
 * in the background.
 * 
 * @author Amber Rama
 * 
 * References:
 * https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
 */
public class FitCalMain {

    /**
     * Launches the GUI and starts the reminder thread.
     * The GUI is built using Swing and displays the calendar view panel.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FitCal - Habit Tracker");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            CalendarView calendarPanel = new CalendarView();
            frame.add(calendarPanel);

            frame.setVisible(true);
        });

        // Start the background thread to remind the user to log habits
        ReminderThread reminder = new ReminderThread();
        reminder.start();
    }
}
