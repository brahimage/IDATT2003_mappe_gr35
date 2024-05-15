package edu.ntnu.stud.idatt2003.gr35.view.gui.buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A button that the current fractal as a png file.
 */
public class SaveButton extends Button {
  /**
   * Constructs a new SaveButton.
   *
   * @throws FileNotFoundException If the icon file is not found.
   */

  public SaveButton() throws FileNotFoundException {
    super();

    Image icon = new Image(new FileInputStream("src/main/resources/icons/save-icon.png"));
    ImageView iconView = new ImageView(icon);

    iconView.setFitWidth(36);
    iconView.setFitHeight(36);

    this.setGraphic(iconView);
    this.setId("small-button");
  }
}