package com.biosim.models;

import java.util.ArrayList;
import java.util.Random;

import com.biosim.enums.DietType;

public class World {
    // Utility
    private Random random = new Random();

    // width & height of the map
    private int rows;
    private int columns;
    
    // Creates a World Map
    private WorldEntity[][] tileMap;

    // Agent List
    private ArrayList<WorldEntity> activeEntities = new ArrayList<WorldEntity>();
    private ArrayList<WorldEntity> removeList = new ArrayList<WorldEntity>();
    private ArrayList<Plant> activePlants = new ArrayList<Plant>();
    private ArrayList<Agent> activeAgents = new ArrayList<Agent>();

    // Constructor
    public World(int rows, int columns) {
        setRows(rows);
        setColumns(columns);

        setTileMap(new WorldEntity[rows][columns]);
    }

    // Getters and Setters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public WorldEntity[][] getTileMap() {
        return tileMap;
    }

    public ArrayList<WorldEntity> getActiveEntities() {
        return activeEntities;
    }

    public ArrayList<Agent> getActiveAgents() {
        return activeAgents;
    }

    public ArrayList<Plant> getActivePlants() {
        return activePlants;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setColumns(int columns) {
        this.columns = columns;
    }

    public void setTileMap(WorldEntity[][] tileMap) {
        this.tileMap = tileMap;
    }

    // Other Methods
    public int[] getValidRandomPosition() {
        int randX;
        int randY;

        do {
            randX = random.nextInt(0, rows);
            randY = random.nextInt(0, columns);
        } while (getTileMap()[randX][randY] != null);

        return new int[]{randX, randY};
    }

    public void addPlants(int num) {
        for (int i = 0; i < num; i++) {
            int[] randomNumbers = getValidRandomPosition();
    
            Plant plant = new Plant(randomNumbers[0], randomNumbers[1]);
    
            activePlants.add(plant);
            activeEntities.add(plant);
    
            getTileMap()[randomNumbers[0]][randomNumbers[1]] = plant;
        }
    }

    public void addHerbivores(int num) {
        for (int i = 0; i < num; i++) {
            int[] randomNumbers = getValidRandomPosition();
    
            Herbivore herbivore = new Herbivore(randomNumbers[0], randomNumbers[1]);
    
            activeAgents.add(herbivore);
            activeEntities.add(herbivore);
    
            getTileMap()[randomNumbers[0]][randomNumbers[1]] = herbivore;
        }
    }

    public void addCarnivores(int num) {
        for (int i = 0; i < num; i++) {
            int[] randomNumbers = getValidRandomPosition();
    
            Carnivore carnivore = new Carnivore(randomNumbers[0], randomNumbers[1]);
    
            activeAgents.add(carnivore);
            activeEntities.add(carnivore);
    
            getTileMap()[randomNumbers[0]][randomNumbers[1]] = carnivore;
        }
    }

    public void addEntities(int numPlants, int numHerbivores, int numCarnivores) {
        addPlants(numPlants);
        addHerbivores(numHerbivores);
        addCarnivores(numCarnivores);
    }

    public boolean isNotOutOfBounds(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < columns) {
            return true;
        } else {
             return false;
        }
    }

    public void addToRemoveList(WorldEntity entity) {
        removeList.add(entity);
    }

    public void removeFromRemoveList() {
        for (WorldEntity e : removeList) {
            activeEntities.remove(e);

            if (e.diet == DietType.HERBIVORE || e.diet == DietType.CARNIVORE) {
                activeAgents.remove(e);
            }

            if (e.diet == DietType.NONE) {
                activePlants.remove(e);
            }

            getTileMap()[e.getxPos()][e.getyPos()] = null;
        }
    }

    public void updatePosition(Agent agent) {
        // cleans last agent position
        int lastX = agent.getxPos();
        int lastY = agent.getyPos();
        getTileMap()[lastX][lastY] = null;

        // changes the agent position values
        agent.move();

        int newX = agent.getxPos();
        int newY = agent.getyPos();

        // moves the agent to a new position
        if (isNotOutOfBounds(newX, newY)) {

            if (getTileMap()[newX][newY] == null) {

                getTileMap()[newX][newY] = agent;

            } else {
                WorldEntity e = getTileMap()[newX][newY];

                if (agent.getDietType() == e.getDietType()) {

                    agent.move(lastX, lastY);
                    getTileMap()[lastX][lastY] = agent;

                } else if (agent.getDietType() == DietType.HERBIVORE && e.getDietType() == DietType.CARNIVORE){

                    agent.move(lastX, lastY);
                    getTileMap()[lastX][lastY] = agent;

                } else if (agent.getDietType() == DietType.CARNIVORE && e.getDietType() == DietType.NONE){

                    agent.move(lastX, lastY);
                    getTileMap()[lastX][lastY] = agent;

                } else if (agent.getDietType() == DietType.HERBIVORE && e.getDietType() == DietType.NONE){

                    addToRemoveList(e);
                    agent.eat();
                    getTileMap()[newX][newY] = agent;

                } else if (agent.getDietType() == DietType.CARNIVORE && e.getDietType() == DietType.HERBIVORE) {
                    
                    addToRemoveList(e);
                    agent.eat();
                    getTileMap()[newX][newY] = agent;
                }
            }
        } else {
            agent.move(lastX, lastY);
            getTileMap()[lastX][lastY] = agent;
        }
    }
}
