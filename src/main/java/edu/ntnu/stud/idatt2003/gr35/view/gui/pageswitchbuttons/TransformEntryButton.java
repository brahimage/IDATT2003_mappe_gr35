package edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.TransformEntryPagePopUp;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.VariablePagePopUp;
import javafx.scene.control.Button;

/**
 * A button that opens a pop-up window for adding a transform to a new chaos game description.
 */
public class TransformEntryButton extends Button {

  /**
   * Constructs a new TransformEntryPopUpButton.
   */
  public TransformEntryButton(VariablePagePopUp pagePopUp) {
    super();

    this.setText("Add Transform");
    this.setId("small-button");
    this.setPrefWidth(150);

    // Opens a new pop-up window for adding a new variable.
    this.setOnAction(e -> {
      new TransformEntryPagePopUp(pagePopUp).showPopUp();
    });
  }
}
