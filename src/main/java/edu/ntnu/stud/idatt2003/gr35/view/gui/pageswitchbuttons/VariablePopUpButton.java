package edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.VariablePagePopUp;
import javafx.scene.control.Button;

/**
 * A button that opens a pop-up window for adding a new variable.
 */
public class VariablePopUpButton extends Button {

  /**
   * Constructs a new VariablePopUpButton.
   */
  public VariablePopUpButton() {
    super();

    this.setText("Edit Variables");
    this.setId("small-button");
    this.setPrefWidth(150);

    // Opens a new pop-up window for adding a new variable.
    this.setOnAction(e -> {
      new VariablePagePopUp().showPopUp();
    });
  }
}
