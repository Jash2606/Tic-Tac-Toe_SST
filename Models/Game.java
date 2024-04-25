package Models;
import java.util.*;

import Exceptions.InvalidMoveException;
import Strategies.WiningAlgorithm;
public class Game{
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private WiningAlgorithm winingAlgorithm;

    public Game(int size, List<Player> players){
        this.board = new Board(size);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winingAlgorithm = new WiningAlgorithm();
    }

    public void printBoard() {
        board.printBoard();
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private boolean ValidateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0  || col >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        if( currentPlayer.getPlayerType().equals(PlayerType.BOT)){
            System.out.println( currentPlayer.getName() + " ka move hai.");
        }else{
            System.out.println( currentPlayer.getName() + " Bhai ka move hai.");
        }

        Move move = currentPlayer.getMove(board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        // if(ValidateMove(move)){
        //     Cell tempCell = board.getBoard().get(row).get(col);
        //     tempCell.setPlayer(currentPlayer);
        //     tempCell.setCellState(CellState.FILLED);
            
        //     Move FinalMove = new Move(tempCell, currentPlayer);
        //     // adding it in list for undo features...
        //     moves.add(FinalMove);
        //     // now how will we know that from list of players which player turn is it?..(we can use nextPlayerMoveIndex for that...)
        //     nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
        //     if(winingAlgorithm.isWinningMove(board, FinalMove)){
        //         winner = currentPlayer;
        //         gameState = GameState.FINISHED;
        //     }
        //     // if moves are equal to size of board then game is finished...
        //     else if(moves.size() == board.getSize() * board.getSize()){
        //         System.out.println("Game is Drawn");
        //         gameState = GameState.FINISHED;
        //     }
        // }else{
        //     throw new InvalidMoveException("Thik se khelo " + currentPlayer.getName() +" Bhai yarr..");
        // }

        try {
            if (ValidateMove(move)) {
            Cell tempCell = board.getBoard().get(row).get(col);
            tempCell.setPlayer(currentPlayer);
            tempCell.setCellState(CellState.FILLED);

            Move FinalMove = new Move(tempCell, currentPlayer);
            // adding it in list for undo features...
            moves.add(FinalMove);
            // now how will we know that from list of players which player turn is it?..(we can use nextPlayerMoveIndex for that...)
            nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
            if (winingAlgorithm.isWinningMove(board, FinalMove)) {
                winner = currentPlayer;
                gameState = GameState.FINISHED;
            }
            // if moves are equal to size of board then game is finished...
            else if (moves.size() == board.getSize() * board.getSize()) {
                System.out.println("Game is Drawn");
                gameState = GameState.FINISHED;
            }
            } 
            else {
            throw new InvalidMoveException("Thik se khelo " + currentPlayer.getName() + " Bhai yarr..");
            }
        } catch (InvalidMoveException e) {
            System.out.println("Thik se khelo " + currentPlayer.getName() + " Bhai yarr..");
        }

    }
}