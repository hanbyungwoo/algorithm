package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2117_홈방범서비스 {
	static int map[][];
	static boolean visited[][];
	static int N, M, home;
	static int dx[] = {-1, 1, 0, 0};	// 상 하 좌 우
	static int dy[] = {0, 0, -1, 1};
	static int max;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 지도 가로세로 크기
			M = Integer.parseInt(st.nextToken());	// 집 마다 비용할 수 있는 비용
			
			map = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						home++;
					}
				}
			}
			
			max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					bfs(i, j);
				}
			}
					
			System.out.println("#"+ca+" "+max);
			ca++;
		}
	}
	
	public static void bfs(int x, int y) {
		visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		
		int homeCnt=0;	// 집 숫자 센다
		int kCnt=1;
		// 집이 있는 경우
		if(map[x][y]==1) {
			homeCnt++;
			cal(kCnt, homeCnt);
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int z=0; z<size; z++) {
				int xx = q.peek().x;
				int yy = q.peek().y;
				q.poll();
				for(int i=0; i<4; i++) {
					int nx = xx + dx[i];
					int ny = yy + dy[i];
					if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if(!visited[nx][ny]) {
							if(map[nx][ny] == 1) {
								homeCnt++;
							}
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					}
				}				
			}
			kCnt++;
			cal(kCnt, homeCnt);
			if(homeCnt == home) {
				// 모든 집을 다 체크했을 경우
				return;
			}
		}
	}
	
	public static void cal(int k, int cnt) {
		int profit = cnt*M - (k*k + (k-1)*(k-1));
		
		// 손해보지 않음 (0도 손해는 아님)
		if(profit >= 0) {
			max = Math.max(max, cnt);
		}
	}

}









