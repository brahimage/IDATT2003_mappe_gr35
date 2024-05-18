package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescription;
import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameFileHandler;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pageelements.DoubleTextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons.TransformEntryButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * A pop-up window that allows the user to input values for a variable page.
 */
public class VariablePagePopUp extends Stage {
  private ViewPage viewPage;

  // Textfield for the user to input the name of the new chaos game description
  private final TextField nameField;

  // TextFields for the user to input values for min and max coordinates
  private final DoubleTextField x0MinCoordField;
  private final DoubleTextField x1MinCoordField;
  private final DoubleTextField x0MaxCoordField;
  private final DoubleTextField x1MaxCoordField;


  // Drop-down menu for the user to select transform type
  private final ComboBox<String> transformTypeComboBox;
  // Button for the user to add a transform
  private final TransformEntryButton addTransformButton;

  // Button to cancel
  private final Button cancelButton;

  // Button to save
  private final Button saveButton;

  // The root of the scene
  private final StackPane root;

  // Layout elements
  VBox pageElementsVBox = new VBox(10);
  HBox cancelConfirmButtonHBox = new HBox(10);
  HBox minCoordsHBox = new HBox(10);
  HBox maxCoordsHBox = new HBox(10);

  private List<Transform2D> transforms;

  /**
   * Constructs a new VariablePagePopUp.
   */
  public VariablePagePopUp(ViewPage viewPage) {
    super();

    this.viewPage = viewPage;

    transforms = new ArrayList<>();

    this.root = new StackPane();

    this.nameField = new TextField();

    this.x0MinCoordField = new DoubleTextField();
    this.x1MinCoordField = new DoubleTextField();
    this.x0MaxCoordField = new DoubleTextField();
    this.x1MaxCoordField = new DoubleTextField();

    this.transformTypeComboBox = new ComboBox<>();
    String[] items = {"Affine", "Julia"};
    transformTypeComboBox.getItems().addAll(items);

    this.addTransformButton = new TransformEntryButton(this);
    this.cancelButton = new Button("Cancel");
    this.saveButton = new Button("Save");

    cancelButton.setId("small-button");
    saveButton.setId("save-button");

    cancelButton.setOnAction(e -> this.close());
    saveButton.setOnAction(e -> {
      try {
        ChaosGameDescription chaosGameDescription = new ChaosGameDescription(
            new Vector2D(getX0MinCoord(), getX1MinCoord()),
            new Vector2D(getX0MaxCoord(), getX1MaxCoord()),
            transforms);
        ChaosGameFileHandler.writeToFile(chaosGameDescription, "ChaosGames/" + getName() + ".json");
        viewPage.updateComboBox();
        this.close();
      } catch (Exception exception) {
        new Alert(Alert.AlertType.WARNING, "Exception occurred: Make sure to fill out all fields correctly.").show();
      }

    });

    // Create HBox for name label and textField
    HBox nameHBox = new HBox();
    nameHBox.setId("textFieldHBox");
    Label nameLabel = new Label("Name: ");
    nameHBox.getChildren().addAll(nameLabel, nameField);

    GridPane minCoords = new GridPane();
    HBox x0HBox = new HBox();
    x0HBox.setId("textFieldHBox");
    Label x0Label = new Label("x0: ");
    x0HBox.getChildren().addAll(x0Label, x0MinCoordField);
    x0HBox.setAlignment(Pos.CENTER);

    HBox x1HBox = new HBox();
    x1HBox.setId("textFieldHBox");
    Label x1Label = new Label("x1: ");
    x1HBox.getChildren().addAll(x1Label, x1MinCoordField);
    x1HBox.setAlignment(Pos.CENTER);

    minCoords.add(x0HBox, 0, 0);
    minCoords.add(x1HBox, 0, 1);
    minCoords.setVgap(10);
    minCoordsHBox.getChildren().addAll(new Text("Min Coords: "), minCoords);


    GridPane maxCoords = new GridPane();
    HBox x0HBox2 = new HBox();
    x0HBox2.setId("textFieldHBox");
    Label x0Label2 = new Label("x0: ");
    x0HBox.getChildren().addAll(x0Label2, x0MaxCoordField);
    x0HBox.setAlignment(Pos.CENTER);

    HBox x1HBox2 = new HBox();
    x1HBox2.setId("textFieldHBox");
    Label x1Label2 = new Label("x1: ");
    x1HBox.getChildren().addAll(x1Label2, x1MaxCoordField);
    x1HBox.setAlignment(Pos.CENTER);

    maxCoords.add(x0HBox2, 0, 0);
    maxCoords.add(x1HBox2, 0, 1);
    maxCoords.setVgap(110);
    maxCoordsHBox.getChildren().addAll(maxCoords);

    HBox transformTypeHBox = new HBox();
    transformTypeHBox.setId("textFieldHBox");
    Label transformTypeLabel = new Label("Transform Type: ");
    transformTypeHBox.getChildren().addAll(transformTypeLabel, transformTypeComboBox);

    // Create HBox for add transform button
    HBox addTransformButtonHBox = new HBox();
    addTransformButtonHBox.getChildren().add(addTransformButton);

    // Create HBox for cancel and save buttons
    HBox cancelSaveButtonHBox = new HBox();
    cancelSaveButtonHBox.getChildren().addAll(cancelButton, saveButton);

    pageElementsVBox.getChildren().addAll(nameHBox, minCoordsHBox, maxCoordsHBox, transformTypeHBox, addTransformButtonHBox, cancelSaveButtonHBox);

    root.getChildren().addAll(pageElementsVBox);
  }

  /**
   * Gets the minimum x0 coordinate.
   *
   * @return the minimum x0 coordinate.
   */
  public double getX0MinCoord() {
    return Double.parseDouble(x0MinCoordField.getText());
  }

  /**
   * Gets the minimum x1 coordinate.
   *
   * @return the minimum x1 coordinate.
   */
  public double getX1MinCoord() {
    return Double.parseDouble(x1MinCoordField.getText());
  }

  /**
   * Gets the maximum x0 coordinate.
   *
   * @return the maximum x0 coordinate.
   */
  public double getX0MaxCoord() {
    return Double.parseDouble(x0MaxCoordField.getText());
  }

  /**
   * Gets the maximum x1 coordinate.
   *
   * @return the maximum x1 coordinate.
   */
  public double getX1MaxCoord() {
    return Double.parseDouble(x1MaxCoordField.getText());
  }

  /**
   * Gets the input name.
   *
   * @return the name of the chaos game description.
   */
  public String getName() {
    return nameField.getText();
  }

  /**
   * Shows the pop-up window.
   */
  public void showPopUp() {
    Scene scene = new Scene(root, 1120, 604);
    scene.getStylesheets().add(
        Objects.requireNonNull(getClass().getResource("/view/stylesheet.css")).toExternalForm());

    this.setResizable(false);

    // Keeps the user from accessing the rest of the application while the window is open
    this.initModality(Modality.APPLICATION_MODAL);
    this.setScene(scene);
    this.show();
  }

  /**
   * Adds a transform to the list of transforms.
   *
   * @param transform The transform to add.
   */
  public void addTransform(Transform2D transform) {
    transforms.add(transform);
    System.out.println(transforms.size());
  }
}
