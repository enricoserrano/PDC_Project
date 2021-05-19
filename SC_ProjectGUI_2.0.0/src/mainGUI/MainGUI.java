package mainGUI;


import rulesGUI.RulesScreen;
import leaderboardGUI.LeaderBoardScreen;
import gameGUI.GameScreen;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainGUI extends JPanel {

    private CardLayout cardLayout = new CardLayout();
    private StartScreen startSc = new StartScreen(this);
    private GameScreen gameSc = new GameScreen(this);
    private RulesScreen rulesSc = new RulesScreen(this);
    private LeaderBoardScreen leaderSC = new LeaderBoardScreen(this);

    public MainGUI() {
        setLayout(cardLayout);
        add(startSc, StartScreen.NAME);
        add(gameSc, GameScreen.NAME);
        add(rulesSc, RulesScreen.NAME);
        add(leaderSC, LeaderBoardScreen.NAME);

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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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
