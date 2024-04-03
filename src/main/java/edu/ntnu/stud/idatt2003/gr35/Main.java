package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescription;
import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameFileHandler;
import java.io.IOException;
import java.util.Scanner;

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
    }
    public static void writeChaosGameDescriptionToFile() {
    }
    public static void runIterationsOfChaosGame() {
    }
    public static void visualizeChaosGame() {
    }
}
