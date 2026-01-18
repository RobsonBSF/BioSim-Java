package com.biosim.views;

import com.biosim.models.Agent;
import com.biosim.models.World;

public class SimulationView {
    
    // prints the world map
    public static void renderMap(World world) {

        String blue = "\033[0;34m"; // blue color code
        String reset = "\033[0m"; // reset color code

        for (Agent x[] : world.getTileMap()) {
            System.out.println();
            for (Agent y : x) {
                if (y != null) {
                    System.out.print(blue + " A " + reset);
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
}
