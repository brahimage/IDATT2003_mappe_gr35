package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.controller.SceneController;
import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescription;
import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescriptionFactory;
import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameFileHandler;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Observable;
import java.util.Observer;

/**
 * The main class for the application.

 */
public class MainUI extends Application implements Observer {
    ChaosGame chaosGame;
    SceneController sceneController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChaosGameDescriptionFactory.GenerateTestFiles();

        sceneController = new SceneController(primaryStage);
        sceneController.addObserver(this);

        primaryStage.setTitle("Chaos Game!");

        sceneController.showViewPage();
        primaryStage.show();

        // Loading the canvas calculates the size of certain elements dynamically.
        // Because of this, it must be done AFTER the stage is shown.
        sceneController.loadCanvas();
    }

    /**
     * update method called when play button is pressed.
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
    }
}