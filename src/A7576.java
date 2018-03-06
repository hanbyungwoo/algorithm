import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7576
public class A7576 {
	static int [][]box;
	static boolean [][]check;
	static int[] pointX = {1, 0, -1, 0};
	static int[] pointY = {0, 1, 0, -1};
	static int w;
	static int h;
	static Queue<Point> q;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h+1][w+1];
		check = new boolean[h+1][w+1];
		q = new LinkedList<Point>();
		
		
		for(int i=1; i<=h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp=1;
			while(st.hasMoreTokens()) {
				box[i][temp] = Integer.parseInt(st.nextToken());
				
				if(box[i][temp] == 1) {	// 토마토 있을 경우
					q.add(new Point(i, temp));
					check[i][temp] = true;
				}
				
				temp++;
			}
		}
		
		while(!q.isEmpty()) {
			int x1 = q.peek().x;
			int x2 = q.peek().y;
			q.remove();
			for(int i=0; i<4; i++) {
				int tempX1 = x1 + pointX[i];
				int tempX2 = x2 + pointY[i];
				if( tempX1 > 0 && tempX1 <= h && tempX2 > 0 && tempX2 <= w) {
					if(box[tempX1][tempX2] != -1 && check[tempX1][tempX2] == false) {
						box[tempX1][tempX2] = box[x1][x2] + 1;
						q.add(new Point(tempX1, tempX2));
					}
					check[tempX1][tempX2] = true;
				}
			}
		}
		
		int answer=0;
		for(int i=1; i<=h; i++) {
			for(int j=1; j<=w; j++) {
				if(box[i][j] > answer) {
					answer = box[i][j];
				}
				if(check[i][j] == false && box[i][j] == 0) {
					answer = -1;
					System.out.println(answer);
					return;
				}
			}
		}
		
		System.out.println(answer-1);
	}
}
