package stopwatch;

public class StopWatch {
    int minutes, hours;
    public void record(int minutes) {
        if(minutes >= 0)
            this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
    public int getHours() { return hours; }
}
