package TestClasses;

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
public class LoginVariablesTest extends LoginVariables {

    //This is testing to see if the variables of username is functioning properly. I am trying to set the user name to Enrico and the expected out to Enrico
    //The test file confirms it works properly
    @Test
    public void testName() {

        LoginVariables.setUserName("Enrico");

        String expected = "Enrico";
        String actual = LoginVariables.getUserName();

        assertEquals(expected, actual);

    }

    //This test should return false as the expected output is different to the set input.
    @Test
    public void testNameFail() {

        LoginVariables.setUserName("Enrico");

        String expected = "Lara";
        String actual = LoginVariables.getUserName();

        assertEquals(expected, actual);

    }

    //Same as the function above, it is testing the variables of user score. 
    @Test
    public void testScore() {

        LoginVariables.setUserScore(300);

        int expected = 300;
        int actual = LoginVariables.getUserScore();

        assertEquals(expected, actual);

    }

    //This test should return false as the expected output is different to the set input.
    @Test
    public void testScoreFail() {

        LoginVariables.setUserScore(300);

        int expected = 500;
        int actual = LoginVariables.getUserScore();

        assertEquals(expected, actual);

    }
}
