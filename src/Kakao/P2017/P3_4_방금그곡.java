package Kakao.P2017;

public class P3_4_��ݱװ� {
	public static void main (String args[] ) {
//		solution("ABCDEFG", new String[]{"12:00,12:17,HELLO321,CDEFGAB", "12:00,12:17,HELLO123,CDEFGAB"});
//		solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
		solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
//		solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
	}
	
	// C#, D#, F#, G#, A#�� V, W, X, Y, Z�� replace�ؼ� Ǯ� ��������.
	
	public static String solution(String mel, String input[]) {
		String answer = "(None)";
		int longPlayer=0;
		// ��ε�
		mel = change(mel);
		
		for(int i=0; i<input.length; i++) {
			String temp[] = input[i].split(",");
			String HH[] = temp[0].split(":");
			String MM[] = temp[1].split(":");
			int startH = Integer.parseInt(HH[0]);// �ð�
			int startM = Integer.parseInt(HH[1]);// ��
			int endH = Integer.parseInt(MM[0]);// �ð�
			int endM = Integer.parseInt(MM[1]);// ��
			
			int time = (endH-startH)*60 + (endM-startM);
			String x = temp[3];
			
			// �Ǻ�
			x= change(x);
			if(time < x.length()) {
				x = x.substring(0, time);
			}
			
			int len = x.length();
			for(int j=len; j<time; j++) {
				x += x.charAt(j%len);
			}
			System.out.println(x);
			// ����
			if(x.contains(mel)) {
				if(longPlayer < time) {
					longPlayer = time;
					answer = temp[2];
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
	
	public static String change(String x) {
		x = x.replace("C#", "V");
		x = x.replace("D#", "W");
		x = x.replace("F#", "X");
		x = x.replace("G#", "Y");
		x = x.replace("A#", "Z");
		
		return x;
	}
}
