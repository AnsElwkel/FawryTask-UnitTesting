package stopwatch;

public class StopWatch {
    int minutes;
    public void record(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}
