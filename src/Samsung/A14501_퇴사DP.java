package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A14501_Åð»çDP {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int day[] = new int[n+1];
		int pay[] = new int[n+1];
		int dp[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			day[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
			
			dp[i] = pay[i];
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(i-j >= day[j]) {
					dp[i] = Math.max(pay[i]+dp[j],  dp[i]);
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=n; i++) {
			if(i+day[i] <= n+1) {
				max = max < dp[i] ? dp[i] : max;
			}
		}
		
		System.out.println(max);
	}
}

