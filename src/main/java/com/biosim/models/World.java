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
        int x = agent.getxPos();
        int y = agent.getyPos();
        getTileMap()[x][y] = null;

        // moves the agent to a new position
        agent.move();

        x = agent.getxPos();
        y = agent.getyPos();
        getTileMap()[x][y] = agent;
    }

    public void addAgent() {

        Random random = new Random();

        int randX = random.nextInt(-1, (rows + 1));
        int randY = random.nextInt(-1, (columns + 1));

        Agent agent = new Agent(randX, randY);

        activeAgents.add(agent);

        updatePosition(agent);
    }
}
