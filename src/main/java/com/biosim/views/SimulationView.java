package com.biosim.views;

import com.biosim.enums.DietType;
import com.biosim.models.World;
import com.biosim.models.WorldEntity;

public class SimulationView {
    
    // Prints the world map
    public static void renderMap(World world) {

        String red = "\033[0;31m"; // red color code
        String green = "\033[0;32m"; // green color code
        String blue = "\033[0;34m"; // blue color code
        String reset = "\033[0m"; // reset color code

        for (WorldEntity x[] : world.getTileMap()) {
            System.out.println();
            for (WorldEntity y : x) {
                if (y != null) {
                    if (y.getDietType() == DietType.NONE) {
                        System.out.print(blue + " P " + reset);
                    }
                    if (y.getDietType() == DietType.HERBIVORE) {
                        System.out.print(green + " H " + reset);
                    }
                    if (y.getDietType() == DietType.CARNIVORE) {
                        System.out.print(red + " C " + reset);
                    }
                } else {
                    System.out.print(" " + 0 + " ");
                }
            }
        }
    }

    // Clears the rendered map in terminal
    public static void clearMap() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    // Renders simulation ending status
    public static void printStatus(int currentSimTime, int numPlants, int numHerbivores, int numCarnivores, int remainingPlants) {
        System.out.println("\n");
        System.out.println("Simulation ended, status:");
        System.out.println("----------------------------------");
        System.out.println("Simulation iterations: " + currentSimTime);
        System.out.println("----------------------------------");
        System.out.println("Starting plants -----> " + numPlants);
        System.out.println("Starting herbivores -> " + numHerbivores);
        System.out.println("Starting carnivores -> " + numCarnivores);
        System.out.println("Remaining plants ----> " + remainingPlants);
    }
}
