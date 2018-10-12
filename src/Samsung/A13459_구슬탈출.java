package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Samsung.A13460_구슬탈출2.Ball;

public class A13459_구슬탈출 {
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 세로	
		int M = Integer.parseInt(st.nextToken());	// 가로
		
		char map[][] = new char[N+1][M+1];
		int check[][][][] = new int[11][11][11][11];
		int red[] = new int [2];
		int blue[] = new int [2];
		Queue<Ball> ball = new LinkedList<Ball>();
		
		for(int i=1; i<=N; i++) {
			map[i] = (" "+br.readLine()).toCharArray();
			for(int j=1; j<=M; j++) {
				if(map[i][j]=='B') {
					blue[0] = i;
					blue[1] = j;
				}
				if(map[i][j]=='R') {
					red[0] = i;
					red[1] = j;	
				}
			}
		}
		
		check[red[0]][red[1]][blue[0]][blue[1]]=1;
		ball.add(new Ball(0, red[0], red[1], blue[0], blue[1]));
		
		
		while(!ball.isEmpty()) {
			int rx = ball.peek().rx;
			int ry = ball.peek().ry;
			int bx = ball.peek().bx;
			int by = ball.peek().by;
			int cnt = ball.peek().cnt;
			ball.poll();
			
			for(int j=0; j<4; j++) {
				int nrx = rx, nry = ry;
				int nbx = bx, nby = by;
				int cr = 0, cb = 0;
				// 탈출구를 만나거나, 맨 끝 벽에 도달 했을 경우
				// 빨간 공 케이스
				while(map[nrx+dx[j]][nry+dy[j]] != '#' && map[nrx][nry] != 'O') {
					nrx += dx[j]; nry+= dy[j]; cr++;
				}
				// 파란 공 케이스
				while(map[nbx+dx[j]][nby+dy[j]] != '#' && map[nbx][nby] != 'O') {
					nbx += dx[j]; nby+= dy[j]; cb++;
				}
				if(nrx==nbx && nry==nby) {
					// 둘 다 구멍으로 들어가버림.. 다른 케이스를 살펴보자.
					if(map[nrx][nry]=='O') continue;
					// 둘 다 구멍으로 안들어감.
					if(cr < cb) {
						nbx-=dx[j];
						nby-=dy[j];
					} else {
						nrx-=dx[j];
						nry-=dy[j];
					}
				}
				
				// 파랑이 들어갔음.. 다른 케이스 
				if(map[nbx][nby]=='O') continue;
				// 빨강이 들어갔음..
				if(map[nrx][nry]=='O') {
					System.out.println(1);
//					System.out.println(cnt+1);
					return;
				}
				if(check[nrx][nry][nbx][nby]==1) continue;
				
				if(cnt < 9) {
					check[nrx][nry][nbx][nby]=1;
					ball.add(new Ball(cnt+1, nrx, nry, nbx, nby));
				}
			}
		}
		
		System.out.println(0);
		
	}
}










