package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2665_미로만들기 {
	static int map[][];
	static boolean visited[][];
	static int n, min;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			char temp [] = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		min = Integer.MAX_VALUE;
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(min);
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		int cnt = 0;
		while(true) {
			// 벽있는 공간 넣을 Queue
			Queue<Point> next_q = new LinkedList<Point>();
			while(!q.isEmpty()) {
				int x1 = q.peek().x;
				int y1 = q.peek().y;
				if(x1 == n-1 && y1 == n-1) {
					min = cnt;
					return;
				}
				q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = x1 + dx[i];
					int ny = y1 + dy[i];
					if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
						if(map[nx][ny]==1 && !visited[nx][ny]) {
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
						} else if(map[nx][ny]==0 && !visited[nx][ny]) {
							visited[nx][ny] = true;
							next_q.add(new Point(nx,ny));
							
						}
					}
				}
			}
			cnt++;
			q = next_q;
		}
	}
}










