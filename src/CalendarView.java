import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CalendarView extends JPanel {
    private JButton[][] buttons = new JButton[5][7];
    private Map<Integer, ArrayList<String>> habitMap = new HashMap<>();

    public CalendarView() {
        setLayout(new GridLayout(5, 7));
        int day = 1;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 7; col++) {
                JButton button = new JButton();

                if (day <= 30) {
                    final int currentDay = day;
                    button.setText(String.valueOf(currentDay));
                    button.setFont(new Font("Arial", Font.BOLD, 16));

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

                        String input = JOptionPane.showInputDialog(
                            null,
                            "Log a habit for Day " + currentDay + ":",
                            "Habit Tracker",
                            JOptionPane.PLAIN_MESSAGE
                        );

                        if (input != null && !input.trim().isEmpty()) {
                            habitMap.put(currentDay, new ArrayList<>(List.of(input)));
                            button.setText("✔ " + currentDay);
                        }
                    });

                    day++;
                } else {
                    button.setEnabled(false);
                }

                buttons[row][col] = button;
                add(button);
            }
        }

        // Create a wrapper panel with a button underneath
        JButton viewHabitsButton = new JButton("View Logged Habits");
        viewHabitsButton.addActionListener(e -> showLoggedHabitsDialog());

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(this, BorderLayout.CENTER);
        wrapper.add(viewHabitsButton, BorderLayout.SOUTH);

        // Display everything in a frame
        JFrame frame = new JFrame("FitCal - Habit Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setContentPane(wrapper);
        frame.setVisible(true);
    }

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
        for (Map.Entry<Integer, ArrayList<String>> entry : habitMap.entrySet()) {
            sb.append("Day ").append(entry.getKey()).append(": ");
            sb.append(String.join(", ", entry.getValue()));
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

    public void printHabitsToConsole() {
        for (Map.Entry<Integer, ArrayList<String>> entry : habitMap.entrySet()) {
            System.out.println("Day " + entry.getKey() + ":");
            for (String habit : entry.getValue()) {
                System.out.println("  - " + habit);
            }
        }
    }
}
