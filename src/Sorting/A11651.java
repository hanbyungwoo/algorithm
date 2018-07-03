package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A11651 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		ArrayList<Dot2> list = new ArrayList<Dot2>();
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Dot2(a, b));
		}
		
		Collections.sort(list);
		for(int i=0; i<num; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
		
	}
}

class Dot2 implements Comparable<Dot2> {
	int x;
	int y;
	public Dot2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Dot2 o) {
		
		if(this.y < o.y) {
			return -1;
		}
		if(this.y > o.y) {
			return 1;
		}
		if(this.y == o.y) {
			if(this.x < o.x) {
				return -1;
			}
			if(this.x > o.x) {
				return 1;
			}
		}
		
		return 0;
		
		
	}
		
}