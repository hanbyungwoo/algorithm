package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A11049_Çà·Ä°ö¼À¼ø¼­ {
	static int arr[][];
	static int d[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		arr = new int[n+1][2];
		d = new int[n+1][n+1];
			
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(d[i], -1);
			}
			
		}
			
		System.out.println(go(1, n));
	}
	
	public static int go(int x, int y) {
		
		if(d[x][y] > 0) {
			return d[x][y];
		}
		
		if( x==y ) return 0;
		
		if(x+1==y) {
			return arr[x][0]*arr[x][1]*arr[y][1];
		}
		
		for(int i=x; i<=y-1; i++) {
			int temp = go(x, i) + go(i+1, y) + arr[x][0]*arr[i][1]*arr[y][1];
			if(d[x][y] == -1 || d[x][y] > temp) {
				d[x][y] = temp;
			}
		}
		
		
		return d[x][y];
	}
}
