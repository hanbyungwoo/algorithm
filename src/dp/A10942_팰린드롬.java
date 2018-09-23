package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A10942_ÆÓ¸°µå·Ò {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int [n+1];
		int d[][] = new int [n+1][n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			d[i][i] = 1; 
		}
		for(int i=1; i<=n-1; i++) {
			if(arr[i]==arr[i+1]) {
				d[i][i+1] = 1;
			}
		}
		for(int k=3; k<=n; k++) {
			for(int i=1; i<=n-k+1; i++) {
				int j = i+k-1;
				if(arr[i] == arr[j] && d[i+1][j-1]==1) {
					d[i][j] = 1;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			System.out.println(d[i][j]);
		}
		
		
	}
}
