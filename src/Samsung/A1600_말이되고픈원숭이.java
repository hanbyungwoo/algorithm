package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1600_말이되고픈원숭이 {
	
	static int hx[] = {-2,-2,-1,1,2,2,1,-1};
	static int hy[] = {-1,1,2,2,1,-1,-2,-2};
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static int map[][];
	static boolean isVisit[][][];
	static int k, w, h, min;
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken()); // 가로
		h = Integer.parseInt(st.nextToken()); // 세로
		
		map = new int[h][w];
		isVisit = new boolean[h][w][31];
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		// 0, 0에서 시작
		bfs(k);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
	}
	
	public static void bfs(int kCnt) {
		Queue<monkey> q = new LinkedList<monkey>();
		q.add(new monkey(0, 0, kCnt, 0));
		
		while(!q.isEmpty()) {
			monkey cur = q.poll();
			
			if(cur.x < 0 || cur.y < 0 || cur.x >= h || cur.y >= w) continue;
			if(map[cur.x][cur.y] == 1) continue;
			
			if(cur.x == h-1 && cur.y== w-1) {
				min = Math.min(min, cur.cnt);
				return;
			}
			
			if(isVisit[cur.x][cur.y][cur.k]) continue;
			isVisit[cur.x][cur.y][cur.k] = true;
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				q.add(new monkey(nx, ny, cur.k, cur.cnt+1));
			}
			
			if(cur.k == 0) continue;
			for(int i=0; i<8; i++) {
				int nx = cur.x + hx[i];
				int ny = cur.y + hy[i];
				// 범위 안에 들고, 방문 안했고, 벽이면 안됨.
				q.add(new monkey(nx, ny, cur.k-1, cur.cnt+1));
			}
		}
	}
	
}

class monkey {
	int x;
	int y;
	int k;
	int cnt;
	public monkey(int x, int y, int k, int cnt) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
}
