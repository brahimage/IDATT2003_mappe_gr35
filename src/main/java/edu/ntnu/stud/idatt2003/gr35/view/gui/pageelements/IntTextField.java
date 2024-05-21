package edu.ntnu.stud.idatt2003.gr35.view.gui.pageelements;

import javafx.scene.control.TextField;


/**
 * A TextField that only accepts integer values.
 * code from <a href="https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx">StackOverFlow</a>
 */
public class IntTextField extends TextField {

  /**
   * Replaces the selection in the text field with the specified text.
   *
   * @param start The start of the selection.
   * @param end The end of the selection.
   * @param text The text to replace the selection with.
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
   * Validates the text to ensure it is an integer value.
   *
   * @param text The text to validate.
   * @return True if the text is an integer value, false otherwise.
   */
  private boolean validate(String text) {
    return text.matches("[0-9]*");
  }
}
