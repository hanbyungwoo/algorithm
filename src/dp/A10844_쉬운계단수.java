package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A10844_쉬운계단수 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		int d[][] = new int [n+1][10];
		
		for(int i=1; i<=9; i++) {
			d[1][i] = 1;
		}
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
//				d[i][j] = 0;
				if(j>=1) {
					d[i][j] += d[i-1][j-1];
					
				}
				if(j<=8) {
					d[i][j] += d[i-1][j+1];
				}
				d[i][j] %= 1000000000;
				
			}
		}
		
		long cnt = 0;
		for(int i=0; i<=9; i++) {
			cnt+=d[n][i];
			cnt %= 1000000000;
		}
		
		System.out.println(cnt);
	}
}
