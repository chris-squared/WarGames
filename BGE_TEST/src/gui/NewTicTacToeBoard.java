package gui;

import NewBoard.Board;
import games.tictactoe.TicTacToeEngine;
import games.tictactoe.TicTacToeLogic;
import games.tictactoe.TicTacToeState;
import games.tictactoe.Utility;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class NewTicTacToeBoard extends Board{

    TicTacToeState state;
    TicTacToeLogic ticTacToeLogic;
    TicTacToeEngine engine;

    int turn;
    boolean endCheck;

    public NewTicTacToeBoard(AnchorPane anchorPane){
        super(anchorPane.getPrefWidth(),anchorPane.getPrefHeight(),3,3);
        state = new TicTacToeState();
        ticTacToeLogic = new TicTacToeLogic(state);
        engine = new TicTacToeEngine(state,ticTacToeLogic);

        Utility.printMenu();
        turn = 1;
        state.gameBoard.printBoard();
    }



}
