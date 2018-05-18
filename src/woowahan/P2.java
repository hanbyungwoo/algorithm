package woowahan;


public class P2 {
	public static void main(String args[]) {
		
		System.out.println(Solution("A586QK", "JJ653K"));
	}
	
	public static int Solution(String A, String B) {
		
		char alec[] = A.toCharArray();
		char bob[] = B.toCharArray();
		
		// T J Q K A 각각 10 11 12 13 14로 치환하여 품
		int cnt=0;		
		for(int i=0; i<alec.length; i++) {
			if(check(alec[i]) > check(bob[i])) {
				cnt++;
			}
			
		}
		
		return cnt;
		

	}
	
	public static int check(char c) {
		switch (c) {
			case 'A' : return 14;
			case 'K' : return 13;
			case 'Q' : return 12;
			case 'J' : return 11;
			case 'T' : return 10;
			default : return c-'0';
		}
	}
	
}

