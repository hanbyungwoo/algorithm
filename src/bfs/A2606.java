package bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A2606 {
	static boolean visited[];
	static ArrayList<Integer>[] list;
	static int cnt;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// N개의 컴퓨터
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());	// M개의 간선
		
		
		list = (ArrayList<Integer>[]) new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		cnt = -1;
		visited = new boolean[N+1];
		dfs(1);
		System.out.println(cnt);
	}
	
	public static void dfs(int x) {
		if(visited[x]) {
			return;
		}
		visited[x] = true;
		cnt++;
		for(int y : list[x]) {
			if(visited[y] == false) {
				dfs(y);
			}
		}
	}
}