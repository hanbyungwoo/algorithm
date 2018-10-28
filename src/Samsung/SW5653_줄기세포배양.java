package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//http://organize-study.tistory.com/166
public class SW5653_줄기세포배양 {
	static final int range = 200;
	static int n, m, k;
	static int map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			Queue<cell> q[] = (Queue<cell>[]) new LinkedList[11];
			for(int i=0; i<=10; i++) {
				q[i] = new LinkedList<cell>();
			}
			int ans=0;
			map = new int[500][500];
			for(int i=range; i<n+range; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=range; j<m+range; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						// 좌표정보를 넣준다.
						// 해당 숫자의 *2를 하는 이유는 해당시간만큼 잠복하고, 해당시간만큼 활성화하기 때문
						// 따라서 life가 다시 map[i][j]와 같아지는 순간 번식이 됨.
						// 0이 면 죽음 그 외의 경우에는 계속 life를 1씩 감소하며 q에 다시 넣어줌.
						q[map[i][j]].add(new cell(2*map[i][j], i, j));
					}
				}
			}
			
			for(int i=0; i<=k; i++) {
				for(int j=10; j>=1; j--) {
					int size = q[j].size();
					for(int k=0; k<size; k++) {
						cell x = q[j].poll();
						if(x.life > j) {	// 잠복기
							if(map[x.x][x.y] > 0) {
								ans++;
								map[x.x][x.y] = -map[x.x][x.y];
							}
							q[j].add(new cell(x.life-1, x.x, x.y));
						} else if(x.life == j) {	// 활성화하고 1시간 지났음.
							// 활성화해도 해당하는 건 넣고 또 새로 활성화되는 세포들 추가 필요.
							// 세포 확장 때 큰 세포가 작은 세포를 먹는데 그것은 이미 큐를 10개에 대한 경우를 다 만든 후
							// 10번 부터 확장하기 때문에 큰 세포가 먼저 자리를 잡음.
							q[j].add(new cell(x.life-1, x.x, x.y));
							for(int l=0; l<4; l++) {
								int nx = x.x + dx[l];
								int ny = x.y + dy[l];
								if(map[nx][ny] != 0) continue;
								map[nx][ny] = j;
								q[j].add(new cell(2*j, nx, ny));
							}
						} else if(j > x.life && x.life > 0) {	// 활성화 중...(번식은 끝났음)
							q[j].add(new cell(x.life-1, x.x, x.y));
						} else {
							ans--;
						}
					}
				}
			}
			System.out.println("#"+(ca++)+" "+ans);
		}
	}
	static class cell {
		int x, y, life;
		public cell(int life, int x, int y) {
			this.life = life;
			this.x = x;
			this.y = y;
		}
	}
	
	
}