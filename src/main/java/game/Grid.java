package main.java.game;

import java.util.*;

public class Grid {

    private int lines;
    private int columns;
    private char[][] grid;
    public int[][] state; // 0: empty / 1:X / 2:O


    /* Build a empty grid with default dimensions */
    public Grid(int lines, int columns) {

        if ((lines < 1) || (columns < 1)){
            throw new IllegalArgumentException("Grid dimensions must excess 0.");
        }

        this.lines = lines;
        this.columns = columns;
        grid = new char[lines][columns];
        state = new int[lines][columns];

        //Initialize
        for (int i = 0; i<lines; i++){
            for (int j = 0; j<columns; j++){
                grid[i][j] = '.';
                state[i][j] = 0;
            }
        }
    }

    //Getters
    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    //Setters

    public void setLines(int l) {
        this.lines = l;
    }

    public void setColumns(int c) {
        this.columns = c;
    }

    public void setState(int[][] s) {
        this.state = s;
    }

    public void display() {

        System.out.println();

        for (int i = 0; i < lines; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(" | " + grid[i][j]);
            }

            System.out.print(" | ");
            System.out.println();
        }

        System.out.println();
    }

    public void fillSquare(Grid grid, int[][] state, int line, int column, int token) {
        //fill a square when a player wants to play
        if(token == 1) {
            grid.grid[line][column] = 'X';
            state[line][column] = 1;

        }

        if(token == 2) {
            grid.grid[line][column] = 'O';
            state[line][column] = 2;

        }
    }

}
