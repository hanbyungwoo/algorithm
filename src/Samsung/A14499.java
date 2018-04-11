package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14499 {
	static int N, M;
	static int map[][];
	static int dx[] = {0,0,-1,1};	// 동 서 북 남
	static int dy[] = {1,-1,0,0};
	static int dice[] = new int[6];
	static int start[];
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		start = new int[2];
		
		start[0] = Integer.parseInt(st.nextToken());
		start[1] = Integer.parseInt(st.nextToken());

		int move = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<move; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int nx = start[0] + dx[x-1];
			int ny = start[1] + dy[x-1];
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				start[0] = nx;
				start[1] = ny;
				change(x);
				System.out.println(dice[0]);
			}
			
		}
	}
	
	public static void change(int x) {
		int temp;
		switch(x) {
		case 1 :	// 동
			temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		case 2 : 	// 서
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
			break;
		case 3 :	// 북
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
		case 4 :	// 남
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
		}
		
		if(map[start[0]][start[1]] == 0) {
			map[start[0]][start[1]] = dice[5];
		} else {
			dice[5] = map[start[0]][start[1]];
			map[start[0]][start[1]] = 0;
		}
		
	}
}









