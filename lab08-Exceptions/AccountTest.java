import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by monsg on 7/1/2017.
 */
public class AccountTest {
    @org.junit.Test
    public void testInit() throws Exception {
        Account c = new Account(3);
        assertTrue(c.getBalance() == 3);
    }

    @Test
    public void testInvalidArgs() throws Exception {
        Account c = new Account(3);
        c.deposit(-2);
        assertTrue(c.getBalance() == 3);
    }

    @Test
    public void testOverdraft() throws Exception {
        Account c = new Account(3);
        c.withdraw(4);
        assertTrue(c.getBalance() == 3);
    }

    @Test
    public void testDeposit() throws Exception {
        Account c = new Account(3);
        c.deposit(1);
        assertTrue(c.getBalance() == 4);
    }

    @Test
    public void testWithdraw() throws Exception {
        Account c = new Account(3);
        c.withdraw(1);
        assertTrue(c.getBalance() == 2);
    }


}