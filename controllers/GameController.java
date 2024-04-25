package controllers;

import java.util.List;

import Exceptions.InvalidMoveException;
import Models.Game;
import Models.GameState;
import Models.Player;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        try{
            if(players.size() < 2){
                throw new Exception("At least 2 players are required to start the game.");
            }
            if( players.get(0).getSymbol().getaChar() == players.get(1).getSymbol().getaChar()){
                throw new Exception("Symbols should be unique for each player.");
            }
        }catch(Exception e){
            System.out.println("Symbols should be unique for each player.");
            return null;
        }
        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
