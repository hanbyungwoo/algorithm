import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/2667

public class A2667 {
	static int [][] a;
	static boolean [][] c;
	static ArrayList<Integer> home;
	static int cnt;
	static int num;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
		
		a = new int[num+1][num+1];
		c = new boolean[num+1][num+1];
		home = new ArrayList<Integer>();
		
		// 입력 값 배열에 넣기
		for(int i=1; i<=num; i++) {
			String line = br.readLine();
			for(int j=1; j<=num; j++) {
				a[i][j] = line.charAt(j-1)-'0';
			}
		}
		
		// dfs
		int step = 0;	// 집 통째 갯수
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				cnt = 0;	// 집 낱개 갯수
				if(c[i][j] == false && a[i][j] == 1) {
					cnt++;
					dfs(i, j);
					step++;
				}
				if(cnt != 0) {
					home.add(cnt);
				}
			}
		}
		System.out.println(step);
		Collections.sort(home);
		for(int i=0; i<home.size(); i++) {
			System.out.println(home.get(i));
		}
		
	}
	
	public static void dfs(int x, int y) {
		if(c[x][y]) {
			return;
		}
		c[x][y] = true;
		
		if(x-1 > 0) {
			if(a[x-1][y] == 1 && c[x-1][y] == false) {
				cnt++;
				dfs(x-1, y);
			}
		}
		if(y-1 > 0) {
			if(a[x][y-1] == 1 && c[x][y-1] == false) {
				cnt++;
				dfs(x, y-1);
			}
		}
		if(x+1 <= num) {
			if(a[x+1][y] == 1 && c[x+1][y] == false) {
				cnt++;
				dfs(x+1, y);
			}
		}
		if(y+1 <= num) {
			if(a[x][y+1] == 1 && c[x][y+1] == false) {
				cnt++;
				dfs(x, y+1);
			}
		}
		
		
	}
}
