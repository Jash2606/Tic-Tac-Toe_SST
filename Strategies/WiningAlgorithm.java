package Strategies;

import Models.Board;
import Models.Move;
import java.util.*;

public class WiningAlgorithm {

    // for row and col , we will maintain hashmap for each row and col...
    HashMap<Integer, HashMap<Character, Integer>> rowMap = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMap = new HashMap<>();

    // for diagonal, we will maintain hashmap for each diagonal...
    HashMap<Character, Integer> leftDiagonalMap  = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalMap  = new HashMap<>();

    public boolean isWinningMove(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getaChar();

        // checking Row...
        if (!rowMap.containsKey(row)) {
            rowMap.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowMap.get(row);

        if (!currRowMap.containsKey(character)) {
            currRowMap.put(character, 1);
        } else {
            currRowMap.put(character, currRowMap.get(character) + 1);
        }

        if (currRowMap.get(character) == board.getSize()) {
            return true;
        }

        // checking Column...
        if (!colMap.containsKey(col)) {
            colMap.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = colMap.get(col);

        if (!currColMap.containsKey(character)) {
            currColMap.put(character, 1);
        } else {
            currColMap.put(character, currColMap.get(character) + 1);
        }

        if (currColMap.get(character) == board.getSize()) {
            return true;
        }

        // checking Left Diagonal...
        if (row == col) {
            if (!leftDiagonalMap.containsKey(character)) {
                leftDiagonalMap.put(character, 1);
            } else {
                leftDiagonalMap.put(character, leftDiagonalMap.get(character) + 1);
            }

            if (leftDiagonalMap.get(character) == board.getSize()) {
                return true;
            }
        }

        //checking Right Diagonal...
        if (row + col == board.getSize() - 1) {
            if (!rightDiagonalMap.containsKey(character)) {
                rightDiagonalMap.put(character, 1);
            } else {
                rightDiagonalMap.put(character, rightDiagonalMap.get(character) + 1);
            }

            if (rightDiagonalMap.get(character) == board.getSize()) {
                return true;
            }
        }
        return false;

    }
    
}
