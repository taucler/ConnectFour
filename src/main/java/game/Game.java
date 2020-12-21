package main.java.game;

import java.util.Random;
import test.java.display.TestGrid;
public class Game{

    //Attributes
    private Grid grid;
    private int nbPlayers;

    //Constructor
    public Game(Grid grid) {
        this.grid = grid;
    }

    //Methods
    public void getGame(Grid grid) {
        this.grid = grid;
    }

    public Grid setGame(Grid g) {
        return grid = g;
    }

    public void play(Player player, Grid grid, int token, TestGrid endgame) {
        java.util.Scanner entry =   new java.util.Scanner(System.in);
        //if the player is an ia
        if(player.getType().equals("ia")){
            Random rand = new Random();
            int choice = rand.nextInt(grid.getColumns()-1);
            grid.fillSquare(choice-1, token, grid, endgame);
        }
        //if the player is a human
        int choice = entry.nextInt();
        grid.fillSquare(choice-1, token, grid,endgame);
    }

    public int getLine(Grid grid, int column, int[][] state) {

        //look for an empty square
        int cpt = 5;
        int line = 5;
        while(state[cpt][column] != 0) { //while the square is not empty, check the following square
            cpt =cpt-1;
            line = cpt;
        }
        return line;
    }
}