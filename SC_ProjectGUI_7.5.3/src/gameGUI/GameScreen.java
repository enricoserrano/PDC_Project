package gameGUI;

import databaseSetup.DatabaseInitialise;
import java.awt.BorderLayout;
import mainGUI.MainGUI;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
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
    ArrayList<Integer> randomsetQuestions = new ArrayList<Integer>(4);
    GameList gl = new GameList();
    LeaderboardList player = new LeaderboardList();
    JLabel question = new JLabel("");
    JLabel money = new JLabel("");
    JButton aChoice = new JButton("");
    JButton bChoice = new JButton("");
    JButton cChoice = new JButton("");
    JButton dChoice = new JButton("");
    JButton fiftyfifty = new JButton("50/50");
    JPanel showQuestion = new JPanel(new GridLayout(5, 10));
    JPanel displayAll = new JPanel(new GridLayout(5, 10));
    JPanel buttonDisplay = new JPanel(new GridLayout(2, 4, 15, 15));
    JPanel emptyGap = new JPanel();
    JPanel fiftyfiftyDisplay = new JPanel(new GridLayout(2, 2, 5, 5));
    boolean fiftyStatus = false;
    String[][] prizeDisplay = {{"100", "200", "300", "500", "1000", "2000", "4000", "8000", "16000", "32000", "64000", "125000", "250000", "500000", "1000000"}};
    String column[] = {"100", "200", "300", "500", "1000", "2000", "4000", "8000", "16000", "32000", "64000", "125000", "250000", "500000", "1000000"};
    //JTable leaderboardTable = new JTable(prizeDisplay, column);

    public void fiftyDisplay(int noQuestion) {

        if (fiftyStatus = true) {
            if (gl.getGameAnswer().get(noQuestion).equals(gl.getGameAchoice().get(noQuestion))) {
                int randomNumA = ThreadLocalRandom.current().nextInt(2, 4);
                switch (randomNumA) {
                    case 2:
                        cChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 3:
                        bChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 4:
                        bChoice.setEnabled(false);
                        cChoice.setEnabled(false);
                        break;
                    default:
                        break;
                }
            } else if (gl.getGameAnswer().get(noQuestion).equals(gl.getGameBchoice().get(noQuestion))) {
                int randomNumB = ThreadLocalRandom.current().nextInt(1, 4);
                switch (randomNumB) {
                    case 1:
                        cChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 2:
                        cChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 3:
                        aChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 4:
                        aChoice.setEnabled(false);
                        cChoice.setEnabled(false);
                        break;
                    default:
                        break;
                }
            } else if (gl.getGameAnswer().get(noQuestion).equals(gl.getGameCchoice().get(noQuestion))) {
                int randomNumC = ThreadLocalRandom.current().nextInt(1, 4);
                switch (randomNumC) {
                    case 1:
                        bChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 2:
                        aChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 3:
                        aChoice.setEnabled(false);
                        dChoice.setEnabled(false);
                        break;
                    case 4:
                        aChoice.setEnabled(false);
                        bChoice.setEnabled(false);
                        break;
                    default:
                        break;
                }
            } else if (gl.getGameAnswer().get(noQuestion).equals(gl.getGameDchoice().get(noQuestion))) {
                int randomNumD = ThreadLocalRandom.current().nextInt(1, 3);
                switch (randomNumD) {
                    case 1:
                        bChoice.setEnabled(false);
                        cChoice.setEnabled(false);
                        break;
                    case 2:
                        aChoice.setEnabled(false);
                        cChoice.setEnabled(false);
                        break;
                    case 3:
                        aChoice.setEnabled(false);
                        bChoice.setEnabled(false);
                        break;
                    default:
                        break;
                }

            }
        }
        question.setText(gl.getGameQuestion().get(noQuestion));
        money.setText("Money Earned: $" + String.valueOf(player.getMoneyEachQuestion().get(testQ)));
        aChoice.setText(gl.getGameAchoice().get(noQuestion));
        bChoice.setText(gl.getGameBchoice().get(noQuestion));
        cChoice.setText(gl.getGameCchoice().get(noQuestion));
        dChoice.setText(gl.getGameDchoice().get(noQuestion));
        ContinueVariables.setMoney(player.getMoneyEachQuestion().get(testQ));
        this.mainGui.getContinueScreen().UpdateScore();
        fiftyfiftyDisplay.remove(emptyGap);
        fiftyfiftyDisplay.remove(fiftyfifty);
        displayAll.remove(fiftyfiftyDisplay);
    }

    public void gameDisplay(int noQuestion) {
        aChoice.setEnabled(true);
        bChoice.setEnabled(true);
        cChoice.setEnabled(true);
        dChoice.setEnabled(true);
        question.setText(gl.getGameQuestion().get(noQuestion));
        money.setText("Money Earned: $" + String.valueOf(player.getMoneyEachQuestion().get(testQ)));
        aChoice.setText(gl.getGameAchoice().get(noQuestion));
        bChoice.setText(gl.getGameBchoice().get(noQuestion));
        cChoice.setText(gl.getGameCchoice().get(noQuestion));
        dChoice.setText(gl.getGameDchoice().get(noQuestion));
        ContinueVariables.setMoney(player.getMoneyEachQuestion().get(testQ));
        this.mainGui.getContinueScreen().UpdateScore();
    }

    //painting money bar
    DefaultTableModel model = new DefaultTableModel(prizeDisplay, column);
    JTable leaderboardTable = new JTable(model) {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);

            //dont need to check users money as it based of question numbers, question numbers go up when u get it right, going of that
            System.out.println("mone" + String.valueOf(player.getMoneyEachQuestion().get(testQ)));
            System.out.println("mone2check" + String.valueOf(ContinueVariables.getMoney()));

            if (!getValueAt(0, 0).toString().equals("") && columnIndex > testQ) {
                component.setBackground(Color.RED);
            } else {
                component.setBackground(Color.GREEN);

            }

            return component;
        }
    };

    public void initialisesetRandom() {
        int randomNumber = 0;
        for (int i = 0; i < 15; i++) {
            randomNumber = (int) (Math.random() * (30 - 0 + 1) + 0);
            while (randomsetQuestions.contains(randomNumber)) {
                randomNumber = (int) (Math.random() * (30 - 0 + 1) + 0);
            }
            randomsetQuestions.add(randomNumber);
        }
    }

    public void customiseScreen() {
        aChoice.setPreferredSize(new Dimension(300, 50));
        bChoice.setPreferredSize(new Dimension(300, 50));
        cChoice.setPreferredSize(new Dimension(300, 50));
        dChoice.setPreferredSize(new Dimension(300, 50));
        fiftyfifty.setPreferredSize(new Dimension(300, 50));
        aChoice.setBackground(Color.decode("#f37315"));
        bChoice.setBackground(Color.decode("#f37315"));
        cChoice.setBackground(Color.decode("#f37315"));
        dChoice.setBackground(Color.decode("#f37315"));
        fiftyfifty.setBackground(Color.decode("#f37315"));
        question.setFont(question.getFont().deriveFont(20.0f));
    }

    public GameScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;

        leaderboardTable.setDefaultEditor(Object.class, null);
        leaderboardTable.setRowHeight(80);

        //find coloum to corresponding winnings to table, then change background colour
        //leaderboardTable.setBackground(Color.green);
        showQuestion.add(question);
        showQuestion.add(money);
        customiseScreen();

        initialisesetRandom();
        buttonDisplay.add(aChoice);
        buttonDisplay.add(bChoice);
        buttonDisplay.add(cChoice);
        buttonDisplay.add(dChoice);
        fiftyfiftyDisplay.add(emptyGap);
        fiftyfiftyDisplay.add(fiftyfifty);
        displayAll.add(showQuestion);
        displayAll.add(leaderboardTable);
        displayAll.add(buttonDisplay);
        displayAll.add(fiftyfiftyDisplay);

        question.setText(gl.getGameQuestion().get(randomsetQuestions.get(0)));
        money.setText("Money Earned: $" + String.valueOf(player.getMoneyEachQuestion().get(0)));
        aChoice.setText(gl.getGameAchoice().get(randomsetQuestions.get(0)));
        bChoice.setText(gl.getGameBchoice().get(randomsetQuestions.get(0)));
        cChoice.setText(gl.getGameCchoice().get(randomsetQuestions.get(0)));
        dChoice.setText(gl.getGameDchoice().get(randomsetQuestions.get(0)));

        add(displayAll);
        setSize(400, 200);
        setVisible(true);
        aChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (aChoice.getText().equals(gl.getGameAnswer().get(randomsetQuestions.get(testQ)))) {
                    if (testQ == 13) {
                        ContinueVariables.setMoney(1000000);
                        mainGui.getContinueScreen().UpdateScore();
                        mainGui.getResultScreen().UpdateUserData();

                        mainGui.finishAndSave();
                        mainGui.showCard(ResultScreen.NAME);
                    } else {
                        testQ++;
                        gameDisplay(randomsetQuestions.get(testQ));
                        mainGui.showCard(ContinueScreen.NAME);
                    }
                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }

            }
        });
        bChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bChoice.getText().equals(gl.getGameAnswer().get(randomsetQuestions.get(testQ)))) {
                    if (testQ == 13) {
                        ContinueVariables.setMoney(1000000);
                        mainGui.getContinueScreen().UpdateScore();
                        mainGui.getResultScreen().UpdateUserData();

                        mainGui.finishAndSave();
                        mainGui.showCard(ResultScreen.NAME);
                    } else {
                        testQ++;
                        gameDisplay(randomsetQuestions.get(testQ));
                        mainGui.showCard(ContinueScreen.NAME);
                    }

                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }
            }
        });
        cChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cChoice.getText().equals(gl.getGameAnswer().get(randomsetQuestions.get(testQ)))) {
                    if (testQ == 13) {
                        ContinueVariables.setMoney(1000000);
                        mainGui.getContinueScreen().UpdateScore();
                        mainGui.getResultScreen().UpdateUserData();

                        mainGui.finishAndSave();
                        mainGui.showCard(ResultScreen.NAME);
                    } else {
                        testQ++;
                        gameDisplay(randomsetQuestions.get(testQ));
                        mainGui.showCard(ContinueScreen.NAME);
                    }

                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }
            }
        });
        dChoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dChoice.getText().equals(gl.getGameAnswer().get(randomsetQuestions.get(testQ)))) {
                    if (testQ == 13) {
                        ContinueVariables.setMoney(1000000);
                        mainGui.getContinueScreen().UpdateScore();
                        mainGui.getResultScreen().UpdateUserData();

                        mainGui.finishAndSave();
                        mainGui.showCard(ResultScreen.NAME);
                    } else {
                        testQ++;
                        gameDisplay(randomsetQuestions.get(testQ));
                        mainGui.showCard(ContinueScreen.NAME);
                    }
                } else {
                    mainGui.showCard(ResultScreen.NAME);
                }
            }
        });
        fiftyfifty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fiftyStatus = true;
                fiftyDisplay(randomsetQuestions.get(testQ));

            }
        });

    }

}
