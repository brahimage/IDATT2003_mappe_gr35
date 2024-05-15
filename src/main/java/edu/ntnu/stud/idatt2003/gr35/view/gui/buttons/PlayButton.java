package edu.ntnu.stud.idatt2003.gr35.view.gui.buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A button that plays the game.
 */
public class PlayButton extends Button {
  /**
   * Constructs a new PlayButton.
   *
   * @throws FileNotFoundException If the icon file is not found.
   */
  public PlayButton() throws FileNotFoundException {
    super();

    try {
      Image icon = new Image(new FileInputStream("src/main/resources/icons/play-icon.png"));
      ImageView iconView = new ImageView(icon);

      this.setMinSize(60, 60);

      iconView.setFitWidth(36);
      iconView.setFitHeight(36);

      this.setGraphic(iconView);
      this.setId("small-button");

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}
