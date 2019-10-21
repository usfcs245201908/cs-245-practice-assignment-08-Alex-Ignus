import javax.lang.model.element.NestingKind;

public class sTest {
	public static void main (String[] args){
		BST<String> bst = new BST<String>();
		
		bst.insert ("pie");
		bst.insert ("problems");
		bst.print ();
		System.out.println ();
		System.out.println (bst.find ("pie"));

		
	}
}
