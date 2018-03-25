package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A5558 {
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int [H+1][W+1];
		
		int d[][] = new int[H+1][W+1];
		int bird[]=new int[2];
		int feed[]=new int[2];
		
		for(int i=1; i<=H; i++) {
			String temp = (" " + br.readLine());
			for(int j=1; j<=W; j++) {
				char a = temp.charAt(j);
				if(a =='S') {
					map[i][j] = -2;	// -2 ==> 새 위치
					bird[0] = i;
					bird[1] = j;
				}
				 
				else if(a == 'X') {
					map[i][j] = -1;	// -1 ==> 진입 금지
				} else if(a== '.') {
					map[i][j] = 0;	// 0 ==> 공백
				} else {
					map[i][j] = a-'0'; // 먹이 숫자들.
					if(map[i][j] == N) {
						// 마지막 먹이 위치 저장
						feed[0] = i;
						feed[1] = j;						
					}
				}
				 	
			}
		}
				
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(bird[0],bird[1]));
		d[bird[0]][bird[1]] = 1;
		int cnt=0;
		int level=1;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int tempX = x + dx[i];
				int tempY = y + dy[i];
				if(tempX > 0 && tempY > 0 && tempX <= H && tempY <= W) {
					if(map[tempX][tempY] != -1 && d[tempX][tempY] == 0) {	// 막히지 않았으면..
						d[tempX][tempY] = d[x][y] + 1;
						if(map[tempX][tempY] == level) {
							level++;
							cnt += d[tempX][tempY];
							// 거리 정보 초기화
							for(int j=0; j<=H; j++){
								for(int k=0; k<=W; k++) { 
									d[j][k] = 0;
								}
							}
							d[tempX][tempY] = 1;
							// 기존 큐 삭제
							q.clear();
							// 새위치에서 다시 시작~
							q.add(new Point(tempX, tempY));
							break;
						} else {
							q.add(new Point(tempX, tempY));
						}
						
					}
					
				}
			}
		}
		
		System.out.println(cnt-level+1);
		
	}
	
}
