import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2146 {

	
	public static void main(String args[]) throws IOException {
		int up [] = {-1, 1, 0, 0};
		int down [] = {0, 0, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int map[][] = new int [num+1][num+1];
		boolean mapCheck[][] = new boolean[num+1][num+1];
		int check[][] = new int [num+1][num+1];
		Queue<Point> q1 = new LinkedList<Point>();
		Queue<Point> q2 = new LinkedList<Point>();
		
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=num; j++) {
				
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 0) {
					check[i][j] = -1;
				} else {
					check[i][j] = 0;
					q2.add(new Point(i, j));
				}
			}
		}
		//////////////
		int cnt = 0;
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				if(map[i][j] == 1 && mapCheck[i][j] == false) {
					cnt++;
					
					q1.add(new Point(i, j));
				}
				while(!q1.isEmpty()) {
					int x1 = q1.peek().x;
					int x2 = q1.peek().y;
					q1.remove();
					for(int k=0; k<4; k++) {
						int tempX1 = x1 + up[k];
						int tempX2 = x2 + down[k];
						if( tempX1 > 0 && tempX1 <= num && tempX2 > 0 && tempX2 <= num) {
							if(mapCheck[tempX1][tempX2] == false && map[tempX1][tempX2] == 1) {
								map[tempX1][tempX2] = cnt;
								q1.add(new Point(tempX1, tempX2));
							}
							mapCheck[tempX1][tempX2] = true;
						}
					}
				}
			}
		}
		
		while(!q2.isEmpty()) {
			int tempX = q2.peek().x;
			int tempY = q2.peek().y;
			q2.remove();
			for(int i=0; i<4; i++) {
				int temp1 = tempX + up[i];
				int temp2 = tempY + down[i];
				if(temp1 > 0 && temp2 > 0 && temp1 <= num && temp2 <= num) {
					if(check[temp1][temp2] == -1) {
						map[temp1][temp2] = map[tempX][tempY];
						check[temp1][temp2] = check[tempX][tempY] + 1;
						q2.add(new Point(temp1, temp2));
					}
				}
			}
		}
		int rst=0;
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				
				for(int k=0; k<4; k++) {
					int tempX = i + up[k];
					int tempY = j + down[k];
					if(tempX > 0 && tempY > 0 && tempX <= num && tempY <= num) {
						if(map[i][j] != map[tempX][tempY] || rst==0) {
							if(rst > check[i][j] + check[tempX][tempY] ) {
								rst = check[i][j] + check[tempX][tempY];
							}
						}
					}
				}
			}
		}
		System.out.println(rst);
	}
}
