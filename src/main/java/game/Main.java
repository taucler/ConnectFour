public class Main{

    public static void main(String[] args) {
        //Getting what's typed in the shell
        java.util.Scanner entry =   new java.util.Scanner(System.in);

        //Display the menu on the screen and get the player info
        System.out.println("Player 1 ?");
        Player Player1 = new Player(entry.next(), entry.next());
        System.out.println("Player 2 ?");
        Player Player2 = new Player(entry.next(), entry.next());

        //Display a new grid on the screen
        //System.out.println("Please provide grid dimensions : l c");
        Grid new_grid = new Grid(6, 7);
        new_grid.display();

        //Play
        Game new_game = new Game(new_grid);
        Player Player=Player1;
        while(true) {
            if(Player == Player1) {
                if(Player1.getType().equals("human")){
                    System.out.println(Player1.getName() + ", your turn ! Please enter a column to play.");
                }
                int token = 1;
                int column = new_game.check(Player, 7);
                if (new_game.play(new_grid, column, new_grid.state) == true) {
                    int line = new_game.getLine(new_grid, column, new_grid.state);
                    Grid grid = new_grid;
                    grid.fillSquare(grid, grid.state, line, column, token);
                }
                new_grid.display();
                Player = Player2;
            }
            if(Player == Player2) {
                if(Player2.getType().equals("human")){
                    System.out.println(Player2.getName() + ", your turn ! Please enter a column to play.");
                }
                int token = 2;
                int column = new_game.check(Player, 7);
                if (new_game.play(new_grid, column, new_grid.state) == true) {
                    int line = new_game.getLine(new_grid, column, new_grid.state);
                    Grid grid = new_grid;
                    grid.fillSquare(grid, grid.state, line, column, token);
                }
                new_grid.display();
                Player = Player1;
            }
        }
    }
}
