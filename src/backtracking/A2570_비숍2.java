package backtracking;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A2570_비숍2 {
	static boolean map[][];
	static boolean block[][];
	
	static boolean check_dig1[];	// / 대각선
	static boolean check_dig2[];	// \ 대각선
	
	static int n;
	static int max;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		map= new boolean[n][n];
		block = new boolean[n][n];
		check_dig1 = new boolean[2*n];	// / 대각선
		check_dig2 = new boolean[2*n];	// \ 대각선
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			block[x-1][y-1] = true; 
			map[x-1][y-1] = false;
			check_dig1[x-1 + y-1] = false;
		}
		calc(0);
		System.out.println(max);
	}
	
	public static void calc(int row) {
		if(row == n) {
			int temp = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==true) {
						temp++;
					}
				}
			}
			if(temp >= max) {
				max = temp;
			}
			return;
		}
		
		for(int col=0; col<n; col++) {
			if(check(row, col) && !block[row][col]) {
				check_dig1[row+col] = true;
				check_dig2[row-col+n] = true;
				map[row][col] = true; 
				calc(row+1);
				check_dig1[row+col] = false;
				check_dig2[row-col+n] = false;
				map[row][col] = false;
			}
		}
		
	}
	
	public static boolean check(int row, int col) {
		if(check_dig1[row+col]) {
			return false;
		}
		if(check_dig2[row-col+n]) {
			return false;
		}
		return true;
	}
	
}

