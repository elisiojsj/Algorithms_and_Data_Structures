public class Node {
	int key;
	Node left;
	Node right;
	Node parent;
	
	public Node(int x) {
		this.key = x;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
