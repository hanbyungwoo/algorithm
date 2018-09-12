package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//http://hsp1116.tistory.com/30 ��������.
public class A2493_ž {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());	// ž�� ����
		Stack<Point> stack = new Stack<Point>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=num; i++) {
			int x = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().y > x) {
					System.out.print(stack.peek().x +  " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			
			stack.push(new Point(i, x));
		}
	}
}

