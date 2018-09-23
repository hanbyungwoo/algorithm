package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A11066_파일합치기 {
	static int arr[];
	static int d[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			arr = new int[n+1];
			d = new int[n+1][n+1];
			
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				Arrays.fill(d[i], -1);
			}
			
			System.out.println(go(1, n));
		}
	}
	
	public static int go(int x, int y) {
		if( x==y ) return 0;
		if(d[x][y] != -1) {
			return d[x][y];
		}
		int ans=-1;
		int sum=0;
		for(int i=x; i<=y; i++) {
			sum += arr[i];
		}
		for(int i=x; i<=y-1; i++) {
			int temp = go(x, i) + go(i+1, y) + sum;
			if(ans == -1 || ans > temp) {
				ans = temp;
			}
		}
		d[x][y] = ans;
		return ans;
	}
}
