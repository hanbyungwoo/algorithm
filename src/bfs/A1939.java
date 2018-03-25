package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1939 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int island = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		int[] check = new int[100005];
		
		ArrayList<Pair>[] list = (ArrayList<Pair>[]) new ArrayList[island+1];
		for(int i=0; i<=island; i++) {
			list[i] = new ArrayList<Pair>();
		}
		
		// 섬에 대한 데이터 입력
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int one= Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[one].add(new Pair(two, weight));
			list[two].add(new Pair(one, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start= Integer.parseInt(st.nextToken());
		int des= Integer.parseInt(st.nextToken());
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(start, 1000000001));
		check[start] = 1000000001;
		while(!q.isEmpty()) {
			int isla = (int)q.peek().x;
			int dis = q.peek().y;
			q.poll();
			
			for(int i=0; i<list[isla].size(); i++) {
				int tempIslan = list[isla].get(i).getX();	// 섬
				int tempDis = list[isla].get(i).getY();		// 중량
				int min = (tempDis>dis)?dis:tempDis;	
				if(check[tempIslan] < min) {
					check[tempIslan] = min;
					q.add(new Pair(tempIslan, min));
				}
			}
		}
		
		System.out.println(check[des]);
	}

	static class Pair {
		int x;
		int y;
		public Pair() {
			
		}
		public Pair(int two, int weight) {
			x = two;
			y = weight;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}

	
}

