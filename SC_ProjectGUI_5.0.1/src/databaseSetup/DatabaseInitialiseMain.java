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
public class DatabaseInitialiseMain {

    private final DatabaseConnectMain dbManager;
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

    public DatabaseInitialiseMain() {
        NetworkServerControl server;
        try {
            server = new NetworkServerControl();
            server.start(null);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseInitialise.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbManager = new DatabaseConnectMain();
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
            this.statement.addBatch("CREATE TABLE PROMPT(QUESTION VARCHAR(3000), ACHOICE VARCHAR(30), BCHOICE VARCHAR(30), CCHOICE VARCHAR(30), DCHOICE VARCHAR(30), ANSWER VARCHAR(30))");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the hardest Rock?', 'Granite', 'Diamond', 'Sandstone', 'Marble', 'Diamond')");//Level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('A magnet would most likely attract which of the following?', 'Metal', 'Plastic', 'Wood', 'Paper', 'Metal')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('By definition, a 10-speed bike has 10 what?', 'Wheels', 'Spokes', 'Gears', 'Lives', 'Gears')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which of these toys have been marketed with the phrase \"robots in disguise\"?', 'Transformers', 'Bratz Doll', 'Gundam', 'Lego', 'Transformers')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the capital of the Philippines?', 'Baguio', 'Quezon City', 'Cebu', 'Manilla', 'Manilla')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which is the highest voice part?', 'Baritone', 'Alto', 'Soprano', 'Tenor', 'Soprano')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('The presidency of Barack Obama started in which year?', '2009', '2012', '2015', '2007', '2009')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which of these famous landmarks was constructed first?', 'Statue of Liberty', 'Great Wall of China', 'Eiffel Tower', 'Big Ben Clock Tower', 'Big Ben Clock Tower')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the smallest type of tree in the world ?', 'Cork Tree', 'Bonsai Tree', 'Hazel', 'Black Walnut', 'Bonsai Tree')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('In which of these films does Whoopi Goldberg dress up as a nun?', 'Sister Act', 'Batman vs Superman', 'Avengers', 'Gladiator', 'Sister Act')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('what does the word loquacious mean?', 'Angry', 'Chatty', 'Beautiful', 'Shy', 'Chatty')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the name for the Jewish New Year?', 'Hanukkah', 'Yom Kippur', 'Kwanza', 'Rosh Hashanah', 'Rosh Hashanah')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which one of these characters is not friends with Harry Potter?', 'Ron Weasley', 'Neville Longbottom', 'Draco Malfoy', 'Hermione Granger', 'Draco Malfoy')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the color of Donald Duck’s bowtie?', 'Red', 'Yellow', 'Blue', 'White', 'Red')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What was the name of the band Lionel Richie was a part of?', 'King Harvert', 'Spectrums', 'Commodores', 'The Marshall Tucker Band', 'Commodores')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which country held the 2016 Summer Olympics?', 'China', 'Ireland', 'Brazil', 'Italy', 'Brazil')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which planet is the hottest?', 'Venus', 'Saturn', 'Mercury', 'Mars', 'Venus')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('In Pirates of the Caribbean, what was Captain Jack Sparrow’s ship’s name?', 'The Marauder', 'The Black Pearl', 'The Black Python', 'The Slytherin', 'The Black Pearl')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the rarest blood type?', 'O', 'A', 'B', 'AB-Negative', 'AB-Negative')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Fe is the chemical symbol for…', 'Zinc', 'Hydrogen', 'Fluorine', 'Iron', 'Iron')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What language is the most spoken worldwide?', 'Chinese', 'Spanish', 'Arabic', 'English', 'English')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is Shakespeare’s shortest tragedy?', 'Macbeth', 'Hamlet', 'Romeo & Juliet', 'Othello', 'Macbeth')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('How many hearts does an octopus have?', '1', '2', '3', '4', '3')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Who painted the Sistine Chapel ceiling?', 'Picasso', 'Da Vinci', 'Michelangelo', 'Van Gogh', 'Michelangelo')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which ocean is the largest?', 'Indian', 'Pacific', 'Atlantic ', 'Arctic', 'Pacific')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('In the Bible, how does the Virgin Mary learn of her pregnancy with baby Jesus?', 'God tells her', 'the angel Gabriel tells her', 'she has a dream about it', 'a doctor tells her', 'the angel Gabriel tells her')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('How many days are in February during a leap year?', '28', '29', '30', '31', '29')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('How many elements are there on the periodic table?', '112', '118', '120', '143', '118')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is a group of lions called?', 'Squad', 'Pack', 'Herd', 'Pride', 'Pride')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('The abbreviation WHO stands for World what Organization?', 'Humanity', 'Health', 'Hygiene', 'Household', 'Health')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which country consumes the most chocolate?', 'Spain', 'Germany', 'North America', 'Switzerland', 'Switzerland')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the longest river in the world?', 'Amazon', 'Congo', 'Nile', 'Hudson', 'Nile')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Which of these touches both Africa and Australia?', 'Pacific Ocean', 'Atlantic Ocean', 'Indian Ocean', 'Arctic Ocean', 'Indian Ocean')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('ALASKA is to 474324 as 744342 is to:', 'LAASAK', 'LAAKAS', 'SAALAK', 'KAASAL', 'LAASAK')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Usher found a young boy singing on YouTube and made him into a famous singer. What’s that kid’s name?', 'Niall Horan', 'Jaden Smith', 'Shawn Mendes', 'Justin Bieber', 'Justin Bieber')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What would be a synonym of an antonym for \"Enormous\"?', 'Big', 'Gigantic', 'Tiny', 'Sizable', 'Tiny')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the complementary color of green?', 'Blue', 'Yellow', 'Red', 'Purple', 'Red')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('Where is the United Nations Headquarters?', 'D.C.', 'NYC', 'Philadelphia', 'Orlando', 'NYC')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What is the deadliest snake?', 'Python', 'Cobra', 'Ribbon Snake', 'Black Mamba', 'Black Mamba')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('How many keys are on a piano?', '86', '87', '88', '90', '88')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('What was the name of the Greek mythological woman who had snakes for hair?', 'Pandora', 'Helen', 'Cassiopeia', 'Medusa', 'Medusa')");//level 2
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
