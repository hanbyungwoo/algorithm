package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2522 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int student = Integer.parseInt(st.nextToken());
		int compare = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = (List<Integer>[]) new List[student+1];
		
		for(int i=1; i<=student; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int ind[] = new int[student+1];
		for(int i=0; i<compare; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			ind[y] += 1;
		}
		
//		Queue<Integer> q = new LinkedList<Integer>();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i=1; i<=student; i++) {
			if(ind[i] == 0) {
				q.offer(i);
//				q.add(i);
			}
		}
		
		for(int i=1; i<=student; i++) {
//			int x = q.remove();
			int x = q.poll();
			System.out.print(x+" ");
			for(int y : list[x]) {
				ind[y] -= 1;
				if(ind[y] == 0) {
//					q.add(y);
					q.offer(y);
				}
			}
		}
		
		System.out.println();
	}
}
