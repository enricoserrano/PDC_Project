package TestClasses;

import gameGUI.ContinueVariables;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import userGUI.LoginVariables;

/**
 * This testing class is testing to see if the set money from the continue
 * variables is working properly
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class ContinueVariablesTest {

    //This is testing the money display in the continue screen. The continue screen displays the current money of the user.
    //This test should return true as the set money is the same as the expected output
    @Test
    public void testPrizeMoney() {
        ContinueVariables.setMoney(500);

        int expected = 500;
        int actual = ContinueVariables.getMoney();

        assertEquals(expected, actual);
    }

    //This should return false
    @Test
    public void testPrizeMoneyFail() {
        ContinueVariables.setMoney(400);

        int expected = 500;
        int actual = ContinueVariables.getMoney();

        assertEquals(expected, actual);
    }
}
