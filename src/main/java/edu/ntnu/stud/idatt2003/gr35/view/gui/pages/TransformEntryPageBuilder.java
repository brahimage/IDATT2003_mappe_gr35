package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Sign;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.JuliaTransform;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A builder class for building pages for adding transformations to a chaos game description.
 */
public abstract class TransformEntryPageBuilder {
  static Transform2D transform;

  /**
   * Builds a page for adding an affine transformation.
   * Consists of fields for each element in a 2*2 matrix and a translation vector.
   *
   * @return The page for adding the affine transformation.
   */
  public static StackPane buildAffineTransformationPage(TransformEntryPagePopUp stage) {
    VBox pageElementsVBox = new VBox(10);

    Text header = new Text("Affine Transformation");
    header.setId("header");

    Text matrixHeader = new Text("Matrix");
    matrixHeader.setId("sub-header");

    TextField a00Field = new TextField();
    TextField a01Field = new TextField();
    TextField a10Field = new TextField();
    TextField a11Field = new TextField();

    GridPane affineMatrixGrid = new GridPane();

    affineMatrixGrid.add(new Text("a00"), 0, 0);
    affineMatrixGrid.add(a00Field, 1, 0);
    affineMatrixGrid.add(new Text("a01"), 2, 0);
    affineMatrixGrid.add(a01Field, 3, 0);
    affineMatrixGrid.add(new Text("a10"), 0, 1);
    affineMatrixGrid.add(a10Field, 1, 1);
    affineMatrixGrid.add(new Text("a11"), 2, 1);
    affineMatrixGrid.add(a11Field, 3, 1);

    Text vectorHeader = new Text("Translation Vector");
    vectorHeader.setId("sub-header");

    TextField b0Field = new TextField();
    TextField b1Field = new TextField();

    GridPane translationVectorGrid = new GridPane();

    translationVectorGrid.add(new Text("b0"), 0, 0);
    translationVectorGrid.add(b0Field, 1, 0);
    translationVectorGrid.add(new Text("b1"), 0, 1);
    translationVectorGrid.add(b1Field, 1, 1);

    Button saveButton = new Button("Save");
    saveButton.setId("save-button");
    Button cancelButton = new Button("Cancel");
    cancelButton.setId("small-button");

    cancelButton.setOnAction(e -> stage.close());
    saveButton.setOnAction(e -> {
      try {
        double a00 = Double.parseDouble(a00Field.getText());
        double a01 = Double.parseDouble(a01Field.getText());
        double a10 = Double.parseDouble(a10Field.getText());
        double a11 = Double.parseDouble(a11Field.getText());
        double b0 = Double.parseDouble(b0Field.getText());
        double b1 = Double.parseDouble(b1Field.getText());
        transform = new AffineTransform2D(new Matrix2x2(a00, a01, a10, a11), new Vector2D(b0, b1));
        stage.passTransform(transform);
        stage.close();
      } catch (Exception exc) {
        new Alert(Alert.AlertType.WARNING, "Please enter valid numbers in all fields.").show();
      }

    });

    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(saveButton, cancelButton);

    pageElementsVBox.getChildren().addAll(header, matrixHeader, affineMatrixGrid, vectorHeader, translationVectorGrid, buttonBox);
    pageElementsVBox.paddingProperty().setValue(new javafx.geometry.Insets(20));

    StackPane out = new StackPane();
    out.getChildren().add(pageElementsVBox);
    return out;
  }

  /**
   * Builds a page for adding a Julia transformation.
   * Consists of fields for the real and imaginary part of the constant c.
   *
   * @return The page for adding the Julia transformation.
   */
  public static StackPane buildJuliaTransformationPage(TransformEntryPagePopUp stage) {
    VBox pageElementsVBox = new VBox(10);

    Text header = new Text("Julia Transformation");
    header.setId("header");

    Text constantHeader = new Text("Constant c");
    constantHeader.setId("sub-header");

    TextField realField = new TextField();
    TextField imaginaryField = new TextField();

    GridPane constantGrid = new GridPane();

    constantGrid.add(new Text("Real"), 0, 0);
    constantGrid.add(realField, 1, 0);
    constantGrid.add(new Text("Imaginary"), 0, 1);
    constantGrid.add(imaginaryField, 1, 1);

    HBox signBox = new HBox();
    ComboBox<String> signComboBox = new ComboBox<>();
    signComboBox.getItems().addAll("Positive", "Negative");
    signBox.getChildren().addAll(new Text("Sign: "), signComboBox);

    Button saveButton = new Button("Save");
    saveButton.setId("save-button");
    Button cancelButton = new Button("Cancel");
    cancelButton.setId("small-button");

    cancelButton.setOnAction(e -> stage.close());
    saveButton.setOnAction(e -> {
      try {
        double real = Double.parseDouble(realField.getText());
        double imaginary = Double.parseDouble(imaginaryField.getText());
        Sign sign = signComboBox.getValue().equals("Positive") ? Sign.POSITIVE : Sign.NEGATIVE;
        transform = new JuliaTransform(new Complex(real, imaginary), sign);
        stage.passTransform(transform);
        stage.close();
      } catch (Exception exc) {
        new Alert(Alert.AlertType.WARNING, "Please enter valid numbers in all fields.").show();
      }
    });

    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(saveButton, cancelButton);

    pageElementsVBox.getChildren().addAll(header, constantHeader, constantGrid, signBox, buttonBox);
    pageElementsVBox.paddingProperty().setValue(new javafx.geometry.Insets(20));

    StackPane out = new StackPane();
    out.getChildren().add(pageElementsVBox);
    return out;
  }

  /**
   * Gets the transform that was created in the last page built by this class.
   *
   * @return The transform that was created in the last page built by this class.
   */
  public static Transform2D getTransform() {
    return transform;
  }
}