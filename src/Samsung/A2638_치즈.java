package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2638_치즈 {
	static int n, m;
	static int map[][], cnt[][];
	static boolean isVisit[][];
	static int dx[] = {-1,0,1,0};	// 상 우 하 좌
	static int dy[] = {0,1,0,-1};
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans=-1;
		while(true) {
			ans++;
			cnt= new int[n][m];
			isVisit = new boolean[n][m];
			// 겉에 흰공간을 돌며 C부분(녹을부분) 체크
			dfs(0, 0);
			
			// 치즈 녹음
			int check=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(cnt[i][j] > 1) {
						map[i][j] = 0;
					} else {
						check++;
					}
				}
			}
			if(check == n*m) {
				System.out.println(ans);
				break;
			}
		}
	}
	
	public static void dfs(int x, int y) {
		isVisit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if(map[nx][ny]==1) {
					cnt[nx][ny]++;
				}
				if(!isVisit[nx][ny] && map[nx][ny]==0) {
					dfs(nx, ny);
				}
			}
		}
	}
}