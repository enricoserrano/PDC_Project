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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;

public class LeaderBoardScreen extends JPanel {

    public static final String NAME = "LeaderBoards";
    private MainGUI mainGui;
    JButton OK = new JButton("OK");
    JButton refresh = new JButton("Update Leaderboard");
    JLabel leaderboard = new JLabel("");
    LeaderboardList ldbl = new LeaderboardList();
    JPanel buttonDisplay = new JPanel();
    JLabel rowName = new JLabel("Name              Score");
    JLabel firstPlace = new JLabel("");
    JLabel secondPlace = new JLabel("");
    JLabel thirdPlace = new JLabel("");
    JPanel showPlace = new JPanel(new GridLayout(4, 3));

    public void refreshPlacing() {
        firstPlace.setText(ldbl.getSortedLeaderboard().keySet().toArray()[0].toString() + "             $" + ldbl.getSortedLeaderboard().values().toArray()[0].toString());
        secondPlace.setText(ldbl.getSortedLeaderboard().keySet().toArray()[1].toString() + "             $" + ldbl.getSortedLeaderboard().values().toArray()[1].toString());
        thirdPlace.setText(ldbl.getSortedLeaderboard().keySet().toArray()[2].toString() + "          $" + ldbl.getSortedLeaderboard().values().toArray()[2].toString());
    }

    public void displayPlacing() {
        firstPlace.setText(ldbl.getSortedLeaderboard().keySet().toArray()[0].toString() + "             $" + ldbl.getSortedLeaderboard().values().toArray()[0].toString());
        secondPlace.setText(ldbl.getSortedLeaderboard().keySet().toArray()[1].toString() + "             $" + ldbl.getSortedLeaderboard().values().toArray()[1].toString());
        thirdPlace.setText(ldbl.getSortedLeaderboard().keySet().toArray()[2].toString() + "          $" + ldbl.getSortedLeaderboard().values().toArray()[2].toString());
    }

    public LeaderBoardScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        displayPlacing();

        rowName.setFont(rowName.getFont().deriveFont(50.0f));
        firstPlace.setFont(firstPlace.getFont().deriveFont(50.0f));
        secondPlace.setFont(secondPlace.getFont().deriveFont(50.0f));
        thirdPlace.setFont(thirdPlace.getFont().deriveFont(50.0f));

        OK.setBackground(Color.decode("#f37315"));
        refresh.setBackground(Color.decode("#f37315"));
        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(refresh, BorderLayout.SOUTH);
        buttonDisplay.add(OK, BorderLayout.SOUTH);

        setLayout(new GridLayout(3, 1));
        OK.setPreferredSize(new Dimension(300, 50));
        refresh.setPreferredSize(new Dimension(300, 50));

        showPlace.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        showPlace.add(rowName);
        showPlace.add(firstPlace);
        showPlace.add(secondPlace);
        showPlace.add(thirdPlace);
        add(showPlace, BorderLayout.CENTER);
        add(buttonDisplay, BorderLayout.SOUTH);

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainGui.showCard(StartScreen.NAME);
            }
        });

        refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshPlacing();

                JOptionPane.showMessageDialog(null, "Leaderboard has been updated");

            }
        });

    }

}
