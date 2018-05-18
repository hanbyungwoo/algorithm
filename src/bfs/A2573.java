package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2573 {
	static int map[][];
	static int next[][];
	static boolean visited[][];
	static int n, m;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());	// 세로
		m = Integer.parseInt(st.nextToken());	// 가로
		
		map = new int[n+1][m+1];
		
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}
		
		next = new int[n+1][m+1];
		int cnt=0;
		while(true) {
			// 1시간 후의 얼음 
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					nextMap(i, j);
				}
			}
			int key = -1;
			int zero = 0;
			visited = new boolean[n+1][m+1];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(visited[i][j] == false && next[i][j] > 0) {
						dfs(i, j);
						key++;
					} else if(next[i][j] == 0) {
						zero++;
					}
				}
			}			
			cnt++;
			if(key > 0) {
				System.out.println(cnt);
				break;
			} else if(zero == n*m) {
				System.out.println(0);
				break;
			}
			// 다음 상태 지도 map에 copy
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					map[i][j] = next[i][j];
				}
			}
		}
		
	}
	
	public static void dfs(int x, int y) {
		if(visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx > 0 && ny > 0 && nx <= n && ny <= m) {
				if(next[nx][ny] > 0 && visited[nx][ny] == false ) {
					dfs(nx, ny);
				}
			}
		}
		
	}
	
	public static void nextMap(int x, int y) {
		int cnt=0;
		int val = map[x][y];
		if(val > 0) { 
			for(int i=0; i<4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx > 0 && ny > 0 && nx <= n && ny <= m) {
					if(map[nx][ny] == 0) {
						cnt++;
					}
				}
			}
		}
		
		next[x][y] = (val-cnt>0?val-cnt:0);
	}
}














