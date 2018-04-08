package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9465 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int map[][] = new int[2][num+1];
			int dp[][] = new int[num+1][3];
			// 1 xx 2 ox 3 xo
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=num; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<=num; i++) {
				dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + map[0][i];
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + map[1][i];
			}
			
			System.out.println(Math.max(dp[num][0], Math.max(dp[num][1], dp[num][2])));
		}
		

	}
}
