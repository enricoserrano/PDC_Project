package gameGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.Border;//this one cant delete
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import leaderboardGUI.LeaderboardList;
import mainGUI.MainGUI;
import resultGUI.ResultScreen;

/**
 * This class is displaying the continue screen. It allows the user to proceed
 * or cash out after they get the question right.
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class ContinueScreen extends JPanel {

    public static final String NAME = "CashOut";
    private MainGUI mainGui;
    LeaderboardList player = new LeaderboardList();
    JButton cashOut = new JButton("Cash Out");
    JButton Continue = new JButton("Continue");
    JLabel displayCash = new JLabel("");
    JPanel buttonDisplay = new JPanel();

    /**
     * This is setting the JLabel text to the current money that the user has
     * earned
     */
    public void UpdateScore() {
        displayCash.setText("Money Earned: $" + String.valueOf(ContinueVariables.getMoney()) + " | Do you want to continue?");
    }

    /**
     * Customizing the panel, buttons, and labels.
     */
    public void customisation() {
        displayCash.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        displayCash.setFont(displayCash.getFont().deriveFont(50.0f));
        cashOut.setBackground(Color.decode("#f37315"));
        Continue.setBackground(Color.decode("#f37315"));
        buttonDisplay.setSize(500, 500);
    }

    /**
     * Displaying the continue screen card
     *
     * @param mainGui
     */
    public ContinueScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        //customising buttons, changing gridlayout and setting displaycash
        displayCash.setText("Money Earned: $" + String.valueOf(ContinueVariables.getMoney()) + " | Do you want to continue?");
        customisation();
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
                mainGui.finishAndSave();
                mainGui.getResultScreen().UpdateUserData();
                mainGui.showCard(ResultScreen.NAME);

            }
        });

    }

}
