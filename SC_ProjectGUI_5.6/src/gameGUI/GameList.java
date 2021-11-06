/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameGUI;

import databaseSetup.DatabaseInitialise;
import databaseSetup.DatabaseInitialiseMain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Enrico
 */
public class GameList {

    private ArrayList<String> gameQuestion = new ArrayList<String>();
    private ArrayList<String> gameAchoice = new ArrayList<String>();
    private ArrayList<String> gameBchoice = new ArrayList<String>();
    private ArrayList<String> gameCchoice = new ArrayList<String>();
    private ArrayList<String> gameDchoice = new ArrayList<String>();
    private ArrayList<String> gameAnswer = new ArrayList<String>();

    public ArrayList<String> getGameQuestion() {
        return gameQuestion;
    }

    public void setGameQuestion(ArrayList<String> gameQuestion) {
        this.gameQuestion = gameQuestion;
    }

    public ArrayList<String> getGameAchoice() {
        return gameAchoice;
    }

    public void setGameAchoice(ArrayList<String> gameAchoice) {
        this.gameAchoice = gameAchoice;
    }

    public ArrayList<String> getGameBchoice() {
        return gameBchoice;
    }

    public void setGameBchoice(ArrayList<String> gameBchoice) {
        this.gameBchoice = gameBchoice;
    }

    public ArrayList<String> getGameCchoice() {
        return gameCchoice;
    }

    public void setGameCchoice(ArrayList<String> gameCchoice) {
        this.gameCchoice = gameCchoice;
    }

    public ArrayList<String> getGameDchoice() {
        return gameDchoice;
    }

    public void setGameDchoice(ArrayList<String> gameDchoice) {
        this.gameDchoice = gameDchoice;
    }

    public ArrayList<String> getGameAnswer() {
        return gameAnswer;
    }

    public void setGameAnswer(ArrayList<String> gameAnswer) {
        this.gameAnswer = gameAnswer;
    }

    public GameList() {
        gameSetup();
    }

    public void gameSetup() {
        DatabaseInitialiseMain ldb = new DatabaseInitialiseMain();
        ldb.displaySetupGame();

        for (String question : ldb.getgameQuestion()) {
            this.gameQuestion.add(question);
        }
        for (String achoice : ldb.getgameAchoice()) {
            this.gameAchoice.add(achoice);
        }
        for (String bchoice : ldb.getgameBchoice()) {
            this.gameBchoice.add(bchoice);
        }
        for (String cchoice : ldb.getgameCchoice()) {
            this.gameCchoice.add(cchoice);
        }
        for (String dchoice : ldb.getgameDchoice()) {
            this.gameDchoice.add(dchoice);
        }
        for (String answer : ldb.getgameAnswer()) {
            this.gameAnswer.add(answer);
        }

    }
}
