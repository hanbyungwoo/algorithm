package NHN.P2018;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nhn4 {
	static String map[][];
	static boolean isVisit[][];
	static ArrayList<Point> home;
	static int n;
	static String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		home = new ArrayList<Point>();
		
		n = Integer.parseInt(st.nextToken());
		map = new String[n][n];
		isVisit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			
			for(int j=0; j<n; j++) {
				map[i][j] =  temp[j];
				if(abc.contains(map[i][j])) {
					home.add(new Point(i, j));
					isVisit[i][j] = true;
				}
			}
		}
		
		bfs();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static int dx[] = {0,0,-1,1};	// го ╩С ©Л аб
	static int dy[] = {-1,1,0,0};
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		for(int i=0; i<home.size(); i++) {
			q.add(new Point(home.get(i).x, home.get(i).y));	
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				int x = q.peek().x;
				int y = q.peek().y;
				q.poll();
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
						
						if(!isVisit[nx][ny] && !abc.contains(map[nx][ny])) {
							int num = Integer.parseInt(map[nx][ny]);
							if(num == 0) {
								map[nx][ny] = map[x][y];
								q.add(new Point(nx, ny));
							} else {
								// ╩С 1 го 2 аб 4 ©Л 8
								for(int k=0; k<4; k++) {
									map[nx][ny] = map[x][y];
									if((num & (1<<(j-1))) > 0) {
										q.add(new Point(nx, ny));	
									}
								}
							}
						}
							
					}
				}
			}
		}
	}
}
