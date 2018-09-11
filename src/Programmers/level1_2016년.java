package Programmers;

public class level1_2016³â {
	static boolean isContain;
	public static void main (String args[] ) {
		solution(5, 24);
		solution(1, 1);
		
	}

	public static String solution(int a, int b) {
		String answer="";
		String[] week={"THU","FRI","SAT","SUN","MON","TUE","WED"};
		int[] month={31,29,31,30,31,30,31,31,30,31,30,31};
		
		int cnt=0;
		for(int i=0; i<a-1; i++) {
			cnt += month[i];
		}
		cnt+=b;
		
		answer = week[cnt%7];
		System.out.println(answer);
		
		return answer;
	}
	
}