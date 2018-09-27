package Programmers;

import java.util.HashMap;

public class level1_Ã¼À°º¹ {
	static boolean isContain;
	public static void main (String args[] ) {
		solution(5, new int[]{2,4}, new int[]{1,3,5});
		solution(5, new int[]{2,4}, new int[]{3});
		
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=1; i<=n; i++) {
			map.put(i, 1);
		}
		for(int i=0; i<lost.length; i++) {
			map.put(lost[i], map.get(lost[i])-1);
		}
		for(int i=0; i<reserve.length; i++) {
			map.put(reserve[i], map.get(reserve[i])+1);
		}
		
		for(int i : map.keySet()) {
			if(map.get(i) == 0) {
				if(i > 1 && map.get(i-1) > 1) {
					map.put(i-1, map.get(i-1)-1);
					map.put(i, 1);
				} else if(i<n && map.get(i+1) > 1) {
					map.put(i+1, map.get(i+1)-1);
					map.put(i, 1);
				}
			}
		}
		
		for(int i : map.keySet()) {
			if(map.get(i) > 0) {
				answer++;
			}
		}
		System.out.println(answer);
        
        return answer;
    }
	
}