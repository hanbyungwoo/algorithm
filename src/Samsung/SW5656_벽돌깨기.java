package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656_벽돌깨기 {
	static int n, w, h, map[][], min;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			min = w*h;
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<w; i++) {
				loop(i, n-1, map);
			}
			System.out.println("#"+(ca++)+" "+min);
		}
		
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void loop(int index, int n, int[][] pre) {
		int [][] copy = new int[h][w];
		
		copyMap(pre, copy);	// copy에 복사
		int temp=0;
		while(temp < h && copy[temp][index] == 0) {
			temp++;
		}
		
		if(temp < h) {
			if(copy[temp][index] > 1) {
				Queue<triple> q = new LinkedList<triple>();
				q.add(new triple(temp, index, copy[temp][index]));
				while(!q.isEmpty()) {
					int size = q.size();
					for(int i=0; i<size; i++) {
						int x = q.peek().x;
						int y = q.peek().y;
						int val = q.peek().val;
						copy[x][y] = 0;
						q.poll();
						for(int j=0; j<4; j++) {
							int nx = x;
							int ny = y;
							for(int k=1; k<val; k++) {
								nx += dx[j];
								ny += dy[j];
								if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
									if(copy[nx][ny]>1) {										
										q.add(new triple(nx, ny, copy[nx][ny]));
										copy[nx][ny] = 0;
									} else {
										copy[nx][ny] = 0;
									}
								} else {
									break;
								}
								
							}
							
							
						}					
					}
					
				}
				
				// 빈공간 없애주기 작업.
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int i=0; i<w; i++) {
					for(int j=h-1; j>=0; j--) {
						if(copy[j][i]!=0) {
							list.add(copy[j][i]);
							copy[j][i] = 0;
						}
					}
					for(int j=h-1; j>=0 && list.size() > 0; j--) {
						copy[j][i] = list.remove(0);
					}
					list.clear();
				}
			} else {
				// 0으로 초기화~
				copy[temp][index] = 0;
			}
		}
		
		if(n==0) {
			int ans = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(copy[i][j]>0) {
						ans++;
					}
				}
			}
			min = Math.min(ans, min);
			return;
		}
		for(int i=0; i<w; i++) {
			loop(i, n-1, copy);
		}
	}
	
	public static void copyMap(int [][] origin, int [][] copy) {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}
	
	static class triple {
		int x, y;
		int val;
		public triple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
}