package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9095 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		
		
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int goal = Integer.parseInt(st.nextToken());
			int dp[] = new int[goal+1];
			dp[0]=1;
			
			for(int i=1; i<=goal; i++) {
				if(i-1>=0) {
					dp[i] += dp[i-1];
				}
				if(i-2>=0) {
					dp[i] += dp[i-2];
				}
				if(i-3>=0) {
					dp[i] += dp[i-3];
				}
			}
			
			System.out.println(dp[goal]);
//			int ans = go(0, 0, goal);
//			System.out.println(ans);
		}
	}
	
	public static int go(int count, int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now = 0;
		for(int i=1; i<=3; i++) {
			now += go(count+1, sum+i, goal);
		}
		return now;
	}
	
	
}
