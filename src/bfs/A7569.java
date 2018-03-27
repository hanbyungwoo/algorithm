package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 토마토
public class A7569 {
	static int dx[] = {0,0,0,0,-1,1};
	static int dy[] = {0,0,-1,1,0,0};
	static int dz[] = {-1,1,0,0,0,0};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());	// 가로 5
		int N = Integer.parseInt(st.nextToken());	// 세로 3
		int H = Integer.parseInt(st.nextToken());	// 높이 1
		int map[][][] = new int [H+1][N+1][M+1];
		boolean check[][][] = new boolean [H+1][N+1][M+1];
		// 높이 행 열 .. // H M N
		
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=1; k<=M; k++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j][k] = temp;
					if(temp == 1) {
						q.add(new Pair(i, j, k));
						check[i][j][k] = true;
					}
				}
			}
		}
		
		// 시작부터 모든 토마토가 익어 있는 상태
		if(q.isEmpty()) {
			System.out.println(0);
			return;
		}
		int day=0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int dh = q.peek().x;
				int dn = q.peek().y;
				int dm = q.peek().z;
				q.poll();
				for(int i=0; i<6; i++) {
					int tempDH = dh + dx[i];
					int tempDN = dn + dy[i];
					int tempDM = dm + dz[i];
					if(tempDM > 0 && tempDN > 0 && tempDH > 0 && tempDN <= N && tempDM <= M && tempDH <= H) {
						if(check[tempDH][tempDN][tempDM] == false && map[tempDH][tempDN][tempDM] == 0) {
							map[tempDH][tempDN][tempDM] = 1;
							check[tempDH][tempDN][tempDM] = true;
							q.add(new Pair(tempDH, tempDN, tempDM));
						}
					}
				}
			}
			day++;
		}
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=M; k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				 
				}
			}
		}
		
		System.out.println(day-1);
		
	}
	
	static class Pair {

		int x;
		int y;
		int z;
		
		public Pair(int j, int i, int k) {
			x = j;
			y = i;
			z = k;
		}
	}
}
