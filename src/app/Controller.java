package app;
/**
 * File: Controller.java
 * Author: Kevin Tran
 * Created on: March, 26, 2024
 * Last Modified: April, 13, 2024
 * Description: Controller Class of Guessing Game
 */

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Random;

public class Controller {
    private static final int GUESS_RANGE = 101;
    private static final int NUM_CHANCES = 10;

    private Random random;

    // Stores values for the number of chances and guesses user has
    private int numGuess, chanceCounter;
    // xOffset and yOffset used to get frame position
    private double xOffset, yOffset;
    @FXML
    private Button minBtn;

    @FXML
    private Button closeBtn;

    @FXML
    private GridPane titleBar;

    @FXML
    private GridPane gameDisplay;

    @FXML
    private GridPane mainMenu;

    @FXML
    private Label chanceCounterLabel;

    @FXML
    private TextField userInputField;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button retryBtn;

    @FXML
    private Label hintLabel;

    @FXML
    private Button mainMenuBtn;

    public void initialize() {
        random = new Random();

        // Generate a random number from 0 to GUESS_RANGE - 1
        numGuess = random.nextInt(GUESS_RANGE);

        // Set initial number of chances
        chanceCounter = NUM_CHANCES;

    }

    public void handleMainMenuAction() {
        // Hide retry button
        retryBtn.setVisible(false);

        // Set menu background
        backgroundImage.setImage((new Image(getClass().getResourceAsStream("/resources/background.png"))));

        //Hide main menu button
        mainMenuBtn.setVisible(false);

        //Display main menu
        mainMenu.setVisible(true);

        // Display game background
        backgroundImage.setImage(new Image(getClass().getResourceAsStream("/resources/background.png")));

        // Generate new number to guess
        numGuess = random.nextInt(GUESS_RANGE);

        // Reset chances
        chanceCounter = NUM_CHANCES;

        // Hide retry button
        retryBtn.setVisible(false);

        // Reset hint
        hintLabel.setText("");

        // Reset input field
        userInputField.setText("");

    }

    public void handleEnterAction() {
        int userGuess;

        try {
            // Stores number from the user input
            userGuess = Integer.parseInt(userInputField.getText().trim());

            if (userGuess == numGuess) {
                // Display winner screen
                backgroundImage.setImage(new Image(getClass().getResourceAsStream("/resources/congraulations.png")));

                // Hide game display
                gameDisplay.setVisible(false);

                // Show retry button
                retryBtn.setVisible(true);
            } else {
                // Decrease chance counter if user fails and updates label
                chanceCounter--;
                chanceCounterLabel.setText("You have " + chanceCounter + " guess" +
                        (chanceCounter == 1 ? "" : "es") + " left!");

                if (chanceCounter <= 0) {
                    // Display Game Over Screen
                    backgroundImage.setImage((new Image(getClass().getResourceAsStream("/resources/game_over.png"))));

                    // Hide Game Display
                    gameDisplay.setVisible(false);

                    // Show Retry Button
                    retryBtn.setVisible(true);
                    mainMenuBtn.setVisible(true);
                }
            }

            // Update hint
            if (userGuess < numGuess) {
                hintLabel.setText("Too Low!");
            } else {
                hintLabel.setText("Too High!");
            }
        } catch (Exception e) {
            hintLabel.setText("That isn't a number!");
        }
    }

    public void handleTryAgainAction() {
        // Display game background
        backgroundImage.setImage(new Image(getClass().getResourceAsStream("/resources/background.png")));

        // Display game layout
        gameDisplay.setVisible(true);

        // Generate new number to guess
        numGuess = random.nextInt(GUESS_RANGE);

        // Reset chances
        chanceCounter = NUM_CHANCES;

        // Hide retry button
        retryBtn.setVisible(false);

        // Hide main menu button
        mainMenuBtn.setVisible(false);

        // Reset hint
        hintLabel.setText("");

        // Reset input field
        userInputField.setText("");

        hintLabel.setText("");

        // Update the count label to show intial value
        chanceCounterLabel.setText("You have 10 guesses!");

    }

    // Starting the game
    public void handleStartAction() {
        // Hide menu
        mainMenu.setVisible(false);

        // Display game
        gameDisplay.setVisible(true);

        chanceCounterLabel.setText("You have 10 guesses!");
    }

    // Exit Game
    public void handleExitAction() {
        Platform.exit();
    }

    // Close Window
    public void handleClosedAction() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    // Minimize Window
    public void handleMinBtn() {
        Stage stage = (Stage) minBtn.getScene().getWindow();
        stage.setIconified(true);
    }

    // Calculate exact position of Window on screen
    public void handleTitleBarClickAction(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
        event.consume();
    }

    // Enables movement of Window through dragging cursor
    public void handleTitleBarMovementAction(MouseEvent event) {
        Scene scene = titleBar.getScene();
        Window window = scene.getWindow();

        window.setX(event.getScreenX() - xOffset);
        window.setY(event.getScreenY() - yOffset);
        event.consume();
    }
}
