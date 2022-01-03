/*
 * public class of node element for BSTs
 */
public class Node {
	int key;
	Node left;
	Node right;
	Node parent;
	int flag; // for postorder walk
	
	public Node(int x) {
		this.key = x;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
