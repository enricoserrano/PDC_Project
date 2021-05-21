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

    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<Integer> scoreList = new ArrayList<Integer>();
    private ArrayList<Integer> moneyEachQuestion = new ArrayList<>(Arrays.asList(100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 12500, 250000, 500000, 1000000));

    public ArrayList<Integer> getMoneyEachQuestion() {
        return moneyEachQuestion;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public void setNameList(String name) {
        this.nameList.add(name);
    }

    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(int score) {
        this.scoreList.add(score);
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
        /*
        //ldb.getSortleaderboardRecord();
        for (Map.Entry<String, Integer> entry : ldb.getSortleaderboardRecord().entrySet()) {
            String name = (entry.getKey());
            int score = (entry.getValue());
            //ldbl = new LeaderboardList(name, score);
            ldbl.setNameList(name);
            ldbl.setScoreList(score);
            //ldbl(name, score);

            System.out.println(entry.getKey() + "   " + entry.getValue());
            System.out.println();

        }

    }
         */

    }
}
