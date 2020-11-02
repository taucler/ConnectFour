package display;

import java.util.*;

public class Grid {

    private int grid_width;
    private int grid_height;

    /* Build a empty grid */
    public Grid(int width, int height){
        this.grid_width = width;
        this.grid_height = height;

        String[][] grid = new String[height][width];
        fill(grid, '.');
    }
}
