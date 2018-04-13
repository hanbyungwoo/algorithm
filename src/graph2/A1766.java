package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//4 2
//4 2
//3 1
public class A1766 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num = Integer.parseInt(st.nextToken());
		int loop = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = (List<Integer>[]) new List[num+1];
		
		for(int i=1; i<=num; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int ind[] = new int[num+1];
		for(int i=0; i<loop; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			ind[b]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// 역순으로
//		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
//		q.offer(3);
//		q.offer(4);
//		q.offer(7);
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.println(x);
		}
		
//		for(int i=1; i<=num; i++) {
//			if(ind[i]==0) {
//				q.offer(i);
//			}
//		}
//		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			
			for(int y : list[x]) {
				ind[y]--;
				if(ind[y]==0) {
					q.offer(y);
				}
			}
		}
		
		
		
	}
}
