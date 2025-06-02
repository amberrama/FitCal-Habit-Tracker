import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * CalendarView displays a monthly calendar where each day is a button.
 * Users can click on a day to log either a meal or fitness habit.
 * Logged habits are stored in a HashMap and can be viewed in a popup.
 * 
 * @author Amber Rama
 * 
 * References: 
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 * https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
 * https://www.w3schools.com/java/java_hashmap.asp
 * https://www.programiz.com/java-programming/polymorphism
 * https://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
 */
public class CalendarView extends JPanel {
    private JButton[][] buttons = new JButton[5][7]; // 5 weeks x 7 days
    private Map<Integer, Habit> habitMap = new HashMap<>(); // Stores habits per day

    /**
     * Constructor that builds the calendar UI and sets up button actions.
     */
    public CalendarView() {
        setLayout(new GridLayout(5, 7)); // 5 rows of 7 days
        int day = 1;

        // Create 30 day buttons
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 7; col++) {
                JButton button = new JButton();

                if (day <= 30) {
                    final int currentDay = day;
                    button.setText(String.valueOf(currentDay));
                    button.setFont(new Font("Arial", Font.BOLD, 16));

                    // When user clicks on a day button
                    button.addActionListener(e -> {
                        if (habitMap.containsKey(currentDay)) {
                            JOptionPane.showMessageDialog(
                                null,
                                "You've already logged a habit for Day " + currentDay + ".",
                                "Already Logged",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                            return;
                        }

                        logHabitForDay(currentDay, button); // Prompt user to log
                    });

                    day++;
                } else {
                    button.setEnabled(false); // Disable unused buttons (e.g. 31st, etc.)
                }

                buttons[row][col] = button;
                add(button);
            }
        }

        // Add "View Logged Habits" button
        JButton viewHabitsButton = new JButton("View Logged Habits");
        viewHabitsButton.addActionListener(e -> showLoggedHabitsDialog());

        // Create a wrapper to show both the calendar and the view button
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(this, BorderLayout.CENTER);
        wrapper.add(viewHabitsButton, BorderLayout.SOUTH);

        // Set up the frame that displays the entire tracker
        JFrame frame = new JFrame("FitCal - Habit Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setContentPane(wrapper);
        frame.setVisible(true);
    }

    /**
     * Prompts the user to choose and enter a habit (Meal or Fitness) for a given day.
     * @param day The calendar day to log for
     * @param button The button to update text on
     */
    private void logHabitForDay(int day, JButton button) {
        String[] options = {"Meal Habit", "Fitness Habit"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "What type of habit would you like to log?",
            "Choose Habit Type",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == 0) { // Meal Habit
            String name = JOptionPane.showInputDialog("Enter name of meal:");
            String mealType = JOptionPane.showInputDialog("Meal type (Breakfast, Lunch, Dinner):");
            String calorieInput = JOptionPane.showInputDialog("Enter calories:");
            try {
                int calories = Integer.parseInt(calorieInput);
                Habit mealHabit = new MealHabit(name, "Day " + day, mealType, calories);
                habitMap.put(day, mealHabit);
                button.setText("✔ " + day);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number. Try logging again.");
            }
        } else if (choice == 1) { // Fitness Habit
            String name = JOptionPane.showInputDialog("Enter name of workout:");
            String workoutType = JOptionPane.showInputDialog("Type of workout:");
            String durationInput = JOptionPane.showInputDialog("Enter duration in minutes:");
            try {
                int duration = Integer.parseInt(durationInput);
                Habit fitnessHabit = new FitnessHabit(name, "Day " + day, workoutType, duration);
                habitMap.put(day, fitnessHabit);
                button.setText("✔ " + day);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number. Try logging again.");
            }
        }
    }

    /**
     * Shows a dialog listing all logged habits, formatted nicely by type.
     */
    private void showLoggedHabitsDialog() {
        if (habitMap.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "No habits logged yet.",
                "Habit Log",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Habit> entry : habitMap.entrySet()) {
            Habit h = entry.getValue();
            sb.append("Day ").append(entry.getKey()).append(": ").append(h.getName());

            // Add extra info based on habit type
            if (h instanceof MealHabit) {
                MealHabit mh = (MealHabit) h;
                sb.append(" (Meal: ").append(mh.getMealType()).append(", ");
                sb.append(mh.getCalories()).append(" cal)");
            } else if (h instanceof FitnessHabit) {
                FitnessHabit fh = (FitnessHabit) h;
                sb.append(" (Workout: ").append(fh.getType()).append(", ");
                sb.append(fh.getDuration()).append(" mins)");
            }

            sb.append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 300));

        JOptionPane.showMessageDialog(
            null,
            scrollPane,
            "Logged Habits",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Optional: Prints habits to the console for debugging.
     */
    public void printHabitsToConsole() {
        for (Map.Entry<Integer, Habit> entry : habitMap.entrySet()) {
            System.out.println("Day " + entry.getKey() + ": " + entry.getValue().getName());
        }
    }
}
