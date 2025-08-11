package stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
    private StopWatch stopWatch;
    @BeforeEach public void init(){
        stopWatch = new StopWatch();
    }

    //Failing Test Case
    @Test public void test1(){
        stopWatch.record(14);
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(14, minutes);
    }

}
