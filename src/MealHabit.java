/**
 * MealHabit represents a meal tracking habit like logging breakfast or lunch.
 * It extends the base Habit class and adds info like meal type and calories.
 *
 * @author Amber Rama
 *
 * References:
 * https://www.w3schools.com/java/java_inheritance.asp
 */
public class MealHabit extends Habit {
    private String mealType; // e.g. Breakfast, Lunch, Dinner
    private int calories;

    /**
     * Constructor for MealHabit.
     * 
     * @param name      the name or description of the habit
     * @param date      the date this meal habit was logged
     * @param mealType  the type of meal (e.g. "Lunch")
     * @param calories  how many calories were in the meal
     */
    public MealHabit(String name, String date, String mealType, int calories) {
        super(name, date);
        this.mealType = mealType;
        this.calories = calories;
    }

    /**
     * Marks the meal habit as complete.
     */
    @Override
    public void markComplete() {
        this.isComplete = true;
    }

    /**
     * @return the type of meal (Breakfast, Lunch, Dinner)
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * @return the calorie count of the meal
     */
    public int getCalories() {
        return calories;
    }
}
