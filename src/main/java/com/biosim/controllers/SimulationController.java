package com.biosim.controllers;

import com.biosim.models.World;
import com.biosim.models.Agent;
import com.biosim.views.SimulationView;

public class SimulationController {
    
    public void startSimulation(int rows, int columns) {

        World world = new World(rows, columns);

        world.addAgent();

        int currentSimTime = 0;

        // Simulation loop
        while (currentSimTime < 10) {

            SimulationView.clearMap();
            SimulationView.renderMap(world);

            // Updates active agents position
            for (Agent a : world.getActiveAgents()) {
                world.updatePosition(a);
            }

            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.err.println("Simulation interrupted");
            }

            currentSimTime++;
        }
    }
}
