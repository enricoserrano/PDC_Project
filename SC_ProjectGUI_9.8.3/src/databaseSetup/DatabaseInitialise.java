package databaseSetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.drda.NetworkServerControl;

/**
 *This class is setting up the leader board database.
 * @author Enrico Serrano 19071299, John Chea 16938895, Leandro Machado 18041563
 */
public class DatabaseInitialise {

    private final DatabaseConnect dbManager;
    private final Connection conn;
    private Statement statement;
    private static final LinkedHashMap<String, Integer> sortleaderboardRecord = new LinkedHashMap<>();

    public static LinkedHashMap<String, Integer> getSortleaderboardRecord() {
        return sortleaderboardRecord;
    }
/**
 * This method is initializing our database for the leader board information.
 */
    public DatabaseInitialise() {
        NetworkServerControl server;
        try {
            server = new NetworkServerControl();
            server.start(null);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseInitialise.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbManager = new DatabaseConnect();
        conn = dbManager.getConnection();
    }
/**
 * This method is used to save the leader board information.
 * @param name: using the parameter string for the username
 * @param score: using the parameter integer to retrieve the user score
 */
    public void saveLeaderBoard(String name, int score) {
        try {
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO LEADERBOARD VALUES('" + name + "', " + score + ")");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " Unable to save information to leaderboard!");
        }
    }
/**
 * This method is used to create the leader board. 
 */
    public void writeLeaderboard() {
        try {

            this.statement = conn.createStatement();
            this.statement.addBatch("CREATE TABLE LEADERBOARD(NAME VARCHAR(20), SCORE INT)");
            /*
            this.statement.addBatch("INSERT INTO LEADERBOARD VALUES('Enrico', 300),\n"
                    + "('Leandro', 200),\n"
                    + "('Enrico', 300),\n"
                    + "('Rocky', 500),\n"
                    + "('John', 100)");
             */
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Leaderboard already exists! Reading the current database....");
        }
    }
/**
 * In this function we are selecting all the information from our database and saving them into our resultSet.
 * @return : it will return the information from the database.
 */
    public ResultSet queryLeaderboard() {
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery("SELECT NAME, SCORE"
                    + " FROM LEADERBOARD"
                    + " ORDER BY SCORE DESC");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " Unable to query the leaderboard table!");
        }
        return (rs);
    }
/**
 * In this method we will be initializing the leader board. We are prompt if a problem arise using an exception to handle the issue, in case the leader board cannot be initialized.
 * @param rs:
 */
    public void initialiseLeaderboard(ResultSet rs) {
        try {
            while (rs.next()) {
                this.sortleaderboardRecord.put(rs.getString("NAME"), rs.getInt("SCORE"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " Unable to write leaderboard information to the program!");
        }
    }
/**
 * This method is getting information from both the writing leader board and initialize leader board function.
 */
    public void displayLeaderboard() {
        this.writeLeaderboard();
        this.initialiseLeaderboard(queryLeaderboard());

    }

}
