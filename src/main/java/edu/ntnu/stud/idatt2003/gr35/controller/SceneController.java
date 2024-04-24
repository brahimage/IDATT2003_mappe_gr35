package edu.ntnu.stud.idatt2003.gr35.controller;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.ViewPage;
import java.io.FileNotFoundException;
import java.util.Objects;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneController {
  private final Scene scene;
  private final ViewPage viewPage;

  public SceneController(Stage primaryStage)
      throws FileNotFoundException {
    this.scene = new Scene(new StackPane(), 1280, 720);

    scene.getStylesheets().add(
        Objects.requireNonNull(getClass().getResource("/view/stylesheet.css")).toExternalForm()
    );

    primaryStage.setScene(scene);
    this.viewPage = new ViewPage();
  }

  public void showViewPage() {
    scene.setRoot(viewPage.getRoot());
  }
}

