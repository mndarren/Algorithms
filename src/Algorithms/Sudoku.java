package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @apiSpec This class is about Sudoku check 
 * @author Darren Zhao Xie
 * @date Apr 14, 2020 Created
 *
 */
public class Sudoku {

    /**
     * Check if the input is a Sudoku. Time O(N^2), Space O(<N^2)
     * @param board
     * @return
     */
    public Boolean isValidSudoku(char[][] board) {
        // list maps will check if there are duplicate in each column
        ArrayList<HashMap<Character, Integer>> listMaps = new ArrayList<HashMap<Character, Integer>>();
        // Add 9 HashMap
        for(int i = 0; i < 9; i++) listMaps.add(new HashMap<Character, Integer>());
        
        for(int i = 0; i < board.length; i++) {
            // Row checker will check if there are duplicate in each row 
            HashMap<Character, Integer> rowChecker = new HashMap<Character, Integer>();
//            System.out.print("\nrow = " + i + ": ");
            for(int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
                if(board[i][j] != '.') {
                    if(!rowChecker.containsKey(board[i][j])) {
                        if(!listMaps.get(j).containsKey(board[i][j])) {
                            listMaps.get(j).put(board[i][j], 1);
                        } else { // if finding duplicate in the column
                            return false;
                        }
                        rowChecker.put(board[i][j], 1);
                    } else { // if finding duplicate in the row
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
