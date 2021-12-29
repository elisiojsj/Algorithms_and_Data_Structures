
public class Stack {

	// sizeStack is a constant and cannot be changed
	final int sizeStack = 10;
	private int[] S = new int[sizeStack];
	private int top = 0;
	
	// constructor
	public Stack() {
		top = 0;
	}
	
	/*
	 * public method to verify if the stack is empty
	 * @return true The stack is empty.
	 * @return false The stack is not empty.
	 */
	public boolean stackEmpty() {
		if (top == 0) {
			return true;
		}
		else return false;
	}
	
	/*
	 * public method to push a number in the stack.
	 * @param c The value to be pushed.
	 * @return false Operation failed the stack is full.
	 * @return true Operation was successfully accomplished. 
	 */
	public boolean push(int c) {
		if (top==sizeStack) { //overflows
			return false;
		}
		else {
			S[top] = c;
			top++;
		}
		return true;
	}
	
	/*
	 * public method to pop from the stack.
	 * @return S[top] The value at the top of the stack.
	 * @return -100000000 Operation failed, stack is empty.
	 */
	public int pop() {
		if (stackEmpty()==false) { //not empty
			--top;
			return S[top];
		}
		else return -100000000;
	}
	
	/*
	 * public helper method to print the stack.
	 */
	public void printStack() {
		if (top == 0) {
			System.out.println("The stack is empty");
		}
		else {
			for(int i=0; i<top; i++) {
				System.out.print("["+S[i]+"]");
			}
			System.out.println();
		}
	}
	
	/*
	 * public main method to test the stack implementation.
	 */
	public static void main(String[] args) {

		Stack s = new Stack();
		
		System.out.println("Try to print the stack:");
		s.printStack();
		
		System.out.println("\nPush 5");
		s.push(5);
		s.printStack();
		
		System.out.println("\nPush 7, 8 and 15");
		s.push(7);
		s.push(8);
		s.push(15);
		s.printStack();
		
		System.out.println("\nPop from stack:"+s.pop());
		s.printStack();
		
		System.out.println("\nPop from stack:"+s.pop());
		s.printStack();
		System.out.println("\nPop from stack:"+s.pop());
		s.printStack();
		System.out.println("\nPop from stack:"+s.pop());
		s.printStack();
		System.out.println("\nPop from stack:"+s.pop());
		s.printStack();
	}
}
