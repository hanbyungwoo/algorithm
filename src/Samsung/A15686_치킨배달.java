package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A15686_ġŲ��� {
	static int n, m, min;
	static int map[][];
	static boolean visit[]; 
	static ArrayList<Point> list;
	static ArrayList<Point> home;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());	// n*n
		m = Integer.parseInt(st.nextToken());	// m���� ġŲ��
		min = Integer.MAX_VALUE;
		list = new ArrayList<Point>();
		home = new ArrayList<Point>();
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Point(i, j));
				} else if(map[i][j] == 1) {
					home.add(new Point(i, j));
				}
			}
		}
		
		visit = new boolean[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			visit[i] = true;
			dfs(i, 1);
			visit[i] = false;
		}
		
		System.out.println(min);
		
	}
	
	public static void dfs(int index, int depth) {
		if(depth == m) {
			int value = 0;
			// Ȯ�� �ʿ� 
			for(int i=0; i<home.size(); i++) {
				int temp=Integer.MAX_VALUE;
				// list�� ġŲ��
				for(int j=0; j<list.size(); j++) {
					// visit[i] �� ���� true�� �͵鿡 ���� ������ ġŲ ������ �ּ� �Ÿ��� ���ؾ���.
					if(visit[j]) {
						int x = list.get(j).x;
						int y = list.get(j).y;
						temp = Math.min(temp, Math.abs(x-home.get(i).x)+Math.abs(y-home.get(i).y));
					}
				}
				value += temp;
			}
			min = Math.min(min, value);
		} else {
			for(int i=index+1; i<list.size(); i++) {
				visit[i] = true;
				dfs(i, depth+1);
				visit[i] = false;
//				dfs(i, depth);
			}
		}
	}
	
}