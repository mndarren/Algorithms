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
	
	public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q) {
		if      (root.getVal() < p.getVal() && root.getVal() < q.getVal())  
			return lowestCommonAncestor(root.getRight(), p, q);
	    else if (root.getVal() > p.getVal() && root.getVal() > q.getVal())  
	    	return lowestCommonAncestor(root.getLeft(), p, q);
	    else                                            
	    	return root;
	}

}