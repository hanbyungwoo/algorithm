package Kakao.P2017;

import java.util.ArrayList;
import java.util.Collections;

public class P3_1 {
	public static void main (String args[] ) {
		System.out.println(solution(2,4,2,1));
//		System.out.println(solution(16,16,2,1));
	}
	
	
	public static String solution(int n, int t, int m, int p) {
		// n 진법
		// t 미리 구할 숫자 갯수 
		// m 게임에 참가하는 인원 
		// p 튜브의 순서
		StringBuffer sb = new StringBuffer();
		sb.append(0);
		for(int i=1; ; i++) {
			sb.append(number(n, i));
			if(sb.length() > m*t) {
				break;
			}
			
		}
		String x ="";
		
		for(int i=p-1; t>0; i=p*m+i) {
			x+=sb.toString().charAt(i);	
			t--;
		}
		return x;
	}
	
	public static String number(int n, int i) {
		ArrayList<String> value = new ArrayList<String>();
		
		while(i > 0) {
			int temp = i%n;
			if(temp > 9) {
				switch(temp) {
					case 10 : value.add("A"); break;
					case 11 : value.add("B"); break;
					case 12 : value.add("C"); break;
					case 13 : value.add("D"); break;
					case 14 : value.add("E"); break;
					case 15 : value.add("F"); break;
					default : break;
				}
			} else {
				value.add(Integer.toString(i%n));
			}
			i = i/n;
		}
		Collections.reverse(value);
		String result="";
		for(int j=0; j<value.size(); j++) {
			result += value.get(j);
		}
		return result;
	}
	
	 
}
