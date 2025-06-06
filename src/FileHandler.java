import java.io.*;
import java.util.ArrayList;

/**
 * FileHandler provides methods to save and load habits to/from a text file.
 * 
 * @author Amber Rama
 */
public class FileHandler {

    /**
     * Saves a list of Habit objects to a text file.
     * Each habit is saved in one line: Type|Name|Date|Extra1|Extra2
     * 
     * @param habits   the list of habits to save
     * @param filename the name of the file to write to
     */
    public static void saveHabits(ArrayList<Habit> habits, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Habit h : habits) {
                if (h instanceof MealHabit) {
                    MealHabit mh = (MealHabit) h;
                    writer.println("Meal|" + mh.getName() + "|" + mh.getDate() + "|" + mh.getMealType() + "|" + mh.getCalories());
                } else if (h instanceof FitnessHabit) {
                    FitnessHabit fh = (FitnessHabit) h;
                    writer.println("Fitness|" + fh.getName() + "|" + fh.getDate() + "|" + fh.getType() + "|" + fh.getDuration());
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving habits: " + e.getMessage());
        }
    }

    /**
     * Loads habits from a text file and returns them as a list of Habit objects.
     * 
     * @param filename the name of the file to read from
     * @return an ArrayList of Habit objects (MealHabit or FitnessHabit)
     */
    public static ArrayList<Habit> loadHabits(String filename) {
        ArrayList<Habit> loadedHabits = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    String type = parts[0];
                    String name = parts[1];
                    String date = parts[2];

                    if (type.equals("Meal")) {
                        String mealType = parts[3];
                        int calories = Integer.parseInt(parts[4]);
                        loadedHabits.add(new MealHabit(name, date, mealType, calories));
                    } else if (type.equals("Fitness")) {
                        String workoutType = parts[3];
                        int duration = Integer.parseInt(parts[4]);
                        loadedHabits.add(new FitnessHabit(name, date, workoutType, duration));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading habits: " + e.getMessage());
        }

        return loadedHabits;
    }
}