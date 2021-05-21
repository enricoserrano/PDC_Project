package leaderboardGUI;

import mainGUI.StartScreen;
import mainGUI.MainGUI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

public class LeaderBoardScreen extends JPanel {

    public static final String NAME = "LeaderBoards";
    private MainGUI mainGui;

    public LeaderBoardScreen(final MainGUI mainGui) {
        //LeaderboardDB ldb = new LeaderboardDB();
        //ldb.displayLeaderboard();
        //ldb.getSortleaderboardRecord();

        this.mainGui = mainGui;
        add(new JLabel(NAME));
        

        JButton OK = new JButton("OK");
        //Border rulesBorder = BorderFactory.createLineBorder(Color.black);
        JLabel leaderboard = new JLabel("");

        /*
        for (Entry<String, Integer> entry : ldb.getSortleaderboardRecord().entrySet()) {
            String key = entry.getKey();
            int score = entry.getValue();
            leaderboard.setText(key + score);
        }
         */
        LeaderboardList ldbl = new LeaderboardList();
        String[][] data = {
            {"Name", "Score"},
            {ldbl.getNameList().get(0), "$" + ldbl.getScoreList().get(0).toString()},
            {ldbl.getNameList().get(1), "$" + ldbl.getScoreList().get(1).toString()},
            {ldbl.getNameList().get(2), "$" + ldbl.getScoreList().get(2).toString()}};
        String column[] = {"NAME", "SCORE"};
        JTable leaderboardTable = new JTable(data, column);
        leaderboardTable.setDefaultEditor(Object.class, null);
        //leaderboard.setText("enter leaderboard here!");
        leaderboardTable.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        leaderboardTable.setRowHeight(40);
        //leaderboardTable.setRowHeight (2 * leaderboardTable.getRowHeight (1), 2 * leaderboardTable.getRowHeight (2));
        leaderboardTable.setRowMargin (5);
        leaderboardTable.setFont(leaderboard.getFont().deriveFont(20.0f));
        OK.setBackground(Color.decode("#f37315"));
        JPanel buttonDisplay = new JPanel();
        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(OK, BorderLayout.SOUTH);
        
        setLayout(new GridLayout(3, 1));
        OK.setPreferredSize(new Dimension(300, 50));
        add(leaderboardTable, BorderLayout.CENTER);
        add(buttonDisplay, BorderLayout.SOUTH);

        //add(new JLabel(NAME));
        //add(new JButton(new AbstractAction("Start Game")
        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(StartScreen.NAME);
            }
        });

    }

}
