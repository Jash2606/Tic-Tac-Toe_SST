package Models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);
    
    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    

    public Move getMove(Board board) {
        System.out.println("Enter the row number to place your symbol: ");
        int row = scanner.nextInt();

        System.out.println("Enter the column number to place your symbol: ");
        int column = scanner.nextInt();

        return new Move(new Cell(row,column) , this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

}
