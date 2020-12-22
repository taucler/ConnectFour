package main.java.game.rules;

public class GameHandler {
    private int nbGamesToWin;
    private int nbPlayers;
    private int[] score;
    private int maxScore;

    public GameHandler(int nbGames, int nbPlayers){
            this.nbGamesToWin = nbGames;
            this.nbPlayers = nbPlayers;
            this.score = new int[this.nbPlayers];
            for(int i=0; i<this.nbPlayers; i++){
                this.score[i]= 0;
            }
            this.maxScore = 0;
    }
    public int getScore(int token){
            return this.score[token];
    }
    public int getMaxScore(){return this.maxScore;}

    public void updateMaxScore(){
        for(int i = 0; i<this.nbPlayers; i++){
            if(this.score[i]>this.maxScore){
                this.maxScore = this.score[i];
            }
        }
        return;
    }
    public void increaseScore(int token){
        this.score[token]++;
        this.updateMaxScore();
        return;
    }
}
