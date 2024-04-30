package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescription;
import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameFileHandler;
import java.util.Scanner;

/**
 * DEPRECATED! This class is no longer used in the application.
 * It was used for the console-based version of the Chaos Game application.
 * Main class for the Chaos Game application.
 */
public class Main {
    static ChaosGameDescription chaosGameDescription;
    static ChaosGame chaosGame;
    static int choice = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            switch (choice) {
                case 0 -> showMainMenu();
                case 1 -> readChaosGameDescriptionFromFile();
                case 2 -> writeChaosGameDescriptionToFile();
                case 3 -> runIterationsOfChaosGame();
                case 4 -> visualizeChaosGame();
                case 666 -> System.exit(0);
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Read Chaos Game Description from file");
        System.out.println("2. Write Chaos Game Description to file");
        if (chaosGameDescription != null) {
            System.out.println("3. Run iterations of selected Chaos Game");
            System.out.println("4. Visualize Chaos Game");
        }
        choice = scanner.nextInt();
        scanner.nextLine();
    }

    public static void readChaosGameDescriptionFromFile() {
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        try {
            chaosGameDescription = ChaosGameFileHandler.readFromFile(filePath);
            chaosGame = new ChaosGame(chaosGameDescription, 120, 50);
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        choice = 0;
    }

    public static void writeChaosGameDescriptionToFile() {
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        try {
            ChaosGameFileHandler.writeToFile(chaosGameDescription, filePath);
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        choice = 0;
    }

    public static void runIterationsOfChaosGame() {
        System.out.println("Enter the number of iterations:");
        int iterations = scanner.nextInt();
        scanner.nextLine();
        chaosGame.runSteps(iterations);
        choice = 0;
    }

    // Causes error when run with test data. Array index out of bounds. Likely caused by transformation of coordinates, coordinates swapped or off-by-one in loop.
    public static void visualizeChaosGame() {
        chaosGame.getCanvas().printCanvas();
        choice = 0;
    }
}
