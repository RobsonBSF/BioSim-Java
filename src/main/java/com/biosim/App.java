package com.biosim;

import com.biosim.models.World;
import com.biosim.views.SimulationView;

public class App {
    public static void main( String[] args ) {

        World world = new World(15, 15);

        SimulationView.renderMap(world);
    }
}
