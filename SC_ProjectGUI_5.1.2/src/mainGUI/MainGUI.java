package mainGUI;

import rulesGUI.RulesScreen;
import leaderboardGUI.LeaderBoardScreen;
import gameGUI.GameScreen;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import databaseSetup.DatabaseInitialise;
import java.util.Map.Entry;
import databaseSetup.DatabaseConnect;
import databaseSetup.DatabaseInitialiseMain;
import gameGUI.ContinueScreen;
import gameGUI.ContinueVariables;
import leaderboardGUI.LeaderboardList;
import resultGUI.ResultScreen;
import userGUI.LoginScreen;
import userGUI.LoginVariables;

public class MainGUI extends JPanel {

    private CardLayout cardLayout = new CardLayout();
    private StartScreen startSc = new StartScreen(this);
    private GameScreen gameSc = new GameScreen(this);
    private RulesScreen rulesSc = new RulesScreen(this);
    private LoginScreen loginSc = new LoginScreen(this);
    private LeaderBoardScreen leaderSC = new LeaderBoardScreen(this);
    private ResultScreen resultSC = new ResultScreen(this);
    private ContinueScreen cashSc = new ContinueScreen(this);

    public ResultScreen getResultScreen() {
        return this.resultSC;
    }

    public ContinueScreen getContinueScreen() {
        return this.cashSc;
    }
    
    public void finishAndSave() {
          DatabaseInitialise ldb = new DatabaseInitialise();
          ldb.saveLeaderBoard(LoginVariables.getUserName(), ContinueVariables.getMoney());
    }
    
    public MainGUI() {
        setLayout(cardLayout);
        add(startSc, StartScreen.NAME);
        add(loginSc, LoginScreen.NAME);
        add(gameSc, GameScreen.NAME);
        add(rulesSc, RulesScreen.NAME);
        add(leaderSC, LeaderBoardScreen.NAME);
        add(resultSC, ResultScreen.NAME);
        add(cashSc, ContinueScreen.NAME);
        // EmptyBorder(int top, int left, int bottom,int right)
        setBorder(new EmptyBorder(10, 150, 10, 150));//card layout size
    }

    public void showCard(String Name) {
        cardLayout.show(this, Name);
    }

    private static void createAndShowGui() {
        ScreenSize ss = new ScreenSize();
        MainGUI mainPanel = new MainGUI();
        JFrame frame = new JFrame("Who wants to be a Millionaire");

        frame.setSize(ss.getScreenWidth(), ss.getScreenHeight());

        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();

            }
        });
    }

}
