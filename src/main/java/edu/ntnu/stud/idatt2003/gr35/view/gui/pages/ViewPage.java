package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameFileHandler;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.DeleteButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.PlayButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons.VariablePopUpButton;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * The main page of the application where the user can view the fractal.
 */
public class ViewPage extends StackPane {
  /**
   * Constructs a new ViewPage.
   *
   * @throws FileNotFoundException If the icon file is not found for any of the buttons.
   */
  public ViewPage() throws FileNotFoundException {
    super();

    this.setId("view-page");

    VBox pageElements = new VBox();
    BorderPane topBar = getTopBar();
    StackPane fractalView = new StackPane();
    Text fractalText = new Text("Fractal View");
    fractalView.setId("fractal-view");
    fractalView.getChildren().add(fractalText);
    fractalView.setAlignment(javafx.geometry.Pos.CENTER);
    pageElements.getChildren().addAll(topBar, fractalView);
    pageElements.setSpacing(20);

    this.getChildren().add(pageElements);
  }

  /**
   * Gets the root of the page.
   *
   * @return The root of the page.
   */
  public StackPane getRoot() {
    return this;
  }

  /**
   * Gets the top bar of the page.
   *
   * @return The top bar of the page.
   * @throws FileNotFoundException If the icon file is not found for any of the buttons.
   */
  public BorderPane getTopBar() throws FileNotFoundException {
    BorderPane topBar = new BorderPane();
    topBar.setId("top-bar");

    VariablePopUpButton variablePopUpButton = new VariablePopUpButton();
    DeleteButton deleteButton = new DeleteButton();
    PlayButton playButton = new PlayButton();
    ComboBox<String> comboBox = new ComboBox<>();

    // Get paths of all .json files in the ChaosGames directory
    ArrayList<String> items;
    try {
      items = ChaosGameFileHandler.GetAllExistingPaths(Path.of("ChaosGames"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // Remove the directory path and the file extension from the paths
    items.replaceAll(s -> s.substring(11, s.length() - 5));

    // Add the items to the ComboBox
    comboBox.getItems().addAll(items);
    comboBox.setId("top-bar-combobox");
    comboBox.setPromptText("Select transformation");

    HBox buttonContainer = new HBox();
    buttonContainer.getChildren().addAll(playButton, deleteButton, comboBox, variablePopUpButton);

    buttonContainer.setSpacing(20);

    topBar.setLeft(buttonContainer);
    topBar.setMinHeight(60);
    return topBar;
  }
}
