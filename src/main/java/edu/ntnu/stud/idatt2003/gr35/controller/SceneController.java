package edu.ntnu.stud.idatt2003.gr35.controller;

import edu.ntnu.stud.idatt2003.gr35.ChaosGame;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.PlayButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.ViewPage;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller class for the scene.
 */
public class SceneController {
  // The scene to be displayed.
  private final Scene scene;
  // The view page to be displayed.
  private final ViewPage viewPage;
  // The dimensions of the canvas.
  private Vector2D canvasDimensions;

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
   * Gets the dimensions of the canvas.
   *
   * @return The dimensions of the canvas
   */
  public Vector2D getCanvasDimensions() {
    return canvasDimensions;
  }

  /**
   * Shows the view page.
   */
  public void showViewPage() {
    scene.setRoot(viewPage.getRoot());
  }
}

