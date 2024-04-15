Guessing Game
=============

Overview
--------

The Guessing Game is an engaging, interactive JavaFX application that challenges players to guess a randomly generated number within a set number of attempts. Designed with an intuitive and visually appealing interface, it provides instant feedback and hints to guide players on whether their guesses are too high or too low.

Features
--------

*   **Interactive Gameplay**: Players have a limited number of attempts to guess the correct number.
*   **Real-Time Hints**: The game informs players if their guess is too high or too low after each attempt.
*   **Customizable UI**: A stylish user interface created with custom CSS that enhances the gaming experience.
*   **Responsive Design**: Works seamlessly across different JavaFX-supported devices, ensuring a consistent gaming experience.

Installation
------------

### Prerequisites

*   Java 8 or higher
*   JavaFX SDK

### Setup

1.  Clone the repository:
    
    bashCopy code
    
    `git clone https://github.com/yourusername/guessing-game.git`
    
2.  Navigate to the project directory:
    
    bashCopy code
    
    `cd guessing-game`
    
3.  Compile the code:
    
    bashCopy code
    
    `javac -cp path/to/javafx-sdk/lib --module-path path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d bin src/app/*.java`
    
4.  Run the application:
    
    bashCopy code
    
    `java -cp bin --module-path path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml app.Main`
    

How to Play
-----------

*   Start the game, and enter your guess in the input field.
*   Click the 'Guess' button or press Enter to submit your guess.
*   Use the hints provided after each guess to adjust your next guess.
