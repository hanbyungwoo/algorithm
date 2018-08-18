package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A14501_Åð»çDFS {
	static int N;
	static int max;
	static boolean visit[];
	static int cost[];
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		visit = new boolean[N+2];
		for(int i=0; i<=N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		cost = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp = i+Integer.parseInt(st.nextToken());
			for(int j=temp; j<=N+1; j++) {
				list.get(i).add(j);
			}
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			if(visit[i] == false) {
				dfs(i, 0);
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int index, int money) {
		visit[index] = true;
		for(int y : list.get(index)) {
			if(y <= N+1 && visit[y] == false) {
				money += cost[index];
				max = max < money ? money : max;
				dfs(y, money);
				money -= cost[index];
			}
		}
		visit[index] = false;
		
	}
}

