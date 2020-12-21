package test.java.display;

import main.java.game.Grid;

public class TestGrid {
    private int win;

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
        //Test de la grille verticalement
        while(token==grid.getState(line-1, column)){
            count++;
            i++;
        }
        i = 1;
        while(token==grid.getState(line-i,column)){
            count++;
            i++;
        }
        if(count>=4){
            this.win = 1;
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
            this.win = 1;
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
            this.win = 1;
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
            this.win = 0;
            return;
        }
    }
}
