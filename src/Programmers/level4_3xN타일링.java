package Programmers;

public class level4_3xN≈∏¿œ∏µ {
	static boolean isContain;
	public static void main (String args[] ) {
		solution(6);
		solution(10);
	}

	public static int solution(int n) {
		int answer=0;
		
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		for(int i=2; i<=n; i+=2) {
			dp[i] = dp[i-2]*3;
			for(int j=i-4; j>=0; j--) {
				dp[i] += dp[j]*2;
			}
		}
		
		System.out.println(dp[n]);
		answer = dp[n]%10000007;
		return answer;
	}
	
}