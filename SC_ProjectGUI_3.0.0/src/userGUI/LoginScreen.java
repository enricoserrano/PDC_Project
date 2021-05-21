/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userGUI;

import com.sun.javafx.scene.EnteredExitedHandler;
import gameGUI.GameScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
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
import mainGUI.StartScreen;

/**
 *
 * @author Enrico
 */
public class LoginScreen extends JPanel {

    public static final String NAME = "Please enter your name";
    private MainGUI mainGui;

    public LoginScreen(final MainGUI mainGui) {
        LoginVariables user = new LoginVariables();
        this.mainGui = mainGui;
        add(new JLabel(NAME));

        JPanel test = new JPanel();
        JButton Enter = new JButton("Enter");
        //JLabel loginText = new JLabel("Please Enter your Name");
        //loginText.setFont(loginText.getFont().deriveFont(30.0f));
        JTextField name = new JTextField();

        name.setBounds(10, 231, 370, 22);
        name.setPreferredSize(new Dimension(500, 100));
        name.setBackground(Color.decode("#eeeeee"));
        test.add(name);

        name.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
        name.setFont(name.getFont().deriveFont(80.0f));
        Enter.setBackground(Color.decode("#f37315"));
        JPanel buttonDisplay = new JPanel();
        buttonDisplay.setSize(500, 500);
        buttonDisplay.add(Enter, BorderLayout.SOUTH);

        setLayout(new GridLayout(4, 1));
        Enter.setPreferredSize(new Dimension(300, 50));
        Enter.setEnabled(false);
        name.getDocument().addDocumentListener(new DocumentListener() {
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
                if (name.getText().equals("") || name.getText().equals(null) || name.getText().trim().isEmpty()) {
                    Enter.setEnabled(false);
                } else {
                    Enter.setEnabled(true);
                }

            }
        });
        //add(loginText, BorderLayout.NORTH);
        add(test, BorderLayout.NORTH);
        add(buttonDisplay, BorderLayout.SOUTH);


        Enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = name.getText();
                user.setUserName(userName);
                mainGui.showCard(GameScreen.NAME);
            }
        });

    }
}
