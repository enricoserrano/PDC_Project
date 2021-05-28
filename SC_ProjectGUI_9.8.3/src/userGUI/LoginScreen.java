package userGUI;

import gameGUI.GameScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mainGUI.MainGUI;

/**
 * This class is used to display the login screen which gathers the player's
 * user name
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class LoginScreen extends JPanel {

    public static final String NAME = "Please enter your name";
    private MainGUI mainGui;
    JTextField loginName = new JTextField();
    JPanel test = new JPanel();
    JButton Enter = new JButton("Enter");
    JPanel buttonDisplay = new JPanel();

    public void clearLogin() {
        loginName.setText("");
    }

    public LoginScreen(final MainGUI mainGui) {

        this.mainGui = mainGui;
        add(new JLabel(NAME));

        loginName.setBounds(10, 231, 370, 22);
        loginName.setPreferredSize(new Dimension(500, 100));
        loginName.setBackground(Color.decode("#eeeeee"));
        test.add(loginName);

        loginName.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
        loginName.setFont(loginName.getFont().deriveFont(80.0f));
        Enter.setBackground(Color.decode("#f37315"));

        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(Enter, BorderLayout.SOUTH);

        setLayout(new GridLayout(4, 1));
        Enter.setPreferredSize(new Dimension(300, 50));
        Enter.setEnabled(false);

        /**
         * Validating so the program would not accept a name that starts with an
         * empty or null character
         */
        loginName.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (loginName.getText().equals("") || loginName.getText().equals(null) || loginName.getText().trim().isEmpty()) {
                    Enter.setEnabled(false);
                } else {
                    Enter.setEnabled(true);
                }

            }
        });
        add(test, BorderLayout.NORTH);
        add(buttonDisplay, BorderLayout.SOUTH);
        Enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = loginName.getText().substring(0, 1).toUpperCase() + loginName.getText().substring(1).toLowerCase();
                LoginVariables.setUserName(playerName);

                mainGui.getResultScreen().UpdateUserData();
                mainGui.showCard(GameScreen.NAME);
            }
        });

    }
}
