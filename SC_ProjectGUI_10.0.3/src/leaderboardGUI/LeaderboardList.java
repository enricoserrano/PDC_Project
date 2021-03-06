package leaderboardGUI;

import databaseSetup.DatabaseInitialise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class is being used in the leader board screen to display the leader board information
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class LeaderboardList {

    private static ArrayList<String> nameList = new ArrayList<String>();
    private static ArrayList<Integer> scoreList = new ArrayList<Integer>();
    private static Map<String, Integer> Leaderboard = new LinkedHashMap<String, Integer>();
    private static Map<String, Integer> sortedLeaderboard = new LinkedHashMap<String, Integer>();
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

    public static Map<String, Integer> getLeaderboard() {
        return Leaderboard;
    }

    public static void setLeaderboard(Map<String, Integer> Leaderboard) {
        LeaderboardList.Leaderboard = Leaderboard;
    }

    public static Map<String, Integer> getSortedLeaderboard() {
        return sortedLeaderboard;
    }

    public static void setSortedLeaderboard(Map<String, Integer> sortedLeaderboard) {
        LeaderboardList.sortedLeaderboard = sortedLeaderboard;
    }

    public void clearhashmap() {
        this.sortedLeaderboard.clear();
    }

    public LeaderboardList() {
        leaderboardSetup();
    }

    /**
     * This function is gathering information from the database (queried) and saving them into variables
     * It also saves  them into a linked hash map which orders from highest to lowest (top 3)
     */
    public void leaderboardSetup() {
        DatabaseInitialise ldb = new DatabaseInitialise();
        ldb.displayLeaderboard();

        Set<String> keySet = ldb.getSortleaderboardRecord().keySet();
        this.nameList = new ArrayList<String>(keySet);

        Collection<Integer> values = ldb.getSortleaderboardRecord().values();
        this.scoreList = new ArrayList<Integer>(values);

        for (int i = 0; i < this.nameList.size(); i++) {
            this.Leaderboard.put(this.nameList.get(i), this.scoreList.get(i));
        }
        //sorting the leaderboard from highest and puttign it into sorted leaderboard
        this.Leaderboard.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> this.sortedLeaderboard.put(x.getKey(), x.getValue()));
    }

}
