package Kakao.P2017;

import java.util.ArrayList;

public class P3_4 {
	public static void main (String args[] ) {
		solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
		solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
		solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
	}
	
	// C#, D#, F#, G#, A#을 V, W, X, Y, Z로 replace해서 풀어도 괜찮을듯.
	
	public static void solution(String mel, String input[]) {
		for(int i=0; i<input.length; i++) {
			String temp[] = input[i].split(",");
			int startH = Integer.parseInt(temp[0].substring(0, 2));// 시간
			int startM = Integer.parseInt(temp[0].substring(3, 5));// 분
			int endH = Integer.parseInt(temp[1].substring(0, 2));// 시간
			int endM = Integer.parseInt(temp[1].substring(3, 5));// 분
			
			int time = (endH-startH)*60 + (endM-startM);
			String x = temp[3];
			
			x = x.replace("#", "");
			int scope = temp[3].length() - x.length();
			if(x.length() < time) {
				int loop = time-x.length();
				for(int j=0; j<loop+scope; j++) {
					temp[3] += temp[3].charAt(j);
					if(temp[3].charAt(j+1) == '#') {
						temp[3] += temp[3].charAt(++j);
						
					}
							
				}
				
			}
			
			int cnt=0;
			if(temp[3].contains(mel)) {
				for(int j=0; j<=temp[3].length(); j++) {
					int k=0;
					if(temp[3].charAt(j)==mel.charAt(k)) {
						while(true) {
							if(temp[3].length() > j && mel.length() > k && temp[3].charAt(j++)==mel.charAt(k++)) {
								cnt++;
							} else {
								break;
							}
							if(cnt==mel.length()) {
								if(temp[3].charAt(j)=='#') {
									break;
								} else{
									System.out.println(temp[2]);	
									return;
								}
							}
						}
					}
				}
				
			}
			
		}
	}
}
