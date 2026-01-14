package com.biosim;

import com.biosim.controllers.SimulationController;

public class App {
    public static void main( String[] args ) {

        SimulationController controller = new SimulationController();

        controller.startSimulation(15, 15);
    }
}
