package Kakao.P2018;

import java.util.PriorityQueue;

public class P1_2_½ÇÆÐÀ² {
	public static void main(String args[]) {
//		solution(5, new int[]{2,1,2,6,2,4,3,3});
		solution(4, new int[]{4,4,4,4,4});
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int total_people[] = new int[N+2];
        int lose_game[] = new int[N+2];
        for(int i=0; i<stages.length; i++) {
        	for(int j=1; j<=stages[i]; j++) {
        		total_people[j]++;
        		if(j==stages[i]) {
        			lose_game[j]++;
        		}
        	}
        }
        
        PriorityQueue<Score> pq = new PriorityQueue<Score>();
        
        for(int i=1; i<N+1; i++) {
        	double temp = ((double)lose_game[i]/total_people[i]);
        	pq.add(new Score(i, temp));
        }
        
        int cnt=0;
        while(!pq.isEmpty()) {
        	System.out.println(pq.peek().seq + ":" + pq.peek().lose);
        	answer[cnt++] = pq.peek().seq;
        	pq.poll();
        }
        return answer;
    }
	
}

class Score implements Comparable<Score> {
	int seq;
	double lose;
	public Score(int seq, double temp) {
		this.lose = temp;
		this.seq = seq;
	}
	
	@Override
	public int compareTo(Score o) {
		if(this.lose < o.lose) {
			return 1;
		} else if(this.lose > o.lose) {
			return -1;
		} else if(this.seq > o.seq) {
			return 1;
		} else if(this.seq < o.seq) {
			return -1;
		} else {
			return 0;
		}
	}
	
}


