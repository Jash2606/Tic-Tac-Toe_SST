package Models;
import java.util.*;
public class Game{
    Board board;
    List<Player> players;
    boolean nextPlayerMoveIndex;
    boolean winner;
    List<Move> moves;
    GameState gameState;
}