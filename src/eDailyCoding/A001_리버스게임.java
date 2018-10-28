package eDailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A001_리버스게임 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][n];
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		while(true) { 
			boolean isOut = true;
			// 가로
			
			int col = 0;
			for(int i=0; i<n; i++) {
				int row = 0;
				for(int j=0; j<n; j++) {
					if(map[i][j]=='B') {
						row++;
					}
				}
				if(row==n) {
					for(int j=0; j<n; j++) {
						map[i][j] = 'B';
					}
				}
			}
			
			// 세로
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					
				}
			}
				
			if(isOut) {
				break;
			}
		}
		
	}
}
