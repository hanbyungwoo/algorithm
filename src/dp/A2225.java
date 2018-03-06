package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2225 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long d[][] = new long [K+1][N+1];
		
		long mod = 1000000000;
		d[0][0] = 1;
		for(int i=1; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<=j; k++) {
					d[i][j] += d[i-1][j-k];
					d[i][j] %= mod;
				}
			}
		}
		System.out.println(d[K][N]);
		
	}
}
