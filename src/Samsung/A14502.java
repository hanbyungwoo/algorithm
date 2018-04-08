package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A14502 {
	static int N, M;
	static int max;
	static boolean visit[][];
	static int map[][], copymap[][], tempmap[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		map = new int[N][M];
		tempmap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				tempmap[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N*M; i++) {
			int x = i/M;
			int y = i%M;
			if(tempmap[x][y]==0) {
				tempmap[x][y] = 1;
				dfs(i, 1);
				tempmap[x][y] = 0;
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int val, int cnt) {
		if(cnt == 3) {
			// 기둥3개 세웠다~
			copymap = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					copymap[i][j] = tempmap[i][j];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copymap[i][j]==2) {
						// 바이러스 확장
						expand(i, j);
					}
				}
			}
			check();
			
		} else {
			for(int i=val+1; i<N*M; i++) {
				int x = i/M;
				int y = i%M;
				
				if(tempmap[x][y] == 0) {
					tempmap[x][y] = 1;
					dfs(i, cnt+1);
				}
				
			}
		}
		tempmap[val/M][val%M]=0;
		cnt--;
	}
	
	public static void expand(int row, int col) {
		for(int i=0; i<4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if(nx >= 0 && ny >=0 && nx < N && ny < M) {
				if(copymap[nx][ny] == 0) {
					copymap[nx][ny] = 3;
					expand(nx, ny);
				}
			}
			
		}
	}
	
	public static void check() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copymap[i][j]==0) {
					cnt++;
				}
			}
		}
		
		if(max < cnt) {
			max = cnt;
		}
	}
}









