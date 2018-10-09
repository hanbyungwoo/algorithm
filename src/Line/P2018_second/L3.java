package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class L3 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		List<Integer>[] list = (List<Integer>[]) new List[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		int ind[] = new int[1000];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			boolean check = false;
			while(st.hasMoreElements()) {
				int x = Integer.parseInt(st.nextToken());
				list[i].add(x);
				set.add(x);
				if(check) {
					ind[x] += 1;	
				}
				check = true;
			}
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
//		for(int i=1; i<=set.size(); i++) {
			for(int i : set) {
				if(ind[i] == 0) {
					q.offer(i);
//					q.add(i);
				}				
			}
//		}
		
		for(int i=1; i<=set.size(); i++) {
//			int x = q.remove();
			int x = q.poll();
//			System.out.print(x+" ");
			for(int y : list[x]) {
				ind[y] -= 1;
				if(ind[y] == 0) {
//					q.add(y);
					q.offer(y);
				}
			}
		}
		while(!q.isEmpty()) {
			System.out.print(q.poll()+" ");
		}
		System.out.println();
	}	
}
