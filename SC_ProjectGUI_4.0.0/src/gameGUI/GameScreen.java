package gameGUI;

import databaseSetup.DatabaseInitialise;
import java.awt.BorderLayout;
import mainGUI.MainGUI;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class GameScreen extends JPanel {

    public static final String NAME = "GameScreen";
    private MainGUI mainGui;
    
    public GameScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;
        GameList gl = new GameList();
        // add(new JLabel(NAME));
        //setLayout(new GridLayout(4, 4));
        
        JLabel question = new JLabel(gl.getGameQuestion().get(1));
        JLabel money = new JLabel("Money Earned");
        JButton aChoice = new JButton(gl.getGameAchoice().get(1));
        JButton bChoice = new JButton(gl.getGameBchoice().get(1));
        JButton cChoice = new JButton(gl.getGameCchoice().get(1));
        JButton dChoice = new JButton(gl.getGameDchoice().get(1));

        JPanel showQuestion = new JPanel(new GridLayout(5,10));
        question.setFont(question.getFont().deriveFont(20.0f));
        showQuestion.add(question);
        showQuestion.add(money);
        
        JPanel buttonDisplay = new JPanel(new GridLayout(2,4));
        
        aChoice.setPreferredSize(new Dimension(300, 50));
        bChoice.setPreferredSize(new Dimension(300, 50));
        cChoice.setPreferredSize(new Dimension(300, 50));
        dChoice.setPreferredSize(new Dimension(300, 50));
        aChoice.setBackground(Color.decode("#f37315"));
        bChoice.setBackground(Color.decode("#f37315"));
        cChoice.setBackground(Color.decode("#f37315"));
        dChoice.setBackground(Color.decode("#f37315"));
        buttonDisplay.add(aChoice);
        buttonDisplay.add(bChoice);
        buttonDisplay.add(cChoice);
        buttonDisplay.add(dChoice);

        add(showQuestion, BorderLayout.SOUTH);
        add(buttonDisplay, BorderLayout.SOUTH);
        setSize(400, 200);
        setVisible(true);

    }

}
