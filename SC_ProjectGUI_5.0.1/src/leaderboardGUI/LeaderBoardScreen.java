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
    JButton OK = new JButton("OK");
    JLabel leaderboard = new JLabel("");
    LeaderboardList ldbl = new LeaderboardList();
    JPanel buttonDisplay = new JPanel();

    public LeaderBoardScreen(final MainGUI mainGui) {

        this.mainGui = mainGui;
        add(new JLabel(NAME));

        String[][] data = {
            {"Name", "Score"},
            {ldbl.getNameList().get(0), "$" + ldbl.getScoreList().get(0).toString()},
            {ldbl.getNameList().get(1), "$" + ldbl.getScoreList().get(1).toString()},
            {ldbl.getNameList().get(2), "$" + ldbl.getScoreList().get(2).toString()}};
        String column[] = {"NAME", "SCORE"};
        JTable leaderboardTable = new JTable(data, column);
        leaderboardTable.setDefaultEditor(Object.class, null);
        leaderboardTable.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        leaderboardTable.setRowHeight(40);

        leaderboardTable.setRowMargin(5);
        leaderboardTable.setFont(leaderboard.getFont().deriveFont(20.0f));
        OK.setBackground(Color.decode("#f37315"));

        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(OK, BorderLayout.SOUTH);

        setLayout(new GridLayout(3, 1));
        OK.setPreferredSize(new Dimension(300, 50));
        add(leaderboardTable, BorderLayout.CENTER);
        add(buttonDisplay, BorderLayout.SOUTH);

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(StartScreen.NAME);
            }
        });

    }

}
