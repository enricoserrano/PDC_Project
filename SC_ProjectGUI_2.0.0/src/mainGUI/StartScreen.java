package mainGUI;

import rulesGUI.RulesScreen;
import leaderboardGUI.LeaderBoardScreen;
import gameGUI.GameScreen;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.*;

public class StartScreen extends JPanel {

    public static final String NAME = "Start";
    private MainGUI mainGui;

    public StartScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        JButton viewRules = new JButton("How to Play");
        JButton viewLeaderboard = new JButton("View Leaderboard");
        JButton gameStart = new JButton("Start Game");
        //JPanel contentPane = new JPanel(this.mainGui);
        JLabel logo = new JLabel(new ImageIcon("./resources/gameLogo.png"));
        setLayout(new GridLayout(2, 10));

        logo.setPreferredSize(new Dimension(600, 600));
        gameStart.setPreferredSize(new Dimension(300, 50));
        viewRules.setPreferredSize(new Dimension(300, 50));
        viewLeaderboard.setPreferredSize(new Dimension(300, 50));

        JPanel image = new JPanel();
        image.setSize(1000, 1000);
        image.add(logo, BorderLayout.NORTH);
        
        JPanel buttonDisplay = new JPanel();
        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(viewRules, BorderLayout.SOUTH);
        buttonDisplay.add(gameStart, BorderLayout.SOUTH);
        buttonDisplay.add(viewLeaderboard, BorderLayout.SOUTH);
        gameStart.setBackground(Color.decode("#f37315"));
        viewRules.setBackground(Color.decode("#f37315"));
        viewLeaderboard.setBackground(Color.decode("#f37315"));
        add(image, BorderLayout.NORTH);
        add(buttonDisplay, BorderLayout.SOUTH);

        
        gameStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(GameScreen.NAME);
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
                mainGui.showCard(LeaderBoardScreen.NAME);
            }
        });

    }

}
