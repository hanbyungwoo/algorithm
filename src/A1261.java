import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1261 {
	static int arr1[] = { -1, 1, 0, 0 };
	static int arr2[] = { 0, 0, -1, 1 };
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int col = Integer.parseInt(st.nextToken());
		 int row = Integer.parseInt(st.nextToken());
		 
		 char temp[][] = new char[row][];
		 for(int i=0; i<row; i++) {
			 temp[i] = br.readLine().toCharArray();
		 }
		 // 2 4 
		 int map[][] = new int[row+1][col+1];
		 int map2[][] = new int[row+1][col+1];
//		 boolean check[][] = new boolean[row+1][col+1];
		 
		 for(int i=1; i<=row; i++) {
			 Arrays.fill(map2[i], -1);
//			 for(int j=1; j<=col; j++) {
//				 map2[i][j] = -1;
//			 }
		 }
		 
		 for(int i=1; i<=row; i++) {
			 for(int j=1; j<=col; j++) {
				 map[i][j] = temp[i-1][j-1]-'0';
			 }
		 }
		 
		 Queue<Point> q = new LinkedList<Point>();
		 Queue<Point> next_q = new LinkedList<Point>();
		 q.add(new Point(1,1));
//		 check[1][1] = true;
//		 int min = 0;
		 map2[1][1] = 0;
		 while(!q.isEmpty()) {
			 int x = q.peek().x;
			 int y = q.peek().y;
			 q.poll();
			 
			 for(int i=0; i<4; i++) {
				 int tempX = x + arr1[i];
				 int tempY = y + arr2[i];
				 if(tempX > 0 && tempY > 0 && tempX <= row && tempY <= col) {
//					 if(check[tempX][tempY] == false) {
//						 check[tempX][tempY] = true;
						 if(map2[tempX][tempY] == -1) {
							 if(map[tempX][tempY] != 0) {
								 map2[tempX][tempY] = map2[x][y] + 1;
								 next_q.add(new Point(tempX, tempY));
							 } else {
								 map2[tempX][tempY] = map2[x][y];
								 q.add(new Point(tempX, tempY));
							 }
							 
						 }
//					 }
				 }
			 }
			 if(q.isEmpty()) {
				 q = next_q;
				 next_q = new LinkedList<Point>();
			 }
		 }
//		 map2[row-1][col] > map2[row][col-1] ? map2[row][col-1] : map2[row-1][col] 
		 System.out.println(map2[row][col]);
	}
}


