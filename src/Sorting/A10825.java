package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A10825 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		ArrayList<Score> list = new ArrayList<Score>();
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken().toString();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Score(str, a, b, c));
		}
		
		Collections.sort(list);
		for(int i=0; i<num; i++) {
			System.out.println(list.get(i).name);
//			System.out.println(list.get(i).toString());
		}
		
	}
}

class Score implements Comparable<Score> {
	String name;
	int kor;
	int eng;
	int math;
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
//	@Override
//	public String toString() {
//		return String.format("%s %d %d %d", this.name, this.kor, this.eng, this.math);
//	}
	
	@Override
	public int compareTo(Score o) {
		// 국어점수 감소하는 순
		if(this.kor > o.kor) {
			return -1;
		}
		if(this.kor < o.kor) {
			return 1;
		}
		if(this.kor == o.kor) {
			// 영어점수 증가하는 순
			if(this.eng < o.eng) {
				return -1;
			}
			if(this.eng > o.eng) {
				return 1;
			}
		}
		
		if(this.kor == o.kor && this.eng == o.eng) {
			if(this.math > o.math) {
				return -1;
			} 
			if(this.math < o.math) {
				return 1;
			}
		}
		if(this.kor == o.kor && this.eng == o.eng && this.math == o.math) {
			// 이름 사전 순
			if(this.name.compareTo(o.name) > 0) {
				return 1;
			}
			if(this.name.compareTo(o.name) < 0) {
				return -1;
			}
		}

		return 0;
		
	}		
}