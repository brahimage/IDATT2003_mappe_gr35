package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ChaosGameFileHandler {

  /**
   * Writes the given ChaosGameDescription object to a file.
   *
   * @param description The ChaosGameDescription object to serialize.
   * @param path The file path where the object should be written.
   * @throws IOException If an I/O error occurs while writing the file.
   */
  public static void writeToFile(ChaosGameDescription description, String path) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
      oos.writeObject(description);
    } // The ObjectOutputStream is auto-closed here, which also flushes the output
  }

  /**
   * Reads a ChaosGameDescription object from a file.
   *
   * @param path The file path from where to read the object.
   * @return The deserialized ChaosGameDescription object.
   * @throws IOException If an I/O error occurs while reading the file.
   * @throws ClassNotFoundException If the class of a serialized object cannot be found.
   */
  public static ChaosGameDescription readFromFile(String path) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
      return (ChaosGameDescription) ois.readObject();
    } // The ObjectInputStream is auto-closed here
  }
}