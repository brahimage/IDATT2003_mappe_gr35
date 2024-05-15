package edu.ntnu.stud.idatt2003.gr35.controller;

import edu.ntnu.stud.idatt2003.gr35.ChaosGame;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.DeleteButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.PlayButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.SaveButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.ViewPage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;

/**
 * Controller class for the scene.
 */
public class SceneController extends Observable implements Observer {
  // The scene to be displayed.
  private final Scene scene;
  // The view page to be displayed.
  private final ViewPage viewPage;
  // The GraphicsContext for the canvas.
  private GraphicsContext gc;
  // The dimensions of the canvas.
  private Vector2D canvasDimensions;
  // The primary stage.
  private final Stage primaryStage;

  /**
   * Constructor for the SceneController.
   *
   * @param primaryStage The primary stage.
   * @throws FileNotFoundException If the file is not found.
   */
  public SceneController(Stage primaryStage) throws FileNotFoundException {
    this.scene = new Scene(new StackPane(), 1280, 720);
    this.primaryStage = primaryStage;
    scene.getStylesheets().add(
        Objects.requireNonNull(getClass().getResource("/view/stylesheet.css")).toExternalForm()
    );

    primaryStage.setScene(scene);
    this.viewPage = new ViewPage();
    initPlayButton();
    initDeleteButton();
    initSaveButton();
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

  /**
   * Loads a reference to the canvas graphics context.
   * Used to draw pixels on the canvas.
   */
  public void loadCanvas() {
    try {
      StackPane root = (StackPane) (viewPage.getChildren().get(0)).lookup("#fractal-view");
      Canvas canvas = (Canvas) root.getChildren().get(0);
      gc = canvas.getGraphicsContext2D();
      canvasDimensions = new Vector2D(canvas.getWidth(), canvas.getHeight());
    } catch (Exception e) {
      throw new RuntimeException("Could not find canvas");
    }
  }

  /**
   * Draws a pixel on the canvas at the specified position.
   *
   * @param pos The position to draw the pixel at.
   */
  public void drawPixel(Vector2D pos) {
    if (gc == null) {
      throw new RuntimeException("GraphicsContext not initialized");
    }
    if (pos.getx0() < 0 || pos.getx0() >= canvasDimensions.getx0() || pos.getx1() < 0
        || pos.getx1() >= canvasDimensions.getx1()) {
      throw new IllegalArgumentException("Position out of bounds");
    }
    gc.fillRect(pos.getx0(), pos.getx1(), 1, 1);
  }

  /**
   * Clears the canvas.
   */
  public void clearCanvas() {
    gc.clearRect(0, 0, canvasDimensions.getx0(), canvasDimensions.getx1());
  }

  public String getChosenGame() {
    return viewPage.getSelectedChaosGame();
  }

  /**
   * Saves the fractal image to a file.
   *
   * @param canvasDimensions The dimensions of the canvas.
   */
  public void saveFractalImage(Vector2D canvasDimensions) {
    Canvas canvas;
    try {
      StackPane root = (StackPane) (viewPage.getChildren().get(0)).lookup("#fractal-view");
      canvas = (Canvas) root.getChildren().get(0);
    } catch (Exception e) {
      throw new RuntimeException("Could not find canvas");
    }

    FileChooser saveFile = new FileChooser();
    saveFile.setTitle("Save Image");

    File file = saveFile.showSaveDialog(primaryStage);
    if (file != null) {
      try {
        WritableImage writableImage =
            new WritableImage((int) canvasDimensions.getx0(), (int) canvasDimensions.getx1());
        canvas.snapshot(new SnapshotParameters(), writableImage);
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
        ImageIO.write(renderedImage, "png", file);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Fetches the javaFX play button and adds an action listener to it.
   */
  private void initPlayButton() {
    try {
      VBox pageElements = null;
      for (Node node : viewPage.getChildren()) {
        if (node instanceof VBox) {
          pageElements = (VBox) node;
          break;
        }
      }
      BorderPane topBar = null;
      for (Node node : pageElements.getChildren()) {
        if (node instanceof BorderPane) {
          topBar = (BorderPane) node;
          break;
        }
      }
      HBox buttonContainer = (HBox) topBar.getLeft();
      PlayButton playButton;
      for (Node node : buttonContainer.getChildren()) {
        if (node instanceof PlayButton) {
          playButton = (PlayButton) node;
          playButton.setOnAction(e -> {
            setChanged();
            notifyObservers();
          });
        }
      }
    } catch (Exception e) {
      throw new RuntimeException("ERROR");
    }
  }

  public void initDeleteButton() {
    try {
      VBox pageElements = null;
      for (Node node : viewPage.getChildren()) {
        if (node instanceof VBox) {
          pageElements = (VBox) node;
          break;
        }
      }
      BorderPane topBar = null;
      for (Node node : pageElements.getChildren()) {
        if (node instanceof BorderPane) {
          topBar = (BorderPane) node;
          break;
        }
      }
      HBox buttonContainer = (HBox) topBar.getLeft();
      DeleteButton deleteButton;
      for (Node node : buttonContainer.getChildren()) {
        if (node instanceof DeleteButton) {
          deleteButton = (DeleteButton) node;
          deleteButton.setOnAction(e -> {
            clearCanvas();
            notifyObservers();
          });
        }
      }
    } catch (Exception e) {
      throw new RuntimeException("ERROR");
    }
  }

  public void initSaveButton() {
    try {
      VBox pageElements = null;
      for (Node node : viewPage.getChildren()) {
        if (node instanceof VBox) {
          pageElements = (VBox) node;
          break;
        }
      }
      BorderPane topBar = null;
      for (Node node : pageElements.getChildren()) {
        if (node instanceof BorderPane) {
          topBar = (BorderPane) node;
          break;
        }
      }
      HBox buttonContainer = (HBox) topBar.getLeft();
      SaveButton saveButton;
      for (Node node : buttonContainer.getChildren()) {
        if (node instanceof SaveButton) {
          saveButton = (SaveButton) node;
          saveButton.setOnAction(e -> {
            saveFractalImage(canvasDimensions);
            System.out.println("Save button pressed");
            setChanged();
            notifyObservers();
          });
        }
      }
    } catch (Exception e) {
      throw new RuntimeException("ERROR");
    }
  }

  /**
   * update method called for each pixel drawn in chaos game.
   *
   * @param o   the observable object.
   * @param arg an argument passed to the {@code notifyObservers}
   *            method.
   */
  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof ChaosGame) {
      if (arg instanceof Vector2D) {
        drawPixel((Vector2D) arg);
      }
    }
  }
}