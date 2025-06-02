import java.util.ArrayList;

/**
 * HabitManager keeps track of all logged habits.
 * It provides a way to add and view all habit entries.
 * 
 * Author: Amber Rama
 */
public class HabitManager {
    private ArrayList<Habit> allHabits;

    /**
     * Creates a new HabitManager with an empty list of habits.
     */
    public HabitManager() {
        allHabits = new ArrayList<>();
    }

    /**
     * Adds a new habit to the list.
     * 
     * @param h The habit to add
     */
    public void addHabit(Habit h) {
        allHabits.add(h);
    }

    /**
     * Returns the full list of habits.
     * 
     * @return An ArrayList of all logged habits
     */
    public ArrayList<Habit> getAllHabits() {
        return allHabits;
    }

    // Note: In a future update, we could sort or filter habits here if needed.
}
