import Exceptions.InvalidMoveException;
import Models.Bot;
import Models.BotDifficultyLevel;
import Models.Game;
import Models.GameState;
import Models.Player;
import Models.PlayerType;
import Models.Symbol;
import controllers.GameController;

import java.util.*;

import javax.print.DocFlavor.STRING;
public class Main {
    public static void main(String[] args) throws InvalidMoveException{
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("Enter the dimension of the board: ");
        int dimension = sc.nextInt();

        System.out.println("Enter the name of the first player: ");
        String player1 = sc.next();
        System.out.println("Welcome " + player1 + " !");
        System.out.println();
        System.out.println("Enter Your Symbol:");
        char symbol1 = sc.next().charAt(0);


        System.out.println("Do you want to play with Bot? (Y/N)");
        String botPlayer = sc.next();

        List<Player> players;

        if (botPlayer.equalsIgnoreCase("Y")) {
            System.out.println("Enter the name of the Bot: ");
            String botName = sc.next(); 

            System.out.println("Symbol of Bot: O ");
            players = List.of(
                    new Player(player1, new Symbol(symbol1), PlayerType.HUMAN),
                    new Player(botName, new Symbol('O'), PlayerType.BOT)
            );
        } else {
            System.out.println("Enter the name of the second player: ");
            String player2Name = sc.next(); 
            System.out.println("Welcome " + player1 + "!");
            System.out.println();
            System.out.println("Enter Your Symbol : ");
            char symbol2 = sc.next().charAt(0);
            players = List.of(
                    new Player(player1, new Symbol(symbol1), PlayerType.HUMAN),
                    new Player(player2Name, new Symbol(symbol2), PlayerType.HUMAN)
            );
        }

        Game game = gameController.startGame(dimension, players);
        //gameController.printBoard(game);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            //1. print the board.
            gameController.printBoard(game);
            System.out.println();

            //2. Player's turn
            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.FINISHED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Apna Bhai " + gameController.getWinner(game).getName() + " jeet gaya! ");
        }
    }
}
