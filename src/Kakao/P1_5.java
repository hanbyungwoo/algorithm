package Kakao;

import java.util.ArrayList;
import java.util.Collections;

public class P1_5 {
	public static void main(String args[]) {
		
//		String str1 = "FRANCE";
//		String str2 = "french";
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
		String str1 = "handshake";
		String str2 = "shake hands";
//		String str1 = "E=M*C^2";
//		String str2 = "e=m*c^2";
		
		char st1[] = str1.toLowerCase().toCharArray();
		char st2[] = str2.toLowerCase().toCharArray();
		
		ArrayList<String> s1 = new ArrayList<String>();
		ArrayList<String> s2 = new ArrayList<String>();
		
		for(int i=0; i<st1.length; i++) {
			if(st1.length > i+1) {
				if(st1[i] >= 'a' && st1[i] <= 'z' && st1[i+1] >= 'a' && st1[i+1] <= 'z') {
					s1.add(str1.toLowerCase().substring(i, i+2));
				}
			}
		}
		
		for(int i=0; i<st2.length; i++) {
			if(st2.length > i+1) {
				if(st2[i] >= 'a' && st2[i] <= 'z' && st2[i+1] >= 'a' && st2[i+1] <= 'z') {
					s2.add(str2.toLowerCase().substring(i, i+2));
				}
			}
		}
		// 합집합, 교집합을 구하자.
		int kyo = 0;
		int sum = 0;
		if(s1.size() != 0 && s2.size() != 0) {
			for(int i=0; i<s1.size(); i++) {
				for(int j=0; j<s2.size(); j++) {
					if(s1.get(i).equals(s2.get(j))) {	// s1, s2 문자열 일치
						s1.remove(i);
						s2.remove(j);
						System.out.println("i : " + i + " j : " + j);
						i--; // i는 해당 자리 이전부터 다시 시작할 수 있도록 셋팅.
//						j--; // break문으로 탈출해서 어차피 0부터 시작
						kyo++;
						break;
					}
				}
			}
			sum = s1.size() + s2.size() + kyo;
		}
		
		System.out.println(kyo + " : " + sum);
		if(kyo == 0 && sum == 0 ) {
			System.out.println(65536);
		} else {
			System.out.println((int)((double)kyo/sum*65536));
		}
	}
	
}
	
