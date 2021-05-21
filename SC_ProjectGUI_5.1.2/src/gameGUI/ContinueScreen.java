/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameGUI;

import mainGUI.MainGUI;
import mainGUI.StartScreen;
import leaderboardGUI.LeaderBoardScreen;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import leaderboardGUI.LeaderboardList;
import mainGUI.MainGUI;
import resultGUI.ResultScreen;

/**
 *
 * @author johnc
 */
public class ContinueScreen extends JPanel {

    public static final String NAME = "CashOut";
    private MainGUI mainGui;
    LeaderboardList player = new LeaderboardList();
    JButton cashOut = new JButton("Cash Out");
    JButton Continue = new JButton("Continue");
    JLabel displayCash = new JLabel("");
    JPanel buttonDisplay = new JPanel();

    public void UpdateScore() {
        displayCash.setText("Money Earned: $" + String.valueOf(ContinueVariables.getMoney()) + "Do you want to continue");
    }
    
    public ContinueScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        //customising buttons, changing gridlayout and setting displaycash
        displayCash.setText("Money Earned: $" + String.valueOf(ContinueVariables.getMoney()) + "Do you want to continue");
        displayCash.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        displayCash.setFont(displayCash.getFont().deriveFont(20.0f));
        cashOut.setBackground(Color.decode("#f37315"));
        Continue.setBackground(Color.decode("#f37315"));
        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(cashOut, BorderLayout.SOUTH);
        buttonDisplay.add(Continue, BorderLayout.SOUTH);
        setLayout(new GridLayout(3, 1));
        cashOut.setPreferredSize(new Dimension(300, 50));
        Continue.setPreferredSize(new Dimension(300, 50));

        add(displayCash, BorderLayout.NORTH);
        add(buttonDisplay, BorderLayout.SOUTH);

        Continue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(GameScreen.NAME);

            }
        });
        
        cashOut.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset();
                mainGui.finishAndSave();
                mainGui.getResultScreen().UpdateUserData();
                mainGui.showCard(ResultScreen.NAME);

                //need to reset game screen aswell when going back to main menu after cash out
                //GameScreen.gameDisplay(0);
                //ConVar.setResetGame(69420);
            }
        });

    }

}
