package main.java.game;

import java.util.Random;
import main.java.game.rules.TestGrid;
public class Game{

    //Attributes
    private int lastColumnPlayed;

    public int getLastColumnPlayed() {
        return lastColumnPlayed;
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
                System.out.println("Erreur colonne non valide " + choice);
                choice=entry.nextInt();
            }
            while(grid.getState(0,choice-1)!=0){
                System.out.println("Erreur colonne non pleine " + choice);
                choice=entry.nextInt();

            }
            lastColumnPlayed = choice;
            grid.fillSquare(choice - 1, token, grid, endgame);
        }
    }
}