package Models;
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name , symbol , playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    // @Override
    public Move getMove(Board board){
        for( int i = 0; i < board.getSize(); i++) {
            for( int j = 0; j < board.getSize(); j++) {
                if( board.getCell(i, j).getCellState().equals(CellState.EMPTY)) {
                    return new Move(board.getCell(i, j), this);
                }
            }
        }
        return null;
    }
}
