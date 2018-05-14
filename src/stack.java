
public class stack {
	public static void main(String args[]) {
		StackTest st = new StackTest(100);
		st.push(1);
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(4);
		
		st.printStack();
		
		st.pop();
		st.pop();
		
		st.push(15);
		st.push(15);
		st.push(20);
		
		st.peek();
		
		st.printStack();
		
	}
}



class StackTest {
	int top;
	int [] stack;
	int size;
	
	public StackTest(int size) {
		top = -1;
		stack = new int[size];
		this.size = size;
	}
	
	public void peek() {
		System.out.println("peek : " + stack[top]);
	}
	
	public void push(int value) {
		stack[++top] = value;
		System.out.println(stack[top] + ": push");
	}
	
	public int pop() {
		System.out.println(stack[top] + ": pop");
		return stack[--top];
	}
	
	public void printStack() {
		System.out.println("--- STACK TEST ---");
		for(int i=top; i>=0; i--) {
			System.out.println(stack[i]);
		}
		System.out.println("-- END OF LIST --");
	}
}