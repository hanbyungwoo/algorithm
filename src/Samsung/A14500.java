package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14500 {
	static int max;
	static int map[][];
	static boolean visit[][];
	static int N, M;
	static int dx[]={-1,1,0,0};
	static int dy[]={0,0,1,-1};
//	static int sx[][] = { { 0,0,-1 },{ 0,-1,1 },{ 0,0,1 },{ 0,-1,1 } };
//	static int sy[][] = { { 1,2,1 },{ 1,0,0 },{ 1,2,1 },{ 1,1,1 } };
	static int sx[][] = { { 0,-1,0 },{ 0,1,0 },{ -1,0,1 },{ -1,0,1 } };
	static int sy[][] = { { -1,0,1 },{ -1,0,1 },{ 0,1,0 },{ 0,-1,0 } };
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				dfs(i,j,1,0);
				solve(i,j);
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int row, int col, int depth, int cnt) {
		if(depth == 4) {
			cnt += map[row][col];
			max = cnt > max ? cnt : max;
			return;
		}
		visit[row][col] = true;
		for(int i=0; i<4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if(nx > 0 && ny > 0 && nx <= N && ny <= M) {
				if(visit[nx][ny] == false) {
					dfs(nx, ny, depth+1, cnt+map[row][col]);
				}
			}
		}
		visit[row][col] = false;
	}
	

	public static void solve(int row, int col) {
		for(int i=0; i<4; i++) {
			int sum=map[row][col];
			for(int j=0; j<3; j++) {
				int nx = row + sx[i][j];
				int ny = col + sy[i][j];
				if(nx > 0 && ny > 0 && nx <= N && ny <= M) {
					sum += map[nx][ny];
				}
			}
			if(sum > max) {
				max = sum;
			}
		}
	}
}
