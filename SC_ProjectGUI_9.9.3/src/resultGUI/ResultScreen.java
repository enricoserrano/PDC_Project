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
import mainGUI.MainGUI;
import mainGUI.StartScreen;
import userGUI.LoginVariables;

/**
 * This class is being used to display the overall result of the user after they
 * have finished playing the game. It is also saving the players progress in the
 * leader board which can be accessed in the leader board screen.
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
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

    /**
     * This function is being used to update the user data and show the user his
     * name and what is his game score.
     */
    public void UpdateUserData() {
        if (ContinueVariables.getMoney() <= 0) {
            displayName.setText("Badluck, " + LoginVariables.getUserName());
            displayScore.setText("You've lost all your money");
        } else if (ContinueVariables.getMoney() >= 1000000) {
            displayName.setText("Congratulations " + LoginVariables.getUserName());
            displayScore.setText("You've become a Millionaire!");
        } else {
            displayName.setText("Congratulations! " + LoginVariables.getUserName());
            displayScore.setText("You have earned $" + ContinueVariables.getMoney() + "!");
        }
    }

    /**
     * customizing the buttons and the text
     */
    public void customisation() {
        displayName.setFont(displayName.getFont().deriveFont(80.0f));
        displayScore.setFont(displayName.getFont().deriveFont(80.0f));
        OK.setBackground(Color.decode("#f37315"));
    }

    /**
     *
     * This function is responsible of displaying the result screen
     */
    public ResultScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        displayInfo.setBorder(new MatteBorder(2, 0, 2, 0, Color.black));
        customisation();
        displayInfo.add(displayName);
        displayInfo.add(displayScore);
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
