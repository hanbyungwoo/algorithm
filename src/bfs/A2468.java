package bfs;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2468 {
	static boolean visited[][];
	static int map[][];
	static int max, N;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// N * N ���
		map = new int[N+1][N+1];

		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if(minH > val) minH = val;
				if(maxH < val) maxH = val;
			}
		}
		
		max = Integer.MIN_VALUE;
		
		// ù������ Ǭ ���... �������� ������ ���� 1~100�̹Ƿ� ���� ������.. ����
		// �ι�°�� Ǭ ���... map���� �Է¹����� �ּ� ���� / �ִ� ���� �ľ��� �� ������
		for(int i=minH; i<=maxH; i++) {
			visited = new boolean[N+1][N+1];
			int temp = 0;
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(visited[j][k]==false && map[j][k] >= i) {
						bfs(j, k, i);
						temp++;
					}
				}
			}
			if(temp > max) {
				max = temp;
			}
		}
		
		System.out.println(max);
	}
	
	public static void bfs(int a, int b, int height) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, b));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx > 0 && ny > 0 && nx <= N && ny <= N) {
					if(visited[nx][ny] == false && map[nx][ny] >= height) {
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}			
		}
	}
}