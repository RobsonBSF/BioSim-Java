package com.biosim.controllers;

import com.biosim.models.World;
import com.biosim.views.SimulationView;

public class SimulationController {
    
    public void startSimulation(int rows, int columns) {

        World world = new World(rows, columns);

        SimulationView.renderMap(world);
    }
}
