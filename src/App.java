import main.java.game.Game;
import main.java.game.rules.GameHandler;
import main.java.game.Grid;
import main.java.game.Player;
import main.java.game.rules.TestGrid;

import java.awt.desktop.SystemSleepEvent;
import java.io.*;
import java.util.InputMismatchException;

public class App {


    public static void main(String[] args) throws IOException{
            System.out.println("Welcome to ConnectFour !");
            PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter("log.txt")));
            //Getting what's typed in the shell
            java.util.Scanner entry = new java.util.Scanner(System.in);

            //Display a new grid on the screen
            //System.out.println("Please provide grid dimensions : l c");
           // Grid grid = new Grid();

            //Display the menu on the screen and get the player info
            //Game game = new Game(grid);
            System.out.println("Number of players ? (max 2 for now)");
            int nbPlayers = -1;
            while(nbPlayers==-1) {
                try {
                    nbPlayers = entry.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("The entered value is not an int");
                }
            }
            while(nbPlayers!=2){
                if(nbPlayers<2){
                    System.out.println("Unfortunately, you cannot play ConnectFour alone (at least 2)... But feel free to play against our IA !");
                }
                else {
                    System.out.println("We are sorry, but our game is not designed to be played by more than 2 players for now. ");
                }
                nbPlayers = entry.nextInt();
            }
            Player players[] = new Player[nbPlayers];
            for(int i = 0; i<nbPlayers; i++){
                players[i]= new Player();
                System.out.println("Please for each player choose human/ia and an username.");
                String type = entry.next();
                while(!(type.equals("ia") || type.equals("human"))){
                    System.out.println("Please respect usage : human YourName or ia RobotName.");
                    type = entry.next();
                }
                players[i].setType(type);
                String name = entry.next();
                players[i].setName(name);
                if(type.equals("human")) {
                    file.println("Joueur " + (i + 1) + " est humain " + name);
                }
                else{
                    file.println("Joueur " + (i + 1) + " est ia " + name);
                }
            }
            GameHandler handler = new GameHandler(3, nbPlayers);
            int currentPlayer=0;
            int begginer=0;
            while(handler.getMaxScore() < 3){
                file.println("Manche commence");
                Grid grid = new Grid();
                Game game = new Game(grid);
                int round = begginer;
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
                    file.println("Joueur " + (currentPlayer+1) + " joue " + game.getLastColumnPlayed());
                }
                if(end.getWin() == -1){ //Tie Game
                    System.out.println("Tie game, nobody won this round ! Next game !");
                    file.println("Egalite");
                }
                else {
                    handler.increaseScore(currentPlayer);
                    System.out.println(players[currentPlayer].getName() + " won this game ! Congratulations !");
                    System.out.print("Score : ");
                    for(int i = 0; i<nbPlayers-1; i++){
                        System.out.print(players[i].getName() + " " + handler.getScore(i) + " - ");
                    }
                    System.out.println(players[nbPlayers-1].getName() + " " + handler.getScore(nbPlayers-1));
                    file.println("Joueur " + (currentPlayer+1) + " gagne");
                    file.print("Score ");
                    for(int i = 0; i<nbPlayers-1; i++){
                        file.print(handler.getScore(i) + " - ");
                    }
                    file.println(handler.getScore(nbPlayers-1));
                    System.out.println("\n ============== NEW ROUND ==============");
                }
                begginer++;
            }
            System.out.println(players[currentPlayer].getName() + " won ! GAME OVER !");
            file.println("Partie finie");
            file.close();
        }
    }

