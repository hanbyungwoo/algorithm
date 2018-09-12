package Programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class level2_������ {
	public static void main(String args[]) {
//		solution(new int[]{5}, 0);
		solution(new int[]{1, 2, 3, 4}, 2);
//		solution(new int[]{2, 1, 3, 2}, 2);
//		solution(new int[]{1, 1, 9, 1, 1, 1}, 3);
	}
	

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<value> q = new LinkedList<value>();
        
        for(int i=0; i<priorities.length; i++) {
        	pq.add(priorities[i]);
        	q.add(new value(i, priorities[i]));
        }
        
//        PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());
//        reverse_pq.addAll(pq);
//        
        while(!q.isEmpty()) {
        	int prior = pq.peek().intValue();
        	pq.poll();
        	
        	int n;
        	while(true) {
        		n = q.peek().x;			// ���� ����
        		int nPrior = q.peek().y;	// �켱 ����
        		q.poll();
        		
        		if(nPrior == prior) {
        			break;
        		}
        		
        		q.add(new value(n, nPrior));
        	}
        	answer++;
        	if(n==location) {
        		break;
        	}
        }
        System.out.println(answer);
        return answer;
    }
	
}

class value {
	int x;
	int y;
	public value(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

