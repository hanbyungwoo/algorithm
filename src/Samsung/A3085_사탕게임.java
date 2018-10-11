package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A3085_사탕게임 {
	static int n, ans;
	static char map[][];
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new char[n][n];
		
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();  
		}
		
		ans = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				char temp = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = temp;
				check();	// 가로 세로 max 확인
				temp = map[i][j+1];
				map[i][j+1] = map[i][j];
				map[i][j] = temp;
				
				temp = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = temp;
				check();
				temp = map[j+1][i];
				map[j+1][i] = map[j][i];
				map[j][i] = temp;
				
			}
		}
		
		System.out.println(ans);
	}
	
	public static void check() {
		// 가로
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=1; j<n; j++) {
				if(map[i][j] == map[i][j-1]) {
					cnt++;
				} else {
					ans = Math.max(ans, cnt);
					cnt = 1;
				}
			}
			ans = Math.max(ans, cnt);
		}
		
		// 세로
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=1; j<n; j++) {
				if(map[j][i] == map[j-1][i]) {
					cnt++;
				} else {
					ans = Math.max(ans, cnt);
					cnt = 1;
				}
			}
			ans = Math.max(ans, cnt);
		}
		
	}
	
	
}
