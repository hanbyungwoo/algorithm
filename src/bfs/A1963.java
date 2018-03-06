package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1963 {
	public static void main(String args[]) throws IOException {
		boolean prime[] = new boolean[10001];
		
		// 소수를 구한다.
		for(int i=2; i<=10000; i++) {
			if(prime[i] == false) {
				for(int j=i*i; j<=10000; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		// 소수의 값들에 true로 기본 값 설정.
		for(int i=0; i<=10000; i++) {
			prime[i] = !prime[i];
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int testCase = Integer.parseInt(st.nextToken());
		
		while(testCase-- > 0) {
			boolean check[] = new boolean[10001];
			int checkNum[] = new int[10001];
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			//checkNum[first]=0;
			check[first] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(first);
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int i=0; i<4; i++) {
					for(int j=0; j<=9; j++) {
						int next = change(now, i, j);
						if(next != -1) {
							if(prime[next] && check[next] == false) {
								q.add(next);
								check[next] = true;
								checkNum[next] = checkNum[now] + 1;
							}
						}
					}
				}
			}
			System.out.println(checkNum[second]);
			
		}
	}
	
	public static int change(int num, int index, int digit) {
		// num 숫자 index 해당 자리를 digit으로 변경하자.
		if(index == 0 && digit == 0) {
			return -1;
		}
		String temp = Integer.toString(num);
		StringBuilder sb = new StringBuilder(temp);
		sb.setCharAt(index,  (char)(digit+'0'));
		return Integer.parseInt(sb.toString());
	}
}
