package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A12100 {
	static int n;
	static int max;
	static int map[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		// 초기 보드판 셋팅 필요
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
		// index 5번까지만 이라서 5번째 멈추도록 구현해야함
		if(index == 5) {
			 for(int i=0; i<n; i++) {
				 for(int j=0; j<n; j++) {
					 max = map[i][j] > max ? map[i][j] : max; 
				 }
			 }
		} else {
			// 빽트레킹을 위해 건드리지 않는 map 생성필요
			int copymap[][] = new int[n][n];
			copy(copymap, map);
			// 상하좌우 4방향 탐색필요함
			for(int i=0; i<4; i++) {
				merge(i);
				dfs(index+1);
			}
			// 뺵트레킹을 위해 원상복귀
			copy(map, copymap);
		}
	}
	
	public static void copy(int [][]copy, int [][] origin) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		
	}
	
	public static void merge(int dir) {
		// map에다가 상하좌우로 올릴것
		Queue<Integer> q = new LinkedList<Integer>();
		switch(dir) {
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
