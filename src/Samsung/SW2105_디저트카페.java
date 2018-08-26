package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2105_디저트카페 {
	static int map[][];
	static int dx[] = {-1, 1, -1, 1};	// 좌상 좌하 우상 우하
	static int dy[] = {-1, -1, 1, 1};
	static int dCnt[];
	static boolean isDesert[];
	static int n, ans, sx, sy;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			isDesert = new boolean[101];
			map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = -1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sx = i;
					sy = j;
					dfs(i, j, 1, -1, 0);
				}
			}
			
			System.out.println("#"+ca+" "+ans);
			ca++;
		}
	}
	
	public static void dfs(int x, int y, int l, int d, int c) {
		// l : 지금까지 온 길이, d : 현재 향하는 방향, c : 지금까지 방향을 바꾼 횟수
		// c 는 3~4일 경우는 사각형임
		// 출발점에서 시작해서 딱 출발점으로 돌아오는 경우 3
		// 출발점에서 시작해서 출발점 뒤에서 도착하는 경우 4
		if( c >= 5 ) {	// 5이상이면 사각형 아님.
			return;
		}
		
		isDesert[map[x][y]] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx == sx && ny == sy && l >= 4 && c >= 3) {
				ans = Math.max(ans, l);
				isDesert[map[x][y]] = false;
				return;
			}
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || isDesert[map[nx][ny]]) {
				continue;
			}
			dfs(nx, ny, l+1, i, i==d?c:c+1);
		}
		isDesert[map[x][y]] = false;
	}
	
}