/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import gameGUI.ContinueVariables;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import userGUI.LoginVariables;

/**
 *
 * @author Enrico
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
