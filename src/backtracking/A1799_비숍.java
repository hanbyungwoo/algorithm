package backtracking;
//http://mygumi.tistory.com/289 참고했음.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1799_비숍 {
	static int map[][];
	static int colors[][]; 
	
	static int[] ans = new int[2];
	static int n;
	static boolean check_dig1[];	// / 대각선
	static boolean check_dig2[];	// \ 대각선

	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		map= new int[n][n];
		colors = new int[n][n];
		check_dig1 = new boolean[2*n];	// / 대각선
		check_dig2 = new boolean[2*n];	// \ 대각선
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
	        for (int j = 0; j < n; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
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
	 
	        if (map[c][r] == 1) {
	            if (check(c, r)) {
	                check_dig1[r+c] = true;
	                check_dig2[r-c+n] = true;
	                dfs(i, cnt + 1, color);
	                check_dig1[r+c] = false;
	                check_dig2[r-c+n] = false;
	            }
	        }
	    }
	    if (v == -1) return;
	}
	 
	public static boolean check(int c, int r) {
		if(check_dig1[r+c]) {
			return false;
		}
		if(check_dig2[r-c+n]) {
			return false;
		}
		return true;
	}


	
}

