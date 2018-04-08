package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11057 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int d[][] = new int[num+1][10];
		
		for(int i=0; i<=9; i++) {
			d[1][i] = 1;
		}
		
		for(int i=2; i<=num; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
					d[i][j] += d[i-1][k];
					d[i][j] %= 10007;
				}
			}
		}
		
		long cnt = 0;
		for(int i=0; i<=9; i++) {
			cnt+=d[num][i];
			cnt %= 10007;
		}
		
		System.out.println(cnt);
		
	}
}
