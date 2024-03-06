package edu.ntnu.stud.idatt2003.gr35;

/**
 * An enumeration representing the sign of a value.
 */
public enum Sign {
  /**
   * Represents the positive sign.
   */
  POSITIVE(1),

  /**
   * Represents the negative sign.
   */
  NEGATIVE(-1);

  private final int value;

  /**
   * Constructs a Sign enum with the specified integer value.
   *
   * @param value The integer value representing the sign.
   */
  Sign(int value) {
    this.value = value;
  }

  /**
   * Gets the integer value associated with the sign.
   *
   * @return The integer value of the sign.
   */
  public int getValue() {
    return value;
  }
}