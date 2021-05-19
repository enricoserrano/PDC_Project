package gameGUI;

import mainGUI.MainGUI;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class GameScreen extends JPanel {

    public static final String NAME = "GameScreen";

    public GameScreen(final MainGUI mainGui) {

        // add(new JLabel(NAME));
        setLayout(new GridLayout(2, 2));

        add(new Button("A"));
        add(new Button("B"));
        add(new Button("C"));
        add(new Button("D"));
        setSize(400, 200);
        setVisible(true);

    }

}
