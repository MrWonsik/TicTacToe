package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.getGameBoard().showGameBoard();
        Scanner scaner = new Scanner(System.in);
        while(!newGame.isEnd()) {
            System.out.println();
            //newGame.setSignInBoard(X, Y, newGame.getPlayerSign());
            newGame.cpuTurn();
            newGame.getGameBoard().showGameBoard();
        }
        System.out.println("End Game");
        //launch(args);
    }
}
