package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//http://stack07142.tistory.com/169
public class A1194 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 세로
		int M = Integer.parseInt(st.nextToken());	// 가로
		int start[] = new int[2];
		
		char[][] map = new char [N][M];
		boolean[][][] check = new boolean[N][M][(1<<7)];
		
		for(int i=0; i<N; i++) {
			char temp[] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = temp[j];
				if(temp[j] == '0') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(start[0], start[1], 0));
		map[start[0]][start[1]] = '.';
		check[start[0]][start[1]][0] = true;
		int step = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			step++;
			while(size-- > 0) {
				int x = q.peek().x;
				int y = q.peek().y;
				int z = q.peek().key;
				
				q.poll();
				
				if(map[x][y] >= 'a' && map[x][y] <= 'f') {	// 키를 발견했음
					z |= (1 << (map[x][y] - 'a'));
//					q.add(new Point(x, y, z));
//					for(int j=0; j<N; j++) {
//						Arrays.fill(check[j], false);
//					}
//					check[x][y]=true;
				}
				
				if(map[x][y] >= 'A' && map[x][y] <= 'F') {	// 문을 만났을 경우
					if((z & (1<<map[x][y] - 'A')) == 0) {	// 해당 키가 없을 경우
//						check[x][y][z]=true;
						continue;
					}
				}
				
				if(map[x][y] == '1') {
					System.out.println(step);
					return;
				}
				
				for(int i=0; i<4; i++) {
					int tempX = x + dx[i];
					int tempY = y + dy[i];
					
					if(tempX >= 0 && tempY >= 0 && tempX < N && tempY < M) {
						if(check[tempX][tempY][z] == false && map[tempX][tempY] != '#') {
							q.add(new Point(tempX, tempY, z));
							check[tempX][tempY][z]=true;
						}
					}
				}
			}
			
		}
		
		System.out.println(-1);
		
		
	}
	
	static class Point {
		int x, y;
		int key;
		public Point (int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
}
