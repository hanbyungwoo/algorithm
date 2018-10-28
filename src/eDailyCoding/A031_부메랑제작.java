package eDailyCoding;

import java.util.Scanner;

public class A031_ºÎ¸Þ¶ûÁ¦ÀÛ {
	static int n, m, max;
	static int map[][];
	static int check[][];
	static int dx[][] = {{-1,-1},{0,-1},{1,1},{0,1},{-1,-1},{0,-1},{0,-1},{1,1}};
	static int dy[][] = {{0,1},{1,1},{0,1},{1,1},{0,-1},{-1,-1},{1,-1},{0,-1}};
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n][m];
        check = new int[n][m];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		map[i][j] = sc.nextInt();
        	}
        }
        max = 0;
        for(int i=0; i<n*m; i++) {
        	dfs(0,check);        	
        }
        
        System.out.println(max);
    }
	
	public static void dfs(int index, int prev[][]) {
		int temp[][] = new int[n][m];
		if(index >= n*m) {
			return;
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(prev[i][j]==2) {
					ans += map[i][j]*2;
				} else if(prev[i][j]==1) {
					ans += map[i][j];
				}
			}
		}
		max = Math.max(max, ans);
		if(prev[index/m][index%m] != 0) {
			return;
		}
		dfs(index+1, prev);
		int x = index/m;
		int y = index%m;
		for(int i=0; i<8; i++) {
			copymap(temp, prev);
			temp[x][y] = 1;
			int cnt=0;
			for(int j=0; j<2; j++) {
				int nx = x+dx[i][j];
				int ny = y+dy[i][j];
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(temp[nx][ny] == 0) {
						if(j==0) {
							temp[nx][ny] = 2;
						} else {
							temp[nx][ny] = 1;
						}
						cnt++;
					}
				}
			}
			if(cnt == 2) {
				for(int j=x; j<x+3; j++) {
					for(int k=y; k<y+3; k++) {
						if(j==x && k==y) {
							continue;
						}
						dfs(j*k, temp);
					}
				}
			}
		}
			
	}
    
	public static void copymap(int[][] copy, int[][] origin) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}
}