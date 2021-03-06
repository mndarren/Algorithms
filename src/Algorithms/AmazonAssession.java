package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DataStructures.MatrixNet;
import DataStructures.MatrixNet.MatrixNode;

/**
 * 
 * @apiSpec (1) Grid with 1 or 0 values, count the ones whose value is 1, and
 *          related values are 1, not including related diagonal block (2) Graph
 *          problem, given nodes and links collection, find the ones without
 *          which all nodes cannot be connected.
 * @author Darren Zhao Xie
 * @date Apr 5, 2020 Created
 *
 */
public class AmazonAssession {
    /**
     * MatrixNet approach is not necessary, but it's a good try. Time O(MN), Space O(MN)
     * only the block that is natural and its related block are natural can be built park.
     * @param rows
     * @param columns
     * @param grid
     * @return int - the number of park can be built
     */
    public int parksNeeded(int rows, int columns, ArrayList<ArrayList<Integer>> grid) {
        int numParks = 0;
        MatrixNet matrix = new MatrixNet();
        matrix.buildLinkedMatrix(grid);

        MatrixNode temp = matrix.upLeft, rowHead = matrix.upLeft;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (temp.val == 1) {
                    if ((temp.left == null || (temp.left != null && temp.left.val == 1))
                            && (temp.right == null || (temp.right != null && temp.right.val == 1))
                            && (temp.up == null || (temp.up != null && temp.up.val == 1))
                            && (temp.down == null || (temp.down != null && temp.down.val == 1))) {
                        numParks++;
                    }
                }
                temp = temp.right;
            }
            temp = rowHead.down;
            rowHead = rowHead.down;
        }
        return numParks;
    }

    /**
     * Actually Directly use grid to do the check makes thing easier: Time O(MN), Space O(1)
     * @param rows
     * @param columns
     * @param grid
     * @return
     */
    public int parksNeeded2(int rows, int columns, ArrayList<ArrayList<Integer>> grid) {
        int numParks = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    if ((j - 1 < 0 || (j - 1 >= 0 && grid.get(i).get(j - 1) == 1))
                            && (j + 1 > columns - 1 || (j + 1 <= columns - 1 && grid.get(i).get(j + 1) == 1))
                            && (i - 1 < 0 || (i - 1 >= 0 && grid.get(i - 1).get(j) == 1))
                            && (i + 1 > rows - 1 || (i + 1 <= rows - 1 && grid.get(i + 1).get(j) == 1))) {
                        numParks++;
                    }
                }
            }
        }
        return numParks;
    }
    
    /**
     * 
     * @param n - the number of nodes in graph
     * @param grid - links represented by 1 or 0
     * @return ArrayList<Integer> - the primary nodes without which the whole tree will be broken
     */
    public ArrayList<Integer> findCoreNodes(int n, ArrayList<ArrayList<Integer>> grid) {
        ArrayList<Integer> coreNodes = new ArrayList<Integer>();
        ArrayList<HashMap> linksList = new ArrayList<HashMap>();
        // add links for each node
        for(int i=0; i<n; i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j=0; j<n; j++) {
                if(grid.get(i).get(j) == 1) {
                    map.put(j, 1);
                }
            }
            linksList.add(map);
        }
        
        //Find the core nodes
        for(int i=0; i<n; i++) {
            ArrayList<Integer> linkedNodes = new ArrayList<Integer>();
            int start = i==0 ? i+1 : i-1;
            collectLinkedNode(i, start, linksList, linkedNodes);
//            System.out.println("Test i = "+i + " linkedNodes = "+linkedNodes.toString());
            if(linkedNodes.size() < n-1) {
                coreNodes.add(i+1);
            }
        }
        return coreNodes;
    }

    // Tool: recursively collect linked nodes
    private void collectLinkedNode(int i, int start, ArrayList<HashMap> linksList, ArrayList<Integer> linkedNodes) {
        linkedNodes.add(start);
        Set<Integer> keySet = linksList.get(start).keySet();
        int count = 0;
        for(Integer n : keySet) {
            if(n == i || linkedNodes.contains(n)) {
                count++;
                // Base case: once all items in the keySet are contained in linkedNodes
                if(count == keySet.size()) return;
                continue;
            } else {
                collectLinkedNode(i, n, linksList, linkedNodes);
            }
        }
        return;
    }
}
