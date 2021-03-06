package main.java.game.rules;

import main.java.game.Grid;

public class TestGrid {
    private int win; //game still running :0 / someone win : positive int / TieGame : -1

    public TestGrid(){
        this.win = 0;
    }

    public int getWin() {
        return win;
    }

    public void testGrid(Grid grid, int line, int column){
        int count = 1;
        int i = 1;
        int token = grid.getState(line,column);
        //test d'égalité
        int tieCount=0;
        while(grid.getState(0, tieCount)!=0) {
            tieCount++;
        }
        if(tieCount==grid.getColumns()){
            this.win=-1;
        }
        //Test de la grille verticalement
        //System.out.println(grid.getState(line+i, column));
        while(token==grid.getState(line+i, column)){
            count++;
            i++;
        }
        i = 1;
        while(token==grid.getState(line-i,column)){
            count++;
            i++;
        }
        if(count>=4){
            this.win = token;
            return;
        }
        //Test de la grille horizontalement
        count = 1;
        i = 1;
        while(token==grid.getState(line,column+i)){
            count++;
            i++;
        }
        i = 1;
        while(token==grid.getState(line,column-i)){
            count++;
            i++;
        }
        if(count>=4){
            this.win = token;
            return;
        }
        //Test de la grille en diagonale
        count = 1;
        i = 1;
        while(token==grid.getState(line-i,column-i)){
            count++;
            i++;
        }
        i = 1;
        while(token==grid.getState(line+i,column+i)){
            count++;
            i++;
        }
        if(count>=4){
            this.win = token;
            return;
        }
    //Test de la grille dans la 2ème diagonale
        count = 1;
        i = 1;
        while(token==grid.getState(line+i,column-i)){
            count++;
            i++;
        }
        i = 1;
        while(token==grid.getState(line-i,column+i)){
            count++;
            i++;
        }
        if(count>=4){
            this.win = token;
            return;
        }
    }
}
