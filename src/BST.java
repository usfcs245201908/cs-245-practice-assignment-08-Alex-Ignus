package src;

public class BST<T> {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     Comparable data;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(Comparable data) { data = data; }
	 * }
	 */
	public class TreeNode {
		Comparable data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(Comparable element){
			this.data=element;
			this.right = this.left = null;
		}
	}
	
	public TreeNode root;
	

	
	public void insert (Comparable element) {

		root = insert (root, element);
	}
	
	public boolean find (Comparable element) {
		return find (root, element);
	}
	
	
	public void delete (Comparable element) {
		root = delete(root, element);

	}
	
	public void print () {
		print (root);
	}
	
	
	private TreeNode insert(TreeNode tree, Comparable element){
		if(tree==null){
			return new TreeNode(element);
		}
		if(element.compareTo (tree.data) < 0) {
			tree.left = insert (tree.left, element);
			return tree;
		} else {
			tree.right = insert (tree.right, element);
			return tree;
		}
	}
	private boolean find(TreeNode tree, Comparable element){
		if(tree == null){
			return false;
		}
		if(element.compareTo (tree.data)== 0){
			return true;
		}
		if(element.compareTo (tree.data) < 0){
			return find (tree.left, element);
		}else{
			return find (tree.right, element);
		}
	}
	private TreeNode delete(TreeNode tree, Comparable element){
		if(tree == null){
			return null;
		}
		if(tree.data.compareTo(element) == 0){
			if(tree.left == null){
				return tree.right;
			}else if(tree.right == null){
				return tree.left;
			}
			else {
				if(tree.right.left == null){
					tree.data = tree.right.data;
					tree.right = tree.right.right;
					return tree;
				}else{
					tree.data = removeSmallest(tree.right);
					return tree;
				}
			}
		}else if(element.compareTo(tree.data) < 0){
			tree.left = delete(tree.left, element);
			return tree;
		}else{
			tree.right = delete(tree.right, element);
			return tree;
		}
	}

	private Comparable removeSmallest(TreeNode tree){
		if(tree.left.left == null){
			Comparable smallest = tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		} else {
			return removeSmallest(tree.left);
		}
	}

	private void print(TreeNode tree){
		if(tree != null){
			print (tree.left);
			System.out.println (tree.data);
			print (tree.right);
		}
	}
}
