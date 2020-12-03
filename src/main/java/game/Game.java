import java.util.Random;

public class Game{

    //Attributes
    private Grid grid;

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

    public int putToken(Player player, int gridLength) {
        java.util.Scanner entry =   new java.util.Scanner(System.in);
        //if the player is an ia
        if(player.getType().equals("ia")){
            Random rand = new Random();
            int choice = rand.nextInt(gridLength-1);
            return choice;
        }
        //if the player is a human
        int choice = entry.nextInt();
        return choice-1;
    }

    public boolean play(Grid grid, int column, int[][] state) {

        //look for an empty square
        int cpt = 5;
        while(state[cpt][column] != 0) { //while the square is not empty, check the following square
            cpt = cpt-1;
            if (state[cpt][column] != 0 && cpt==0) {
                return false;
            }
        }
        return true;
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