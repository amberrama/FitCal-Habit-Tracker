/**
 * FitnessHabit represents a workout or exercise habit.
 * It extends the base Habit class and adds details like
 * workout type and duration in minutes.
 *
 * @author Amber Rama
 *
 * References:
 * https://www.w3schools.com/java/java_inheritance.asp
 */
public class FitnessHabit extends Habit {
    private String type;     // Type of fitness activity (e.g., Cardio, Strength)
    private int duration;    // Duration in minutes

    /**
     * Creates a new FitnessHabit with name, date, type, and duration.
     * 
     * @param name     the name of the habit (e.g., "Morning Run")
     * @param date     the date it was done (e.g., "2025-06-02")
     * @param type     the type of activity (e.g., "Cardio")
     * @param duration how long the activity lasted (in minutes)
     */
    public FitnessHabit(String name, String date, String type, int duration) {
        super(name, date);
        this.type = type;
        this.duration = duration;
    }

    /**
     * Marks this fitness habit as complete.
     */
    @Override
    public void markComplete() {
        this.isComplete = true;
    }

    /**
     * @return the type of fitness activity
     */
    public String getType() {
        return type;
    }

    /**
     * @return the duration in minutes
     */
    public int getDuration() {
        return duration;
    }
}
