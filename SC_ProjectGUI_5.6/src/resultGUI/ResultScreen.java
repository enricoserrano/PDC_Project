/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultGUI;

import gameGUI.ContinueVariables;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import leaderboardGUI.LeaderBoardScreen;
import leaderboardGUI.LeaderboardList;
import mainGUI.MainGUI;
import mainGUI.StartScreen;
import userGUI.LoginVariables;

/**
 *
 * @author Enrico
 */
public class ResultScreen extends JPanel {

    public static final String NAME = "Result";
    private MainGUI mainGui;
    private static String resultName;
    JButton OK = new JButton("OK");
    JLabel displayName = new JLabel("");
    JLabel displayScore = new JLabel("");
    JPanel displayInfo = new JPanel();
    JPanel buttonDisplay = new JPanel();

    public void UpdateUserData() {
        displayName.setText("Congratulations! " + LoginVariables.getUserName());
        displayScore.setText("You have earned $" + ContinueVariables.getMoney() + "!");
    }
    
    public ResultScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));


        displayInfo.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        displayName.setFont(displayName.getFont().deriveFont(80.0f));
        displayScore.setFont(displayName.getFont().deriveFont(80.0f));
        displayInfo.add(displayName);
        displayInfo.add(displayScore);
        OK.setBackground(Color.decode("#f37315"));

        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(OK, BorderLayout.SOUTH);

        setLayout(new GridLayout(3, 2));
        OK.setPreferredSize(new Dimension(300, 50));
        add(displayInfo);
        add(buttonDisplay, BorderLayout.SOUTH);

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.resetGame();
                mainGui.showCard(StartScreen.NAME);
                
            }
        });

    }
}
