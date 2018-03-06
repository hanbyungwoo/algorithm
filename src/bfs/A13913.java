package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class A13913 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		int check[] = new int[100001];
		boolean check2[] = new boolean[100001];
		
		for(int i=0; i<100001; i++) {
			check[i] = -1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(one);
		while(!q.isEmpty()) {
			int temp = q.remove();
			if(temp == two) {
				int cnt=0;
				ArrayList<Integer> list = new ArrayList<Integer>();
				int pre = two;
				while(pre!=one) {
					list.add(pre);
					pre = check[pre];
					cnt++;
				}
				System.out.println(cnt);
				System.out.print(one+" ");
				
				for(int i=list.size()-1; i>-1; i--) {
					System.out.print(list.get(i)+" ");
				}
				
				return;
			}
			if(temp-1 > 0 && check[temp-1] == -1 && !check2[temp-1]) {	
				q.add(temp-1);
				check[temp-1] = temp;
				check2[temp-1] = true;
			}
			if(temp+1 < 100001 && check[temp+1] == -1 && !check2[temp+1]) {
				q.add(temp+1);
				check[temp+1] = temp;
				check2[temp+1] = true;
			}
			if(temp*2 < 100001 && check[temp*2] == -1 && !check2[temp*2]) {
				q.add(temp*2);
				check[temp*2] = temp;
				check2[temp*2] = true;
			}
		}
		
		
		
	}
	
}
