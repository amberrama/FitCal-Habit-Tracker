public class FitnessHabit extends Habit {
    private String type;
    private int duration; // in minutes

    public FitnessHabit(String name, String date, String type, int duration) {
        super(name, date);
        this.type = type;
        this.duration = duration;
    }

    @Override
    public void markComplete() {
        this.isComplete = true;
    }
    public String getType() {
            return type;
    }
    public int getDuration() {
        return duration;
    }

}
