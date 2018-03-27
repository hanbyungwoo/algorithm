package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A13265 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		while(t-- >  0) {
			st = new StringTokenizer(br.readLine());
			int circle = Integer.parseInt(st.nextToken());
			int line = Integer.parseInt(st.nextToken());
			int color[] = new int[circle+1];
			
			ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[circle+1];
			for(int i=0; i<=circle; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for(int i=1; i<=line; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int line1 = Integer.parseInt(st.nextToken());
				int line2 = Integer.parseInt(st.nextToken());
				list[line1].add(line2);
				list[line2].add(line1);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			if(circle > 1) {
				q.add(1);
				color[1] = 1;
			} 
			
			while(!q.isEmpty()) {
				int x = q.poll();
				
				for( int y : list[x] ) {
					// 색이 아직 칠해지지 않은 경우
					if(color[y] == 0) {
						color[y] = 3-color[x];
						q.add(y);
					} 
				}
			}
			
			boolean ok=true;
			for(int i=1; i<=circle; i++) {
				for(int x : list[i]) {
					if(color[x] == color[i]) {
						ok = false;
					}
				}
			}
			if(circle==0) {
				ok = false;
			}
			if(ok) {
				System.out.println("possible");	
			} else {
				System.out.println("impossible");
			}
		}
	}
}
