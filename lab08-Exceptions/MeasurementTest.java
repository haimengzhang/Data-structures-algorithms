import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by monsg on 7/1/2017.
 */
public class MeasurementTest {

    @Test
    public void testConstructor() {
        Measurement x = new Measurement ();
        assertTrue(x.getFeet() == 0 && x.getInches() == 0);
        Measurement y = new Measurement (2);
        assertTrue(y.getFeet() == 2 && y.getInches() == 0);
        Measurement z = new Measurement (3, 2);
        assertTrue(z.getFeet() == 3 && z.getInches() == 2);
    }

    @Test
    public void getFeet() throws Exception {
        Measurement x = new Measurement ();
        assertTrue(x.getFeet() == 0);
        Measurement y = new Measurement (2);
        assertTrue(y.getFeet() == 2);
        Measurement z = new Measurement (3, 2);
        assertTrue(z.getFeet() == 3);
    }

    @Test
    public void getInches() throws Exception {
        Measurement x = new Measurement ();
        assertTrue(x.getInches() == 0);
        Measurement y = new Measurement (2);
        assertTrue(y.getInches() == 0);
        Measurement z = new Measurement (3, 2);
        assertTrue(z.getInches() == 2);
    }

    @Test
    public void plus() throws Exception {
        Measurement x = new Measurement (1, 9);
        Measurement y = new Measurement (0, 3);
        y.plus(x);
        assertTrue(y.getFeet() == 2 && y.getInches() == 0);
    }

    @Test
    public void minus() throws Exception {
        Measurement x = new Measurement (1, 9);
        Measurement y = new Measurement (0, 10);
        x.minus(y);
        assertTrue(x.getFeet() == 0 && x.getInches() == 11);
    }

    @Test
    public void multiple() throws Exception {
        Measurement x = new Measurement (2, 5);
        x.multiple(2);
        assertTrue(x.getFeet() == 4 && x.getInches() == 10);
    }

}