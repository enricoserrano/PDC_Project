package mainGUI;

import rulesGUI.RulesScreen;
import leaderboardGUI.LeaderBoardScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import userGUI.LoginScreen;

public class StartScreen extends JPanel {

    public static final String NAME = "Start";
    private MainGUI mainGui;
    JButton viewRules = new JButton("How to Play");
    JButton viewLeaderboard = new JButton("View Leaderboard");
    JButton gameStart = new JButton("Start Game");
    JButton exitGame = new JButton("Exit Game");
    JLabel logo = new JLabel(new ImageIcon("./resources/gameLogo.png"));
    JPanel image = new JPanel(new GridLayout(0, 1, 0, 100));

    public StartScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;

        logo.setPreferredSize(new Dimension(600, 600));
        gameStart.setPreferredSize(new Dimension(200, 50));
        viewRules.setPreferredSize(new Dimension(200, 50));
        viewLeaderboard.setPreferredSize(new Dimension(300, 50));
        exitGame.setPreferredSize(new Dimension(300, 50));

        image.add(logo, BorderLayout.NORTH);

        JPanel buttonDisplay = new JPanel(new GridLayout(0, 1, 0, 10));
        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(viewRules, BorderLayout.CENTER);
        buttonDisplay.add(gameStart, BorderLayout.CENTER);
        buttonDisplay.add(viewLeaderboard, BorderLayout.CENTER);
        buttonDisplay.add(exitGame, BorderLayout.CENTER);
        gameStart.setBackground(Color.decode("#f37315"));
        viewRules.setBackground(Color.decode("#f37315"));
        viewLeaderboard.setBackground(Color.decode("#f37315"));
        exitGame.setBackground(Color.decode("#f37315"));
        JPanel empty = new JPanel(new GridLayout(0, 1, 0, 10));
        empty.setPreferredSize(new Dimension(5, 5));
        empty.setMinimumSize(new Dimension(5, 5));
        empty.setMaximumSize(new Dimension(5, 5));

        add(empty, BorderLayout.CENTER);
        add(image, BorderLayout.NORTH);
        add(buttonDisplay, BorderLayout.CENTER);

        gameStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(LoginScreen.NAME);
            }
        });

        viewRules.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(RulesScreen.NAME);
            }
        });

        viewLeaderboard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.updateLeaderboard();
                mainGui.showCard(LeaderBoardScreen.NAME);
            }
        });
        exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int confirmation = JOptionPane.showConfirmDialog(null, "Do you wish to exit the game?", "Confirm", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {

                }
            }
        });
    }

}
