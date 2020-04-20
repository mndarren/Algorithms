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
        ArrayList<HashMap<Character, Integer>> columMaps = new ArrayList<HashMap<Character, Integer>>();
        for(int i = 0; i < 9; i++) columMaps.add(new HashMap<Character, Integer>());
        
        ArrayList<HashMap<Character, Integer>> boxMaps = new ArrayList<HashMap<Character, Integer>>();
        for(int i = 0; i < 9; i++) boxMaps.add(new HashMap<Character, Integer>());
        
        for(int i = 0; i < board.length; i++) {
            // Row checker will check if there are duplicate in each row 
            HashMap<Character, Integer> rowChecker = new HashMap<Character, Integer>();
//            System.out.print("\nrow = " + i + ": ");
            for(int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
                if(board[i][j] != '.') {
                    // check if column is duplicated
                    if(!columMaps.get(j).containsKey(board[i][j])) columMaps.get(j).put(board[i][j], 1);
                    else return false;
                    
                    // check if row is duplicated
                    if(!rowChecker.containsKey(board[i][j])) rowChecker.put(board[i][j], 1);
                    else return false;
                    
                    // check if subbox is duplicated
                    int box = i/3*3 + j/3;
                    if(!boxMaps.get(box).containsKey(board[i][j])) boxMaps.get(box).put(board[i][j], 1);
                    else return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Check if a Sudoku can be solved
     * @param board
     * @return
     */
    public Boolean isSolvable(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for(int k = 0; k < 9; k++) {
                        board[i][j] = (char)(k + '1');
                        if(isValid(i, j, board) && isSolvable(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    // tool for isSolvable to check if the current row and column is valid
    private boolean isValid(int i, int j, char[][] board) {
        // check ith row
        for (int c = 0; c < 9; c++)
            if (c != j && board[i][c] == board[i][j])   return false;
        // check jth col
        for (int r = 0; r < 9; r++)
            if (r != i && board[r][j] == board[i][j])   return false;
        // check (i,j)'s subbox
        for (int k = 0; k < 9; k++) {
            int row = i / 3 * 3 + k / 3, col = j / 3 * 3 + k % 3;
            if (row != i && col != j && board[row][col] == board[i][j]) return false;
        }
        return true;
    }
    
    // Not working
    public Boolean isSolvable1(char[][] board) {
     // list maps will check if there are duplicate in each column
        ArrayList<HashMap<Character, Integer>> columMaps = new ArrayList<HashMap<Character, Integer>>();
        for(int i = 0; i < 9; i++) columMaps.add(new HashMap<Character, Integer>());
        
        ArrayList<HashMap<Character, Integer>> boxMaps = new ArrayList<HashMap<Character, Integer>>();
        for(int i = 0; i < 9; i++) boxMaps.add(new HashMap<Character, Integer>());
        
        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Integer> rowChecker = new HashMap<Character, Integer>();
            for (int j = 0; j < board[i].length; j++) {
                int box = i/3*3 + j/3;
                if (board[i][j] == '.') {
                    for(int k = 0; k < 9; k++) {
                        board[i][j] = (char)(k + '1');
                        if(isValid(i, j, board, rowChecker, columMaps, boxMaps) && isSolvable1(board)) return true;
                        board[i][j] = '.';
                        columMaps.get(j).remove(board[i][j]);
                        rowChecker.remove(board[i][j]);
                        boxMaps.get(box).remove(board[i][j]);
                    }
                    return false;
                } else { // assume no duplicate of the existing values in the matrix
                    // check if column is duplicated
                    if(!columMaps.get(j).containsKey(board[i][j])) columMaps.get(j).put(board[i][j], 1);
                    
                    // check if row is duplicated
                    if(!rowChecker.containsKey(board[i][j])) rowChecker.put(board[i][j], 1);
                    
                    // check if subbox is duplicated
                    if(!boxMaps.get(box).containsKey(board[i][j])) boxMaps.get(box).put(board[i][j], 1);
                }
            }
        }
        return true;
    }
    
    // Not work since recursion with collection objects
    private boolean isValid(int i, int j, char[][] board, 
            HashMap<Character, Integer> rowChecker, 
            ArrayList<HashMap<Character, Integer>> columMaps,
            ArrayList<HashMap<Character, Integer>> boxMaps) {

        int box = i/3*3 + j/3;
        if(columMaps.get(j).containsKey(board[i][j]) 
                || rowChecker.containsKey(board[i][j])
                || boxMaps.get(box).containsKey(board[i][j])) {
            return false;
        } 
        // check if column is duplicated
        if(!columMaps.get(j).containsKey(board[i][j])) columMaps.get(j).put(board[i][j], 1);
        
        // check if row is duplicated
        if(!rowChecker.containsKey(board[i][j])) rowChecker.put(board[i][j], 1);
        
        // check if subbox is duplicated
        if(!boxMaps.get(box).containsKey(board[i][j])) boxMaps.get(box).put(board[i][j], 1);
        
        return true;
    }

}
