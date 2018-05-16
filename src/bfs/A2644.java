package bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A2644 {
	static boolean visited[];
	static int d[];
	static ArrayList<Integer>[] list;
	static int cnt, start, end;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// N명의 사람

		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());	// 출발
		end = Integer.parseInt(st.nextToken());		// 종료
		
		list = (ArrayList<Integer>[]) new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());	// 간선
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		cnt = 0;
		visited = new boolean[N+1];
		d = new int[N+1];
		dfs(start);
		if(d[end] == 0) System.out.println(-1);
		else System.out.println(d[end]);
	}
	
	public static void dfs(int x) {
		if(visited[x]) {
			return;
		}
		visited[x] = true;
		cnt++;
		if(x == end) {
			return;
		}
		for(int y : list[x]) {
			if(visited[y] == false) {
				d[y] = d[x] + 1;
				dfs(y);
			}
		}
	}
}