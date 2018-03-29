import static org.junit.Assert.*;

/**
 * Created by monsg on 7/1/2017.
 */
public class ModNCounterTest {

    @org.junit.Test
    public void testConstructor() {
        ModNCounter c = new ModNCounter(2);
        assertTrue(c.value() == 0);
    }

    @org.junit.Test
    public void testIncrement() throws Exception {
        ModNCounter c = new ModNCounter(2);
        c.increment();
        assertTrue(c.value()  == 1);
        c.increment();
        assertTrue(c.value() == 0);
    }

    @org.junit.Test
    public void testReset() throws Exception {
        ModNCounter c = new ModNCounter(2);
        c.increment();
        c.reset();
        assertTrue(c.value() == 0);
    }
}