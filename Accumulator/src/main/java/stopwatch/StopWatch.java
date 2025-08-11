package stopwatch;

public class StopWatch {
    int minutes;
    public void record(int minutes) {
        if(minutes >= 0)
            this.minutes = minutes;

        this.minutes %= 60;
    }

    public int getMinutes() {
        return minutes;
    }
}
