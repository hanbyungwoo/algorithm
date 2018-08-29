package Samsung;
//1
//7 9 6 0 13
//5 2 1 0 6 5 1 6 5
//3 3 0 2 3 3 2 4 1
//6 5 5 6 2 5 1 1 6
//2 0 1 7 5 7 2 2 2
//2 7 2 0 2 3 6 2 5
//2 7 1 6 2 6 6 2 2
//1 3 1 1 1 5 1 6 6

// 내가 틀린 이유
// 한 번 방문한 경우에는 visit을 true로 변경해서 재접근이 불가능하다.
// 하지만 3이라는 시간 뒤에 다른 경로를 통하여
// 5라는 시간에 해당 루트에 또 접근하는 경우가 발생할 수 있다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1953_탈주범검거 {
	static int map[][];
	static int dx[] = {-1, 1, 0, 0};	// 상 하 좌 우
	static int dy[] = {0, 0, -1, 1};
	static int dCnt[];
	static boolean isVisit[][], ret[][];
	static int n, m, ans, r, c, l;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			isVisit = new boolean[n][m];
			ret = new boolean[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ret[r][c] = true;
			dfs(r, c, 1);
			
			ans = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(ret[i][j]) {
						ans++;
					}
				}
			}
			
			System.out.println("#"+ca+" "+ans);
			ca++;
		}
	}
	
	public static void dfs(int x, int y, int time) {
		if(time == l) {
			return;
		}
		
		// 0 상 1하 2좌 3우
		switch(map[x][y]) {
		case 1 : 
			go(x, y, 0, time);	
			go(x, y, 1, time);
			go(x, y, 2, time);
			go(x, y, 3, time);
			break;
		case 2 :
			go(x, y, 0, time);	
			go(x, y, 1, time);
			break;
		case 3 :
			go(x, y, 2, time);
			go(x, y, 3, time);
			break;
		case 4 :
			go(x, y, 0, time);
			go(x, y, 3, time);
			break;
		case 5 :
			go(x, y, 1, time);
			go(x, y, 3, time);
			break;
		case 6 :
			go(x, y, 1, time);
			go(x, y, 2, time);
			break;
		case 7 :
			go(x, y, 0, time);
			go(x, y, 2, time);
			break;
		default : 
			break;
		}
	}
	
	public static void go(int x, int y, int dir, int time) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || ny < 0 || nx >= n || ny >= m || isVisit[nx][ny]) {
			return;
		}
		int temp = map[nx][ny];
		isVisit[nx][ny] = true;
		switch(dir) {
		case 0 :
			if(temp == 1 || temp == 2 || temp == 5 || temp == 6) {
				ret[nx][ny] = true;
//				isVisit[nx][ny] = true;
				dfs(nx, ny, time+1);
			}
			break;
		case 1 :
			if(temp == 1 || temp == 2 || temp == 4 || temp == 7) {
				ret[nx][ny] = true;
//				isVisit[nx][ny] = true;
				dfs(nx, ny, time+1);
			}
			break;
		case 2 :
			if(temp == 1 || temp == 3 || temp == 4 || temp == 5) {
				ret[nx][ny] = true;
//				isVisit[nx][ny] = true;
				dfs(nx, ny, time+1);
			}
			break;
		case 3 :
			if(temp == 1 || temp == 3 || temp == 6 || temp == 7) {
				ret[nx][ny] = true;
//				isVisit[nx][ny] = true;
				dfs(nx, ny, time+1);
			}
			break;
		default :
			break;
		}
		isVisit[nx][ny] = false;
	}
}








