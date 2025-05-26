import java.util.ArrayList;

public class HabitManager {
    private ArrayList<Habit> allHabits;

    public HabitManager() {
        allHabits = new ArrayList<>();
    }

    public void addHabit(Habit h) {
        allHabits.add(h);
    }

    public ArrayList<Habit> getAllHabits() {
        return allHabits;
    }

    // TODO Sort by date and load into calendar
}
