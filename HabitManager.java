import java.util.ArrayList;

public class HabitManager {
    private ArrayList<Habit> habits;

    public HabitManager() {
        habits = new ArrayList<>();
    }

    public void addHabit(Habit h) {
        habits.add(h);
    }

    // More methods to be added...
}
