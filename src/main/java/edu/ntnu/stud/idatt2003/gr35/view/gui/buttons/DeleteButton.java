package edu.ntnu.stud.idatt2003.gr35.view.gui.buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DeleteButton extends Button {
  public DeleteButton() throws FileNotFoundException {
    super();

    Image icon = new Image(new FileInputStream("src/main/resources/icons/delete-icon.png"));
    ImageView iconView = new ImageView(icon);

    iconView.setFitWidth(36);
    iconView.setFitHeight(36);

    this.setGraphic(iconView);
    this.setId("small-button");

    this.setOnAction(e -> {
          System.out.println("Delete button clicked");
          // TODO: Add button functionality.
        }
    );
  }
}
