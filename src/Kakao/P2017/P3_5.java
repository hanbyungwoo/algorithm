package Kakao.P2017;

import java.util.Arrays;

public class P3_5 {
	static boolean isContain;
	public static void main (String args[] ) {
		solution(new String[]{"go","gone","guild"});
		solution(new String[]{"abc","def","ghi","jklm"});
		solution(new String[]{"word","war","warrior","world"});
		
	}
	// 트라이 ~ 사용하기
	public static void solution(String input[]) {
		Arrays.sort(input);
		int cnt=0;
		int pre = -1; 
		int post = -1;
		for(int i=0; i<input.length; i++) {
			
			if(i== input.length-1) {
				post = -1;
			} else {
				post = compareString(input[i], input[i+1]);
			}
			
			cnt += pre >= post ? pre : post;
			pre = post;
			if(isContain) {
				pre += 1;
			}
			
		}
		System.out.println(cnt);
	}
	
	public static int compareString(String x, String y) {
		if(y.contains(x)) {
			isContain = true;
			return x.length();
		} else {
			isContain = false;
			// 포함하지 않을 경우
			for(int i=0; ;i++) {
				if(x.charAt(i) != y.charAt(i)) {
					return i+1;
				}
			}
		}
	}
}
