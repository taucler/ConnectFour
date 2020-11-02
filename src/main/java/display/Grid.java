package display;

import java.util.*;

public class Grid {

    private int grid_width;
    private int grid_height;

    /* Build a empty grid with default dimensions */
    public void DefaultGrid(){
        this.grid_width = 6;
        this.grid_height = 7;

        String[][] grid = new String[grid_height][grid_width];
        Arrays.fill(grid, '.');
    }

    /* Build a empty grid with choice of dimensions */
    public Grid(int width, int height){
        this.grid_width = width;
        this.grid_height = height;

        String[][] grid = new String[height][width];
        Arrays.fill(grid, '.');
    }


}
