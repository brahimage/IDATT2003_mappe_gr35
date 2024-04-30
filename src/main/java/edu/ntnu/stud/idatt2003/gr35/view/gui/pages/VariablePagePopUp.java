package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pageelements.DoubleTextField;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pageelements.IntTextField;
import java.util.Objects;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class VariablePagePopUp extends Stage {
  private final DoubleTextField x0MinCoordField;
  private final DoubleTextField x1MinCoordField;
  private final DoubleTextField x0MaxCoordField;
  private final DoubleTextField x1MaxCoordField;

  private final DoubleTextField constantField;

  private final DoubleTextField a00MatrixField;
  private final DoubleTextField a01MatrixField;
  private final DoubleTextField a10MatrixField;
  private final DoubleTextField a11MatrixField;

  private final DoubleTextField x0VectorField;
  private final DoubleTextField x1VectorField;

  private final IntTextField stepField;

  private final StackPane root;

  VBox pageElementsVBox = new VBox(10);
  HBox cancelConfirmButtonHBox = new HBox(10);
  HBox minCoordsHBox = new HBox(10);
  HBox maxCoordsHBox = new HBox(10);
  HBox matrixHBox = new HBox(10);
  HBox vectorHBox = new HBox(10);


  public VariablePagePopUp() {
    super();

    this.root = new StackPane();

    this.x0MinCoordField = new DoubleTextField();
    this.x1MinCoordField = new DoubleTextField();
    this.x0MaxCoordField = new DoubleTextField();
    this.x1MaxCoordField = new DoubleTextField();

    this.constantField = new DoubleTextField();

    this.a00MatrixField = new DoubleTextField();
    this.a01MatrixField = new DoubleTextField();
    this.a10MatrixField = new DoubleTextField();
    this.a11MatrixField = new DoubleTextField();

    this.x0VectorField = new DoubleTextField();
    this.x1VectorField = new DoubleTextField();

    this.stepField = new IntTextField();

    GridPane minCoords = new GridPane();
    HBox x0HBox = new HBox();
    Label x0Label = new Label("x0: ");
    x0HBox.getChildren().addAll(x0Label, x0MinCoordField);
    x0HBox.setAlignment(Pos.CENTER);

    HBox x1HBox = new HBox();
    Label x1Label = new Label("x1: ");
    x1HBox.getChildren().addAll(x1Label, x1MinCoordField);
    x1HBox.setAlignment(Pos.CENTER);

    minCoords.add(x0HBox, 0, 0);
    minCoords.add(x1HBox, 0, 1);
    minCoords.setVgap(10);
    minCoordsHBox.getChildren().addAll(new Text("Min Coords: "), minCoords);


    GridPane maxCoords = new GridPane();
    HBox x0HBox2 = new HBox();
    Label x0Label2 = new Label("x0: ");
    x0HBox.getChildren().addAll(x0Label2, x0MaxCoordField);
    x0HBox.setAlignment(Pos.CENTER);

    HBox x1HBox2 = new HBox();
    Label x1Label2 = new Label("x1: ");
    x1HBox.getChildren().addAll(x1Label2, x1MaxCoordField);
    x1HBox.setAlignment(Pos.CENTER);

    maxCoords.add(x0HBox2, 0, 0);
    maxCoords.add(x1HBox2, 0, 1);
    maxCoords.setVgap(10);
    maxCoordsHBox.getChildren().addAll(maxCoords);

    GridPane matrix = new GridPane();

    HBox a00MatrixHBox = new HBox();
    Label a00MatrixLabel = new Label("a00: ");
    a00MatrixHBox.getChildren().addAll(a00MatrixLabel, a00MatrixField);
    a00MatrixHBox.setAlignment(Pos.CENTER_LEFT);

    HBox a01MatrixHBox = new HBox();
    Label a01MatrixLabel = new Label("a01: ");
    a01MatrixHBox.getChildren().addAll(a01MatrixLabel, a01MatrixField);
    a01MatrixHBox.setAlignment(Pos.CENTER_LEFT);

    HBox a10MatrixHBox = new HBox();
    Label a10MatrixLabel = new Label("a10: ");
    a10MatrixHBox.getChildren().addAll(a10MatrixLabel, a10MatrixField);
    a10MatrixHBox.setAlignment(Pos.CENTER_LEFT);

    HBox a11MatrixHBox = new HBox();
    Label a11MatrixLabel = new Label("a11: ");
    a11MatrixHBox.getChildren().addAll(a11MatrixLabel, a11MatrixField);
    a11MatrixHBox.setAlignment(Pos.CENTER_LEFT);

    matrix.add(a00MatrixHBox, 0, 0);
    matrix.add(a01MatrixHBox, 1, 0);
    matrix.add(a10MatrixHBox, 0, 1);
    matrix.add(a11MatrixHBox, 1, 1);
    matrix.setHgap(10);
    matrix.setVgap(10);
    matrixHBox.getChildren().addAll(new Text("Matrix: "), matrix);

    GridPane vector = new GridPane();
    HBox x0VectorHBox = new HBox();
    Label x0VectorLabel = new Label("x0: ");
    x0VectorHBox.getChildren().addAll(x0VectorLabel, x0VectorField);
    x0VectorHBox.setAlignment(Pos.CENTER_LEFT);

    HBox x1VectorHBox = new HBox();
    Label x1VectorLabel = new Label("x1: ");
    x1VectorHBox.getChildren().addAll(x1VectorLabel, x1VectorField);
    x1VectorHBox.setAlignment(Pos.CENTER_LEFT);

    vector.add(x0VectorHBox, 0, 0);
    vector.add(x1VectorHBox, 1, 0);
    vector.setVgap(10);
    vectorHBox.getChildren().addAll(new Text("Vector: "), vector);

    pageElementsVBox.getChildren().addAll(minCoordsHBox, maxCoordsHBox, matrixHBox, vectorHBox, constantField, stepField);

    root.getChildren().addAll(pageElementsVBox);
  }

  public double getX0MinCoord() {
    return Double.parseDouble(x0MinCoordField.getText());
  }

  public double getX1MinCoord() {
    return Double.parseDouble(x1MinCoordField.getText());
  }

  public double getX0MaxCoord() {
    return Double.parseDouble(x0MaxCoordField.getText());
  }

  public double getX1MaxCoord() {
    return Double.parseDouble(x1MaxCoordField.getText());
  }

  public double getConstant() {
    return Double.parseDouble(constantField.getText());
  }

  public double getA00Matrix() {
    return Double.parseDouble(a00MatrixField.getText());
  }

  public double getA01Matrix() {
    return Double.parseDouble(a01MatrixField.getText());
  }

  public double getA10Matrix() {
    return Double.parseDouble(a10MatrixField.getText());
  }

  public double getA11Matrix() {
    return Double.parseDouble(a11MatrixField.getText());
  }

  public double getX0Vector() {
    return Double.parseDouble(x0VectorField.getText());
  }

  public double getX1Vector() {
    return Double.parseDouble(x1VectorField.getText());
  }

  public int getStep() {
    return Integer.parseInt(stepField.getText());
  }

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
}
