package Programmers;

public class level4_선입선출스케줄링 {
	static boolean isContain;
	public static void main (String args[] ) {
		solution(6, new int []{1,2,3});
		
	}

	public static int solution(int n, int[] cores) {
		int answer=0;
		int size = cores.length;
		int usage[] = new int[size];
		while(n > 0) {
			int min=10001;
			for(int i=0; i<size; i++) {
				if(usage[i] == 0) {
					usage[i] = cores[i];
					n--;
				}
				min = Math.min(min, usage[i]);
//				min = min > usage[i] ? usage[i] : min;
			}
			for(int i=0; i<size; i++) {
				usage[i] -= min;
			}
		}
		
		answer = 0;
		for(int i=1; i<size; i++) {
			if(usage[i] > usage[answer]) {
				answer = i;
			}
		}
		System.out.println(answer+1);
		return answer+1;
	}
	
}
