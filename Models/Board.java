package Models;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for( int i = 0; i < size; i++) {
            List<Cell> temp = new ArrayList<>();
            for( int j = 0; j < size; j++) {
                temp.add(new Cell(i, j));
            }
            board.add(temp);
        }
    }
    
    public void printBoard() {
        for( int i = 0; i < size; i++) {
            for( int j = 0; j < size; j++) {
                board.get(i).get(j);
                if( board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  __  |");
                }else{
                    System.out.print("|  " + board.get(i).get(j).getPlayer().getSymbol().getaChar() + "  |");
                }
            }
            System.out.println();
        }
    }


    public int getSize() {
        return size;
    }
    public List<List<Cell>> getBoard() {
        return board;
    }

    public Cell getCell(int x, int y) {
        return board.get(x).get(y);
    }

    public void setCell(int x, int y, Cell cell) {
        board.get(x).set(y, cell);
    }




}
