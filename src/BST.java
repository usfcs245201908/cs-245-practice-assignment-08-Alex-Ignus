import javax.swing.*;
import java.net.HttpRetryException;

public class BST<T> {
	
	public class BSTNode {
		Comparable data;
		BSTNode left;
		BSTNode right;
		
		public BSTNode (Comparable data){
			this.data=data;
			this.right = this.left = null;
		}
	}
	
	public BSTNode root;
	

	
	public void insert (Comparable element) {
		
		insert (root, element);
	}
	
	public boolean find (Comparable element) {
		return find (root, element);
	}
	
	
	public void delete (T insertable) {
	}
	
	public void print () {
		print (root);
	}
	
	
	private BSTNode insert(BSTNode tree, Comparable element){
		if(tree==null){
			System.out.print ("im here");
			return new BSTNode (element);
		}
		if(element.compareTo (tree.data) < 0) {
			tree.left = insert (tree.left, element);
			return tree;
		} else {
			tree.right = insert (tree.right, element);
			return tree;
		}
	}
	private boolean find(BSTNode tree, Comparable element){
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
	
	private void print(BSTNode tree){
		if(tree != null){
			print (tree.left);
			System.out.print (tree.data);
			print (tree.right);
		}
	}
}
