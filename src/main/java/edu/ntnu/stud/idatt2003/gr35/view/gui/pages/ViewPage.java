package edu.ntnu.stud.idatt2003.gr35.view.gui.pages;

import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.DeleteButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.buttons.PlayButton;
import edu.ntnu.stud.idatt2003.gr35.view.gui.pageswitchbuttons.VariablePopUpButton;
import java.io.FileNotFoundException;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ViewPage extends StackPane {
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

  public StackPane getRoot() {
    return this;
  }

  public BorderPane getTopBar() throws FileNotFoundException {
    BorderPane topBar = new BorderPane();
    topBar.setId("top-bar");

    VariablePopUpButton variablePopUpButton = new VariablePopUpButton();
    DeleteButton deleteButton = new DeleteButton();
    PlayButton playButton = new PlayButton();
    ComboBox<String> comboBox = new ComboBox<>();

    comboBox.getItems().addAll("Sierpinski", "Julia", "Barley");
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
