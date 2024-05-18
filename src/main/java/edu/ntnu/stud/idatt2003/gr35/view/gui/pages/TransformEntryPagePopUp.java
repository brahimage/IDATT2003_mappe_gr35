package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import java.util.Objects;

import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A pop-up window that allows the user to input values for a transform.
 */
public class TransformEntryPagePopUp extends Stage {
  // Contains a StackPane root that can be filled by classes representing different types of transform
  private final StackPane root;
  private VariablePagePopUp pagePopUp;

  /**
   * Constructs a new TransformEntryPagePopUp.
   */
  public TransformEntryPagePopUp(VariablePagePopUp pagePopUp, String transformType) {
    super();
    this.root = new StackPane();
    this.pagePopUp = pagePopUp;
    populate(transformType);
  }

  /**
   * Populates root stackpane with the elements of the transform entry page.
   *
   * @param transformType The type of transform to be added.
   */
  public void populate(String transformType) {
    switch (transformType) {
      case "Affine":
        root.getChildren().add(TransformEntryPageBuilder.buildAffineTransformationPage(this));
        break;
      case "Julia":
        root.getChildren().add(TransformEntryPageBuilder.buildJuliaTransformationPage());
        break;
      default:
        throw new IllegalArgumentException("Invalid transform type: " + transformType);
    }
  }

  /**
   * Fetches transform from the page builder and passes it to ViewPage.
   */
  public void passTransform(Transform2D transform) {
    pagePopUp.addTransform(transform);
  }

  /**
   * Shows the pop-up window.
   */
  public void showPopUp() {
    Scene scene = new Scene(root, 620, 404);
    scene.getStylesheets().add(
        Objects.requireNonNull(getClass().getResource("/view/stylesheet.css")).toExternalForm());

    this.setResizable(false);

    // Keeps the user from accessing the rest of the application while the window is open
    this.initModality(Modality.APPLICATION_MODAL);
    this.setScene(scene);
    this.show();
  }
}
