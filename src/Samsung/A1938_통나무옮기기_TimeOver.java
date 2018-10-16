package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1938_통나무옮기기_TimeOver {
	static int N;
	static char map[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		map = new char[N][N];
		
		int start_temp[] = new int[6];
		int end_temp[] = new int[6];
		int cnt1=0, cnt2=0;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'B') {
					start_temp[cnt1++] = i;
					start_temp[cnt1++] = j;
				} else if(map[i][j] == 'E') {
					end_temp[cnt2++] = i;
					end_temp[cnt2++] = j;
				}
			}
		}
		treeInfo start = new treeInfo(start_temp[0], start_temp[1], start_temp[2], start_temp[3], start_temp[4], start_temp[5]);
		boolean visited[][][][][][] = new boolean[N][N][N][N][N][N];
		
		Queue<treeInfo> q = new LinkedList<treeInfo>();
		q.add(start);
		visited[start.x1][start.y1][start.x2][start.y2][start.x3][start.y3] = true;
		int ans=-1;
		int dx[] = {-1,1,0,0};	// 상하좌우
		int dy[] = {0,0,-1,1};
		int tx[] = {-1,-1,1,1}; // 대각선
		int ty[] = {-1,1,1,-1};
		while(!q.isEmpty()) {
			int size = q.size();
			ans++;
			for(int i=0; i<size; i++) {
				treeInfo temp = q.poll();
				if(temp.x1 == end_temp[0] && temp.y1 == end_temp[1] && temp.x2 == end_temp[2] && temp.y2 == end_temp[3] && temp.x3 == end_temp[4] && temp.y3 == end_temp[5]) {
					System.out.println(ans);
					return;
				}
				// 총 5가지 경우
				// U D L R인 경우(상하좌우)
				for(int j=0; j<4; j++) {
					int nx1 = temp.x1 + dx[j];
					int ny1 = temp.y1 + dy[j];
					int nx2 = temp.x2 + dx[j];
					int ny2 = temp.y2 + dy[j];
					int nx3 = temp.x3 + dx[j];
					int ny3 = temp.y3 + dy[j];
					if(range(nx1, ny1) && range(nx2, ny2) && range(nx3, ny3)) {
						if(!visited[nx1][ny1][nx2][ny2][nx3][ny3]) {
							visited[nx1][ny1][nx2][ny2][nx3][ny3] = true;
							q.add(new treeInfo(nx1, ny1, nx2, ny2, nx3, ny3));
						}
					}
				}
				// T인 경우 (회전)
				int check=0;
				for(int j=0; j<4; j++) {
					int nx = temp.x2 + dx[j];
					int ny = temp.y2 + dy[j];
					int tnx = temp.x2 + tx[j];
					int tny = temp.y2 + ty[j];
					if(range(nx, ny) && range(tnx, tny)) {
						
						check++;
					} else {
						break;
					}
				}
				// 회전 가능한 경우
				if(check==4) {
					// 가로인 경우
					if(temp.x1 == temp.x3) {
						int x1 = temp.x2+dx[0];
						int y1 = temp.y2+dy[0];
						int x3 = temp.x2+dx[1];
						int y3 = temp.y2+dy[1];
						if(!visited[x1][y1][temp.x2][temp.y2][x3][y3]) {
							q.add(new treeInfo(x1, y1, temp.x2, temp.y2, x3, y3));
							visited[x1][y1][temp.x2][temp.y2][x3][y3] = true;
						}
					} else {
					// 세로인 경우
						int x1 = temp.x2+dx[2];
						int y1 = temp.y2+dy[2];
						int x3 = temp.x2+dx[3];
						int y3 = temp.y2+dy[3];
						if(!visited[x1][y1][temp.x2][temp.y2][x3][y3]) {
							q.add(new treeInfo(x1, y1, temp.x2, temp.y2, x3, y3));
							visited[x1][y1][temp.x2][temp.y2][x3][y3] = true;
						}
					}
				}
				
			}
		}
		System.out.println(0);
		
	}
	
	public static boolean range(int x, int y) {
		if(x >= 0 && y >= 0 && y < N && x < N && map[x][y] != '1') return true;
		else return false;
	}
}

class treeInfo {
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int y3;
	public treeInfo(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
}











