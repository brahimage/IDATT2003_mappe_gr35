package edu.ntnu.stud.idatt2003.gr35.view.gui.pageelements;

import javafx.scene.control.TextField;


/**
 * code from <a href="https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx">StackOverFlow</a>
 */
public class IntTextField extends TextField {

  @Override
  public void replaceText(int start, int end, String text) {
    if (validate(text)) {
      super.replaceText(start, end, text);
    }
  }

  @Override
  public void replaceSelection(String text) {
    if (validate(text)) {
      super.replaceSelection(text);
    }
  }

  private boolean validate(String text) {
    return text.matches("[0-9]*");
  }
}
