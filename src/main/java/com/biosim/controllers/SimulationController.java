package com.biosim.controllers;

import com.biosim.models.World;
import com.biosim.models.Agent;
import com.biosim.views.SimulationView;

public class SimulationController {
    
    public void startSimulation(int rows, int columns) {

        World world = new World(rows, columns);

        // Main simulation parameters (you can modify these numbers to change how the simulation performs)
        int refreshInXCicles = 20;
        int cicleDelay = 250; // milliseconds
        int startingPlants = 5;
        int startingHerbivores = 5;
        int StartingCarnivores = 5;
        int numPlants = 5;
        int numHerbivores = 5;
        int numCarnivores = 5;

        world.addEntities(startingPlants, startingHerbivores, StartingCarnivores);

        int currentSimTime = 0;

        // Simulation loop
        while (!world.getActiveAgents().isEmpty()) {

            SimulationView.clearMap();
            SimulationView.renderMap(world);

            // Updates agents status and positions
            for (Agent a : world.getActiveAgents()) {
                world.updatePosition(a);
                a.decayHunger();

                if (a.getHunger() == 0) {
                    world.addToRemoveList(a);
                }
            }

            // Adds new agents each X cicles
            if (currentSimTime % refreshInXCicles == 0) {
                world.addPlants(1);
                world.addHerbivores(1);
                world.addCarnivores(1);
            }

            world.removeFromRemoveList();

            try {
                Thread.sleep(cicleDelay);
            } catch (InterruptedException e) {
                System.err.println("Simulation interrupted");
            }

            currentSimTime++;
        }

        int remainingPlants = world.getActivePlants().size();

        // Simulation Status
        SimulationView.printStatus(currentSimTime, numPlants, numHerbivores, numCarnivores, remainingPlants);
    }
}
