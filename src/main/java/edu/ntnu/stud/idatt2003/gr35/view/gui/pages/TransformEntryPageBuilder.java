package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import javafx.scene.layout.StackPane;

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
  public static StackPane buildAffineTransformationPage() {
    // TODO - Implement
    return new StackPane();
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