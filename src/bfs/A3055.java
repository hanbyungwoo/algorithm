package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A3055 {
	static int up[] = {0,0,-1,1};
	static int down[] = {1,-1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		char map[][] = new char [one+1][two+1];
		int water[][] = new int [one+1][two+1];
		int d[][] = new int[one+1][two+1];
		
		for(int i=1; i<=one; i++) {
			
			map[i] = (" "+br.readLine()).toCharArray();
			
		}
		int desX=0, desY=0;
		int tempX=0, tempY=0;
		
		Queue<Point> q = new LinkedList<Point>();
		
		for(int i=1; i<=one; i++) {
			for(int j=1; j<=two; j++) {
				if(map[i][j] == 'S') {	// ����ġ ��ġ
					tempX = i;
					tempY = j;
				}
				if(map[i][j] == 'D') {	// ���� ��ġ
					desX = i;
					desY = j;
				}
				if(map[i][j] == '*') {	// ���� ��ġ
					q.add(new Point(i,j));
					water[i][j] = 1;
				}
			}
		}
		
		q.add(new Point(tempX, tempY));
		d[tempX][tempY] = 1;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int xx = x+up[i];
				int yy = y+down[i];
				if(xx > 0 && yy > 0 && xx <=one && yy <= two) {
					// ������ Ȯ��.
					if(water[x][y] == 1 && map[xx][yy] != 'X' && water[xx][yy] == 0 && map[xx][yy] != 'D' ) {	// �ش� ���⿡ �� ����
						water[xx][yy] = 1;	// ���� ��������.
						q.add(new Point(xx, yy));
					}
					// ��Ȯ�� �� ����ġ �̵�
					if(d[xx][yy] <= d[x][y] +1 && map[x][y] == 'S' && water[xx][yy] != 1 && map[xx][yy] != 'X' && d[xx][yy] == 0) {	// ����ġ / ������ / ������ ����
						
						map[xx][yy] = 'S';
						//map[x][y] = '.';
						d[xx][yy] = d[x][y] + 1;
						q.add(new Point(xx, yy));
					}
				}
			}
		}
		
		if(d[desX][desY] == 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(d[desX][desY]-1);
		}
	}
	
}
