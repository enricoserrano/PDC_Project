package rulesGUI;

import mainGUI.MainGUI;
import mainGUI.StartScreen;
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

public class RulesScreen extends JPanel {

    public static final String NAME = "Rules";
    private MainGUI mainGui;
    JButton OK = new JButton("OK");
    JPanel buttonDisplay = new JPanel();

    public RulesScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        JLabel displayRules = new JLabel("");
        displayRules.setText("<html>Welcome to Who wants to be a Millionaire!<br> The game consists of 15 questions, difficulty increases with each question and so does the prize money earned<br> Contestant will be a given four set of choices for each question and they must choose the right answer in order to advance to the next round<br>Contestant will be given a 50/50 lifeline which they can only use once and it eliminates two of the wrong answers which gives them an advantage<br> The game features a leaderboard which displays the top 3 players to have earned the most money!<br> Will your name be in the leaderboard? let us see!</html>");
        displayRules.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        displayRules.setFont(displayRules.getFont().deriveFont(20.0f));
        OK.setBackground(Color.decode("#f37315"));

        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(OK, BorderLayout.SOUTH);

        setLayout(new GridLayout(3, 1));
        OK.setPreferredSize(new Dimension(300, 50));
        add(displayRules, BorderLayout.NORTH);
        add(buttonDisplay, BorderLayout.SOUTH);

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(StartScreen.NAME);
            }
        });

    }

}
