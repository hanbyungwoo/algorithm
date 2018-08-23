package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW2382_미생물격리 {
	static int map[][];
	static int dx[] = {-1, 1, 0, 0};	// 상 하 좌 우
	static int dy[] = {0, 0, -1, 1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());	// 맵 가로세로 크기
			int m = Integer.parseInt(st.nextToken());	// m 시간 후
			int k = Integer.parseInt(st.nextToken());	// k 미생물 군집 수
			
			LinkedList<Home> list = new LinkedList<Home>();
			
			map = new int[n][n];
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");	
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				list.add(new Home(x, y, cnt, dir-1));
				// arraylist로 내림차순 먼저한 다음에
				// map에 해당 인덱스 번호 저장?!
				
			}
			
			for(int i=0; i<m; i++) {
				Collections.sort(list);
				for(int[] x : map) {
					Arrays.fill(x, -1);
				}
 				for(int j=0; j<list.size(); j++) {
					
					int x = list.get(j).x;
					int y = list.get(j).y;
					int cnt = list.get(j).cnt;
					int dir = list.get(j).dir;
					
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					// 약품 구역
					if(nx == 0 || ny == 0 || nx == n-1 || ny == n-1) {
						cnt = cnt/2;
						dir = (dir%2==0) ? dir+1 : dir-1;
						list.get(j).cnt = cnt;
						list.get(j).dir = dir;
					}
					
					// 이동한 위치에 군집이 있다면 삭제
					if(map[nx][ny] != -1) {
						list.get(map[nx][ny]).cnt += cnt;
						list.get(j).cnt = 0;
					} else {
						map[nx][ny] = j; 
						list.get(j).x = nx;
						list.get(j).y = ny;
					}
				}
				
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).cnt == 0) {
						list.remove(j);
						j--;
					}
				}
			}
			int sum=0;
			for(int i=0; i<list.size(); i++) {
				sum += list.get(i).cnt;
			}
			
			System.out.println("#"+ca+" "+sum);
			ca++;
		}
	}

}

class Home implements Comparable<Home>{
	int x;
	int y;
	int cnt;
	int dir;
	
	public Home(int x, int y, int cnt, int dir) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.dir = dir;
	}

	@Override
	public int compareTo(Home o) {
		// 미생물 군집 내림차순 정리
		if(o.cnt > this.cnt) {
			return 1;
		} else if(o.cnt < this.cnt) {
			return -1;
		} else {
			return 0;	
		}
	}
	
}

