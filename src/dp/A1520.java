package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1520 {
	static int up[] = {-1, 1, 0, 0};
	static int down[] = {0, 0, 1, -1};
	static int n;
	static int m;
	static int value[][];
	static int d[][];
	static int ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		value = new int[n+1][m+1];
		d = new int[n+1][m+1];
		ans=0;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=m; j++) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(go(value, 1, 1));
	}
	
	public static int go(int[][] value, int x, int y) {
		if(x == n && y == m) return 1;
		if(d[x][y]>0) return d[x][y];
		for(int i=0; i<4; i++) {
			int nx=up[i]+x;
			int ny=down[i]+y;
			if(nx > 0 && ny > 0 && nx <= n && ny <= m) {
				if(value[x][y] > value[nx][ny]) d[x][y] += go(value, nx, ny);
			}
		}
		return d[x][y];
	}
}
