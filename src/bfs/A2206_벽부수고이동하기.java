package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2206_벽부수고이동하기 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 세로 6
		int M = Integer.parseInt(st.nextToken());	// 가로 4
		
		int map[][] = new int [N+1][M+1];
		boolean visited[][] = new boolean [N*M+1][2];
		
		for(int i=1; i<=N; i++) {
			char temp[] = br.readLine().toString().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = temp[j-1] - '0';
			}
		}
		int dis=1;
		Queue<Three> q = new LinkedList<Three>();
		q.add(new Three(1,1,0));
		visited[1][0] = true;
		// dist[(tempX-1)*M+tempY]
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int x = q.peek().x;
				int y = q.peek().y;
				int z = q.peek().z;
				q.poll();
				
				if(x==N && y==M) {
					System.out.println(dis);
					return;
				}
				
				for(int i=0; i<4; i++) {
					int tempX = x + dx[i];
					int tempY = y + dy[i];
					// 폭탄을 안터트림
					if(tempX > 0 && tempY > 0 && tempX <= N && tempY <= M) {
						if(visited[(tempX-1)*M+tempY][z] == false && map[tempX][tempY] == 0) {
							q.add(new Three(tempX, tempY, z));
							visited[(tempX-1)*M+tempY][z] = true;
						}
					}
					if(z==0) {
						// 폭탄 터트린 경우
						if(tempX > 0 && tempY > 0 && tempX <= N && tempY <= M) {
							if(visited[(tempX-1)*M+tempY][z] == false) {
								q.add(new Three(tempX, tempY, z+1));
								visited[(tempX-1)*M+tempY][z+1] = true;
							}
						}
					}
				}
			}
			dis++;
		}
		
		System.out.println(-1);
		
	}
	static class Three {
		int x;
		int y;
		int z;
		public Three(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
