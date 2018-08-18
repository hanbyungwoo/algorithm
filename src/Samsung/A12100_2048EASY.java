package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A12100_2048EASY {
	static int n;
	static int max;
	static int map[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		
		// 초기 보드판 설정
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);
		
		
	}
	
	public static void dfs(int index) {
		if(index == 5) {
			// 종료
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] > max) 
						max = map[i][j];
				}
			}
			return;
		}
			
		int copymap[][] = new int[n][n];
		
		copy(copymap, map);
		for(int i=0; i<4; i++) {
			
			merge(i);
			dfs(index+1);
			
		}
		copy(map, copymap);
		
	}
	public static void copy(int [][] map1, int [][] map2) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map1[i][j] = map2[i][j];
			}
		}
	}
	public static void merge(int x) {
		// 0 상 1 하 2 좌 3우
		Queue<Integer> q = new LinkedList<Integer>();
		switch (x) {
		case 0 :	// 상
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[j][i] != 0) q.add(map[j][i]);
					map[j][i] = 0;
				}
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					int val = q.poll();
					
					if(map[idx][i]==0) map[idx][i] = val;
					else if(map[idx][i] == val) {
						map[idx][i] *= 2;
						idx++;
					}
					else {
						map[++idx][i] = val;
					}
				}
			}
			break;
		case 1 :	// 하
			for(int i=0; i<n; i++) {
				for(int j=n-1; j>=0; j--) {
					if(map[j][i] != 0) q.add(map[j][i]);
					map[j][i] = 0;
				}
				
				int idx = n-1;
				
				while(!q.isEmpty()) {
					int val = q.poll();
					
					if(map[idx][i]==0) map[idx][i] = val;
					else if(map[idx][i] == val) {
						map[idx][i] *= 2;
						idx--;
					}
					else {
						map[--idx][i] = val;
					}
				}
			}
			break;
		case 2 :	// 좌
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] != 0) q.add(map[i][j]);
					map[i][j] = 0;
				}
				
				int idx = 0;
				
				while(!q.isEmpty()) {
					int val = q.poll();
					
					if(map[i][idx]==0) map[i][idx] = val;
					else if(map[i][idx] == val) {
						map[i][idx] *= 2;
						idx++;
					}
					else {
						map[i][++idx] = val;
					}
				}
			}
			break;
		case 3 :	// 우
			for(int i=0; i<n; i++) {
				for(int j=n-1; j>=0; j--) {
					if(map[i][j] != 0) q.add(map[i][j]);
					map[i][j] = 0;
				}
				
				int idx = n-1;
				
				while(!q.isEmpty()) {
					int val = q.poll();
					
					if(map[i][idx]==0) map[i][idx] = val;
					else if(map[i][idx] == val) {
						map[i][idx] *= 2;
						idx--;
					}
					else {
						map[i][--idx] = val;
					}
				}
			}
			break;
		}
	}
}
