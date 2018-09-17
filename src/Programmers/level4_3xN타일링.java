package Programmers;

public class level4_3xN≈∏¿œ∏µ {
	static boolean isContain;
	public static void main (String args[] ) {
		solution(6);
		solution(50);
		solution(100);
	}
	public static int solution(int n) {
		int answer=0;
		
		long dp[] = new long[n+1];
		dp[0] = 1;
		dp[2] = 3;
		for(int i=2; i<=n; i+=2) {
			dp[i] = (long)(dp[i-2]*3);
			for(int j=i-4; j>=0; j-=2) {
				dp[i] = (long)(dp[i] + dp[j]*2);
			}
			dp[i] = (long)(dp[i]%1000000007);
		}
		answer = (int)(dp[n]);
		System.out.println(answer);
		
		return answer;
	}
	
}