package Samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2477 {
	static int dx[] = {-1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean student[];
	static int map[][];
	static boolean check[][];
	static ArrayList<Three> list;
	static ArrayList<Door> door;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			map = new int[n+1][n+1];
			
			list = new ArrayList<Three>();
			door = new ArrayList<Door>();
			
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=n; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(temp == 1) {
						list.add(new Three(i, j));
					} else {
						door.add(new Door(i, j, temp));
					}
				}
			}
			student = new boolean[list.size()];
			for(int i=0; i<list.size(); i++) {
				int first = Math.abs(door.get(0).i-list.get(i).i)+Math.abs(door.get(0).j-list.get(i).j);
				int second = Math.abs(door.get(1).i-list.get(i).i)+Math.abs(door.get(1).j-list.get(i).j);
				// 1분 기다리는 것 포함
				list.get(i).door1 = first+1;
				list.get(i).door2 = second+1;
			}
			
			DFS(0);

		}
	}
	
	public static void DFS(int sel) {
		if(sel==list.size()) {
			int time=0;
			
			ArrayList<Integer> first = new ArrayList<Integer>();
			ArrayList<Integer> second = new ArrayList<Integer>();
			for(int i=0; i<list.size(); i++) {
				if(student[i]) {
					first.add(list.get(i).door1);
				} else {
					second.add(list.get(i).door2);
				}
			}
			
			Collections.sort(first);
			Collections.sort(second);
			int Amax = 0;
			int Bmax = 0;
			if(first.size() > 0) {
				for(int i=0; i<first.size(); i++) {
					int three=0;
					int term = door.get(0).time + first.get(i);
					
					for(int j=i+1; j<first.size(); j++) {
						if(first.get(j) < term) {
							three++;
						} else {
							break;
						}
						
						if(three == 3) {
							first.set(j,  term);
							break;
						}
					}
				}
				Collections.sort(first);
				Amax = first.get(first.size() - 1);
			}
			
			if(second.size() > 0) {
				for(int i=0; i<second.size(); i++) {
					int three=0;
					int term = door.get(1).time + second.get(i);
					
					for(int j=i+1; j<second.size(); j++) {
						if(second.get(j) < term) {
							three++;
						} else {
							break;
						}
						
						if(three == 3) {
							second.set(j,  term);
							break;
						}
					}
				}
				Collections.sort(second);
				Bmax = second.get(second.size() - 1);
			}
			
		} else {
			student[sel]=true;
			DFS(sel+1);
			student[sel]=false;
			DFS(sel+1);
		}
	}

}
class Door {
	int i;
	int j;
	int time;
	int people;
	public Door(int i, int j, int t) {
		this.i = i;
		this.j = j;
		this.time = t;
	}
}

class Three{
	int i;
	int j;
	int door1;
	int door2;
	public Three(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
 
