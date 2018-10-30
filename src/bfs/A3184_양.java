package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A3184_¾ç {
	static char map[][];
	static boolean visited[][];
	static int n, m, sh, wo, to_sh, to_wo;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j]!='#') {
					sh = 0;
					wo = 0;		
					
					bfs(i, j);
					to_sh += sh;
					to_wo += wo;
				}
			}
		}
		
		System.out.println(to_sh+" "+to_wo);
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		if(map[x][y] == 'v') {
			wo++;
		} else if(map[x][y] == 'o') {
			sh++;
		}
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(!visited[nx][ny] && map[nx][ny]!='#') {
						if(map[nx][ny] == 'v') {
							wo++;
						} else if(map[nx][ny] == 'o') {
							sh++;
						}
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		
		if(wo >= sh) {
			sh = 0;
		} else if(sh > wo) {
			wo = 0;
		}
	}
	
}
