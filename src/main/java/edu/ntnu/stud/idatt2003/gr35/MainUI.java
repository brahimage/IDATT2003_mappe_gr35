package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class for the application.

 */
public class MainUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneController sceneController = new SceneController(primaryStage);

        primaryStage.setTitle("Chaos Game!");

        sceneController.showViewPage();
        primaryStage.show();
    }
}
