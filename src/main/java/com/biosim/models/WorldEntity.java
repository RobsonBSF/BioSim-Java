package com.biosim.models;

import com.biosim.enums.DietType;

public abstract class WorldEntity {

    // Base attribute
    protected DietType diet;

    // Map position
    protected int xPos;
    protected int yPos;

    // Constructor
    protected WorldEntity(int x, int y) {
        setxPos(x);
        setyPos(y);
    }

    // Getters and Setters
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public DietType getDietType() {
        return diet;
    }

    protected void setxPos(int xPos) {
        this.xPos = xPos;
    }

    protected void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
