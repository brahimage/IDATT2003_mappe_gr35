package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameFileHandler;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.DeleteButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.PlayButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.QuitButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.SaveButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons.VariablePopUpButton;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
/**
 * The main page of the application where the user can view the fractal.
 */
public class ViewPage extends StackPane {
  private String selectedChaosGame;
  /**
   * Constructs a new ViewPage.
   *
   * @throws FileNotFoundException If the icon file is not found for any of the buttons.
   */
  public ViewPage() throws FileNotFoundException {
    super();

    selectedChaosGame = "";

    this.setId("view-page");

    VBox pageElements = new VBox();
    BorderPane topBar = getTopBar();
    StackPane fractalView = new StackPane();
    Canvas fractalCanvas = new Canvas();

    fractalView.setPadding(new javafx.geometry.Insets(20));


    /*
     * Dimensions of canvas is 20 pixels less than that of the fractal view on all sides.
     * This is to make sure that the canvas is not drawn on the border of the fractal view.
     * WARNING: This is known to cause weird scaling issues that ruin the view
     * if this value is lower than 40. (This may be affected by resolution changes)
     * When changing this value, make sure to test the scaling of the fractal view.
     */

    fractalView.setMinSize(40, 40); // Adjust the values as needed

    fractalCanvas.widthProperty().bind(fractalView.widthProperty().subtract(40));
    fractalCanvas.heightProperty().bind(fractalView.heightProperty().subtract(40));

//    fractalCanvas.setHeight(fractalView.getHeight() - 40);
//    fractalCanvas.setWidth(fractalView.getWidth() - 40);

    fractalCanvas.setId("fractal-canvas");
    fractalView.setId("fractal-view");
    fractalView.getChildren().add(fractalCanvas);
    fractalView.setPadding(new javafx.geometry.Insets(20));
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
    SaveButton saveButton = new SaveButton();
    QuitButton quitButton = new QuitButton();
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

    // Get the selected value from the ComboBox
    ObservableValue<String> selectedValue = comboBox.valueProperty();

    // Add a listener to the selected value
    selectedValue.addListener((observable, oldValue, newValue) -> {
          System.out.println("Selected value: " + newValue);
          selectedChaosGame = newValue;
        });

    HBox buttonContainer = new HBox();
    buttonContainer.getChildren().addAll(playButton, deleteButton, comboBox, variablePopUpButton, saveButton);

    buttonContainer.setSpacing(20);

    topBar.setLeft(buttonContainer);
    topBar.setRight(quitButton);
    topBar.setMinHeight(60);
    return topBar;
  }

  /**
   * Gets the selected chaos game in drop-down menu.
   *
   * @return The name of the selected chaos game.
   */
  public String getSelectedChaosGame() {
    return selectedChaosGame;
  }
}
