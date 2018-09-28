package NHN.P2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static int n, cnt;
	static int map[][];
	static boolean isVisit[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		n = Integer.parseInt(st.nextToken());
//		map = new int[n][n];
//		isVisit = new boolean[n][n];
//		for(int i=0; i<n; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			for(int j=0; j<n; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		cnt=1;
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(map[i][j] == 1 && !isVisit[i][j]) {
//					isVisit[i][j] = true;
//					dfs(i, j);
//					list.add(cnt);
//					cnt = 1;
//				}
//			}
//		}
//		
//		Collections.sort(list);
//		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
		//	1¹ø ¹®Á¦
		int cnt=0;
		Queue<Integer> q = new LinkedList<Integer>();
		while(st.hasMoreTokens()) {
			int temp = Integer.parseInt(st.nextToken()); 
			if(q.contains(temp)) {
				q.remove(temp);
				q.add(temp);
			} else if(q.size() > 3) {
				int x = q.poll();
				q.add(temp);
				System.out.println(x);
				cnt++;
			}  else {
				q.add(temp);
			}
		}
		if(cnt == 0) {
			System.out.println(0);
		}
		
		while(!q.isEmpty()) {
			System.out.print(q.poll()+", ");
		}
		
	}
	
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(!isVisit[nx][ny] && map[nx][ny] == 1) {
					isVisit[nx][ny] = true;
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}
}
