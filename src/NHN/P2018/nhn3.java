package NHN.P2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nhn3 {
	static int days, max, max_cost;
	static int cost[];
	static boolean visit[];
	static boolean visit2[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		days = Integer.parseInt(st.nextToken());
		cost = new int[days];
		
		visit = new boolean[days];
		
		st = new StringTokenizer(br.readLine(), " ");
		
//		int dp[] = new int[days];
		max_cost = 0;
		for(int i=0; i<days; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			max_cost = Math.max(max_cost, cost[i]);
		}
		// 내림차순인 경우
		// 예외처리하나 해주고
		max = 0;
		for(int i=0; i<days; i++) {
			visit[i] = true;
			dfs(i, 1);
			visit[i] = false;
		}
		
		System.out.println(max);
		
	}	
	
	public static void dfs(int index, int depth) {
//		int arr[] = {1,2,3,4,5};
		int pay = 0;
		int coin_cnt = 0;
		int check = 0;
		for(int i=0; i<days; i++) {
			// 코인을 산다.
			if(visit[i]) {
//				System.out.print(arr[i]);
				coin_cnt++;
				pay -= cost[i];
			} else {
			// 코인을 판다.
				if(max_cost == cost[i] && !visit[i]) {
					pay += cost[i]*coin_cnt;
				} else {
					pay += cost[i]*coin_cnt;
				}
				// 수수료
				pay--;
				coin_cnt = 0;
				///
				
				check++;
			}
		}
//		visit2 = new boolean[check];
//		for(int i=0; i<check; i++) {
//			visit2[i] = true;
//			dfs2(i, 1, check);
//			visit2[i] = false;
//		}
		max = Math.max(max, pay);
//		System.out.println();
		for(int i=index+1; i<days; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, depth+1);
				visit[i] = false;
			}
		}
	}
	

}
