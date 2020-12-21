package main.java.game;

public class Player{

    //Attributes
    private String type;
    private String name;

    //Constructor
    public Player(String type, String name) {
        this.type=type;
        this.name=name;
    }

    //Methods
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type){ this.type = type;}

    public void setName(String name){ this.name = name;}
}