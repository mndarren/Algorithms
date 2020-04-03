package DataStructures;

public class BinarySearchTree {

	private BSTNode root;
	
	public Boolean containNode(int value) {
		return containRecursiveNode(root, value);
	}
	
	public void add(int value) {
		setRoot(addRecursive(getRoot(), value));
	}
	
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	public int findLargestValue() {
		return findLargestValue(root);
	}

	public int findSmallestValue() {
		return findSmallestValue(root);
	}
	
	public void queryInOrder() {
		traverseInOrder(root);
	}
	
	public void queryPostOrder() {
		traversePostOrder(root);
	}
	
	public void queryPreOrder() {
		traversePreOrder(root);
	}
	
	// In Order: left, current, right
	private void traverseInOrder (BSTNode current) {
		if (current != null) {
			traverseInOrder(current.getLeft());
			System.out.print(" " + current.getVal());
			traverseInOrder(current.getRight());
		}
	}
	
	// Pre Order: current, left, right
	private void traversePreOrder (BSTNode current) {
		if (current != null) {
			System.out.print(" " + current.getVal());
			traversePreOrder(current.getLeft());
			traversePreOrder(current.getRight());
		}
	}
	
	// Post Order: left, right, current
	private void traversePostOrder (BSTNode current) {
		if (current != null) {
			traversePostOrder(current.getLeft());
			traversePostOrder(current.getRight());
			System.out.print(" " + current.getVal());
		}
	}
	
	// Recursive find largest value
	private int findLargestValue(BSTNode current) {
		return current.getRight() == null ? current.getVal() : findSmallestValue(current.getRight());
	}
		
	// Recursive find smallest value
	private int findSmallestValue(BSTNode current) {
		return current.getLeft() == null ? current.getVal() : findSmallestValue(current.getLeft());
	}

	// Recursive delete
	private BSTNode deleteRecursive(BSTNode current, int value) {
		if (current == null) return null;
		if (value == current.getVal()) {
			if (current.getLeft() == null && current.getRight() == null) return null;
			if (current.getLeft() == null) return current.getRight();
			if (current.getRight() == null) return current.getLeft();
		}
		if (value < current.getVal()) {
			current.setLeft(deleteRecursive(current.getLeft(), value));
			return current;
		}
		// value > current.getVal()
		current.setRight(deleteRecursive(current.getRight(), value));
		return current;
	}

	// Recursively check if containing a Node
	private Boolean containRecursiveNode(BSTNode current, int value) {
		if (current == null) return false;
		if (current.getVal() == value) return true;
		
		return current.getVal() < value 
				? containRecursiveNode(current.getLeft(), value) 
				: containRecursiveNode(current.getRight(), value);
	}

	// Recursively add Node in the tree
	private BSTNode addRecursive(BSTNode current, int value) {
		if (current == null) return new BSTNode(value);
		
		if (value < current.getVal()) current.setLeft(addRecursive(current.getLeft(), value));
		else if (value > current.getVal()) current.setRight(addRecursive(current.getRight(), value));
		else return current;
		return current;
	}

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}
}
