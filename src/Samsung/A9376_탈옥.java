package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A9376_탈옥 {
	static final int BLANK = 0;
    static final int WALL = -1;
    static final int PRISON = 1;
    static final int DOOR = 2;
    static int map[][];
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static int h, w;
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken())+2;
			w = Integer.parseInt(st.nextToken())+2;
			map = new int[h][w];
			
			Point helper = new Point(0, 0);
			Point prison1 = new Point(-1, -1);
			Point prison2 = new Point(-1, -1);
			
			for(int i=1; i<h-1; i++) {
				String s = "."+br.readLine()+".";
				for(int j=0; j<w; j++) {
					char c = s.charAt(j);
					switch(c) {
					case '.' : 
						map[i][j] = BLANK;
						break;
					case '*' :
						map[i][j] = WALL;
						break;
					case '$' :
						map[i][j] = PRISON;
						if(prison1.x == -1) {
							prison1 = new Point(i, j);
						} else {
							prison2 = new Point(i, j);
						}
						break;
					case '#' :
						map[i][j] = DOOR;
						break;
					
					}
				}
			}
			
			for(int i=0; i<w; i++) {
				map[0][i] = map[h-1][i] = BLANK;
			}
			int[][] dist1 = bfs(helper);
			int[][] dist2 = bfs(prison1);
			int[][] dist3 = bfs(prison2);
			
			int ans = h*w;
			int tempCost = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == WALL) continue;
					tempCost = dist1[i][j] + dist2[i][j] + dist3[i][j];
					if(map[i][j]==DOOR) tempCost -= 2;
					
					ans = Math.min(ans, tempCost);

				}
			}
			
			System.out.println(ans);
		}
	}
	
	public static int[][] bfs(Point src) {
		int[][] dist = new int[h][w];
		
		for(int i=0; i<h; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(src);
		dist[src.x][src.y] = 0;
		
		while(!queue.isEmpty()) {
			Point u = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = u.x + dx[i];
				int ny = u.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
				if(map[nx][ny] == WALL) continue;
				
				if(map[nx][ny] == BLANK || map[nx][ny] == PRISON) {
					// 아직 방문안했고 다음칸이 숫자 더 큰 경우
					if(dist[nx][ny] == -1 || dist[nx][ny] > dist[u.x][u.y]) {
						dist[nx][ny] = dist[u.x][u.y];
						queue.add(new Point(nx, ny));
					}
				} else if(map[nx][ny] == DOOR) {
					// 문이라 접근할 때 +1 이 증가함
					if(dist[nx][ny] == -1 || dist[nx][ny] > dist[u.x][u.y]+1) {
						dist[nx][ny] = dist[u.x][u.y] + 1;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
		return dist;
	}
}










