package finalProject;

public class MealHabit extends Habit {
    private String mealType; // e.g. Breakfast, Lunch, Dinner
    private int calories;

    public MealHabit(String name, String date, String mealType, int calories) {
        super(name, date);
        this.mealType = mealType;
        this.calories = calories;
    }

    @Override
    public void markComplete() {
        this.isComplete = true;
    }

    public String getMealType() { return mealType; }
    public int getCalories() { return calories; }
}
