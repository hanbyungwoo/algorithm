package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//4 2
//4 2
//3 1
public class A2056 {
	public static void main(String args[]) throws IOException {
//		PriorityQueue<Integer>
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = (List<Integer>[]) new List[num+1];
		List<Integer>[] val = (List<Integer>[]) new List[num+1];
		
		for(int i=1; i<=num; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=num; i++) {
			val[i] = new ArrayList<Integer>();
		}
		int ind[] = new int[num+1];
		int time[] = new int[num+1];
		int d[] = new int[num+1];
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			time[i] = a;
			while(st.hasMoreTokens()) {
				int c = Integer.parseInt(st.nextToken());
				list[i].add(c);
				val[c].add(i);
				ind[i]=b;
			}
			
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i=1; i<=num; i++) {
			if(ind[i]==0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0; i<size; i++) {
				int x = q.poll();
				//System.out.print(x+" ");
				d[x] = time[x];
				for(int y : val[x]) {
					ind[y]--;
					if(ind[y]==0) {
						q.offer(y);
					}
				}
				for(int y : list[x]) {
					if(d[x] < d[y] + time[x]) {
						d[x] = d[y] + time[x];
					}
				}
				
			}
			
		}
		int max=0;
		for(int i=0; i<=num; i++) {
			if(max < d[i]) {
				max = d[i];
			}
		}
		System.out.println(max);
		
		
	}
}

