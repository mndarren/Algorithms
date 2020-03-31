package DataStructures;

/**
 * 
 * @apiSpec BFS = Breadth First Search for Queue, DFS = Depth First Search for Stack
 * @author Darren Zhao Xie
 * @date Mar 30, 2020 Created
 *
 */
public class BSTNode {
	private int val;
	private BSTNode left;
	private BSTNode right;
	public BSTNode(int x) {
		setVal(x);
		setLeft(null);
		setRight(null);
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "BSTNode [val=" + val + "]";
	}
	
}
