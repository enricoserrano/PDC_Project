/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import leaderboardGUI.LeaderboardList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This testing class is testing the leader board (user score)
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class LeaderboardScoreTest {

    //This is testing the arraylist (score) for the leaderboard variables. In the program, it is only showing the top 3 of this arraylist
    @Test
    public void testLeaderboardArrayScore() {

        ArrayList<Integer> scoreTest = new ArrayList<Integer>();
        scoreTest.add(100);
        scoreTest.add(300);
        scoreTest.add(500);

        LeaderboardList.setScoreList(scoreTest);

        ArrayList<Integer> expectedTest = new ArrayList<Integer>();
        expectedTest.add(100);
        expectedTest.add(300);
        expectedTest.add(500);

        assertEquals(scoreTest, expectedTest);
    }

    //This test should return false as the expected output is not the same as the input
    @Test
    public void testLeaderboardArrayScoreFail() {

        ArrayList<Integer> scoreTest = new ArrayList<Integer>();
        scoreTest.add(100);
        scoreTest.add(300);
        scoreTest.add(500);

        LeaderboardList.setScoreList(scoreTest);

        ArrayList<Integer> expectedTest = new ArrayList<Integer>();
        expectedTest.add(500);
        expectedTest.add(300);
        expectedTest.add(500);

        assertEquals(scoreTest, expectedTest);
    }
}
