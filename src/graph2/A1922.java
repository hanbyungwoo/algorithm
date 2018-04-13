package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// MST 관련 문제

public class A1922 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int com = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int li = Integer.parseInt(st.nextToken());
		
		// 위상에 대한 정리
		List<Pair>[] list = (List<Pair>[]) new List[com+1];
		
		for(int i=1; i<=com; i++) {
			list[i] = new ArrayList<Pair>();
		}
		for(int i=1; i<=li; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Pair(end, cost));
			list[end].add(new Pair(start, cost));
		}
		boolean c[] = new boolean [com+1];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
			
		c[1] = true;
		for(Pair x : list[1]) {
			q.add(x);
		}
		
		int ans = 0;
		
		for(int i=0; i<com-1; i++) {
			Pair e = new Pair();
			while(!q.isEmpty()) {
				// 최소값이 가장 먼저 나오게 됨.
				e = q.poll();
				if(c[e.x]==false) {
					break;
				}
			}
			c[e.x] = true;
			ans += e.y;
			for(Pair pp : list[e.x]) {
				q.add(pp);
			}
			
		}
		
		System.out.println(ans);
		
	}
}

class Pair implements Comparable<Pair> {
	int x;
	int y;
	public Pair() {
		
	}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.y > o.y) return 1;
		else if (this.y < o.y) return -1;
		else return 0;
	}
}

