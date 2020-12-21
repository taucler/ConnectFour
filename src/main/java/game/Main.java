package main.java.game;
import test.java.display.TestGrid;

public class Main {


    public static void main(String[] args) {
        System.out.println("Welcome to ConnectFour !");
        System.out.println("Please for each player choose human/ia and an username.");
        //Getting what's typed in the shell
        java.util.Scanner entry = new java.util.Scanner(System.in);

        //Display a new grid on the screen
        //System.out.println("Please provide grid dimensions : l c");
        Grid grid = new Grid();

        //Display the menu on the screen and get the player info
        Game game = new Game(grid);
        System.out.println("Number of players ?");
        int nbPlayers = Integer.parseInt(entry.next());
        Player players[] = new Player[nbPlayers];

        int round = 0;
        int currentPlayer;
        //Play
        TestGrid end = new TestGrid();

        while (end.getWin() == 0) {
            currentPlayer = round % nbPlayers;
            if (players[currentPlayer].getType().equals("human")) {
                System.out.println(players[currentPlayer].getName() + ", your turn ! Please enter a column to play.");
            }
            int token = currentPlayer + 1;
            game.play(players[currentPlayer], grid, token, end);
            round++;
        }
    }
}