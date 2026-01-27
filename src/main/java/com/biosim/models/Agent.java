package com.biosim.models;

import java.util.Random;

public class Agent {

    // Map position
    private int xPos;
    private int yPos;

    // Base atributes
    private int life;
    private int hunger;

    // Constructor
    public Agent(int x, int y) {
        setxPos(x);
        setyPos(y);

        setLife(100);
        setHunger(100);
    }

    // Getters and Setters
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getLife() {
        return life;
    }

    public int getHunger() {
        return hunger;
    }

    private void setxPos(int xPos) {
        this.xPos = xPos;
    }

    private void setyPos(int yPos) {
        this.yPos = yPos;
    }

    private void setLife(int life) {
        this.life = life;
    }

    private void setHunger(int hunger) {
        this.hunger = hunger;
    }

    // Other Methods
    public void move() {

        Random random = new Random();

        int x = getxPos();
        int y = getyPos();

        // generates a random number between -1 and 1
        int randomX = random.nextInt(-1, 2);
        int randomY = random.nextInt(-1, 2);

        setxPos(x + randomX);
        setyPos(y + randomY);
    }

    public void move(int x, int y) {
        setxPos(x);
        setyPos(y);
    }
}
