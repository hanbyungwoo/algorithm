package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2156 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int dp[][] = new int [num+1][3];
		int wine[] = new int[num+1];
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine());
			wine[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=num; i++) {
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			dp[i][1] = dp[i-1][0] + wine[i];
			dp[i][2] = dp[i-1][1] + wine[i];
		}
		
		System.out.println(Math.max(dp[num][0], Math.max(dp[num][1], dp[num][2])));
		
		
	}
}
