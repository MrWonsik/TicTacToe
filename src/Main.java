import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("javaFX/TicTacToe.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        /*Game newGame = new Game();
        newGame.getGameBoard().showGameBoard();
        Scanner scaner = new Scanner(System.in);
        int X = 0;
        int Y = 0;
        while(!newGame.isEnd()) {
            newGame.cpuTurn();
            newGame.getGameBoard().showGameBoard();
            System.out.println();

        }
        System.out.println("End Game");*/
        launch(args);
    }
}
