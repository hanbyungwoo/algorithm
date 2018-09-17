package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2570_ºñ¼ó2 {
	static int map[][];
	static int colors[][]; 
	static boolean[] visited = new boolean[100];

	static int[] ans = new int[2];
	static int n, m;
	static int[] dy = { -1, -1, 1, 1 };
	static int[] dx = { -1, 1, 1, -1 };


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		map= new int[n][n];
		colors = new int[n][n];
		
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 1;
		}
		
		for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            
	            if (i % 2 == 0) {
	                if (j % 2 == 0) {
	                    colors[i][j] = 1;
	                }
	            } else {
	                if (j % 2 != 0) {
	                    colors[i][j] = 1;
	                }
	            }
	        }
	    }
	    dfs(-1, 0, 1);
	    dfs(-1, 0, 0);
	    System.out.println(ans[0] + ans[1]);
	}
	
	public static void dfs(int v, int cnt, int color) {
	    if (ans[color] < cnt) {
	        ans[color] = cnt;
	    }
	 
	    for (int i = v + 1; i < n * n; i++) {
	        int c = i / n;
	        int r = i % n;
	 
	        if (colors[c][r] != color) {
	            continue;
	        }
	 
	        if (map[c][r] != 1) {
	            if (check(c, r)) {
	                visited[i] = true;
	                dfs(i, cnt + 1, color);
	            }
	        }
	    }
	    if (v == -1) return;
	    visited[v] = false;
	}
	 
	public static boolean check(int c, int r) {
		for (int i = 0; i < 4; i++) {
	        int nx = dx[i] + r;
	        int ny = dy[i] + c;
	        int v = ny * n + nx;
	 
	        for (int j = 1; j < n; j++) {
	            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
	            	if(map[nx][ny]!=1) {
		                if (visited[v]) {
		                    return false;
		                }
	            	} else {
	            		return true;
	            	}
	            }
	            nx += dx[i];
	            ny += dy[i];
	            v = ny * n + nx;
	        }
	    }
	    return true;

	}
}

