package main.java.game;

public class Main{

    public static void main(String[] args) {
        //Getting what's typed in the shell
        java.util.Scanner entry =   new java.util.Scanner(System.in);

        //Display the menu on the screen and get the player info
        System.out.println("Player 1 ?");
        Player player1 = new Player(entry.next(), entry.next());
        System.out.println("Player 2 ?");
        Player player2 = new Player(entry.next(), entry.next());

        //Display a new grid on the screen
        //System.out.println("Please provide grid dimensions : l c");
        Grid new_grid = new Grid(6, 7);
        new_grid.display();

        //Play
        Game new_game = new Game(new_grid);
        Player player = player1;
        while(true) {
            if(player == player1) {
                if(player1.getType().equals("human")){
                    System.out.println(player1.getName() + ", your turn ! Please enter a column to play.");
                }
                int token = 1;
                int column = new_game.putToken(player, 7);
                if (new_game.play(new_grid, column, new_grid.state) == true) {
                    int line = new_game.getLine(new_grid, column, new_grid.state);
                    Grid grid = new_grid;
                    grid.fillSquare(grid, grid.state, line, column, token);
                }
                new_grid.display();
                player = player2;
            }
            if(player == player2) {
                if(player2.getType().equals("human")){
                    System.out.println(player2.getName() + ", your turn ! Please enter a column to play.");
                }
                int token = 2;
                int column = new_game.putToken(player, 7);
                if (new_game.play(new_grid, column, new_grid.state) == true) {
                    int line = new_game.getLine(new_grid, column, new_grid.state);
                    Grid grid = new_grid;
                    grid.fillSquare(grid, grid.state, line, column, token);
                }
                new_grid.display();
                player = player2;
            }
        }
    }
}
