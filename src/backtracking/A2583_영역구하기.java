package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A2583_영역구하기 {
	static int m,n,k;
	static boolean map[][];
	static boolean isVisit[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static ArrayList<Integer> list;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new boolean[m][n];
		isVisit = new boolean[m][n];
		list = new ArrayList<Integer>();
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1, y1, x2, y2;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int j=x1; j<x2; j++) {
				for(int k=y1; k<y2; k++) {
					map[k][j] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!map[j][i] && !isVisit[j][i]) {
					isVisit[j][i] = true;
					cnt=1;
					dfs(j, i);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}

	}
	
	public static void dfs(int y, int x) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < m && !isVisit[ny][nx] && !map[ny][nx]) {
				cnt++;
				isVisit[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}
	
}

