package infixTopostfix;
/**
 * 스택을 배열로 구현함.
 */
public class stack {
	public char[] stack;		// 스택
	public int point = 0;		// 스택 포인트
	
	public stack() {
		stack = new char[100];
	}
	
	/**
	 * 스택의 최상위에 값을 추가한다. 
	 * @param c
	 */
	public void push(char c) {
		// 스택의 최상위에 값을 추가한다. 
		this.stack[this.point] = c;
		this.point ++;
		return ;
	}
	
	/**
	 * 스택의 최상위에 값을 가져온다. 
	 * @return
	 */
	public char pop() {
		this.point--;
		char result = stack[this.point];
		this.stack[this.point] = '\0';
		return result;
	}
	
	/**
	 * 스택 내용을 모두 보여준다.
	 */
	public void show() {
		for (int i = 0; i < this.point; i++) {
			System.out.print(this.stack[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 스택이 비었다면 true를 비어있지 않다면 false를 반환한다.
	 * @return 비었다면 true / 비어있지 않다면 false
	 */
	public Boolean IsEmpty() {
		return (this.point == 0 ? true : false);
	}
}
