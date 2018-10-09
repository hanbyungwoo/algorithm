package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A11559_PuyoPuyo {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static int map[][] = new int[12][6];
	static int cnt[][];
	static boolean visited[][];
	static boolean isBreak;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<12; i++) {
			String temp = br.readLine().toString();
			for(int j=0; j<6; j++) {
				char chr = temp.charAt(j);
				int val=0;
				switch(chr) {
				case '.' : val=0; break;
				case 'R' : val=1; break;
				case 'G' : val=2; break;
				case 'B' : val=3; break;
				case 'P' : val=4; break;
				case 'Y' : val=5; break;
				default : break;
				}
				map[i][j] = val;
			}
		}
		int ans=0;
		while(true) {
			
			cnt = new int[12][6];
			visited = new boolean[12][6];
			isBreak = false;
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					ArrayList<Point> list = new ArrayList<Point>();
					Queue<Point> q = new LinkedList<Point>();
					if(!visited[i][j] && map[i][j] != 0) {
						q.add(new Point(i, j));
						while(!q.isEmpty()) {
							int x = q.peek().x;
							int y = q.peek().y;
							list.add(new Point(x, y));
							q.poll();
							visited[x][y] = true;
							for(int k=0; k<4; k++) {
								int nx = x+dx[k];
								int ny = y+dy[k];
								if(nx >= 0 && ny >= 0 && nx < 12 && ny < 6) {
									if(!visited[nx][ny] && map[nx][ny] != 0 && map[x][y] == map[nx][ny]) {
										q.add(new Point(nx, ny));
									}
								}
							}
						}
						if(list.size() >= 4) {
							isBreak = true;
							for(int k=0; k<list.size(); k++) {
								cnt[list.get(k).x][list.get(k).y] += 100;
							}
						}
					}
				}
			}
//			for(int i=0; i<12; i++) {
//				for(int j=0; j<6; j++) {
//					if(!visited[i][j] && map[i][j] != 0) {
//						ArrayList<Point> list = new ArrayList<Point>();
//						list.add(new Point(i, j));
//						dfs(i, j, 1, list);
//					}
//				}
//			}
			
			if(!isBreak) break;
			ans++;
			for(int i=0; i<6; i++) {
				Queue<Integer> q = new LinkedList<Integer>();
				for(int j=11; j>=0; j--) {
					if(cnt[j][i] < 100 && map[j][i] != 0) {
						q.add(map[j][i]);
					}
				}
				int x = 11;
				while(!q.isEmpty()) {
					map[x--][i] = q.poll();
				}
				for(int j=x; j>=0; j--) {
					map[j][i] = 0;
				}
			}
			
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int depth, ArrayList<Point> list) {
		visited[x][y] = true;
		if(depth>=4) {
			isBreak = true;
			// 터지는 블록 체크
			for(int i=0; i<list.size(); i++) {
				cnt[list.get(i).x][list.get(i).y] += 100;
			}
		}
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && nx < 12 && ny < 6) {
				if(!visited[nx][ny] && map[nx][ny] != 0 && map[x][y] == map[nx][ny]) {
					list.add(new Point(nx, ny));
					dfs(nx, ny, depth+1, list);
				}
			}
		}
	}
}
