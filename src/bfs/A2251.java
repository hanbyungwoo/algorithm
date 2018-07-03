package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2251 {
	static int to[] = {0, 0, 1, 1, 2, 2};
	static int from[] = {1, 2, 0, 2, 0, 1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int cup[] = new int[3];
		for(int i=0; i<3; i++) {
			cup[i] = Integer.parseInt(st.nextToken());
		}
		int sum = cup[2];
		boolean check[][] = new boolean[201][201];
		boolean[] ans = new boolean[201];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
		check[0][0] = true;
		ans[cup[2]] = true;
		
		while(!q.isEmpty()) {
			int cur[] = new int[3];
			Pair p = q.poll();
			cur[0] = p.first;
			cur[1] = p.second;
			cur[2] = sum - cur[0] - cur[1];
			for(int i=0; i<6; i++) {
				int []next = {cur[0], cur[1], cur[2]};
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;
				if(next[to[i]] > cup[to[i]]) {	// 해당 컵의 용량 초과시
					next[from[i]] = next[to[i]] - cup[to[i]];
					next[to[i]] = cup[to[i]]; 
				}
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Pair(next[0], next[1]));
					if(next[0] == 0) {
						ans[next[2]] = true;
					}
				}
			}
		}
		
		for(int i=0; i<=cup[2]; i++) {
			if(ans[i]) {
				System.out.print(i + " ");
			}
		}
	}
}

class Pair implements Comparable<Pair> {

	int first;
	int second;
	
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	// 여기서는 compartTo가 꼭 필요한건 아니지만 그냥 써봄
	
	@Override
	public int compareTo(Pair o) {
		if(this.first < o.first) {
			return -1;
		}
		if(this.first > o.first) {
			return 1;
		}
		if(this.second < o.second) {
			return -1;
		}
		if(this.second > o.second) {
			return 1;
		}
		return 0;
	}
	
	
}
