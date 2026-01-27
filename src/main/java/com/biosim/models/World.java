package com.biosim.models;

import java.util.ArrayList;
import java.util.Random;

public class World {

    // width & height of the map
    private int rows;
    private int columns;
    
    // Creates a World Map
    private Agent[][] tileMap;

    // Agent List
    private ArrayList<Agent> activeAgents = new ArrayList<Agent>();

    // Constructor
    public World(int rows, int columns) {
        setRows(rows);
        setColumns(columns);

        setTileMap(new Agent[rows][columns]);
    }

    // Getters and Setters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Agent[][] getTileMap() {
        return tileMap;
    }

    public ArrayList<Agent> getActiveAgents() {
        return activeAgents;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setColumns(int columns) {
        this.columns = columns;
    }

    public void setTileMap(Agent[][] tileMap) {
        this.tileMap = tileMap;
    }

    // Other Methods
    public void updatePosition(Agent agent) {

        // cleans last agent position
        int lastX = agent.getxPos();
        int lastY = agent.getyPos();
        getTileMap()[lastX][lastY] = null;

        // moves the agent to a new position
        agent.move();

        int newX = agent.getxPos();
        int newY = agent.getyPos();

        // verifies if new position is out of bounds
        if (newX >= 0 && newX < rows && newY >= 0 && newY < columns) {
            getTileMap()[newX][newY] = agent;
        } else {
            agent.move(lastX, lastY);
            getTileMap()[lastX][lastY] = agent;
        }
    }

    public void addAgent() {

        Random random = new Random();

        int randX = random.nextInt(0, rows);
        int randY = random.nextInt(0, columns);

        Agent agent = new Agent(randX, randY);

        activeAgents.add(agent);

        getTileMap()[randX][randY] = agent;
    }
}
