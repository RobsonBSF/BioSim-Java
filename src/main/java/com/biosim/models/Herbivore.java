package com.biosim.models;

import com.biosim.enums.DietType;

public class Herbivore extends Agent {

    // Constructor
    public Herbivore(int x, int y) {
        super(x, y);

        diet = DietType.HERBIVORE;
    }
}
