import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2146 {

	
	public static void main(String args[]) throws IOException {
		int up [] = {-1, 1, 0, 0};
		int down [] = {0, 0, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int map[][] = new int [num+1][num+1];
		int group[][] = new int [num+1][num+1];
		Queue<Point> q = new LinkedList<Point>();
		
		// 맵 저장
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=num; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}
		
		int cnt=0;
		// 그룹을 하기 위한 작업
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				if(map[i][j]==1&&group[i][j]==0) {
					Queue<Point> tempQ = new LinkedList<Point>();
					group[i][j] = ++cnt;
					tempQ.add(new Point(i, j));
					while(!tempQ.isEmpty()) {
						int x = tempQ.peek().x;
						int y = tempQ.peek().y;
						tempQ.poll();
						for(int k=0; k<4; k++) {
							int tempX = x+up[k];
							int tempY = y+down[k];
							if(tempX>0 && tempY>0 && tempX<=num && tempY<=num) {
								if(map[tempX][tempY]==1 && group[tempX][tempY]==0) {
									group[tempX][tempY] = cnt;
									tempQ.add(new Point(tempX, tempY));
								}
							}
						}
					}
				}
			}
		}
		// 맵 초기화
		for(int i=1; i<=num; i++){
			for(int j=1; j<=num; j++) {
				if(map[i][j]==1) {
					map[i][j] = 0;
					q.add(new Point(i, j));
				} else {
					map[i][j] = -1;
				}
			}
		}
		// 거리로 저장하기
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int tempX = x+up[i];
				int tempY = y+down[i];
				if(tempX > 0 && tempY > 0 && tempX <=num && tempY <= num) {
					if(map[tempX][tempY]==-1) {
						map[tempX][tempY] = map[x][y]+1;
						group[tempX][tempY] = group[x][y];
						q.add(new Point(tempX, tempY));
					}
				}
			}
		}
		// 최소 길이 구하기
		int ans=-1;
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				
				for(int k=0; k<4; k++) {
					int x = i + up[k];
					int y = j + down[k];
					if(x>0 && y>0 && x<=num && y<=num) {
						if(group[i][j] != group[x][y]) {
							if(ans == -1 || ans > map[i][j]+map[x][y]) {
								ans = map[i][j]+map[x][y];
							}
						}
					}
				}
				
			}
		}
		System.out.println(ans);
	}
}
