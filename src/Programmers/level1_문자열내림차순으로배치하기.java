package Programmers;

import java.util.Arrays;

public class level1_문자열내림차순으로배치하기 {
	public static void main (String args[] ) {
		solution("Zbcdefg");
		
	}

	public static String solution(String s) {
		String answer="";
		
		String[] temp= s.split("");
		Arrays.sort(temp);
		for(int i=temp.length-1; i>=0; i--) {
			answer += temp[i];
		}
		System.out.println(answer);
		
		return answer;
	}
	
}