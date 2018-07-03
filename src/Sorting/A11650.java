package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A11650 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		ArrayList<Dot> list = new ArrayList<Dot>();
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Dot(a, b));
		}
		
		Collections.sort(list);
		for(int i=0; i<num; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
		
	}
}

class Dot implements Comparable<Dot> {
	int x;
	int y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Dot o) {
		// x Á¤·Ä
		if(this.x < o.x) {
			return -1;
		}
		if(this.x > o.x) {
			return 1;
		}
		if(this.x == o.x) {
			if(this.y < o.y) {
				return -1;
			}
			if(this.y > o.y) {
				return 1;
			}
		}
		
		return 0;
			
	}		
}