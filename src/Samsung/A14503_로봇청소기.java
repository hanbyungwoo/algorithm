package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14503_로봇청소기 {
	static int N, M, cnt;
	static int map[][], direction[][];
	static int dx[] = {-1,0,1,0};	// 북 동 남 서
	static int dy[] = {0,1,0,-1};
	static int dice[] = new int[6];
	static int start[];
	static boolean visit[][];
	static boolean exit;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		start = new int[2];
		
		st = new StringTokenizer(br.readLine(), " ");		
		start[0] = Integer.parseInt(st.nextToken());
		start[1] = Integer.parseInt(st.nextToken());
		int curDir = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		direction = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(start[0], start[1], curDir));
		visit[start[0]][start[1]]=true;
		
		while(!q.isEmpty()) {
			Info temp = q.poll();
			int y = temp.c;
			int x = temp.r;
			int dir = temp.d;
			
			int nx=0;
			int ny=0;
			int changeDir = dir;
			boolean ch = false;
			
			for(int i=0; i<4; i++) {
				// 왼쪽 방향으로 회전
				changeDir = (changeDir+3)%4;
				nx = x + dx[changeDir];
				ny = y + dy[changeDir];
				if(range(nx, ny)) {
					if(map[nx][ny] == 0 && visit[nx][ny] == false) {
						// 청소 아직 안한 공간...
						visit[nx][ny] = true;
						ch = true;
						cnt++;
						q.add(new Info(nx, ny, changeDir));
						break;
					}
				}
				
			}
			
			// 후진해야 하는 경우
			if(!ch) {
				changeDir = (dir+2)%4;
				nx = x + dx[changeDir];
				ny = y + dy[changeDir];
				if(range(nx, ny)) {
					if(map[nx][ny] != 1) {
						// 후진 시 벽이 아니라면.
						q.add(new Info(nx, ny, dir));
					}
				}
			}
		}
		
		System.out.println(cnt+1);
	}
	
	public static boolean range(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < M) {
			return true;
		} else {
			return false;
		}
	}
}

class Info {
	int r;
	int c;
	int d;
	public Info(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
}









