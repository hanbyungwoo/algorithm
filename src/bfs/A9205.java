package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A9205 {
	static int start[];
	static int end[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int storeCnt = Integer.parseInt(st.nextToken());
			boolean visited[] = new boolean[storeCnt+1];
			
			start = new int[2];
			st = new StringTokenizer(br.readLine(), " ");
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			ArrayList<Point> list = new ArrayList<Point>();
			for(int i=0; i<=storeCnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Point(a, b));
			}
			
			end = new int[2];
			
			end[0] = list.get(storeCnt).x;
			end[1] = list.get(storeCnt).y;
			boolean ch = false;
			
			Queue<Point> q = new LinkedList<Point>();
			q.add(new Point(start[0], start[1]));
			
			while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				q.poll();
				
				if(x==end[0] && y==end[1]) {
					ch = true;
					break;
				}
				
				for(int i=0; i<=storeCnt; i++) {
					if(visited[i] == false && Math.abs(x-list.get(i).x) + Math.abs(y-list.get(i).y) <= 1000) {
						q.add(new Point(list.get(i)));
						visited[i] = true;
					}
				}
			}
			
			if(ch) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
			
		}
	}
}
