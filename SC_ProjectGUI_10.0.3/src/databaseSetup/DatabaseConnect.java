package databaseSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is used for connecting to the database.
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class DatabaseConnect {

    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private static final String URL = "jdbc:derby://localhost:1527/LEADERBOARD;create=true";  //url of the DB host

    Connection conn;

    public DatabaseConnect() {
        establishConnection();
    }

    public static void main(String[] args) {
        DatabaseConnect dbManager = new DatabaseConnect();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }

    /**
     * Establishing connection
     */
    public void establishConnection() {
        //Establish a connection to Database
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    /**
     * Closing connection
     */
    public void closeConnections() {
        if (conn != null) {
            try {
                DriverManager.getConnection("jdbc:derby://localhost:1527/LEADERBOARD;user=pdc;password=pdc;shutdown=true");
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Querying Database
     */
    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    /**
     * Updating the database.
     */
    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
