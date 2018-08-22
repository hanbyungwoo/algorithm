package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A15684_사다리조작 {
	static int N, M, H;
	static int map[][];
	static int result = -1;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// 세로선
		M = Integer.parseInt(st.nextToken());	// 줄 긋는 가로선
		H = Integer.parseInt(st.nextToken());	// 투명 가로선
	
		map = new int[H+1][N+1];

		if(M==0) {
			System.out.println(0);
			return;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;		// 선 그어진 출발
			map[x][y+1] = 2;	// 선 그어진 도착
		}
		
		// 총 3개 선을 MAX로 그을 수 있기 떄문에 3번만 돈다.
		for(int i=0; i<4; i++) {
			dfs(0, i);
			if(result != -1) {
				break;
			}
		}
		System.out.println(result);
	}
	
	public static void dfs(int cnt, int total) {
		if(result != -1) {
			return;
		}
		// 그을 수 있는 선을 다 그은 경우
		if(cnt >= total) {
			for(int i=1; i<=N; i++) {	// 사다리 확인
				int tmp = i;
				for(int j=1; j<=H; j++) {
					if(map[j][tmp] == 0) {
						continue;
					}
					if(map[j][tmp] > 0) {
						// 1이면 왼쪽에서 오른쪽으로 이동하므로 tmp(세로선위치) 1 증가
						// 2이면 오른쪽에서 왼쪽으로 이동하므로 tmp(세로선위치) 1 감소
						if(map[j][tmp] == 1) {
							tmp++;
							continue;
						} else {
							tmp--;
							continue;
						}
						
					}
				}
				if(tmp == i) {
					// 자신의 번호에서 출발해서 자신에게 도착
					continue;
				} else {
					// 실패
					return;
				}
			}
			result = total;
			return;
		}
		
		for(int i=1; i<N; i++) {	// 사다리 확인
			for(int j=1; j<=H; j++) {
				if(map[j][i]==0 && map[j][i+1]==0) {
					map[j][i] = 1;
					map[j][i+1] = 2;
					dfs(cnt+1, total);
					map[j][i] = 0;
					map[j][i+1] = 0;
				}
			}
		}
	}
}