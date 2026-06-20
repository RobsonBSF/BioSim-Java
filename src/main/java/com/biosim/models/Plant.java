package com.biosim.models;

import com.biosim.enums.DietType;

public class Plant extends WorldEntity {

    public Plant(int x, int y) {
        super(x, y);

        diet = DietType.NONE;
    }
}
