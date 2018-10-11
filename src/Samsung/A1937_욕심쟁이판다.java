package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1937_øÂΩ…¿Ô¿Ã∆«¥Ÿ {
	static int n, ans;
	static int map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int dp[][];
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans = Math.max(ans, dfs(i,j));
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static int dfs(int x, int y) {
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		int max = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) { 
				if(map[nx][ny] < map[x][y]) {
					max = Math.max(max, dfs(nx, ny));
				}
			}	
		}
		
		dp[x][y] = max + 1;
		return dp[x][y];
	}
	
	
}
