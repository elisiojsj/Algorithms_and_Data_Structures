import java.util.Stack;

public class TreeWalk extends BinarySearchTree {
	
	/*
	 * public method to walk the tree in preorder fashion and print the keys.
	 * @param x The node to start the walk (root) 
	 */
	public void preorderTreeWalk(Node x) {
		if (x != null) {
			System.out.print(" "+x.key);
			preorderTreeWalk(x.left);
			preorderTreeWalk(x.right);
		}
	}
	
	/*
	 * public method to walk the tree in order fashion and print the keys.
	 * @param x The node to start the walk (root) 
	 */
	public void inorderTreeWalk(Node x) {
		if (x != null) {
			inorderTreeWalk(x.left);
			System.out.print(" "+x.key);
			inorderTreeWalk(x.right);
		}
	}
	
	/*
	 * public method to walk the tree in postorder fashion and print the keys.
	 * @param x The node to start the walk (root) 
	 */
	public void postorderTreeWalk(Node x) {
		if (x != null) {
			postorderTreeWalk(x.left);
			postorderTreeWalk(x.right);
			System.out.print(" "+x.key);
		}
	}
	
	
	/*
	 * public method to walk the tree in preorder fashion and print the keys.
	 * Non recursive version.
	 * @param x The node to start the walk (root) 
	 */
	public void preorderTreeWalkNonRec(Node x) {
		Stack<Node> s = new java.util.Stack<Node>();
		//s.push(x);

		while((x!=null) || (s.empty()!=true)) {
			while (x != null) {
				s.push(x);
				System.out.print(" "+x.key);
				x = x.left;
			}
			x = s.pop();
			x = x.right;
		}
	}

	/*
	 * public method to walk the tree in order fashion and print the keys.
	 * Non recursive version.
	 * @param x The node to start the walk (root) 
	 */
	public void inorderTreeWalkNonRec(Node x) {
		Stack<Node> s = new java.util.Stack<Node>();

		while((x!=null) || (s.empty()!=true)) {
			while (x != null) {
				s.push(x);
				x = x.left;
			}
			x = s.pop();
			System.out.print(" "+x.key);
			x = x.right;
		}
	}

	/*
	 * public method to walk the tree in postorder fashion and print the keys.
	 * Non recursive version.
	 * @param x The node to start the walk (root) 
	 */
	public void postorderTreeWalkNonRec(Node x) {
		Stack<Node> s = new java.util.Stack<Node>();

		while((x!=null) || (s.empty()!=true)) {
			while (x != null) {
				s.push(x);
				x = x.left;
			}
			x = s.pop();
			if(x.flag != 567890) {
				x.flag = 567890; 
				s.push(x);
				x = x.right;
			}
			else {
				System.out.print(" "+x.key);
				x = null;
			}
		}
	}

	
	
	public static void main(String[] args) {
		TreeWalk bst = new TreeWalk();

		bst.treeInsert(new Node(15));
		bst.treeInsert(new Node(6));
		bst.treeInsert(new Node(18));
		bst.treeInsert(new Node(3));
		bst.treeInsert(new Node(7));
		bst.treeInsert(new Node(17));
		bst.treeInsert(new Node(20));
		bst.treeInsert(new Node(2));
		bst.treeInsert(new Node(4));
		bst.treeInsert(new Node(13));
		bst.treeInsert(new Node(9));
		
		bst.print2D();
		
		System.out.print("\nPreorder Tree Walk: ");
		bst.preorderTreeWalk(bst.root);
		System.out.print("\nPreorder Tree Walk NR: ");
		bst.preorderTreeWalkNonRec(bst.root);

		System.out.print("\n\nInorder Tree Walk: ");
		bst.inorderTreeWalk(bst.root);
		System.out.print("\nInorder Tree Walk NR: ");
		bst.inorderTreeWalkNonRec(bst.root);

		System.out.print("\n\nPostorder Tree Walk: ");
		bst.postorderTreeWalk(bst.root);
		System.out.print("\nPostorder Tree Walk NR: ");
		bst.postorderTreeWalkNonRec(bst.root);
	}
}
