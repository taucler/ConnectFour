package main.java.game;
import test.java.display;

public class Main{

    public static void main(String[] args) {
        System.out.println("Welcome to ConnectFour !");
        System.out.println("Please for each player choose human/ia and an username.");
        //Getting what's typed in the shell
        java.util.Scanner entry =   new java.util.Scanner(System.in);

        //Display a new grid on the screen
        //System.out.println("Please provide grid dimensions : l c");
        Grid new_grid = new Grid(6, 7);

        //Display the menu on the screen and get the player info
        Game game = new Game(grid);
        System.out.println("Number of players ?");
        int nbPlayers = Integer.parseInt(entry.next());
        Player players[nbPlayers];

        int round = 0;
        int currentPlayer;
        //Play
        display.TestGrid end = new display.TestGrid();

        while(end.getWin == false) {
            currentPlayer = round%nbPlayers;
            if(players(currentPlayer).getType().equals("human")){
                System.out.println(players(currentPlayer).getName() + ", your turn ! Please enter a column to play.");
            }
            int token = currentPlayer + 1;
            int column = game.askToken(players(currentPlayer), 7);
            //PUT TOKEN
            round++;
            //end.testGrid

        }
    }
}
