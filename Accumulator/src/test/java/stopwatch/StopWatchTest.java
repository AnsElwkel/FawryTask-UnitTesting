package stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
    private StopWatch stopWatch;
    @BeforeEach public void init(){
        stopWatch = new StopWatch();
    }

    ///Passing Test => Record minutes
    @Test public void test1(){
        stopWatch.record(14);
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(14, minutes);
    }

    ///Passing Test => Ignore negative minutes
    @Test public void test2(){
        stopWatch.record(-5);
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(0, minutes);
    }

    ///Passing Test => Increase hours when minutes >= 60 == minutes must be < 60
    @Test public void test3(){
        stopWatch.record(60);
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(0, minutes);
    }

    //Passing Test => Increase day ,, since the requirements are to count minutes only
    //So this test already handling by previous cycle
    @Test public void test4(){
        stopWatch.record(StopWatch.DAILY_WORKING_HOURS * 60 + 2);
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(2, minutes);
    }

}
