package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2636_치즈 {
	static int row, col;
	static int map[][];
	static boolean isVisit[][];
	static int cheese, lastCheese;
	static boolean stop = false;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		col = Integer.parseInt(st.nextToken());	// 세로
		row = Integer.parseInt(st.nextToken());	// 가로
		map = new int[col][row];
		isVisit = new boolean[col][row];
		
		for(int i=0; i<col; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		
		int time=0;
		while(cheese!=0) {
			time++;
			lastCheese = 0;
			dfs(0, 0);
			init();
		}
		
		System.out.println(time + " " + lastCheese);

	}
	
	public static void dfs(int x, int y) {
		// 가장자리 부분에 0으로 셋팅되어있기 때문에 가능함.
		isVisit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx >= 0 && ny >= 0 && nx < col && ny < row) {
				if(map[nx][ny] == 1 && !isVisit[nx][ny]) {
					map[nx][ny]=0;
					isVisit[nx][ny]=true;
					cheese--;
					lastCheese++;
				} else if(map[nx][ny] == 0 && !isVisit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static void init() {
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				isVisit[i][j] = false;
			}
		}
	}
	
}

