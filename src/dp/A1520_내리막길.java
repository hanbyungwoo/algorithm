package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 경로를 탐색할 경우에는 시간초과가 뜨기 때문에
// 이미 탐색 했던 경로에 대해서는 종료해버림.

public class A1520_내리막길 {
	static int up[] = {-1, 1, 0, 0};
	static int down[] = {0, 0, 1, -1};
	static int n, m, ans;
	static int map[][], dp[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		ans=0;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		
		System.out.println(go(map, n, m));
	}
	
	public static int go(int[][] value, int x, int y) {
		if(x == 1 && y == 1) return 1;
		// 아직 탐색 안 한 경로만 확인
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			for(int i=0; i<4; i++) {
				int nx=up[i]+x;
				int ny=down[i]+y;
				if(nx > 0 && ny > 0 && nx <= n && ny <= m) {
					if(value[x][y] < value[nx][ny]) {
						dp[x][y] += go(value, nx, ny);
					}
				}
			}
		}
		return dp[x][y];
	}
}
