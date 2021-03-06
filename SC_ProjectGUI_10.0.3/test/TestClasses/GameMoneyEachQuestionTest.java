package TestClasses;

import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import leaderboardGUI.LeaderboardList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This testing class is testing to see if the money earned per question is
 * working properly so it can be used in the leader board and for the players
 * information
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class GameMoneyEachQuestionTest {

    //Testing to see if prizemoney earned per question is right 
    //This should return true
    //100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 12500, 250000, 500000, 1000000
    //3 in the list = 500;
    @Test
    public void testMoneyEachQuestion() {

        int prizemoneyEachQ = LeaderboardList.getMoneyEachQuestion().get(3);
        int expected = 500;
        assertEquals(prizemoneyEachQ, expected);
    }

    //This should return false
    @Test
    public void testMoneyEachQuestionFail() {

        int prizemoneyEachQ = LeaderboardList.getMoneyEachQuestion().get(3);
        int expected = 200;
        assertEquals(prizemoneyEachQ, expected);
    }
}
