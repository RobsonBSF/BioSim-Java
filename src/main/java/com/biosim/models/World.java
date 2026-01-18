package com.biosim.models;

public class World {

    // width & height of the map
    private int rows;
    private int columns;
    
    // Creates a World Map
    private Agent[][] tileMap;

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

        int x = agent.getxPos();
        int y = agent.getyPos();
        
        getTileMap()[x][y] = agent;
    }
}
