/**
 * Habit is an abstract class that represents a general habit with a name and date.
 * 
 * Other types of habits (like fitness or meal habits) will extend this class.
 * It includes common fields like name, date, and whether the habit is complete.
 * 
 * @author Amber Rama
 *
 * References:
 * https://www.w3schools.com/java/java_abstract.asp
 */
public abstract class Habit {
    protected String name;       // What the habit is (e.g., "Workout")
    protected String date;       // When it was logged (e.g., "2025-06-02")
    protected boolean isComplete; // If the habit has been marked as done

    /**
     * Constructor for Habit.
     * 
     * @param name the name or description of the habit
     * @param date the date the habit is associated with
     */
    public Habit(String name, String date) {
        this.name = name;
        this.date = date;
        this.isComplete = false;
    }

    /**
     * Abstract method that marks the habit as complete.
     * Subclasses must implement this based on their specific needs.
     */
    public abstract void markComplete();

    /**
     * @return the name of the habit
     */
    public String getName() {
        return name;
    }

    /**
     * @return the date of the habit
     */
    public String getDate() {
        return date;
    }

    /**
     * @return true if the habit is complete, false otherwise
     */
    public boolean isComplete() {
        return isComplete;
    }
}
