package com.biosim.models;

import com.biosim.enums.DietType;

public class Carnivore extends Agent {
   
    // Constructor
    public Carnivore(int x, int y) {
        super(x, y);

        diet = DietType.CARNIVORE;
    }
}
