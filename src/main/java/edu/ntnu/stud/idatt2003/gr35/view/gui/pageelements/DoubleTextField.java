package edu.ntnu.stud.idatt2003.gr35.view.gui.pageelements;

import javafx.scene.control.TextField;

/**
 * A TextField that only accepts double values.
 */
public class DoubleTextField extends TextField {
  /**
   * Constructs a new DoubleTextField.
   */
  @Override
  public void replaceText(int start, int end, String text) {
    if (validate(text)) {
      super.replaceText(start, end, text);
    }
  }

  /**
   * Replaces the selection in the text field with the specified text.
   *
   * @param text The text to replace the selection with.
   */
  @Override
  public void replaceSelection(String text) {
    if (validate(text)) {
      super.replaceSelection(text);
    }
  }

  /**
   * Validates the text to ensure it is a double value.
   *
   * @param text The text to validate.
   * @return True if the text is a double value, false otherwise.
   */
  private boolean validate(String text) {
    return text.matches("[0-9]*\\.?[0-9]*");
  }
}
