package DataStructures;

public class BinarySearchTree {

	private BSTNode root;
	
	public Boolean containNode(int value) {
		return containRecursiveNode(root, value);
	}
	
	// Recursively check if containing Node
	private Boolean containRecursiveNode(BSTNode current, int value) {
		if (current == null) return false;
		if (current.getVal() == value) return true;
		
		return current.getVal() < value 
				? containRecursiveNode(current.getLeft(), value) 
				: containRecursiveNode(current.getRight(), value);
	}

	public void add(int value) {
		setRoot(addRecursive(getRoot(), value));
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
