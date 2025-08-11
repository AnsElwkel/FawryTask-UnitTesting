package accumulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccumulatorTestCase {
    //Red Phase
    //Test Cases
    //11 -> 1 (Failing Test)
    //0 -> 0
    //10 -> 0 (Failing Test)
    //5 -> 5

    private Accumulator acc;

    @BeforeEach
    public void init(){
        acc = new Accumulator();
    }

    @Test
    public void test1(){
        int res = acc.add(11);
        assertEquals(1, res);
    }

    @Test
    public void test3(){
        int res = acc.add(10);
        assertEquals(0, res);
    }

}
