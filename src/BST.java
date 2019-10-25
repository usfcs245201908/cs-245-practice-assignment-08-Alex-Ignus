package src;

public class BST<T> {

	/**
	 *
	 */
	private class TreeNode {
		Comparable data; //data stored in this node for retrieval and comparison
		TreeNode left;
		TreeNode right;

		/**
		 * @param element the element we are initializing our TreeNode with as data
		 */
		public TreeNode(Comparable element){
			this.data=element;
			this.right = this.left = null;
		}
	}

	/**
	 * Initial start of the tree
	 */
	public TreeNode root;


	/**
	 * @param element the comparable object to added into our tree
	 */
	public void insert (Comparable element) { root = insert (root, element); }

	/**
	 * @param element the comparable object to search for in our tree
	 * @return true if present, false if element is not present in the tree
	 */
	public boolean find (Comparable element) {
		return find (root, element);
	}

	/**
	 * @param element the comparable object to remove from our tree
	 *
	 */
	public void delete (Comparable element) { root = delete(root, element); }

	/**
	 * Prints out the Binary Search tree starting from root
	 */
	public void print () {
		print (root);
	}


	/**
	 * @param tree The root of our tree to added too
	 * @param element the comparable object to added into our tree
	 * @return returns the tree after creation or insertion
	 */
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

	/**
	 * @param tree the tree we are searching in
	 * @param element the comparable object to search for in our tree
	 * @return boolean: True if element is in the tree, false if its not
	 */
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

	/**
	 * @param tree The tree we are traversing to remove the element from.
	 * @param element the element we are going to remove from our tree
	 * @return the newly edited tree
	 */
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

	/**
	 * @param tree the tree we are going to remove from
	 * @return the smallest object found in the tree
	 */
	private Comparable removeSmallest(TreeNode tree){
		if(tree.left.left == null){
			Comparable smallest = tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		} else {
			return removeSmallest(tree.left);
		}
	}

	/**
	 * @param tree the tree we are going to print
	 */
	private void print(TreeNode tree){
		if(tree != null){
			print (tree.left);
			System.out.println (tree.data);
			print (tree.right);
		}
	}
}
