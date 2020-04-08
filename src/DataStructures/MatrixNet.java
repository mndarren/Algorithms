package DataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is designed for Amazon assessment problem, but it's not necessary. 
 * However, it's still good for a new Data Structure.
 * @apiSpec Linked Matrix matching 2 D Array
 * @author Darren Zhao Xie
 * @date Apr 5, 2020 Created
 *
 */
public class MatrixNet {
	/**
	 * 
	 * @apiSpec Matrix Node with 4 pointers
	 * @author Darren Zhao Xie
	 * @date Apr 5, 2020 Created
	 *
	 */
	public class MatrixNode {
		public int val;
		public MatrixNode left;
		public MatrixNode right;
		public MatrixNode up;
		public MatrixNode down;
		
		MatrixNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
			this.up = null;
			this.down = null;
		}
	}
	
	public MatrixNode upLeft;

	// Build Linked Matrix
	public MatrixNode buildLinkedMatrix(ArrayList<ArrayList<Integer>> grid) {
		int m = grid.size();
		int n = grid.get(0).size();
		// special case: empty grid
		if(n == 0) return null;
		
		upLeft = new MatrixNode(grid.get(0).get(0)); 
//		System.out.print(upLeft.val);
		MatrixNode prevTemp = upLeft, currTemp = upLeft, prevRowHead = upLeft, currRowHead = upLeft;
		for(int i = 0; i < m; i++) {
			for(int j = 1; j < n; j++) {
				currTemp.right = new MatrixNode(grid.get(i).get(j));
//				System.out.print(" " +currTemp.right.val);
				currTemp.right.left = currTemp;
				if(i != 0) {
					currTemp.right.up = prevTemp.right;
					prevTemp.right.down = currTemp.right;
				}
				currTemp = currTemp.right;
				prevTemp = prevTemp.right;
			}
			if(i+1 < m) {
				currRowHead.down = new MatrixNode(grid.get(i+1).get(0));
//				System.out.print("\n" + currRowHead.down.val);
				currRowHead.down.up = currRowHead;
				prevRowHead = currRowHead;
				prevTemp = currRowHead;
				currRowHead = currRowHead.down;
				currTemp = currRowHead;
			}
			
		}
		return upLeft;
	}
}
