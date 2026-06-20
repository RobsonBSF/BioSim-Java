package com.biosim.models;

import java.util.Random;

public class Agent extends WorldEntity {

    // Base attribute
    private int hungerLvl = 100; // MAX: 100

    // Constructor
    public Agent(int x, int y) {
        super(x, y);
    }

     public int getHunger() {
         return hungerLvl;
     }

    private void setHunger(int hunger) {
        this.hungerLvl = hunger;
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

    public void eat() {
        if (this.hungerLvl + 20 <= 100) {
            setHunger(hungerLvl += 20);
        }
    }

    public void decayHunger() {
        if (this.hungerLvl - 5 >= 0) {
            setHunger(hungerLvl -= 5);
        }  
    }
}
