package edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons;

import edu.ntnu.stud.idatt2003.gr35.view.gui.pages.VariablePagePopUp;
import javafx.scene.control.Button;

public class VariablePopUpButton extends Button {

  public VariablePopUpButton() {
    super();

    this.setText("Variable PopUp");
    this.setId("small-button");

    this.setOnAction(e -> {
      new VariablePagePopUp().showPopUp();
    });
  }
}
