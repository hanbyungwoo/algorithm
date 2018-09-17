package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class level2_H_Index {
	public static void main(String args[]) {
		solution(new int[]{3,0,6,1,5});
		solution(new int[]{0,1,4,5});
	}
	

	public static int solution(int[] citations) {
        int answer = 0;

        Integer[] temp = new Integer[citations.length];
        for(int i=0; i<citations.length; i++) {
        	temp[i] = citations[i];
        }
//        System.arraycopy(citations, 0, temp, 0, citations.length);
        
        
        Arrays.sort(temp);
        List<Integer> list = Arrays.asList(temp);
        
        Collections.reverse(list);
        temp = list.toArray(new Integer[list.size()]);
        
        
        for(int i=0; i<temp.length; i++) {
        	if(temp[i] == i+1) {
        		answer = i+1;
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
	
}

