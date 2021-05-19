
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class IntroductionGUI extends JPanel {

    private String gameTitle = "Who wants to be a millionaire!";
    private String gameRulestext = "should probably have another panel popup to show game rules same for leaderboard";

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameRulestext() {
        return gameRulestext;
    }

    public void setGameRulestext(String gameRulestext) {
        this.gameRulestext = gameRulestext;
    }

    public IntroductionGUI() {
        JButton gameStart = new JButton("Start Game");
        JButton viewRules = new JButton("How to Play");
        JButton viewLeaderboard = new JButton("View Leaderboard");
        JLabel gameRules = new JLabel("");
        JPanel introPanel = new JPanel();

        introPanel.add(gameRules);
        introPanel.setSize(500, 500);
        viewRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameRules.setText(getGameRulestext());
            }
        });

        //customising the color and the size of the buttons
        gameStart.setPreferredSize(new Dimension(300, 50));
        viewRules.setPreferredSize(new Dimension(300, 50));
        viewLeaderboard.setPreferredSize(new Dimension(300, 50));
        gameStart.setBackground(Color.decode("#f37315"));
        viewRules.setBackground(Color.decode("#f37315"));
        viewLeaderboard.setBackground(Color.decode("#f37315"));

        add(gameStart, BorderLayout.CENTER);
        add(viewRules, BorderLayout.CENTER);
        add(viewLeaderboard, BorderLayout.CENTER);
        add(introPanel, BorderLayout.CENTER);
    }

}
