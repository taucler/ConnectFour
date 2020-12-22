import main.java.game.Game;
import main.java.game.rules.GameHandler;
import main.java.game.Grid;
import main.java.game.Player;
import main.java.game.rules.TestGrid;

public class App {


    public static void main(String[] args) {
            System.out.println("Welcome to ConnectFour !");
            //Getting what's typed in the shell
            java.util.Scanner entry = new java.util.Scanner(System.in);

            //Display a new grid on the screen
            //System.out.println("Please provide grid dimensions : l c");
           // Grid grid = new Grid();

            //Display the menu on the screen and get the player info
            //Game game = new Game(grid);
            System.out.println("Number of players ?");
            int nbPlayers = Integer.parseInt(entry.next());
            Player players[] = new Player[nbPlayers];
            for(int i = 0; i<nbPlayers; i++){
                players[i]= new Player();
                System.out.println("Please for each player choose human/ia and an username.");
                players[i].setType(entry.next());
                players[i].setName(entry.next());
            }
            GameHandler handler = new GameHandler(3, nbPlayers);
            int currentPlayer=0;
            while(handler.getMaxScore() < 3){
                Grid grid = new Grid();
                Game game = new Game(grid);
                int round = 0;
                currentPlayer = 0;
                //Play
                TestGrid end = new TestGrid();
                grid.display();
                while (end.getWin() == 0) {
                    currentPlayer = round % nbPlayers;
                    if (players[currentPlayer].getType().equals("human")) {
                        System.out.println(players[currentPlayer].getName() + ", your turn ! Please enter a column to play.");
                    }
                    int token = currentPlayer + 1;
                    game.play(players[currentPlayer], grid, token, end);
                    grid.display();
                    round++;
                }
                handler.increaseScore(currentPlayer);
                System.out.println(players[currentPlayer].getName() + " won this game ! Congratulations ! You have now "
                + handler.getScore(currentPlayer) +" points.");
            }
            System.out.println(players[currentPlayer].getName() + " won ! GAME OVER !");
        }
    }

