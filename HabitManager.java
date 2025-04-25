import java.util.ArrayList;

public class HabitManager {
    private ArrayList<Habit> habits;

    public HabitManager() {
        habits = new ArrayList<>();
    }

    public void addHabit(Habit h) {
        habits.add(h);
    }

    public ArrayList<Habit> getHabits() {
        return habits;
    }

    // TODO: Need to find a better way to link habits to specific calendar days.
    // Challenge: Habits aren't organized by date yet; will figure out in Week 4.
}
