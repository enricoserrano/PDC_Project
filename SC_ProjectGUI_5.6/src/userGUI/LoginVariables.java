/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userGUI;

/**
 *
 * @author Enrico
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
