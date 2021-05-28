package databaseSetup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.drda.NetworkServerControl;

/**
 *This Class is made to handle the initialization of the database for the questions in the game and also the answers.
 * @author Enrico Serrano 19071299, John Chea 16938895, Leandro Machado 18041563
 */
public class DatabaseInitialiseMain {

    private final DatabaseConnectMain dbManager;
    private final Connection conn;
    private Statement statement;
    private static final ArrayList<String> gameDifficulty = new ArrayList<>();
    private static final ArrayList<String> gameQuestion = new ArrayList<>();
    private static final ArrayList<String> gameAchoice = new ArrayList<>();
    private static final ArrayList<String> gameBchoice = new ArrayList<>();
    private static final ArrayList<String> gameCchoice = new ArrayList<>();
    private static final ArrayList<String> gameDchoice = new ArrayList<>();
    private static final ArrayList<String> gameAnswer = new ArrayList<>();

    public static ArrayList<String> getgameDifficulty() {
        return gameDifficulty;
    }

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
/**
 * In this function 
 */
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
/**
 * In this function we will check the existence of a table and if the table does exist the table will be dropped.
 * @param name: is the name of the database table. 
 */
    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmb = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmb.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " Table already exists!");
        }

    }
/**
 * In this function we will create a table for our questions and answers, every column value will be set in each line.
 */
    public void writeSetupGame() {
        try {

            this.statement = conn.createStatement();
            this.checkExistedTable("PROMPT");
            this.statement.addBatch("CREATE TABLE PROMPT(DIFFICULTY VARCHAR(1), QUESTION VARCHAR(3000), ACHOICE VARCHAR(30), BCHOICE VARCHAR(30), CCHOICE VARCHAR(30), DCHOICE VARCHAR(30), ANSWER VARCHAR(30))");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', What is the hardest Rock?', 'Granite', 'Diamond', 'Sandstone', 'Marble', 'Diamond')");//Level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'A magnet would most likely attract which of the following?', 'Metal', 'Plastic', 'Wood', 'Paper', 'Metal')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'By definition, a 10-speed bike has 10 what?', 'Wheels', 'Spokes', 'Gears', 'Lives', 'Gears')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which of these toys have been marketed with the phrase \"robots in disguise\"?', 'Transformers', 'Bratz Doll', 'Gundam', 'Lego', 'Transformers')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is the capital of the Philippines?', 'Baguio', 'Quezon City', 'Cebu', 'Manilla', 'Manilla')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which is the highest voice part?', 'Baritone', 'Alto', 'Soprano', 'Tenor', 'Soprano')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'The presidency of Barack Obama started in which year?', '2009', '2012', '2015', '2007', '2009')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which of these famous landmarks was constructed first?', 'Statue of Liberty', 'Great Wall of China', 'Eiffel Tower', 'Big Ben Clock Tower', 'Big Ben Clock Tower')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is the smallest type of tree in the world ?', 'Cork Tree', 'Bonsai Tree', 'Hazel', 'Black Walnut', 'Bonsai Tree')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'In which of these films does Whoopi Goldberg dress up as a nun?', 'Sister Act', 'Batman vs Superman', 'Avengers', 'Gladiator', 'Sister Act')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'what does the word loquacious mean?', 'Angry', 'Chatty', 'Beautiful', 'Shy', 'Chatty')");//level1
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is the name for the Jewish New Year?', 'Hanukkah', 'Yom Kippur', 'Kwanza', 'Rosh Hashanah', 'Rosh Hashanah')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which one of these characters is not friends with Harry Potter?', 'Ron Weasley', 'Neville Longbottom', 'Draco Malfoy', 'Hermione Granger', 'Draco Malfoy')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is the color of Donald Duck’s bowtie?', 'Red', 'Yellow', 'Blue', 'White', 'Red')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What was the name of the band Lionel Richie was a part of?', 'King Harvert', 'Spectrums', 'Commodores', 'The Marshall Tucker Band', 'Commodores')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which country held the 2016 Summer Olympics?', 'China', 'Ireland', 'Brazil', 'Italy', 'Brazil')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which planet is the hottest?', 'Venus', 'Saturn', 'Mercury', 'Mars', 'Venus')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'In Pirates of the Caribbean, what was Captain Jack Sparrow’s ship’s name?', 'The Marauder', 'The Black Pearl', 'The Black Python', 'The Slytherin', 'The Black Pearl')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is the rarest blood type?', 'O', 'A', 'B', 'AB-Negative', 'AB-Negative')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Fe is the chemical symbol for…', 'Zinc', 'Hydrogen', 'Fluorine', 'Iron', 'Iron')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What language is the most spoken worldwide?', 'Chinese', 'Spanish', 'Arabic', 'English', 'English')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is Shakespeare’s shortest tragedy?', 'Macbeth', 'Hamlet', 'Romeo & Juliet', 'Othello', 'Macbeth')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'How many hearts does an octopus have?', '1', '2', '3', '4', '3')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Who painted the Sistine Chapel ceiling?', 'Picasso', 'Da Vinci', 'Michelangelo', 'Van Gogh', 'Michelangelo')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which ocean is the largest?', 'Indian', 'Pacific', 'Atlantic ', 'Arctic', 'Pacific')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'In the Bible, how does the Virgin Mary learn of her pregnancy with baby Jesus?', 'God tells her', 'the angel Gabriel tells her', 'she has a dream about it', 'a doctor tells her', 'the angel Gabriel tells her')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'How many days are in February during a leap year?', '28', '29', '30', '31', '29')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'How many elements are there on the periodic table?', '112', '118', '120', '143', '118')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'What is a group of lions called?', 'Squad', 'Pack', 'Herd', 'Pride', 'Pride')");//level
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'The abbreviation WHO stands for World what Organization?', 'Humanity', 'Health', 'Hygiene', 'Household', 'Health')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('1', 'Which country consumes the most chocolate?', 'Spain', 'Germany', 'North America', 'Switzerland', 'Switzerland')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'What is the longest river in the world?', 'Amazon', 'Congo', 'Nile', 'Hudson', 'Nile')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'Which of these touches both Africa and Australia?', 'Pacific Ocean', 'Atlantic Ocean', 'Indian Ocean', 'Arctic Ocean', 'Indian Ocean')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'ALASKA is to 474324 as 744342 is to:', 'LAASAK', 'LAAKAS', 'SAALAK', 'KAASAL', 'LAASAK')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'Usher found a young boy singing on YouTube and made him into a famous singer. What’s that kid’s name?', 'Niall Horan', 'Jaden Smith', 'Shawn Mendes', 'Justin Bieber', 'Justin Bieber')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'What would be a synonym of an antonym for \"Enormous\"?', 'Big', 'Gigantic', 'Tiny', 'Sizable', 'Tiny')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'What is the complementary color of green?', 'Blue', 'Yellow', 'Red', 'Purple', 'Red')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'Where is the United Nations Headquarters?', 'D.C.', 'NYC', 'Philadelphia', 'Orlando', 'NYC')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'What is the deadliest snake?', 'Python', 'Cobra', 'Ribbon Snake', 'Black Mamba', 'Black Mamba')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'How many keys are on a piano?', '86', '87', '88', '90', '88')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'What was the name of the Greek mythological woman who had snakes for hair?', 'Pandora', 'Helen', 'Cassiopeia', 'Medusa', 'Medusa')");//level 2
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'The Da Vinci Code opens with a murder in which museum:', 'The Guggenheim', 'The Louvre', 'The Van Gogh museum', 'The Metropolitan Museum of Art', 'The Louvre')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'Which of the following men does not have a chemical element named for him?', 'Albert Einstein', 'Niels Bohr', 'Isaac Newton', 'Enrico Fermi', 'Isaac Newton')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'What letter must appear on the beginning of the registration number of all nonmilitary aircraft in the US?', 'N', 'A', 'U', 'L', 'N')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'During WWII, US soldiers used the first commercial aerosol cans to hold what ?', 'Cleaning Fluid', 'Antiseptic', 'Insecticide', 'Shaving cream', 'Insecticide')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'Which of the following landlocked countries is entirely contained within another country?', 'Lesotho', 'Burkina Faso', 'Mongolia', 'Luxembourg', 'Lesotho')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('2', 'Which of these U.S Presidents appeared on the television series \"Laugh In\"?', 'Lyndon Johnson', 'Richard Nixon', 'Jimmy Carter', 'Gerald Ford', 'Richard Nixon')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'The Earth is approximately how many miles away from the Sun?', '9.3 million', '39 million', '93 million', '193 million', '93 million')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'Who wrote The Scarlett Letter?', 'Shakespeare', 'Stephen King', 'Nathanial Hawthorne', 'Ernest Hemingway', 'Nathanial Hawthorne')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'In which city were Anne Frank and her family in hiding?', 'Paris', 'Amsterdam', 'Brussels', 'Frankfurt', 'Amsterdam')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'Emetophobia is the fear of?', 'Seeing the Light', 'Flying', 'Vomiting', 'Dogs', 'Vomiting')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'what is one half of one third of one third of 990', '50', '35', '55', '45', '55')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', '\"Nephelococcygia\" is the practice of doing what ', 'Finding', 'Sneezing with your eyes open', 'Breaking glass with your voice', 'Swimming in freezing water', 'Finding')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'According to the Population Reference Bureau, what is the approximate number of people who have ever lived on Earth?', '50 billion', '100 billion', '1 trillion', '5 trillion', '100 billion')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'What insect shorted out an early supercomputer and inspired the term \"computer bug\"?', 'Roach', 'Fly', 'Japanese Beetle', 'Moth', 'Moth')");
            this.statement.addBatch("INSERT INTO PROMPT VALUES('3', 'Compiled by Benjamin Franklin in 1737, \"The Drinker's Dictionary\" included all but which of these synonyms for \"drunkenness\"?', 'Nimptopsical', 'Buzzey', 'Pifflicated', 'Staggerish', 'Pifflicated')");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Setup Game already exists! Reading the current database....");
        }
    }
/**\
 * In this function we are saving the database information into the correct variables.
 * @param rs: is the database parameter imported from QuerySetupGame().
 */
    public void initialiseSetupGame(ResultSet rs) {
        try {
            while (rs.next()) {
                this.gameDifficulty.add(rs.getString("DIFFICULTY"));
                this.gameQuestion.add(rs.getString("QUESTION"));
                this.gameAchoice.add(rs.getString("ACHOICE"));
                this.gameBchoice.add(rs.getString("BCHOICE"));
                this.gameCchoice.add(rs.getString("CCHOICE"));
                this.gameDchoice.add(rs.getString("DCHOICE"));
                this.gameAnswer.add(rs.getString("ANSWER"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " Unable to initialise game setup!");
        }
    }
/**
 * In this function we are selecting all the information from our database and saving them into our resultSet
 * @return it will return the information from the database.
 */
    public ResultSet querySetupGame() {
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery("SELECT DIFFICULTY, QUESTION, ACHOICE, BCHOICE, CCHOICE, DCHOICE, ANSWER"
                    + " FROM PROMPT");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " Unable to query game setup!");
        }
        return (rs);
    }
/**
 * In this function we will use both functions to display all of our database information.
 */
    public void displaySetupGame() {
        this.writeSetupGame();
        this.initialiseSetupGame(querySetupGame());
    }
}
