package woowahan;

import java.util.Stack;
import java.util.StringTokenizer;

public class P1 {
	public static void main(String args[]) {
		
		System.out.println(Solution("13 DUP 4 POP 5 DUP + DUP + -"));
	}
	
	public static int Solution(String S) {
		
		StringTokenizer st = new StringTokenizer(S, " ");
		Stack<Integer> s = new Stack<Integer>();
		while(st.hasMoreTokens()) {
			String temp = st.nextToken().toString();
			
			if(temp.equals("DUP")) {
				System.out.println("DUP");
				if(s.size() > 0) {
					int x = s.peek();
					s.push(x);
				} else {
					return -1;
				}
			} else if(temp.equals("POP")) {
				System.out.println("POP");
				if(s.size() > 0) {
					s.pop();
				} else {
					return -1;
				}
			} else if(temp.equals("+")) {
				System.out.println("+");
				if(s.size() > 1) {
					int x = s.pop();
					int y = s.pop();
					s.push(x+y);
				} else {
					return -1;
				}
			} else if(temp.equals("-")) {
				if(s.size() > 1) {
					int x = s.pop();
					int y = s.pop();
					int sub = x-y;
					if(sub < 0) {
						return -1;
					} else {
						s.push(sub);
					}
				} else {
					return -1;
				}
				System.out.println("-");
			} else { // integer
				s.push(Integer.parseInt(temp));
			}
		}
		
		
		return s.pop();
	}
}
