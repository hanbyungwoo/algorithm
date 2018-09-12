package Programmers;

import java.util.HashMap;

public class level1_완주하지못한선수 {


	public static void main(String args[]) {
		solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
	}
	

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<participant.length; i++) {
			if(map.containsKey(participant[i])) {
				map.put(participant[i], map.get(participant[i])+1);				
			} else {
				map.put(participant[i], 1);
			}
        }
        
        for(int i=0; i<completion.length; i++) {
			map.put(completion[i], map.get(completion[i])-1);				
		}
        
        for(String key : map.keySet()) {
			if(map.get(key)==1) {
				answer = key;
				return answer;
			}
		}
        return answer;
    }
	
}