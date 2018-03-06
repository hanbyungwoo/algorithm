package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A5014 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int total = Integer.parseInt(st.nextToken());
		int current = Integer.parseInt(st.nextToken());
		int des = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(current);
		boolean check[] = new boolean[total+1];
		int value[] = new int[total+1];
		
		// 현위치, 목적지 같으므로 종료
		if(current == des) {
			System.out.println(0);
			return;
		}
		
		check[current] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			int uptemp = temp + up;
			int downtemp = temp - down;
			if(uptemp <= total) {
				if(check[uptemp] == false) {
					check[uptemp] = true;
					value[uptemp] = value[temp] + 1;
					q.add(uptemp);
				}
			}
			if(downtemp > 0) {
				if(check[downtemp] == false) {
					check[downtemp] = true;
					value[downtemp] = value[temp] + 1;
					q.add(downtemp);
				}
			}
		}
		
		if(value[des]==0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(value[des]);
		}
	}
}

