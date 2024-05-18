package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import javafx.scene.control.Button;
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
  /**
   * Builds a page for adding an affine transformation.
   * Consists of fields for each element in a 2*2 matrix and a translation vector.
   *
   * @return The page for adding the affine transformation.
   */
  public static StackPane buildAffineTransformationPage(Stage stage) {
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
  public static StackPane buildJuliaTransformationPage() {
    // TODO - Implement
    return new StackPane();
  }
}