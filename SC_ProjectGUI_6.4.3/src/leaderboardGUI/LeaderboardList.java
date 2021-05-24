/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leaderboardGUI;

import databaseSetup.DatabaseInitialise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Enrico
 */
public class LeaderboardList {

    private static ArrayList<String> nameList = new ArrayList<String>();
    private static ArrayList<Integer> scoreList = new ArrayList<Integer>();
    private static ArrayList<Integer> moneyEachQuestion = new ArrayList<>(Arrays.asList(100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 12500, 250000, 500000, 1000000));

    public static ArrayList<String> getNameList() {
        return nameList;
    }

    public static void setNameList(ArrayList<String> nameList) {
        LeaderboardList.nameList = nameList;
    }

    public static ArrayList<Integer> getScoreList() {
        return scoreList;
    }

    public static void setScoreList(ArrayList<Integer> scoreList) {
        LeaderboardList.scoreList = scoreList;
    }

    public static ArrayList<Integer> getMoneyEachQuestion() {
        return moneyEachQuestion;
    }

    public static void setMoneyEachQuestion(ArrayList<Integer> moneyEachQuestion) {
        LeaderboardList.moneyEachQuestion = moneyEachQuestion;
    }


    public LeaderboardList() {
        leaderboardSetup();
    }

    public void leaderboardSetup() {
        DatabaseInitialise ldb = new DatabaseInitialise();
        ldb.displayLeaderboard();

        Set<String> keySet = ldb.getSortleaderboardRecord().keySet();
        this.nameList = new ArrayList<String>(keySet);
        for (String key : this.nameList) {
            System.out.println(key);
        }
        Collection<Integer> values = ldb.getSortleaderboardRecord().values();
        this.scoreList = new ArrayList<Integer>(values);
        for (int value : this.scoreList) {
            System.out.println(value);
        }

    }
}
