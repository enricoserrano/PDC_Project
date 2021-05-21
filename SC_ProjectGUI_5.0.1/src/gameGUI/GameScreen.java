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
import java.awt.event.ActionListener;

import javax.swing.*;
import leaderboardGUI.LeaderBoardScreen;
import leaderboardGUI.LeaderboardList;
import mainGUI.StartScreen;
import resultGUI.ResultScreen;

public class GameScreen extends JPanel {

    public static final String NAME = "GameScreen";
    private MainGUI mainGui;
    //static int noQuestion = 0;
    public static int testQ = 0;
    private static String userName;

    GameList gl = new GameList();
    LeaderboardList player = new LeaderboardList();
    JLabel question = new JLabel("");
    JLabel money = new JLabel("");
    JButton aChoice = new JButton("");
    JButton bChoice = new JButton("");
    JButton cChoice = new JButton("");
    JButton dChoice = new JButton("");
    JPanel showQuestion = new JPanel(new GridLayout(5, 10));
    JPanel displayAll = new JPanel(new GridLayout(5, 10));
    JPanel buttonDisplay = new JPanel(new GridLayout(2, 4));
    String[][] prizeDisplay = {{"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100", "12000", "13000", "14000", "15000"}};
    String column[] = {"100333", "enrico", "300", "400", "500", "600", "700", "800", "900", "1000", "1100", "12000", "13000", "14000", "15000"};
    JTable leaderboardTable = new JTable(prizeDisplay, column);

    public void gameDisplay(int noQuestion) {

        question.setText(gl.getGameQuestion().get(noQuestion));
        money.setText("Money Earned: $" + String.valueOf(player.getMoneyEachQuestion().get(noQuestion)));
        aChoice.setText(gl.getGameAchoice().get(noQuestion));
        bChoice.setText(gl.getGameBchoice().get(noQuestion));
        cChoice.setText(gl.getGameCchoice().get(noQuestion));
        dChoice.setText(gl.getGameDchoice().get(noQuestion));
        ContinueVariables.setMoney(player.getMoneyEachQuestion().get(noQuestion));
    }

    public GameScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;

        leaderboardTable.setDefaultEditor(Object.class, null);
        leaderboardTable.setRowHeight(80);
        showQuestion.add(question);
        showQuestion.add(money);
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
        question.setFont(question.getFont().deriveFont(20.0f));
        displayAll.add(showQuestion);
        displayAll.add(leaderboardTable);
        displayAll.add(buttonDisplay);
        add(displayAll);
        setSize(400, 200);
        setVisible(true);

        question.setText(gl.getGameQuestion().get(testQ));
        money.setText("Money Earned");
        aChoice.setText(gl.getGameAchoice().get(testQ));
        bChoice.setText(gl.getGameBchoice().get(testQ));
        cChoice.setText(gl.getGameCchoice().get(testQ));
        dChoice.setText(gl.getGameDchoice().get(testQ));
        aChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (aChoice.getText().equals(gl.getGameAnswer().get(testQ))) {
                    testQ++;
                    gameDisplay(testQ);
                    mainGui.showCard(ContinueScreen.NAME);
                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }

                //noQuestion++;
            }
        });
        bChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bChoice.getText().equals(gl.getGameAnswer().get(testQ))) {
                    testQ++;
                    gameDisplay(testQ);
                    mainGui.showCard(ContinueScreen.NAME);
                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }
            }
        });
        cChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cChoice.getText().equals(gl.getGameAnswer().get(testQ))) {
                    testQ++;
                    gameDisplay(testQ);
                    mainGui.showCard(ContinueScreen.NAME);
                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }
            }
        });
        dChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dChoice.getText().equals(gl.getGameAnswer().get(testQ))) {
                    testQ++;
                    gameDisplay(testQ);
                    mainGui.showCard(ContinueScreen.NAME);
                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }
            }
        });

    }

}
