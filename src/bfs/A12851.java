package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A12851 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		boolean check2[] = new boolean[100001];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(one);
		int result=999999999; 	
		int visit=0;
		int time = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			for(int i=0; i<size; i++) {
				int temp = q.remove();
				check2[temp] = true;
				
				if(temp == two) {
					if(result >= time) {
						// 첫 번째 체크한 time을 result에 저장
						result = time;
						// 같은 시간대 two에 방문한 횟수
						visit++;
					}					
				}
				// -1, +1, *2 -> 3가지 케이스 확인
				if(temp-1 >= 0 && !check2[temp-1]) {	
					q.add(temp-1);
				}
				if(temp+1 < 100001 && !check2[temp+1]) {
					q.add(temp+1);
				}
				if(temp*2 < 100001 && !check2[temp*2]) {
					q.add(temp*2);
				}
			}
		}
		System.out.println(result);
		System.out.println(visit);
		
		
	}
	
}
