package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1949_등산로조성 {
	static int n, k, max;
	static int map[][];
	static boolean isVisit[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			isVisit = new boolean[n][n];
			max = Integer.MIN_VALUE;
			int high=0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(high < map[i][j]) {
						high = map[i][j];
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == high) {
						dfs(i, j, 1, map[i][j], false);
					}
				}
			}
			
			System.out.println("#"+ca+" "+max);
			ca++;
		}
	}
	
	public static void dfs(int x, int y, int depth, int preValue, boolean check) {
		if(max < depth) max = depth;
		
		isVisit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && !isVisit[nx][ny]) {
				if(preValue > map[nx][ny]) {
					dfs(nx, ny, depth+1, map[nx][ny], check);
				}
				// 깍기 사용 아직 안함
				else if(!check && preValue > map[nx][ny] - k) {
					// map[x][y] -1을 하는 이유는
					// 현재의 봉우리 보다 1작은 것이 가능한한 
					// 높은 봉우리로 이동하는 것이 유리하게 만들어 줌
					dfs(nx, ny, depth+1, map[x][y]-1, true);
				}
			}
		}
		isVisit[x][y] = false;
	}
	
}








