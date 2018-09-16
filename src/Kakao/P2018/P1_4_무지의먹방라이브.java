package Kakao.P2018;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class P1_4_무지의먹방라이브 {
	public static void main(String args[]) {
//		solution(new int[]{3,1,2}, 5);
		solution(new int[]{1,6,2}, 9);
		solution(new int[]{100,200,300,400,500}, 1000);
	}
	
	
	public static int solution(int[] food_times, long k) {
        int answer = 0;
        
        int size = food_times.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<size; i++) {
        	min = Math.min(min, food_times[i]);
        }
        Queue<Point> q = new LinkedList<Point>();
        
        int val = (int)(k/size);
        
        if(val < min && val > 0) {
    		min = val;
    	}
        val = val-min;
        
        int tempNum=Integer.MAX_VALUE;
        long k_cnt=0;
        k_cnt = size*min;
        for(int i=0; i<size; i++) {
        	int insert = food_times[i]-min;
        	if(insert > 0) {
	       		q.add(new Point(i+1,insert));
	       		tempNum = Math.min(tempNum, food_times[i]-min);
        	}
        }
        min = tempNum;
        
        	
        
        while(!q.isEmpty() && k_cnt < k) {
        	int q_size = q.size();
        	tempNum = Integer.MAX_VALUE;
        	if(val < min && val > 0) {
        		min = val;
//        		k = k - size*min;
        	} 
            val = val-min;
            
            if(q_size == 1) {
            	int x = (int) (q.peek().y-(k-k_cnt));
            	if( x <= 0 ) {
            		q.poll();
            	}
            	break;
            }
            
        	for(int i=0; i<q_size; i++) {
	        	int seq = q.peek().x;
	        	int time = q.peek().y;
	        	q.poll();
	        	
	        	time -= min;
	        	if(time != 0) {
	        		q.add(new Point(seq, time));
	        		tempNum = Math.min(tempNum, time);
	        	}
	        	k_cnt+=min;
	        	if( k_cnt >= k ) {
	        		break;
	        	}
        	}
        }
        
        if(q.isEmpty()) {
        	answer = -1;
        } else {
        	answer = q.peek().x;
        }
        System.out.println(answer);
        
        return answer;
    }
	
	
	
}

