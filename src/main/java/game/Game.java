package main.java.game;

import java.util.Random;
import main.java.game.rules.TestGrid;
public class Game{

    //Attributes
    private Grid grid;
    private int nbPlayers;
    private int lastColumnPlayed;

    //Constructor
    public Game(Grid grid) {
        this.grid = grid;
    }

    //Methods
    public void getGame(Grid grid) {
        this.grid = grid;
    }

    public int getLastColumnPlayed() {
        return lastColumnPlayed;
    }

    public Grid setGame(Grid g) {
        return grid = g;
    }

    public void play(Player player, Grid grid, int token, TestGrid endgame) {
        java.util.Scanner entry =   new java.util.Scanner(System.in);
        //if the player is an ia
        if(player.getType().equals("ia")){
            int choice =(int)(Math.random()*grid.getColumns());
            lastColumnPlayed = choice + 1;
            grid.fillSquare(choice, token, grid, endgame);
        }
        else {
            //if the player is a human
            int choice = entry.nextInt();
            while(choice < 1 || choice > grid.getColumns()+1){
                System.out.println("Chosen column is out of range, please choose a new column.");
                choice=entry.nextInt();
            }
            while(grid.getState(0,choice-1)!=0){
                System.out.println("Chosen column is already full, please choose a new column.");
                choice=entry.nextInt();

            }
            lastColumnPlayed = choice;
            grid.fillSquare(choice - 1, token, grid, endgame);
        }
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