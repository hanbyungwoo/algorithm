import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4963
public class A4963 {

	 static int map[][];
	 static boolean mapCheck[][];
	 static int w;
	 static int h;
	 
	 public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 while(true) {
			 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			 w = Integer.parseInt(st.nextToken());
			 h = Integer.parseInt(st.nextToken());
			 
			 map = new int[h+1][w+1];
			 mapCheck = new boolean[h+1][w+1];
			 
			 if(w==0 && h==0) {
				 return;
			 }
			 
			 for(int i=1; i<=h; i++) {
				 int temp=1;
				 st = new StringTokenizer(br.readLine(), " ");
				 while(st.hasMoreTokens()) {
					 map[i][temp++] = Integer.parseInt(st.nextToken());
				 }
			 }
			 int island = 0;
			 for(int i=1; i<=h; i++) {
				 for(int j=1; j<=w; j++) {
					 if(map[i][j]==1 && mapCheck[i][j]==false) {
						 island++;
						 dfs(i, j);
					 }
				 }
			 }
			 System.out.println(island);
		 }
		  
	 }
	 public static void dfs(int x, int y) {
		if(mapCheck[x][y]) {
			return;
		}
		mapCheck[x][y] = true;
		
		if(x-1 > 0) {
			if(map[x-1][y] == 1 && mapCheck[x-1][y] == false) {
				dfs(x-1, y);
			}
		}
		if(y-1 > 0) {
			if(map[x][y-1] == 1 && mapCheck[x][y-1] == false) {
				dfs(x, y-1);
			}
		}
		if(x+1 <= h) {
			if(map[x+1][y] == 1 && mapCheck[x+1][y] == false) {
				dfs(x+1, y);
			}
		}
		if(y+1 <= w) {
			if(map[x][y+1] == 1 && mapCheck[x][y+1] == false) {
				dfs(x, y+1);
			}
		}
		if(x-1 > 0 && y-1 > 0) {
			if(map[x-1][y-1] == 1 && mapCheck[x-1][y-1] == false) {
				dfs(x-1, y-1);
			}
		}
		if(x-1 > 0 && y+1 <= w) {
			if(map[x-1][y+1] == 1 && mapCheck[x-1][y+1] == false) {
				dfs(x-1, y+1);
			}
		}
		if(x+1 <= h && y-1 > 0) {
			if(map[x+1][y-1] == 1 && mapCheck[x+1][y-1] == false) {
				dfs(x+1, y-1);
			}
		}
		if(x+1 <= h && y+1 <= w) {
			if(map[x+1][y+1] == 1 && mapCheck[x+1][y+1] == false) {
				dfs(x+1, y+1);
			}
		}
			
			
	 }
}
