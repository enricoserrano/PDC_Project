package leaderboardGUI;

import mainGUI.StartScreen;
import mainGUI.MainGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 * This class is responsible for displaying the the results of the players (top
 * 3)
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class LeaderBoardScreen extends JPanel {

    public static final String NAME = "LeaderBoards";
    private MainGUI mainGui;
    JButton OK = new JButton("OK");
    JButton refresh = new JButton("Update Leaderboard");
    JLabel leaderboard = new JLabel("");
    LeaderboardList ldbl = new LeaderboardList();
    JPanel buttonDisplay = new JPanel();

    JLabel rowName = new JLabel("Name");
    JLabel rowScore = new JLabel("Score");

    JLabel firstPlace = new JLabel("");
    JLabel secondPlace = new JLabel("");
    JLabel thirdPlace = new JLabel("");

    JLabel firstPlaceScore = new JLabel("");
    JLabel secondPlaceScore = new JLabel("");
    JLabel thirdPlaceScore = new JLabel("");

    JLabel Scores = new JLabel("");

    JPanel showPlace = new JPanel(new GridLayout(4, 2));

    /**
     * This allows the user to refresh the leader board information and see the
     * latest placing
     */
    public void refreshPlacing() {
        String firstName = ldbl.getSortedLeaderboard().keySet().toArray()[0].toString();
        String secondName = ldbl.getSortedLeaderboard().keySet().toArray()[1].toString();
        String thirdName = ldbl.getSortedLeaderboard().keySet().toArray()[2].toString();

        String firstScore = ldbl.getSortedLeaderboard().values().toArray()[0].toString();
        String secondScore = ldbl.getSortedLeaderboard().values().toArray()[1].toString();
        String thirdScore = ldbl.getSortedLeaderboard().values().toArray()[2].toString();

        firstPlace.setText(String.format("%s     ", firstName));
        secondPlace.setText(String.format("%s    ", secondName));
        thirdPlace.setText(String.format("%s     ", thirdName));

        firstPlaceScore.setText(String.format("%s %s", "$", firstScore));
        secondPlaceScore.setText(String.format("%s %s", "$", secondScore));
        thirdPlaceScore.setText(String.format("%s %s", "$", thirdScore));

    }

    /**
     * Displays the current placing of the leader board
     */
    public void displayPlacing() {
        String firstName = ldbl.getSortedLeaderboard().keySet().toArray()[0].toString();
        String secondName = ldbl.getSortedLeaderboard().keySet().toArray()[1].toString();
        String thirdName = ldbl.getSortedLeaderboard().keySet().toArray()[2].toString();

        String firstScore = ldbl.getSortedLeaderboard().values().toArray()[0].toString();
        String secondScore = ldbl.getSortedLeaderboard().values().toArray()[1].toString();
        String thirdScore = ldbl.getSortedLeaderboard().values().toArray()[2].toString();

        firstPlace.setText(String.format("%s     ", firstName));
        secondPlace.setText(String.format("%s    ", secondName));
        thirdPlace.setText(String.format("%s     ", thirdName));

        firstPlaceScore.setText(String.format("%s %s", "$", firstScore));
        secondPlaceScore.setText(String.format("%s %s", "$", secondScore));
        thirdPlaceScore.setText(String.format("%s %s", "$", thirdScore));

        String parts[] = null;

    }

    public void customisation() {
        rowName.setFont(rowName.getFont().deriveFont(50.0f));
        rowScore.setFont(rowName.getFont().deriveFont(50.0f));
        firstPlace.setFont(firstPlace.getFont().deriveFont(50.0f));
        secondPlace.setFont(secondPlace.getFont().deriveFont(50.0f));
        thirdPlace.setFont(thirdPlace.getFont().deriveFont(50.0f));

        firstPlaceScore.setFont(thirdPlace.getFont().deriveFont(50.0f));
        secondPlaceScore.setFont(thirdPlace.getFont().deriveFont(50.0f));
        thirdPlaceScore.setFont(thirdPlace.getFont().deriveFont(50.0f));
        buttonDisplay.setSize(500, 500);
        OK.setBackground(Color.decode("#f37315"));
        refresh.setBackground(Color.decode("#f37315"));
        buttonDisplay.setSize(500, 500);
    }

    /**
     * This class is responsible of displaying the leader board screen
     * 
     */
    public LeaderBoardScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        displayPlacing();

        customisation();
        buttonDisplay.add(refresh, BorderLayout.SOUTH);
        buttonDisplay.add(OK, BorderLayout.SOUTH);

        setLayout(new GridLayout(3, 1));
        OK.setPreferredSize(new Dimension(300, 50));
        refresh.setPreferredSize(new Dimension(300, 50));

        showPlace.setBorder(new MatteBorder(4, 0, 2, 0, Color.black));

        showPlace.add(rowName);
        showPlace.add(rowScore);

        showPlace.add(firstPlace);
        showPlace.add(firstPlaceScore);

        showPlace.add(secondPlace);
        showPlace.add(secondPlaceScore);

        showPlace.add(thirdPlace);
        showPlace.add(thirdPlaceScore);

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
