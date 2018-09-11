package Kakao.P2017_CodeFestival;

import java.util.LinkedList;
import java.util.Queue;

public class P1_보행자천국 {
	public static void main(String args[]) {
//		solution(3, 3, new int[][]{{0,0,0},{0,0,0},{0,0,0}});
		solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
	}
	
	static int dx[] = {1, 0};
	static int dy[] = {0, 1};
	static int map[][];
	static boolean isVisit[][];
	static int row, col;
	
	static int MOD = 20170805;
	public static int solution(int m, int n, int[][] cityMap) {
	      int answer=0;
	      
	      int r[][] = new int[m+1][n+1];
	      int b[][] = new int[m+1][n+1];
	      r[1][1] = 1;
	      b[1][1] = 1;
	      
	      for(int i=1; i<=m; i++) {
	    	  for(int j=1; j<=n; j++) {
	    		  if(cityMap[i-1][j-1]==0) {
	    			  // 0인 경우 왼쪽이나 위쪽 오는 경우 다 더함
	    			  r[i][j] = (r[i][j]+r[i][j-1]+b[i-1][j])%MOD;
	    			  b[i][j] = (b[i][j]+r[i][j-1]+b[i-1][j])%MOD;
	    		  }
	    		  else if(cityMap[i-1][j-1]==1) {
	    			  r[i][j] = 0;
	    			  b[i][j] = 0;
	    		  }
	    		  else {
	    			  r[i][j] = r[i][j-1];
	    			  b[i][j] = b[i-1][j];
	    		  }
	    	  }
	      }
	      answer = (r[m][n-1]+b[m-1][n])%MOD;
//	      row = m;
//	      col = n;
//	      map = new int[m][n];
//	      isVisit = new boolean[m][n];
//	      map[0][0] = 1;
//	      go(cityMap);
//	      answer = map[m-1][n-1];
	      System.out.println(answer);
	      return answer;
	      
	      
	      
	  }
	
	public static void go(int[][] cityMap) {
		Queue<xy> q = new LinkedList<xy>();
		q.add(new xy(0,0,0,0,0));
		isVisit[0][0] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int z=0; z<size; z++) {
				xy temp = q.poll();
				int x = temp.x;
				int y = temp.y;
				int dir = temp.dir;
				
				for(int i=0; i<2; i++) {
					// 0 아래
					// 1 오른쪽
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
						switch(cityMap[nx][ny]) {
						case 0 : 
							// 자유
							if(!isVisit[nx][ny]) {
								isVisit[nx][ny] = true;
								q.add(new xy(nx, ny, x, y, i));
							}
							map[nx][ny] += map[x][y];
							map[nx][ny] %= MOD;
							break;
						case 1 :
							// 금지
							break;
						case 2 :
							// 직진만..
							if(dir == i) {
								if(!isVisit[nx][ny]) {
									isVisit[nx][ny] = true;
									q.add(new xy(nx, ny, x, y, i));
								}
								map[nx][ny] += map[x][y];
								map[nx][ny] %= MOD;
							}
							break;
						default :
							break;
						}
					}
				}
			}
		}
	}
}

class xy {
	int x;
	int y;
	int prex;
	int prey;
	int dir;
	public xy(int x, int y, int prex, int prey, int dir) {
		this.x = x;
		this.y = y;
		this.prex = prex;
		this.prey = prey;
		this.dir = dir;
	}
}

