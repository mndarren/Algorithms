package Algorithms;

import DataStructures.BSTNode;

/**
 * 
 * @apiSpec Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * @author Darren Zhao Xie
 * @date Mar 28, 2020 Created
 *
 */
public class LowestCommonAncestorBST {
	// top down approach: Time - O(logN), Space - O(logN)
	public BSTNode lowestCommonAncestorTD(BSTNode root, BSTNode p, BSTNode q) {
		if      (root.getVal() < p.getVal() && root.getVal() < q.getVal())  
			return lowestCommonAncestorTD(root.getRight(), p, q);
	    else if (root.getVal() > p.getVal() && root.getVal() > q.getVal())  
	    	return lowestCommonAncestorTD(root.getLeft(), p, q);
	    else                                            
	    	return root;
	}

	// Bottom up approach: Time - O(N), Space - O(N) Not working
	public BSTNode lowestCommonAncestorBU(BSTNode root, BSTNode p, BSTNode q) {
		if (root == null || root == p || root == q) return root;
		BSTNode left = lowestCommonAncestorBU(root.getLeft(), p, q);
		BSTNode right = lowestCommonAncestorBU(root.getRight(), p, q);
		return left == null ? right : (right == null ? left : root);
	}
}