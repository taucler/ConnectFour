package display;

import main.java.Grid;

public class TestGrid {
    private int win;

    public class TestGrid(Grid grid, int line, int column){
        int count = 1;
        int i = 1;
        //Test de la grille verticalement
        while((line+i)Grid[line][column]==Grid[line+i][column]){
            count++;
            i++;
        }
        i = 1;
        while(Grid[line][column]==Grid[line-i][column]){
            count++;
            i++;
        }
        if(count>=4){
            return 1;
        }
        //Test de la grille horizontalement
        count = 1;
        i = 1;
        while(Grid[line][column]==Grid[line][column+i]){
            count++;
            i++;
        }
        i = 1;
        while(Grid[line][column]==Grid[line][column-i]){
            count++;
            i++;
        }
        if(count>=4){
            return 1;
        }
        //Test de la grille en diagonale
        count = 1;
        i = 1;
        while(Grid[line][column]==Grid[line][column+i]){
            count++;
            i++;
        }
        i = 1;
        while(Grid[line][column]==Grid[line][column-i]){
            count++;
            i++;
        }
        if(count>=4){
            return 1;
        }

    }
}
