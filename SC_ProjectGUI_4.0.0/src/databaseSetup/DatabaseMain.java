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
public class DatabaseMain {

    private final DatabaseMainConnect dbManager;
    private final Connection conn;
    private Statement statement;
    private static final ArrayList<String> gameQuestion = new ArrayList<>();
    private static final ArrayList<String> gameAchoice = new ArrayList<>();
    private static final ArrayList<String> gameBchoice = new ArrayList<>();
    private static final ArrayList<String> gameCchoice = new ArrayList<>();
    private static final ArrayList<String> gameDchoice = new ArrayList<>();
    private static final ArrayList<String> gameAnswer = new ArrayList<>();

    public static ArrayList<String> getgameQuestion() {
        return gameQuestion;
    }

    public static ArrayList<String> getgameAchoice() {
        return gameAchoice;
    }

    public static ArrayList<String> getgameBchoice() {
        return gameBchoice;
    }

    public static ArrayList<String> getgameCchoice() {
        return gameCchoice;
    }

    public static ArrayList<String> getgameDchoice() {
        return gameDchoice;
    }

    public static ArrayList<String> getgameAnswer() {
        return gameAnswer;
    }

    public DatabaseMain() {
        NetworkServerControl server;
        try {
            server = new NetworkServerControl();
            server.start(null);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseInitialise.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbManager = new DatabaseMainConnect();
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

    public void writeSetupGame() {
        try {

            this.statement = conn.createStatement();
            this.checkExistedTable("PROMPT");
            this.statement.addBatch("CREATE TABLE PROMPT(QUESTION VARCHAR(50), ACHOICE VARCHAR(20), BCHOICE VARCHAR(20), CCHOICE VARCHAR(20), DCHOICE VARCHAR(20), ANSWER VARCHAR(20))");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Amagnetwouldmostlikelyattractwhichofthefollowing?', 'Metal', 'Plastic', 'Wood', 'Paper', 'Metal'),\n"
                    + "('WhatisthehardestRock?', 'Granite', 'Diamond', 'Sandstone', 'Marble', 'Diamond')");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "write prompt error!");
        }
    }

    public void initialiseSetupGame(ResultSet rs) {
        try {
            while (rs.next()) {
                this.gameQuestion.add(rs.getString("QUESTION"));
                this.gameAchoice.add(rs.getString("ACHOICE"));
                this.gameBchoice.add(rs.getString("BCHOICE"));
                this.gameCchoice.add(rs.getString("CCHOICE"));
                this.gameDchoice.add(rs.getString("DCHOICE"));
                this.gameAnswer.add(rs.getString("ANSWER"));
                //this.sortleaderboardRecord.put(rs.getString("NAME"), rs.getInt("SCORE"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "initialise setup is error");
        }
    }

    public ResultSet querySetupGame() {
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery("SELECT QUESTION, ACHOICE, BCHOICE, CCHOICE, DCHOICE, ANSWER"
                    + " FROM PROMPT");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "query setup is error");
        }
        return (rs);
    }

    public void displaySetupGame() {
        this.writeSetupGame();
        this.initialiseSetupGame(querySetupGame());
    }
}
