package eDailyCoding;

import java.util.Scanner;

public class A060_Àå±º°ú¶¥ {
	static int n, m, max;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		map[i][j] = sc.nextInt();
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(!visited[i][j]) {
	        		visited[i][j] = true;
	            	dfs(i, j, 1, map[i][j]);
	            	visited[i][j] = false;
        		}
        	}
        }
        
        System.out.println(max);
    }
	
	public static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(sum, max);
			return;
		} else {
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						dfs(nx, ny, depth+1, sum+map[nx][ny]);
						visited[nx][ny] = false;
					}
				}
			}
			
		}
	}
	
}