package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for deconstructing and reconstructing ChaosGameDescription objects to and from files.
 * Uses Serialization to read and write objects.
 */
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

  /**
   * Retrieves a list of all the .json files contained within a given folder.
   *
   * @param folder The folder to search for .json files.
   * @return A list of paths to .json files.
   * @throws IOException If an I/O error occurs while accessing the folder.
   */
  public static ArrayList<String> GetAllExistingPaths(Path folder) throws IOException {
    try (Stream<Path> paths = Files.walk(folder)) {
      return paths
          .filter(Files::isRegularFile)
          .map(Path::toString)
          .filter(string -> string.endsWith(".json"))
          .collect(Collectors.toCollection(ArrayList::new));
    }
  }
}