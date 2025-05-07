package finalProject;
public abstract class Habit {
    protected String name;
    protected String date;
    protected boolean isComplete;

    public Habit(String name, String date) {
        this.name = name;
        this.date = date;
        this.isComplete = false;
    }

    public abstract void markComplete();

    public String getName() { return name; }
    public String getDate() { return date; }
    public boolean isComplete() { return isComplete; }
}
