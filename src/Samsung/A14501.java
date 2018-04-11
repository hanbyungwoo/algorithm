package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A14501 {
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
		
//		int max = 0;
//		for (int i = 2; i <= n; i++) {
//			for (int j = 1; j < i; j++) {
//				if (i - j >= day[j]) {
//					dp[i] = Math.max(pay[i] + dp[j], dp[i]);
//				}
//			}
//		}
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
			if(y < N+2 && visit[y] == false) {
				money += cost[index];
				if(max < money) {
					max = money;
				}
				dfs(y, money);
				money -= cost[index];
			}
		}
		visit[index] = false;
		
	}
}

