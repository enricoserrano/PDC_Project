/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseSetup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author Enrico
 */
public class DatabaseInitialise {

    private final DatabaseConnect dbManager;
    private final Connection conn;
    private Statement statement;
    private static final LinkedHashMap<String, Integer> sortleaderboardRecord = new LinkedHashMap<>();

    public static LinkedHashMap<String, Integer> getSortleaderboardRecord() {
        return sortleaderboardRecord;
    }

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

    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmb = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmb.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "check listed table is error");
        }

    }

    public void writeLeaderboard() {
        try {

            this.statement = conn.createStatement();
            this.checkExistedTable("LEADERBOARD");
            this.statement.addBatch("CREATE TABLE LEADERBOARD(NAME VARCHAR(20), SCORE INT)");
            this.statement.addBatch("INSERT INTO LEADERBOARD VALUES('Enrico', 4000),\n"
                    + "('Bradley', 200),\n"
                    + "('Shakeer', 1000000),\n"
                    + "('Rocky', 500000),\n"
                    + "('Kyle', 500)");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "write leaderboard error!");
        }
    }

    public ResultSet queryLeaderboard() {
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery("SELECT NAME, SCORE"
                    + " FROM LEADERBOARD"
                    + " ORDER BY SCORE DESC");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "query table is error");
        }
        return (rs);
    }

    public void initialiseLeaderboard(ResultSet rs) {
        try {
            while (rs.next()) {
                this.sortleaderboardRecord.put(rs.getString("NAME"), rs.getInt("SCORE"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "result  table is error");
        }
    }

    public void displayLeaderboard() {
        this.writeLeaderboard();
        this.initialiseLeaderboard(queryLeaderboard());

    }

}
