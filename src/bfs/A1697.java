package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1697 {
	public static void main(String args[]) throws IOException {
		int arrow[] = {-1, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		boolean check [] = new boolean[100001];
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(first, 0));
		check[first] = true;
		if(first == second) {
			System.out.println(0);
			return;
		}
		while(!q.isEmpty()) {
			int n = q.peek().x;
			int m = q.peek().y;
			q.remove();
			m++;
			for(int i=0; i<3; i++) {
				int temp;
				if(i<2) {
					temp = n + arrow[i];
				}
				else {
					temp = n * 2;
				}
				if(temp < 100001 && temp >= 0) {
					if(check[temp] == false) {
						q.add(new Point(temp, m));
						check[temp]=true;
					}
				}
				if(temp == second) {
					System.out.println(m);
					return;
				}
			}
		}
	}
}
