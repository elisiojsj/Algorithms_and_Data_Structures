public class BinarySearchTree {

	// root node of the BST
	public Node root;
	
	/*
	 * constructor
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/*
	 * public method to search a node with key = k.
	 * The version implemented is the iterative one.
	 * @param x The node to start looking from.
	 * @param k The value to be found.
	 * @return x The node found with the corresponding key.
	 */
//	public Node treeSearch(Node x, int k) {
	public Node treeSearch(int k) {
		Node x = root;
		while ((x !=null) && (k != x.key)) {
			if (k < x.key) {
				x = x.left;
			}
			else x = x.right;
		}
		return x;
	}
	
	
	/*
	 * public method to find the node with minimum key in the subtree
	 * rooted at a given node x.
	 * @param x The node to start the search.
	 * @return x The minimum node found.
	 */
	public Node treeMinimum(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	/*
	 * public method to find the node with maximum key in the subtree
	 * rooted at a given node x.
	 * @param x The node to start the search.
	 * @return x The maximum node found.
	 */
	public Node treeMaximum(Node x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}
	
	/*
	 * public method to return the successor of a node x in a BST if it exists
	 * and null if x has the largest key in the tree.
	 * @param x The node of which the successor is to be found.
	 * @return y The successor node found.
	 */
	public Node treeSuccessor(Node x) {
		if (x.right != null) {
			return treeMinimum(x.right);
		}
		Node y = x.parent;
		while ((y!=null) && (x==y.right)) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/*
	 * public method to insert a node z in the BST.
	 * @param z The node to be inserted.
	 */
	public void treeInsert(Node z) {
		Node y = null;
		Node x = root;
		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			}
			else x = x.right;
		}
		z.parent = y;

		if (y==null) {
			root = z; //tree was empty
		}
		else if (z.key < y.key) {
			y.left = z;
		}
		else y.right = z;
	}
	
	/*
	 * public method to replace one subtree as a child of its parent
	 * with another subtree.
	 * @param u The root node of the subtree to be replaced.
	 * @param v The root node of the subtree that will replace u.
	 */
	public void transplant(Node u, Node v) {
		if (u.parent == null) {
			root = v;
		}
		else if (u==u.parent.left) {
			u.parent.left = v;
		}
		else u.parent.right = v;
		if (v != null) {
			v.parent = u.parent;
		}
	}
	
	/*
	 * public method to delete a node in the BST.
	 * @param z The node to be deleted.
	 */
	public void treeDelete(Node z) {
		if(z.left==null) {
			transplant(z, z.right);
		}
		else if (z.right == null) {
			transplant(z, z.left);
		}
		else {
			Node y = treeMinimum(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
		}
	}
	

	/*
	 * public method to print the BST recursively in 2D.
	 * Copied from https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
	 * @param x The node to be printed.
	 * @param space The space between nodes to be printed.
	 */
	public void print2DUtil(Node x, int space)
	{
	    // Base case
	    if (x == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    print2DUtil(x.right, space);
	 
	    // Print current node after space
	    // count
	    System.out.print("\n");
	    for (int i = COUNT; i < space; i++)
	        System.out.print(" ");
	    System.out.print(x.key + "\n");
	 
	    // Process left child
	    print2DUtil(x.left, space);
	}

	static final int COUNT = 10;
	 
	/*
	 * public method wrapper over the print2DUtil()
	 * Copied from https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
	 */
	public void print2D()
	{
	    // Pass initial space count as 0
	    print2DUtil(root, 0);
	}
	
	
	/*
	 * public main method to test the class.
	 */
	public static void main (String args[]) {
		BinarySearchTree bst=new BinarySearchTree();
		
		bst.treeInsert(new Node(10));
		bst.treeInsert(new Node(15));
		bst.treeInsert(new Node(5));
		bst.treeInsert(new Node(2));
		bst.treeInsert(new Node(7));
		bst.treeInsert(new Node(16));
		bst.treeInsert(new Node(22));
		bst.treeInsert(new Node(1));
		bst.treeInsert(new Node(14));
		
		Node t = bst.treeSearch(14);
		if (t == null) {
			System.out.println("Node NOT found.");
		}
		else System.out.println("Node found: "+t.key);
		
		System.out.println("Tree minimum = "+bst.treeMinimum(bst.root).key);
		System.out.println("Tree maximum = "+bst.treeMaximum(bst.root).key);
		System.out.println("Tree successor 5 = "+bst.treeSuccessor(bst.treeSearch(5)).key);
		System.out.println("Tree successor 7 = "+bst.treeSuccessor(bst.treeSearch(7)).key);
		
		bst.print2D();
		
		System.out.println("\nDelete the node with key 16");
		bst.treeDelete(bst.treeSearch(16));

		bst.print2D();
	}


}
