/**
 * File: Main
 * Author: Kevin Tran
 * Created on: March, 26, 2024
 * Last Modified: April, 13, 2024
 * Description: Main Class of Guessing Game
 */
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("Guessing Game");

        // Hide the Windows Title Bar
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(new Scene(root, 540, 790));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
