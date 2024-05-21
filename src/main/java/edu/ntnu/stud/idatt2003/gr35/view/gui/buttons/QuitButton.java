package edu.ntnu.stud.idatt2003.gr35.view.gui.buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A button that quits the application.
 */
public class QuitButton extends Button {

  /**
   * Constructs a new QuitButton.
   *
   * @throws FileNotFoundException If the icon file is not found.
   */
  public QuitButton() throws FileNotFoundException {
    super();

    try {
      Image icon = new Image(new FileInputStream("src/main/resources/icons/quit-icon.png"));
      ImageView iconView = new ImageView(icon);
      this.setText("Quit App");

      this.setMinSize(60, 60);

      iconView.setFitWidth(28);
      iconView.setFitHeight(28);

      this.setGraphic(iconView);
      this.setId("small-button");

      this.setOnAction(e -> System.exit(0));

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}
