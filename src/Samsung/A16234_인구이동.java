package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A16234_인구이동 {
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][n];
		int cnt[][];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isOut;
		int ans = -1;
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		while(true) {
			int num = 1;
			isOut = false;
			Queue<Point> q = new LinkedList<Point>();
			cnt = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(cnt[i][j] != 0) continue;
					q.add(new Point(i, j));
					cnt[i][j] = num;
					int sum = map[i][j];
					int div = 1;
					while(!q.isEmpty()) {
						Point temp = q.poll();
						int x = temp.x;
						int y = temp.y;
						
						for(int k=0; k<4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
								if(cnt[nx][ny] == 0 && Math.abs(map[nx][ny]-map[x][y]) >= l && Math.abs(map[nx][ny]-map[x][y]) <= r) {
									isOut = true;
									div++;
									sum += map[nx][ny];
									cnt[nx][ny] = num;
									q.add(new Point(nx, ny));
								}
							}
						}
					}
					int avg = sum/div;
					for(int k=0; k<n; k++) {
						for(int m=0; m<n; m++) {
							if(cnt[k][m] == num) {
								map[k][m] = avg; 
							}
						}
					}
					num++;
				}
			}
			
			
			ans++;
			if(!isOut) {
				break;
			}
		}
		
		
		System.out.println(ans);
			
	}
}










