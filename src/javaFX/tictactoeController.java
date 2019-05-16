package javaFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class tictactoeController {
    @FXML
    private void startGame(ActionEvent event) throws Exception {

    }

    @FXML
    private void exitGame(ActionEvent event) throws Exception {
        Platform.exit();
    }
}
