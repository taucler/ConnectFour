package main.java.game;
import main.java.game.rules.TestGrid;

public class Grid {

    private int lines;
    private int columns;
    private char[][] grid;
    private int[][] state; // 0: empty / 1:X / 2:O

    public Grid() {
        this.lines = 6; //Default value
        this.columns = 7;   //Default value
        this.grid = new char[this.lines][this.columns];
        this.state = new int[this.lines][this.columns];
        //Initialize
        for (int i = 0; i<this.lines; i++){
            for (int j = 0; j<this.columns; j++){
                this.grid[i][j] = '.';
                this.state[i][j] = 0;
            }
        }
    }

    /* Build a empty grid with default dimensions */
    public Grid(int line, int column) {

        if ((line < 4) || (column < 4)){
            throw new IllegalArgumentException("Grid dimensions must excess 4.");
        }

        this.lines = line;
        this.columns = column;
        this.grid = new char[this.lines][this.columns];
        this.state = new int[this.lines][this.columns];

        //Initialize
        for (int i = 0; i<line; i++){
            for (int j = 0; j<column; j++){
                this.grid[i][j] = '.';
                this.state[i][j] = 0;
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

    public int getState(int line, int column) {
        if(line >= this.lines || line < 0){
            return 0;
        }
        if(column >= this.columns || column < 0){
            return 0;
        }
        return state[line][column];}

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

    public void setState(int line, int column, int val){this.state[line][column]=val;}

    public void display() {
        System.out.println();
        for (int i = 1; i < this.columns + 1; i++) {
            System.out.print("   " + i);
        }
        System.out.println();

        for (int i = 0; i < this.lines; i++){
            for (int j = 0; j < this.columns; j++){
                System.out.print(" | " + this.grid[i][j]);
            }

            System.out.print(" | ");
            System.out.println();
        }

        System.out.println();
    }

    public void fillSquare(int column, int token, Grid grid, TestGrid endgame) {
        //fill a square when a player wants to play
        int current = 0;
        if(this.state[current][column]!=0){
            System.out.println("Chosen column is already full, please choose a new column.");
        }
        while((this.state[current][column]==0) && (current<grid.getLines()-1)) {
            current++;
        }
        if((current == grid.getLines()-1) && (this.state[current][column]==0)){
            current++;
        }
        if(token == 1) {
            this.grid[current-1][column] = 'X';
            this.state[current-1][column] = 1;
        }
        if(token == 2) {
            this.grid[current-1][column] = 'O';
            this.state[current-1][column] = 2;
        }
        endgame.testGrid(grid, current-1, column);
    }

}
