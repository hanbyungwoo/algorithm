package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2294 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int pr[] = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			pr[i] = Integer.parseInt(st.nextToken());
		}
		int d[] = new int[m+1];
		
		for(int i=1; i<=m; i++) {
			d[i] = -1;	
		}
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<=m; j++) {
				if(j-pr[i] >= 0 && d[j-pr[i]] != -1) {
					if(d[j] == -1 || d[j] > d[j-pr[i]] + 1) {
						d[j] = d[j-pr[i]]+1; 
					}
				}
			}
		}
		
		System.out.println(d[m]);
	}
}
