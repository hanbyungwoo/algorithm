package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A10814 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		ArrayList<Dot3> list = new ArrayList<Dot3>();
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken().toString();
			list.add(new Dot3(a, b));
		}
		
		Collections.sort(list);
		for(int i=0; i<num; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}
		
	}
}

class Dot3 implements Comparable<Dot3> {
	int x;
	String y;
	public Dot3(int x, String y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Dot3 o) {
		
		if(this.x < o.x) {
			return -1;
		}
		if(this.x > o.x) {
			return 1;
		}
		return 0;
		
	}		
}