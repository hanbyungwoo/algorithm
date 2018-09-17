package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class level2_가장큰수 {
	public static void main(String args[]) {
//		solution(new int[]{3,0,6,1,5});
//		solution(new int[]{0,1,4,5});
		solution(new int[]{3,30,34,5,9});
	}
	

	public static String solution(int[] numbers) {
        
		String answer = "";
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[10];
		for(int i=0; i<10; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<numbers.length; i++) {
			String temp = numbers[i]+"";
			list[temp.charAt(0)-'0'].add(Integer.parseInt(temp)); 
		}
		
        for(int i=9; i>0; i--) {
        	
        	String temp = "";
        	Collections.sort(list[i]);
	        do {
	        	StringBuilder sb = new StringBuilder();
	            for (int j=0; j<list[i].size(); j++) {
	                //System.out.print(list[i].get(j) + " ");
	                sb.append(list[i].get(j));
	            }
	            //System.out.println();
	            if(temp.compareTo(sb.toString()) < 0) {
	            	temp = sb.toString();
	            }
	        } while(next_permutation(list[i]));
	        answer += temp;
        }
        //System.out.println("--> " + answer);
        return answer;
    }
	
	public static boolean next_permutation(ArrayList<Integer> arr) {
    	
        int i = arr.size()-1;
        while (i > 0 && arr.get(i-1) >= arr.get(i)) {
            i -= 1;
        }

        // 마지막 순열
        if (i <= 0) {
            return false;
        }

        int j = arr.size()-1;
        while (arr.get(j) <= arr.get(i-1)) {
            j -= 1;
        }

        Collections.swap(arr, i-1, j);

        j = arr.size()-1;
        while (i < j) {
        	Collections.swap(arr, i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }
}

