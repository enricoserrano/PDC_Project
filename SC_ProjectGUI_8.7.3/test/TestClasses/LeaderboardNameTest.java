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
import userGUI.LoginVariables;

/**
 *
 * @author Enrico
 */
public class LeaderboardNameTest {

    //This is testing the arraylist (name) for the leaderboard variables. In the program, it is only showing the top 3 of this arraylist
    @Test
    public void testLeaderboardArrayName() {

        ArrayList<String> nameTest = new ArrayList<String>();
        nameTest.add("Lean");
        nameTest.add("Superman");
        nameTest.add("John");

        LeaderboardList.setNameList(nameTest);

        ArrayList<String> expectedTest = new ArrayList<String>();
        expectedTest.add("Lean");
        expectedTest.add("Superman");
        expectedTest.add("John");

        assertEquals(nameTest, expectedTest);
    }

    //This should return false as the expected ouput isnt the same as the input
    @Test
    public void testLeaderboardArrayNameFail() {

        ArrayList<String> nameTest = new ArrayList<String>();
        nameTest.add("Lean");
        nameTest.add("Superman");
        nameTest.add("John");

        LeaderboardList.setNameList(nameTest);

        ArrayList<String> expectedTest = new ArrayList<String>();
        expectedTest.add("Lean");
        expectedTest.add("Batman");
        expectedTest.add("John");

        assertEquals(nameTest, expectedTest);
    }
}
