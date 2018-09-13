package Programmers;

import java.util.PriorityQueue;

public class level2_´õ¸Ê°Ô {
	public static void main(String args[]) {
		solution(new int[]{1,2,3,9,10,11}, 7);
	}
	

	public static int solution(int[] scoville, int K) {
		int answer=0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        
        boolean check = false;
        while(!pq.isEmpty() && pq.size() >= 2) {
        	int x = pq.poll();
        	int y = pq.poll();
        	pq.add(x+2*y);
        	answer++;
        	if(pq.peek().intValue() >= K) {
        		check = true;
        		break;
        	}
        }
        
        if(!check) {
        	answer = -1;
        }
        System.out.println(answer);
        
        return answer;
                
    }
	
}

