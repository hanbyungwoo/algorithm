package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1495 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int d[][] = new int [n+1][m+1];
		
		st = new StringTokenizer(br.readLine());
		int vol[] = new int [n+1];
		for(int i=1; i<=n; i++) {
			vol[i] = Integer.parseInt(st.nextToken());
		}
		
		d[0][s] = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<=m; j++) {
				if(d[i][j] == 1) {
					if(j+vol[i+1] <= m) {
						d[i+1][j+vol[i+1]] = 1;
					}
					if(j-vol[i+1] >= 0) {
						d[i+1][j-vol[i+1]] = 1;
					}
				}
			}
		}
		
		for(int i=m; i>=0; i--) {
			if(d[n][i]==1) {
				System.out.println(i);
				break;
			}
			if(i==0) {
				System.out.println(-1);
			}
		}
		
	}
}
