package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14891_톱니바퀴 {
	static char cir1[], cir2[], cir3[], cir4[];
	static int ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cir1 = new char[8];
		cir2 = new char[8];
		cir3 = new char[8];
		cir4 = new char[8];
		
		cir1 = br.readLine().toCharArray();
		cir2 = br.readLine().toCharArray();
		cir3 = br.readLine().toCharArray();
		cir4 = br.readLine().toCharArray();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Queue<Point> q = new LinkedList<Point>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int cycle = Integer.parseInt(st.nextToken());
			q.add(new Point(num, cycle));
		}
		
		while(!q.isEmpty()) {
			int num = q.peek().x;
			int cycle = q.peek().y;
			q.poll();
			check(num, cycle);
		}
		
		cal();
		
	}
	public static void cal() {
		if(cir1[0]=='1') ans+=1;
		if(cir2[0]=='1') ans+=2;
		if(cir3[0]=='1') ans+=4;
		if(cir4[0]=='1') ans+=8;
		System.out.println(ans);
	}
	public static void check(int num, int cycle) {
		Pair n[] = new Pair[4];
		switch(num) {
		case 1 :
			n[0] = new Pair(true, cycle);
			if(cir1[2]!=cir2[6]) {	// 다를 경우
				n[1] = new Pair(true, cycle*-1);
				if(cir2[2]!=cir3[6]) {	// 다를 경우
					n[2] = new Pair(true, cycle);
					if(cir3[2]!=cir4[6]) {	// 다를 경우
						n[3] = new Pair(true, cycle*-1);
					}
				}
			}
			break;
		case 2 :
			n[1] = new Pair(true, cycle);
			if(cir2[6]!=cir1[2]) {
				n[0] = new Pair(true, cycle*-1);
			}
			if(cir2[2]!=cir3[6]) {
				n[2] = new Pair(true, cycle*-1);
				if(cir3[2]!=cir4[6]) {
					n[3] = new Pair(true, cycle);
				}
			}
			break;
		case 3 :
			n[2] = new Pair(true, cycle);
			if(cir3[2]!=cir4[6]) {
				n[3] = new Pair(true, cycle*-1);
			}
			if(cir2[2]!=cir3[6]) {
				n[1] = new Pair(true, cycle*-1);
				if(cir1[2]!=cir2[6]) {
					n[0] = new Pair(true, cycle);
				}
			}
			break;
		case 4 :
			n[3] = new Pair(true, cycle);
			if(cir4[6]!=cir3[2]) {	// 다를 경우
				n[2] = new Pair(true, cycle*-1);
				if(cir2[2]!=cir3[6]) {	// 다를 경우
					n[1] = new Pair(true, cycle);
					if(cir1[2]!=cir2[6]) {	// 다를 경우
						n[0] = new Pair(true, cycle*-1);
					}
				}
			}
			break;
		}
		
		for(int i=0; i<4; i++) {
			if(n[i] != null && n[i].x) {
				if(i==0) {
					rotate(cir1, n[i].y);
				} 
				if(i==1) {
					rotate(cir2, n[i].y);
				}
				if(i==2) {
					rotate(cir3, n[i].y);
				}
				if(i==3) {
					rotate(cir4, n[i].y);
				}
			}
		}
	}
	
	public static void rotate(char arr[], int cycle) {
		if(cycle == 1) {	// 시계방향
			char temp = arr[0];
			arr[0] = arr[7];
			arr[7] = arr[6];
			arr[6] = arr[5];
			arr[5] = arr[4];
			arr[4] = arr[3];
			arr[3] = arr[2];
			arr[2] = arr[1];
			arr[1] = temp;
		} else if(cycle == -1) {	// 반시계방향
			char temp = arr[0];
			arr[0] = arr[1];
			arr[1] = arr[2];
			arr[2] = arr[3];
			arr[3] = arr[4];
			arr[4] = arr[5];
			arr[5] = arr[6];
			arr[6] = arr[7];
			arr[7] = temp;
		}
	}
}
class Pair {
	boolean x;
	int y;
	public Pair(boolean x, int y) {
		this.x = x;
		this.y = y;
	}
}













