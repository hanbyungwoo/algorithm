package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A3190 {
	static int n;
	static int map[][];
	static int direction[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	// 0 상 1 하 2 좌 3 우
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		direction = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine());
		int apple = Integer.parseInt(st.nextToken());
		for(int i=0; i<apple; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 사과의 위치 저장
			map[x][y] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		
		Arrow[] info = new Arrow[L+1];
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			char[] y = st.nextToken().toCharArray();
			// 시간, 방향 정보 저장
			info[i] = new Arrow(x, y[0]);
		}
		info[L] = new Arrow(100, 'X');
		
		int headRow = 1, headCol = 1;
		int tailRow = 1, tailCol = 1;
		// 0위 1아래 2왼쪽 3오른쪽
		int current = 3;
		
		// 뱀 위치 2
		map[headRow][headCol] = 2;
		direction[headRow][headCol] = current;
		
		int cnt=0;
		boolean check = false;
		for(int a=0; a<L+1 && !check; a++) {
			int time = info[a].time;
			char arrow = info[a].arrow;
			
			int diff = time;
			if(a>0) diff = info[a].time - info[a-1].time;
				
			while(diff-- > 0) {
				cnt++;
				
				// 방향 기록
				direction[headRow][headCol] = current;
				// 머리 이동
				headRow += dx[current];
				headCol += dy[current];
				// 벽 확인
				if(headRow < 1 || headCol < 1 || headRow > n || headCol > n) {
					System.out.println(cnt);
					check = true;
					break;
				}
				
				// 진행 - 빈칸일경우
				if(map[headRow][headCol] == 0) {
					map[headRow][headCol] = 2;
					direction[headRow][headCol] = current;
					
					map[tailRow][tailCol] = 0;
					
					int tailDir = direction[tailRow][tailCol];
					tailRow += dx[tailDir];
					tailCol += dy[tailDir];
				}
				// 진행 - 사과있을경우
				else if(map[headRow][headCol] == 1) {
					map[headRow][headCol] = 2;
					direction[headRow][headCol] = current;
				}
				// 진행 - 자신에게 부딪칠 경우
				else if(map[headRow][headCol] == 2) {
					System.out.println(cnt);
					check = true;
					break;
				}
			}
			// 방향 갱신
			if(arrow=='D') {	// 오른쪽
				// 0 1 2 3
				// 0->3
				// 1->2
				// 2->0
				// 3->1 오른-아래
				switch(current) {
					case 0 : current = 3; break;
					case 1 : current = 2; break;
					case 2 : current = 0; break;
					case 3 : current = 1; break;
				}
			} else if(arrow=='L') {	// 왼쪽 
				// 0->2
				// 1->3
				// 2->1
				// 3->0
				switch(current) {
					case 0 : current = 2; break;
					case 1 : current = 3; break;
					case 2 : current = 1; break;
					case 3 : current = 0; break;
				}
			}
		}
		
	}
}

class Arrow {
	int time;
	char arrow;
	public Arrow(int time, char arrow) {
		this.time = time;
		this.arrow = arrow;
	}
}
