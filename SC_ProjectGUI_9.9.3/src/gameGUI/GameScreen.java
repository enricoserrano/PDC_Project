package gameGUI;

import mainGUI.MainGUI;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import leaderboardGUI.LeaderboardList;
import resultGUI.ResultScreen;

/**
 * This class is is responsible for displaying the questions, choices and
 * answers.
 *
 * @author Enrico Serrano 19071299, Chea 16938895, Leandro Machado 18041563
 */
public class GameScreen extends JPanel {

    public static final String NAME = "GameScreen";
    private MainGUI mainGui;
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

    /**
     * This function is responsible for reseting the variables(money, fifty
     * status, questions to display) after the user has played. It essentially
     * allows the user to retry the game without having the same set of
     * questions.
     */
    public void retryGame() {
        testQ = 0;
        ContinueVariables.setMoney(0);
        randomsetQuestions.clear();
        initialisesetRandom();
        fiftyStatus = false;
        question.setText(gl.getGameQuestion().get(randomsetQuestions.get(testQ)));
        money.setText("Money Earned: $" + String.valueOf(player.getMoneyEachQuestion().get(testQ)));
        aChoice.setText(gl.getGameAchoice().get(randomsetQuestions.get(testQ)));
        bChoice.setText(gl.getGameBchoice().get(randomsetQuestions.get(testQ)));
        cChoice.setText(gl.getGameCchoice().get(randomsetQuestions.get(testQ)));
        dChoice.setText(gl.getGameDchoice().get(randomsetQuestions.get(testQ)));
    }

    /**
     * This function is allowing the fifty fifty lifeline to work. It is
     * disabling two incorrect answers and one correct answer and incorrect
     * answer
     *
     * @param noQuestion: The current question number being displayed.
     */
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

    /**
     * This function is responsible for displaying the next question.
     *
     * @param noQuestion: Current question number
     */
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

    /**
     * This method is displaying the current progress of the user. It is
     * painting the background color of the table based on the amount of money
     * earned.
     */
    DefaultTableModel model = new DefaultTableModel(prizeDisplay, column);
    JTable leaderboardTable = new JTable(model) {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);

            if (!getValueAt(0, 0).toString().equals("") && columnIndex > testQ) {
                component.setBackground(Color.RED);
            } else {
                component.setBackground(Color.GREEN);

            }

            return component;
        }
    };

    /**
     * This function is responsible for randomizing a set of questions based on
     * database information.
     */
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

    /**
     * Customizing buttons, background and text.
     */
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

    /**
     * This function is initializing the game screen and gathering information
     * from past functions, customizing buttons, validating user answer, and
     * updating the players progress.
     *
     * @param mainGui
     */
    public GameScreen(final MainGUI mainGui) {
        this.mainGui = mainGui;

        leaderboardTable.setDefaultEditor(Object.class, null);
        leaderboardTable.setRowHeight(80);

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
