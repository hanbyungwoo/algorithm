package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1726_로봇 {
	static int n, m;
	static int map[][];
	static boolean isVisit[][][];
	static int dx[] = {0,1,0,-1};	// 동 남 서 북
	static int dy[] = {1,0,-1,0};
	static Queue<Robot> q;
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());	// 세로
		n = Integer.parseInt(st.nextToken());	// 가로
		
		map = new int[m+1][n+1];
		isVisit = new boolean[m+1][n+1][4];
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine(), " ");
		Robot start = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), change(Integer.parseInt(st.nextToken())), 0);
		st = new StringTokenizer(br.readLine(), " ");
		Robot end = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), change(Integer.parseInt(st.nextToken())), 0);
		if(start==end) {
			System.out.println(0);
			return;
		}
		q = new LinkedList<Robot>();
		isVisit[start.x][start.y][start.dir] = true;
		q.add(start);
		while(!q.isEmpty()) {
			Robot temp = q.poll();
			
			if(temp.x==end.x && temp.y==end.y && temp.dir==end.dir) {
				System.out.println(temp.cnt);
				return;
			}
			// 전진중..최대 3칸
			for(int k=1; k<=3; k++) {
				int nx = temp.x + (dx[temp.dir]*k);
				int ny = temp.y + (dy[temp.dir]*k);
				if(range(nx, ny)) {
					if(map[nx][ny] == 0) {
						if(!isVisit[nx][ny][temp.dir]) {
							isVisit[nx][ny][temp.dir] = true;
							q.add(new Robot(nx, ny, temp.dir, temp.cnt+1));
						}
					} else {
						break;
					}
				} 
			}
			
			// 회전
			for(int i=0; i<4; i++) {
				// 현재 방향 제외
				if(temp.dir!=i && !isVisit[temp.x][temp.y][i]) {
					int plus=1;
					if(temp.dir==0) {
						if(i==2) plus++;
					} else if(temp.dir==1) {
						if(i==3) plus++;
					} else if(temp.dir==2) {
						if(i==0) plus++;
					} else {
						if(i==1) plus++;
					}
					isVisit[temp.x][temp.y][i] = true;
					q.add(new Robot(temp.x, temp.y, i, temp.cnt+plus));
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		if(x>0 && y>0 && x <= m && y <= n) return true;
		else return false;
	}
	
	public static int change(int x) {
		switch (x) {
		case 1 : return 0; // 동
		case 2 : return 2; // 서 
		case 3 : return 1; // 남
		case 4 : return 3; // 북
		default : break;
		}
		return 0;
	}
	
	
}

class Robot {
	int x;
	int y;
	int dir;
	int cnt;
	public Robot(int x, int y, int dir, int cnt) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}
}