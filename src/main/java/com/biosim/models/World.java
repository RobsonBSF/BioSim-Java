package com.biosim.models;

public class World {

    // width & height of the map
    private int rows;
    private int columns;
    
    // Creates a World Map
    private int[][] tileMap;

    // Constructor
    public World(int rows, int columns) {
        setRows(rows);
        setColumns(columns);

        setTileMap(new int[rows][columns]);
    }

    // Getters and Setters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getTileMap() {
        return tileMap;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setColumns(int columns) {
        this.columns = columns;
    }

    public void setTileMap(int[][] tileMap) {
        this.tileMap = tileMap;
    }

    // Other Methods
    public void updatePosition(int x, int y, int value) {
        getTileMap()[x][y] = value;
    }
}
