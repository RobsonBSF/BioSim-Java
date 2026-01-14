package com.biosim.views;

import com.biosim.models.World;

public class SimulationView {
    
    public static void renderMap(World world) {

        for (int x[] : world.getTileMap()) {
            System.out.println();
            for (int y : x) {
                System.out.print(" " + y + " ");
            }
        }
    }
}
