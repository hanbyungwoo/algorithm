package Kakao;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class P1_4 {
	public static void main(String args[]) {
		int n=1;
		int t=1;
		int m=5;
		String timeTable[] = {"08:00", "08:01", "08:02", "08:03", "08:03"};
		System.out.println(solution(n, t, m, timeTable));
	}
	public static String solution(int n, int t, int m, String[] timeTable) {
		// n ���� t �����ð� m �ִ� ž�� �ο�
		PriorityQueue<Time> pq = new PriorityQueue<Time>();
		for(String time : timeTable) {
			pq.add(new Time(time));
		}
		
		// conTime : ���� ���� �����忡 ���� �ʰ� ������ �� �ִ� �ð�.
		Time conTime = new Time("00:00");
		
		for(int i=0; i<n; i++) {
			Time busTime = new Time("09:00");
			busTime.add(i, t);
			
			conTime = busTime;
			
			int capacity = m;
			// ������ ����� �¿���
			while(!pq.isEmpty() && capacity > 0 && pq.peek().compareTo(busTime) <= 0) { // ������ �ð��� ũ�ų� ����.
				Time crewTime = pq.poll();
				
				if(capacity == 1) {
					conTime = crewTime;
					conTime.add(1, -1);
				}
				
				capacity--;
			}
			
		}
		
		return conTime.toString();
	}
}

class Time implements Comparable<Time>{
	int h, m;
	
	Time(String time) {
		this.h = Integer.parseInt(time.substring(0,2));
		this.m = Integer.parseInt(time.substring(3,5));
	}
	
	// n�� ���� ����, t�� �ð�
	void add(int n, int t) {
		int addHour = (n*t)/60;
		int addMin = (n*t)%60;
		
		h += addHour;
		m += addMin;
		
		if(m >= 60) {
			h++;
			m -= 60;
		} else if(m < 0) {
			h--;
			m += 60;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d", this.h, this.m);
	}
	
	@Override
	public int compareTo(Time o) {
			if(this.h < o.h) {		// ������ �ð��� ��ŭ
				return -1;
			} else if(this.h > o.h) {	// ���� �ð��� ��ŭ
				return 1;
			} else if(this.m < o.m) {	// �ð��� ����, ������ �ð��� ��ŭ
				return -1;
			} else if(this.m > o.m) {	// �ð��� ����, ���� �ð��� ��ŭ
				return 1;
			} else {	// �ð�, �� ��� ���� ���
				return 0;
			}
	}
}