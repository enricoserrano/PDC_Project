package userGUI;

/**
 * This class is being used in the login screen which has a variable of user
 * name and user score
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class LoginVariables {

    private static String userName;
    private static int userScore;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        LoginVariables.userName = userName;
    }

    public static int getUserScore() {
        return userScore;
    }

    public static void setUserScore(int userScore) {
        LoginVariables.userScore = userScore;
    }

    public LoginVariables() {
    }

}
