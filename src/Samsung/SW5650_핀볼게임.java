package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW5650_핀볼게임 {
	static int map[][], N;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ArrayList<hole> holelist = new ArrayList<hole>();
			// 지도 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >= 6 && map[i][j] <= 10) {
						holelist.add(new hole(i, j, map[i][j]));
					}
				}
			}
			int ans=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 공백인 경우에만 공을 놓을 수 있음
					if(map[i][j]==0) {
						// 4방향으로 
						for(int k=0; k<4; k++) {
							ans = Math.max(ans, game(i, j, k, holelist));
						}
					}
					
				}
			}
			System.out.println("#"+(ca++)+" "+ans);
		}
	}
	
	public static int game(int x, int y, int dir, ArrayList<hole> list) {
		// 상좌하우
		int dx[] = {-1,0,1,0};
		int dy[] = {0,-1,0,1};
		int nx = x;
		int ny = y;
		int cnt = 0;
		boolean isOut = false;
		while(!isOut) {
			while(map[nx][ny] == 0) {
				nx += dx[dir];
				ny += dy[dir];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					// 범위 안
					if(map[nx][ny]==-1 || (nx == x && ny == y)) {
						isOut = true;
						break;
					}
				} else {
					// 범위 외 : 벽에 맞는 경우 방향 반대로 설정
					dir = (dir+2)%4;
					nx += dx[dir];
					ny += dy[dir];
					cnt++;
					if(map[nx][ny]==-1 || (nx == x && ny == y)) {
						isOut = true;
						break;
					}
				}	
			}
			if(!isOut) {
				switch(map[nx][ny]) {
				case 1 :
					if(dir==0) dir=2;
					else if(dir==1) dir=0;
					else if(dir==2) dir=3;
					else dir=1;
					cnt++;
					break;
				case 2 :
					if(dir==0) dir=3;
					else if(dir==1) dir=2;
					else if(dir==2) dir=0;
					else dir=1;
					cnt++;
					break;
				case 3 :
					if(dir==0) dir=1;
					else if(dir==1) dir=3;
					else if(dir==2) dir=0;
					else dir=2;
					cnt++;
					break;
				case 4 :
					if(dir==0) dir=2;
					else if(dir==1) dir=3;
					else if(dir==2) dir=1;
					else dir=0;
					cnt++;
					break;
				case 5 : 
					dir = (dir+2)%4;
					cnt++;
					break;
				default :
					// 웜홀인 경우..?
					for(int i=0; i<list.size(); i++) {
						if(list.get(i).seq == map[nx][ny] && (list.get(i).x != nx || list.get(i).y != ny)) {
							nx = list.get(i).x;
							ny = list.get(i).y;
							break;
						}
					}
					break;
				}
				nx += dx[dir];
				ny += dy[dir];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					// 범위 안
					if(map[nx][ny]==-1 || (nx == x && ny == y)) {
						isOut = true;
						break;
					}
				} else {
					// 범위 외 : 벽에 맞는 경우 방향 반대로 설정
					dir = (dir+2)%4;
					nx += dx[dir];
					ny += dy[dir];
					cnt++;
					if(map[nx][ny]==-1 || (nx == x && ny == y)) {
						isOut = true;
						break;
					}
				}	
			}
			
			
		}
		
		
		
		return cnt;
	}
	
	static class pinBall {
		int x, y;
		int dir, cnt;
		public pinBall(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	
	static class hole {
		int x, y, seq;
		public hole(int x, int y, int seq) {
			this.x = x;
			this.y = y;
			this.seq = seq;
		}
	}
}