package edu.ntnu.stud.idatt2003.gr35.controller;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.ViewPage;
import java.io.FileNotFoundException;
import java.util.Objects;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Controller class for the scene.
 */
public class SceneController {
  // The scene to be displayed.
  private final Scene scene;
  // The view page to be displayed.
  private final ViewPage viewPage;

  /**
   * Constructor for the SceneController.
   *
   * @param primaryStage The primary stage.
   * @throws FileNotFoundException If the file is not found.
   */
  public SceneController(Stage primaryStage) throws FileNotFoundException {
    this.scene = new Scene(new StackPane(), 1280, 720);

    scene.getStylesheets().add(
        Objects.requireNonNull(getClass().getResource("/view/stylesheet.css")).toExternalForm()
    );

    primaryStage.setScene(scene);
    this.viewPage = new ViewPage();
  }

  /**
   * Shows the view page.
   */
  public void showViewPage() {
    scene.setRoot(viewPage.getRoot());
  }
}

